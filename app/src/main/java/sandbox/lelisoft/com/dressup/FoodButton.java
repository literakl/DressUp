package sandbox.lelisoft.com.dressup;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * Created by Leoš on 05.09.2016.
 */
public class FoodButton extends Button {
    private static final int[] STATE_FRIED = {R.attr.state_fried};
    private static final int[] STATE_BAKED = {R.attr.state_baked};

    private boolean mIsFried = false;
    private boolean mIsBaked = false;

    public void setFried(boolean isFried) {
        Log.d("FoodButton","fried = "+isFried);
        mIsFried = isFried;
        refreshDrawableState();
    }
    public void setBaked(boolean isBaked) {
        Log.d("FoodButton","baked = "+isBaked);
        mIsBaked = isBaked;
        refreshDrawableState();
    }

    public FoodButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        for (int i=0;i<attrs.getAttributeCount();i++) {
            Log.d("test", ""+attrs.getAttributeName(i)+" = "+attrs.getAttributeValue(i));
            switch (attrs.getAttributeName(i)) {
                case "state_baked": mIsBaked = attrs.getAttributeBooleanValue(i, false); break;
                case "state_fried": mIsFried = attrs.getAttributeBooleanValue(i, false); break;
            }
        }

        Log.d("FoodButton","baked = "+mIsBaked + ", fried = " + mIsFried);
    }

    public FoodButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
        Log.d("FoodButton","onCreateDrawableState");
        final int[] drawableState = super.onCreateDrawableState(extraSpace + 2);
        if (mIsFried) {
            mergeDrawableStates(drawableState, STATE_FRIED);
        }
        if (mIsBaked) {
            mergeDrawableStates(drawableState, STATE_BAKED);
        }
        return drawableState;
    }
}

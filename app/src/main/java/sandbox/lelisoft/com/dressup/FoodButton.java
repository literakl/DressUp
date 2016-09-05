package sandbox.lelisoft.com.dressup;

import android.content.Context;
import android.util.AttributeSet;
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
        mIsFried = isFried;
    }
    public void setBaked(boolean isBaked) {
        mIsBaked = isBaked;
        refreshDrawableState();
    }

    public FoodButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FoodButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int[] onCreateDrawableState(int extraSpace) {
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

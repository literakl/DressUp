package sandbox.lelisoft.com.dressup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Leoš on 05.09.2016.
 */
public class FoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        final FoodButton button = (FoodButton) findViewById(R.id.foodButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setBaked(true);
                button.setFried(true);
                view.refreshDrawableState();
            }
        });
    }
}

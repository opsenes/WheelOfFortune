package android.com.rotatingwheel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.concurrent.ThreadLocalRandom;

public class WheelActivity extends AppCompatActivity {
    private int from = 0;
    // private int to = ThreadLocalRandom.current().nextInt(0,361);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheel);
        final ImageView wheel = (ImageView)findViewById(R.id.wheel);
        ImageView spinner = (ImageView)findViewById(R.id.spin);
        //RotateAnimation r; // = new RotateAnimation(ROTATE_FROM, ROTATE_TO);

        //wheel.startAnimation(r);
        spinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int to = 1800 + ThreadLocalRandom.current().nextInt(0,361);
                Log.d("to", ""+(to-1800));
                RotateAnimation r = new RotateAnimation(from, to, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                r.setFillAfter(true);
                r.setDuration((long) 2*1500);
                r.setRepeatCount(0);
                wheel.startAnimation(r);
                from = to % 360;
            }
        });
    }
}

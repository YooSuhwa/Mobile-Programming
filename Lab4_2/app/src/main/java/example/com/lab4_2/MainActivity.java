package example.com.lab4_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout ll;

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.ll2);
        Button button1 = (Button) findViewById(R.id.openB);
        Button button2 = (Button) findViewById(R.id.closeB);

        // When you click this button(OPEN PAGE),
        // a Layout(Sliding Area) appears with sliding animation on the left. "<-"
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate);
                ll.setVisibility(View.VISIBLE);
                ll.startAnimation(animation);

            }
        });
        // When you click this button(CLOSE PAGE),
        // A Layout(Sliding Area) disappears with sliding animation on the right. "->"
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(
                        getApplicationContext(), R.anim.translate_closed);
                //ll.setVisibility(View.VISIBLE);
                ll.startAnimation(animation);
                ll.setVisibility(View.GONE);

            }
        });

    }
}

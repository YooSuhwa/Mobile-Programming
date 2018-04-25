package example.com.lab3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button btn_frag1;
    public Button btn_frag2;

    public FirstFragment firstFragment;
    public SecondFragment secondFragment;

    //init method.
    public void init() {
        btn_frag1 = (Button) findViewById(R.id.btnTab1);
        btn_frag2 = (Button) findViewById(R.id.btnTab2);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
    }

    //Button click Listener
    //When you click the buttons, a new activity(page) opens.
    //TAB1 button - fitXY / Tab2 button - original
    private void setListener() {
        btn_frag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, firstFragment).commit();
            }
        });
        btn_frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_for_fragment, secondFragment).commit();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }


}

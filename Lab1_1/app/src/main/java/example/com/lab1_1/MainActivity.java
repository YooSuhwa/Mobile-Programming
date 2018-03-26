package example.com.lab1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

/*Make an App for changing an Image from RED to Blue*/
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.red);
        imageView2 = (ImageView) findViewById(R.id.blue);
    }
    public void onButton1Clicked(View v){
        changeImage();
    }

    //The image changes when you press the button.
    //If imageIndex is 1, a red android picture appears.
    //If imageIndex is 2, a blue android picture appears.
    private void changeImage(){
        if (imageIndex == 0){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        }
        else if (imageIndex == 1){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }

    }
}

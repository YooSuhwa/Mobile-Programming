package example.com.lab2_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn; //"NEXT"button

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText) findViewById(R.id.editText);
        nextBtn = (Button) findViewById(R.id.nextButton);

        //When you click this button, a new activity(page) opens.
        //Send Url through the intent.
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = Url.getText().toString();
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("Url", url);

                startActivity(intent);
            }
        });
    }
}

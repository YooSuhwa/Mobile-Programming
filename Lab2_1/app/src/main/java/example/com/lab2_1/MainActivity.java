package example.com.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText Name;
    EditText Age;
    Button button1;

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.edit1);
        Age = (EditText) findViewById(R.id.edit2);
        button1 = (Button) findViewById(R.id.butAdd);

        //When you click this button, a new activity(page) opens.
        //Send login name and age through the intent.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String N = Name.getText().toString();
               String A = Age.getText().toString();

                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", N);
                intent.putExtra("loginAge", A);
                startActivity(intent);
            }
        });
    }
}

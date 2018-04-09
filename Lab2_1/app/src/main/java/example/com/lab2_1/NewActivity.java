package example.com.lab2_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //Receive information(login name and age) from previous activity through intent.
        Intent passedIntent = getIntent();
        if (passedIntent!=null){
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");

            //Shows information received from previous activity through toast.
            Toast.makeText(this, "Student info : "+loginName+", "+loginAge, Toast.LENGTH_LONG).show();
        }

        //When you click this button,
        // this activity(NewActivity.java) is finished
        // and the go back to the previous activity(page).
        Button button0 = (Button)findViewById(R.id.butClosed);
        button0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}

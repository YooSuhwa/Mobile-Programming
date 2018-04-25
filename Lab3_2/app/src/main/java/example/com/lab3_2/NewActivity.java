package example.com.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {

    //onCreate() : Called when the activity is first created.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();

        TextView txtName = (TextView)findViewById(R.id.Fname);
        TextView txtSex = (TextView)findViewById(R.id.Fsex);
        TextView txtCheck = (TextView)findViewById(R.id.Fcheck);

        //Receive information from previous activity through intent.
        //And then set Text of TextViews that from intent.
        txtName.setText(intent.getStringExtra("name"));
        txtSex.setText(intent.getStringExtra("sex"));
        txtCheck.setText(intent.getStringExtra("check"));

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);
    }


    //When you click this button(btnBack),
    // this activity(NewActivity.java) is finished
    // and the go back to the previous activity(page).
    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnBack:
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
        }
    }
}

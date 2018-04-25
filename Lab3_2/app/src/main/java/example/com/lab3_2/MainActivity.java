package example.com.lab3_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RadioButton male, female;
    CheckBox SMS, eMail;
    EditText editName;

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.name);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        SMS = (CheckBox) findViewById(R.id.SMS);
        eMail = (CheckBox) findViewById(R.id.eMail);

        Button btnCommit = (Button) findViewById(R.id.btnEnter);
        btnCommit.setOnClickListener(this);
    }

    // Check whether information has been entered.
    // If you don't enter the information, show toast to enter the information.
    public boolean isEmpty() {

        if (TextUtils.isEmpty(editName.getText().toString())) {
            Toast.makeText(this, "이름을 입력하세요", Toast.LENGTH_SHORT).show();
            return false;
        }
        if ((!male.isChecked()) && (!female.isChecked())) {
            Toast.makeText(this, "성별을 선택하세요", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //When you click this button, a new activity(page) opens.
    //Send name and sex, check reception through the intent.
    @Override
    public void onClick(View v) {

        if( isEmpty())
        {
            Intent intent = new Intent(this, example.com.lab3_2.NewActivity.class);
            StringBuffer buffer = new StringBuffer();

            if (male.isChecked()) {
                intent.putExtra("sex", ":"+male.getText().toString());
            } else if (female.isChecked()) {
                intent.putExtra("sex", ":"+female.getText().toString());
            }
            intent.putExtra("name", ":"+editName.getText().toString());

            buffer.append(":");
            if (SMS.isChecked())
                buffer.append("SMS");
            if (eMail.isChecked()) {
                if (buffer.length() == 0)
                    buffer.append("e-mail");
                else
                    buffer.append(" & e-mail");
            }

            if (buffer.length() == 0)
                buffer.append("none");

            intent.putExtra("check", buffer.toString());

            startActivity(intent);
            finish();
        }

    }
}


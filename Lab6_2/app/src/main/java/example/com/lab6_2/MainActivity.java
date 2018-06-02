package example.com.lab6_2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String inputSn = "", inputName = "";
    EditText editSn;
    EditText editName;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    // onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bool = (Button) findViewById(R.id.BtnBool);
        Button save = (Button) findViewById(R.id.BtnSave);
        Button init = (Button) findViewById(R.id.ButInit);

        editSn = (EditText) findViewById(R.id.sn);
        editName = (EditText) findViewById(R.id.name);


        //When you click this button(불러오기),
        // Data is received using Shared preference.
        bool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                applySharedPreference();
            }
        });

        // When you click this button(저장하기),
        //   Data is saved in Shared preference.
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputSn = editSn.getText().toString();
                inputName = editName.getText().toString();
                sharedPrefernces();
            }
        });

        //When you click this button(초기화),
        //   CLEAR content of edit texts
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editName.setText("");
                editSn.setText("");
            }
        });


    }

    // In each entry of the form <Key-value> the key is student number and name
    // and value must be a primitive data type.
    //To save
    public void sharedPrefernces() {
        sh_Pref = getSharedPreferences("Lab6_2", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("number", inputSn);
        toEdit.putString("name", inputName);
        toEdit.commit();
    }

    //To load data (retrieve)
    public void applySharedPreference() {
        sh_Pref = getSharedPreferences("Lab6_2", MODE_PRIVATE);
        if (sh_Pref != null && sh_Pref.contains("number")) {
            String sn = sh_Pref.getString("number", "00000000");
            editSn.setText(sn);
            String name = sh_Pref.getString("name", "noname");
            editName.setText(name);
        }
    }
}



package example.com.lab6_1;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String inputData;
    EditText edit;

    // onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button write = (Button) findViewById(R.id.ButWrite);
        Button clear = (Button) findViewById(R.id.ButClear);
        Button read = (Button) findViewById(R.id.ButRead);
        Button finish = (Button) findViewById(R.id.ButFinish);

        edit = (EditText) findViewById(R.id.txtData);

        //When you click this button(WRITE SD FILE),
        //  WRITE user input text in EXTERNAL storage.
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputData = edit.getText().toString();

                File file = new File(Environment.getExternalStorageDirectory(), "textfile.txt");
                try {
                    FileWriter fw = new FileWriter(file, false);
                    fw.write(inputData);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(MainActivity.this, "Done writing SD 'mysdfile.txt", Toast.LENGTH_SHORT).show();

            }
        });

        //When you click this button(CLEAR SCREEN),
        //  CLEAR content of edit text
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edit.setText("");
            }
        });

        //When you click this button(READ SD FILE),
        //  READ content in EXTERNAL storage
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Environment.getExternalStorageDirectory() + "/textfile.txt";
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(path));
                    String data = null;
                    data = reader.readLine();

                    StringBuffer buf = new StringBuffer();

                    while (data != null) {
                        buf.append(data);
                        data = reader.readLine();

                    }
                    edit.setText(buf.toString() + "\n");

                    reader.close();


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        //When you click this button(FINISH APP),
        // FINISH this lab6 app.
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

package example.com.lab1_2;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    //View object reference, Connect the variables to Views
    public void init(){
        btn_clear = (Button)findViewById(R.id.clear);
        btn_print = (Button)findViewById(R.id.print);
        edit_name = (EditText)findViewById(R.id.editText);
        view_print = (TextView)findViewById(R.id.text);


    }

    //Clear edit text.
    public void clearClicked(View v){
        edit_name.setText("");

    }

    //Getting input from EditText and show this input.
    public void printClicked(View v){
        String text = "";
        text = edit_name.getText().toString();
        view_print.setText(text);
    }
}

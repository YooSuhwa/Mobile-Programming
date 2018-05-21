package example.com.lab5_2;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView, result;
    private String input;
    EditText editText;

    // onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.input);
        result = (TextView) findViewById(R.id.result);

        // When you click this button(CALCULATE),
        // Do a factorial calculation on the number entered in the editText.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = editText.getText().toString();
                //Starts the FactoThread
                new FactoThread().execute();
            }
        });


    }

    // This Threads is FactoThread
    //  that do the factorial calculation on the number entered in the editText.
    private class FactoThread extends AsyncTask<Void, Integer, Void> {
        private int facto;
        private int n;

        // onPreExecute() - Invoked on the UI thread before the task is executed.
        // Initialize the factorial result to 1.
        // The value entered by the user via editText is stored in n.
        @Override
        protected void onPreExecute() {
            facto = 1;
            n = Integer.parseInt(input);
        }


        // doInBackground() - Invoked after onPreExecute() finishes executing.
        // Contains the coding instruction which should be performed in a background thread.
        // One digit appears every 500 ms, and the factorial calculation is performed.
        @Override
        protected Void doInBackground(Void... params) {
            for (int i = n; i > 0; i--) {
                try {
                    Thread.sleep(500);
                    facto *= i;
                    //Invokes onProgressUpdate();
                    publishProgress(i);
                } catch (Exception e) {
                }
            }
            return null;

        }


        //onProgressUpdate() - Invoked on the UI thread after a call to publishProgress.
        //Show one digit appears every 500 ms on the UI.
        @Override
        protected void onProgressUpdate(Integer... values) {
            textView.append(" " + values[0].intValue());
        }

        //onPostExecute() - Synchronize itself again with the user interface thread and allows to update it.
        //Show the final factorial result on the UI.
        @Override
        protected void onPostExecute(Void aVoid) {
            result.setText("= " + facto);
        }
    }
}

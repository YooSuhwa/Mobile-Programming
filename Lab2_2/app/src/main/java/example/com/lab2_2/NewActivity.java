package example.com.lab2_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView) findViewById(R.id.textView);
        goBtn = (Button) findViewById(R.id.go);
        backBtn = (Button) findViewById(R.id.back);

        //Receive information(url) from previous activity through intent.
        final Intent passdIntent = getIntent();
        final String passedUrl = passdIntent.getStringExtra("Url");
        textView.setText(passedUrl);

        //When you click this GO button, show web page.
        //If there are no text on TextView, then float Toast message.
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!passedUrl.isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }else
                {
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.", Toast.LENGTH_LONG).show();

                }
            }
        });

        //When you click BACK button, return to first screen and float Toast message.
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌렀습니다", Toast.LENGTH_LONG).show();
                finish();

            }
        });

    }
}

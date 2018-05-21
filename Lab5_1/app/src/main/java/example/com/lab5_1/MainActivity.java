package example.com.lab5_1;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    // onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        //When you click this button(동작변경),
        // the image of a dog on each threads changes from one image to another at random.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //thread0 is image of the left dog.
                DogThread thread0 = new DogThread(0);
                thread0.start();

                //thread1 is image of the right dog.
                DogThread thread1 = new DogThread(1);
                thread1.start();
            }
        });

    }


    //Design DogThread
    class DogThread extends Thread {

        // The stateIndex is the index for three dog images
        // that change in the thread0/thread1.
        private int stateIndex;
        // The dogIndex is the index of for each dog image
        // on the left and right sides of the screen(thread0/thread1 itself).
        private int dogIndex;

        //The ArrayList stores three dog images.
        ArrayList<Integer> image = new ArrayList<Integer>();

        public DogThread(int index) {
            dogIndex = index;

            image.add(R.drawable.dog1);
            image.add(R.drawable.dog2);
            image.add(R.drawable.dog3);
        }

        //Run method in DogThread
        public void run() {
            {
                stateIndex = 0;
                for (int i = 0; i < 9; i++) {
                    //A message for printing.
                    final String msg = "dog #" + dogIndex + "state : " + stateIndex;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // Shows the state of the dog image.
                            editText.append(msg + "\n");

                            //Change image
                            if (dogIndex == 0) {
                                imageView1.setImageResource(image.get(stateIndex));

                            } else if (dogIndex == 1) {
                                imageView2.setImageResource((image.get(stateIndex)));
                            }
                        }
                    });

                    try {
                        //To change the image in random time.
                        int sleepTime = getRandomTime(500, 3000);
                        Thread.sleep(sleepTime);

                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    stateIndex++;

                    if (stateIndex >= image.size())
                        stateIndex = 0;

                }

            }
        }

        //Can get the time randomly
        public int getRandomTime(int min, int max) {
            return min + (int) (Math.random() * (max - min));
        }
    }
}

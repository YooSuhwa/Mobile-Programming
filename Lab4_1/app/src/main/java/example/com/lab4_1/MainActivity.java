package example.com.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Container layout to combine views
        LinearLayout ll = new LinearLayout(this);
        MyView vm = new MyView(this);
        //Included MyView in Linear layout
        ll.addView(vm);
        setContentView(ll);
    }
    protected class MyView extends View {
        Paint pnt = new Paint();
        Path path = new Path();
        public MyView (Context context){
            super(context);
        }

        // Draw on screen
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // Set the color, width and style of the paint
            pnt.setColor(Color.BLUE);
            pnt.setStrokeWidth(8);
            pnt.setStyle(Paint.Style.STROKE);

            //Set canvas's color
            canvas.drawColor(Color.WHITE);
            //Draw the stored path
            canvas.drawPath(path, pnt);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            float X = event.getX();
            float Y = event.getY();

            // Move the position X, Y instead of drawing the path
            if (event.getAction() == MotionEvent.ACTION_DOWN)
               path.moveTo(X,Y);

            // Draw a line according to the path moved
            else if (event.getAction() == MotionEvent.ACTION_MOVE)
                path.lineTo(X,Y);
            //else if (event.getAction() == MotionEvent.ACTION_UP)

            invalidate();
            return true;
        }
    }
}

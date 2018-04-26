package example.com.f_lab3_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // When you click this button, a context menu opens.
        mBtn = (Button) findViewById(R.id.button);
        //Register the view to which the context menu should be associated.
        registerForContextMenu(mBtn);
    }

    //When the register view receives a long-click event,
    //this method is called by system.
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");

        //To add a menu item to the context menu,
        // you create an instance of the MenuItem class and use the add() method of the Menu object.
        // Four arguments : groupId, itemId, order, title
        menu.add(0, 1, 0, "Red");
        menu.add(0, 2, 0, "Green");
        menu.add(0, 3, 0, "Blue");

    }

    // When the user selects a menu item, this method is called by system.
    public boolean onContextItemSelected (MenuItem item){
        int itemId = item.getItemId();
        if (itemId == 1) {mBtn.setTextColor(Color.RED);  return true;}
        if (itemId == 2) {mBtn.setTextColor(Color.GREEN);  return true;}
        if (itemId == 3) {mBtn.setTextColor(Color.BLUE);  return true;}
        return true;
    }

}

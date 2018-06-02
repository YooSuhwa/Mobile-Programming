package example.com.lab6_3;

        import android.content.ContentValues;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    MySQLiteOpenHelper helper;
    String name, sn, dname;
    EditText editName, editSn;
    ListView listView;
    String[] studentInfo;

    //onCreate() : Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.name);
        editSn = (EditText) findViewById(R.id.sn);
        Button add = (Button) findViewById(R.id.BtnAdd);
        final Button delete = (Button) findViewById(R.id.BtnDelete);
        listView = (ListView) findViewById(R.id.listview);

        helper = new MySQLiteOpenHelper(MainActivity.this, "lab6", null, 1);

        // When you click this button(추가),
        // add at ListView.
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check whether the user entered the name and student number.
                if (!(isEmptyName() && isEmptySn())) {
                    // If you don't enter your name and student number when you add it, a toast message is displayed.
                    Toast.makeText(MainActivity.this, "모든 항목을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                name = editName.getText().toString();
                sn = editSn.getText().toString();
                //  Log.d("suh", name+sn);

                //Insert data at SQLite database.
                insert(name, sn);
                invalidate();
            }
        });

        // When you click this button(삭제),
        // remove data from ListView.
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Check whether the user entered the name.
                if (!isEmptyName()) {
                    //  If you don't enter your name when you delete it,
                    //a toast message is displayed.
                    Toast.makeText(MainActivity.this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                //Delete data such as user input name.
                dname = editName.getText().toString();
                deleteM(dname);

                invalidate();
            }

        });


    }

    //Insert data at SQLite database.
    public void insert(String name, String sn) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name", name);
        values.put("studentNo", sn);
        //  Log.d("suh","name"+ name+"sn"+sn);
        db.insert("student", null, values);
    }

    //Delete data
    public void deleteM(String name) {
        //Deletes data with the same name entered by the user.
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
    }

    //Check whether the user entered the student number.
    public boolean isEmptySn() {
        if (TextUtils.isEmpty(editSn.getText().toString())) {
            return false;
        }

        return true;
    }

    //Check whether the user entered the name.
    public boolean isEmptyName() {

        if (TextUtils.isEmpty(editName.getText().toString())) {
            return false;
        }

        return true;
    }


    // load all data from SQLite database.
    public void select() {
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);

        // Log.d("suh","select dd");
        studentInfo = new String[c.getCount()];

        int count = 0;
        while (c.moveToNext()) {

            studentInfo[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("studentNo"));
            //  Log.d("suh","요깅");
            count++;
        }
        c.close();

    }

    //Show data at list view
    public void invalidate() {
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentInfo);
        //Log.d("suh","invalidate");
        listView.setAdapter(adapter);
    }

}

package example.com.lab6_3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lg on 2018-05-07.
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // call super() to initialize underlying database.
        // TODO Auto-generated constructor stub
    }

    //Create table student
    @Override
    public void onCreate (SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql ="create table student ("+
                "_id integer, "+
                "name text, "+
                "studentNo text);";
        db.execSQL(sql);
    }

    //make a modification to the tables structures.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists student";
        db.execSQL(sql);
        onCreate(db);
    }
}

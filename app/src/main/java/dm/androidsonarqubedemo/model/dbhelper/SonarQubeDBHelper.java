package dm.androidsonarqubedemo.model.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SonarQubeDBHelper extends SQLiteOpenHelper {


    public SonarQubeDBHelper(Context context) {
        super(context, DBConstant.DATABASE_NAME, null, DBConstant.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (db != null) {
            db.execSQL(getSQLForSacnTable());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion > newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + DBConstant.USER_TABLE_NAME + ";");
            onCreate(db);
        }
    }

    private String getSQLForSacnTable() {
        return "CREATE TABLE IF NOT EXISTS " + DBConstant.USER_TABLE_NAME + " (" +
                DBConstant.USER_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DBConstant.USER_FIELD_FNAME + " TEXT," +
                DBConstant.USER_FIELD_LNAME + " TEXT," +
                DBConstant.USER_FIELD_EMAIL + " TEXT," +
                DBConstant.USER_FIELD_PHONE + " TEXT," +
                DBConstant.USER_FIELD_PASSWORD + " TEXT)";
    }

}

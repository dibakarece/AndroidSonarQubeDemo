package dm.androidsonarqubedemo.model.dbhelper;

import android.content.ContentResolver;
import android.net.Uri;

public class DBConstant {

    public static final String AUTHORITY = "dm.androidsonarqubedemo.model.dbhelper.provider";
    public static final String DATABASE_NAME = "sonarqube.db";
    public static final int DATABASE_VERSION = 1;

    public static final String USER_TABLE_NAME = "user";
    public static final String USER_FIELD_ID = "_id";
    public static final String USER_FIELD_FNAME = "fname";
    public static final String USER_FIELD_LNAME = "lname";
    public static final String USER_FIELD_EMAIL = "email";
    public static final String USER_FIELD_PHONE = "phone";
    public static final String USER_FIELD_PASSWORD = "password";

    private static final String BASE_CONTENT_URI = "content://" + AUTHORITY;
    public static final Uri USER_URI = Uri.parse(BASE_CONTENT_URI + "/" + USER_TABLE_NAME);

    public static final String[] PROJECTION_ALL = new String[]{
            USER_FIELD_ID, USER_FIELD_FNAME, USER_FIELD_LNAME, USER_FIELD_EMAIL, USER_FIELD_PHONE, USER_FIELD_PASSWORD
    };

    public static final String SELECTION_LOGIN = USER_FIELD_EMAIL + "=? AND " + USER_FIELD_PASSWORD + "=?";


}

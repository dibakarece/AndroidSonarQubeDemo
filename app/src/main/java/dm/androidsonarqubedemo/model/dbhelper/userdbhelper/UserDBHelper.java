package dm.androidsonarqubedemo.model.dbhelper.userdbhelper;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

import dm.androidsonarqubedemo.model.data.UserDetail;
import dm.androidsonarqubedemo.model.dbhelper.DBConstant;

public class UserDBHelper {

    private Context context;
    private static UserDBHelper instance;
    private ContentResolver resolver;

    public static UserDBHelper getInstance(Context context) {
        synchronized (UserDBHelper.class) {
            instance = new UserDBHelper();
            instance.context = context;
            instance.resolver = context.getContentResolver();
        }
        return instance;
    }

    public UserDetail checkUser(String email, String password) {
        UserDetail userDetail = null;
        try {
            Cursor cursor = resolver.query(DBConstant.USER_URI, DBConstant.PROJECTION_ALL, DBConstant.SELECTION_LOGIN, new String[]{email, password}, null);
            if (cursor != null && cursor.getCount() >= 1) {
                cursor.moveToFirst();
                userDetail = new UserDetail();
                userDetail.setFname(cursor.getString(cursor.getColumnIndex(DBConstant.USER_FIELD_FNAME)));
                userDetail.setLname(cursor.getString(cursor.getColumnIndex(DBConstant.USER_FIELD_LNAME)));
                userDetail.setEmail(cursor.getString(cursor.getColumnIndex(DBConstant.USER_FIELD_EMAIL)));
                userDetail.setPhone(cursor.getString(cursor.getColumnIndex(DBConstant.USER_FIELD_PHONE)));
                userDetail.setPassword(cursor.getString(cursor.getColumnIndex(DBConstant.USER_FIELD_PASSWORD)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userDetail;
    }

    public boolean insert(ContentValues values) {
        boolean isSuccess = false;
        try {
            Uri uri = resolver.insert(DBConstant.USER_URI, values);
            isSuccess = (TextUtils.isEmpty(uri.toString()) ? false : true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

}

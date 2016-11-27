package dm.androidsonarqubedemo.model.dbhelper.userdbhelper;


import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import dm.androidsonarqubedemo.model.data.UserDetail;

public class UserTableTaskOperation extends AsyncTask<Void, Void, Void> {


    public enum OperationType {
        Delete, Insert, Fetch, CheckUser
    }

    private Context context;
    private OperationType type;
    private OperationListener listener;

    private boolean isHitSuccess = false;
    private UserDetail inUser;
    private UserDetail outUser;
    private ArrayList<UserDetail> list;


    public UserTableTaskOperation(Context context, OperationListener listener, UserDetail userDetail, OperationType type) {
        this.context = context;
        this.listener = listener;
        this.inUser = userDetail;
        this.type = type;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        switch (type) {
            case Delete:
                break;
            case Insert:
                isHitSuccess = UserDBHelper.getInstance(context).insert(inUser.getContentValue());
                break;
            case CheckUser:
                outUser = UserDBHelper.getInstance(context).checkUser(inUser.getEmail(), inUser.getPassword());
                break;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        switch (type) {
            case Delete:
                break;

            case Insert:
                listener.insert(isHitSuccess);
                break;

            case CheckUser:
                listener.isExist(outUser, (outUser == null) ? false : true);
                break;
        }
    }


}

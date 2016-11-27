package dm.androidsonarqubedemo.model.dbhelper.userdbhelper;


import dm.androidsonarqubedemo.model.data.UserDetail;

public interface OperationListener {

    void onUpdateSuccess();

    void onDeleteSuccess();

    void onFetchSuccess(UserDetail detail);

    void isExist(UserDetail detail, boolean isExist);

    void insert(boolean isSuccess);

    void onUpdateFail();

    void onDeleteFail();

    void onFetchFail();
}

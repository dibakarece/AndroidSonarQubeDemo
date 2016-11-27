package dm.androidsonarqubedemo.presenter.createact;


import android.os.AsyncTask;
import android.text.TextUtils;

import dm.androidsonarqubedemo.model.data.UserDetail;
import dm.androidsonarqubedemo.model.dbhelper.userdbhelper.OperationListener;
import dm.androidsonarqubedemo.model.dbhelper.userdbhelper.UserTableTaskOperation;

public class CreateAccActPresenterImpl implements CreateAccActPresenter.OnUiInteraction, OperationListener {

    private CreateAccActPresenter.OnUiNotifying mPresenter;

    public CreateAccActPresenterImpl(CreateAccActPresenter.OnUiNotifying presenter) {
        this.mPresenter = presenter;
    }


    @Override
    public void onCreateClickEvent(String fname, String lname, String email, String phone, String password) {
        onValidated(fname, lname, email, phone, password);
    }

    @Override
    public void onViewDestroy() {
        mPresenter = null;
    }

    @Override
    public void onValidated(String fname, String lname, String email, String phone, String password) {

        if (TextUtils.isEmpty(fname)) {
            mPresenter.onToastShow("Enter your first name");
            return;
        }

        if (TextUtils.isEmpty(lname)) {
            mPresenter.onToastShow("Enter your last name");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            mPresenter.onToastShow("Enter your email address");
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            mPresenter.onToastShow("Enter your phone number");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPresenter.onToastShow("Enter your password");
            return;
        }

        new UserTableTaskOperation(mPresenter.getActivityInstance(),
                this, new UserDetail(-1, fname, lname, email, phone, password),
                UserTableTaskOperation.OperationType.Insert)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void onUpdateSuccess() {

    }

    @Override
    public void onDeleteSuccess() {

    }

    @Override
    public void onFetchSuccess(UserDetail detail) {

    }

    @Override
    public void isExist(UserDetail detail, boolean isExist) {

    }

    @Override
    public void insert(boolean isSuccess) {
        mPresenter.onToastShow("Your account created successfully.You can Login Now");
        mPresenter.getActivityInstance().overridePendingTransition(0, 0);
        mPresenter.getActivityInstance().finish();
    }

    @Override
    public void onUpdateFail() {

    }

    @Override
    public void onDeleteFail() {

    }

    @Override
    public void onFetchFail() {

    }
}

package dm.androidsonarqubedemo.presenter.loginact;


import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;

import dm.androidsonarqubedemo.model.data.UserDetail;
import dm.androidsonarqubedemo.model.dbhelper.userdbhelper.OperationListener;
import dm.androidsonarqubedemo.model.dbhelper.userdbhelper.UserTableTaskOperation;
import dm.androidsonarqubedemo.ui.activities.CreateAccActivity;
import dm.androidsonarqubedemo.ui.activities.DashboardActivity;

public class LoginActPresenterImpl implements LoginActPresenter.OnUiInteraction, OperationListener {

    private LoginActPresenter.OnUiNotifying mPresenter;

    public LoginActPresenterImpl(LoginActPresenter.OnUiNotifying presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onLoginClickEvent(String email, String password) {
        onValidatedUser(email, password);
    }

    @Override
    public void onCreateNewUser() {
        mPresenter.getActivityInstance().startActivity(new Intent(mPresenter.getActivityInstance(), CreateAccActivity.class));
        mPresenter.getActivityInstance().overridePendingTransition(0, 0);
    }

    @Override
    public void onValidatedUser(String email, String password) {

        if (TextUtils.isEmpty(email)) {
            mPresenter.onToastShow("Enter your email address");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            mPresenter.onToastShow("Enter your password");
            return;
        }
        new UserTableTaskOperation(mPresenter.getActivityInstance(),
                this, new UserDetail(email, password),
                UserTableTaskOperation.OperationType.CheckUser)
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
        if (isExist) {
            mPresenter.onToastShow("Successfully login");
            Intent intent = new Intent(mPresenter.getActivityInstance(), DashboardActivity.class);
            intent.putExtra("user", detail);
            mPresenter.getActivityInstance().startActivity(intent);
            mPresenter.getActivityInstance().overridePendingTransition(0, 0);
        } else {
            mPresenter.onToastShow("Please enter valid credential");
        }
    }

    @Override
    public void insert(boolean isSuccess) {

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

    @Override
    public void onViewDestroy() {
        mPresenter = null;
    }
}

package dm.androidsonarqubedemo.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dm.androidsonarqubedemo.R;
import dm.androidsonarqubedemo.model.data.UserDetail;
import dm.androidsonarqubedemo.presenter.dashboardact.DashboardActPresenter;
import dm.androidsonarqubedemo.presenter.dashboardact.DashboardActPresenterImpl;
import dm.androidsonarqubedemo.presenter.loginact.LoginActPresenter;
import dm.androidsonarqubedemo.presenter.loginact.LoginActPresenterImpl;
import dm.androidsonarqubedemo.ui.BaseActivity;


public class DashboardActivity extends BaseActivity implements DashboardActPresenter.OnUiNotifying {

    private TextView txt_name;
    private TextView txt_email;
    private TextView txt_phone;

    DashboardActPresenterImpl actPresenter;

    @Override
    protected void onDestroy() {
        actPresenter.onViewDestroy();
        super.onDestroy();
    }

    @Override
    public Activity getActivityInstance() {
        return DashboardActivity.this;
    }

    @Override
    protected void initPresenter() {
        actPresenter = new DashboardActPresenterImpl(this);
    }

    @Override
    protected void initUiComponent() {
        setContentView(R.layout.activity_dashboard);
        txt_name = (TextView) findViewById(R.id.login_edt_name);
        txt_email = (TextView) findViewById(R.id.login_edt_email);
        txt_phone = (TextView) findViewById(R.id.login_edt_phone);
    }

    @Override
    protected void initListener() {
        txt_phone.setOnClickListener(this);
    }

    @Override
    protected void setBundleValues() {
        UserDetail mDetail = getIntent().getParcelableExtra("user");
        if (mDetail != null) {
            txt_name.setText(mDetail.getFname() + " " + mDetail.getLname());
            txt_email.setText(mDetail.getEmail());
            txt_phone.setText(mDetail.getPhone());
        }
    }

    @Override
    protected void removeListener() {
        txt_phone.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onToastShow(String msg) {
        Toast.makeText(getActivityInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}

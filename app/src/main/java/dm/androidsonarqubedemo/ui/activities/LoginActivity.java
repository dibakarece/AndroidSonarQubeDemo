package dm.androidsonarqubedemo.ui.activities;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dm.androidsonarqubedemo.R;
import dm.androidsonarqubedemo.presenter.loginact.LoginActPresenter;
import dm.androidsonarqubedemo.presenter.loginact.LoginActPresenterImpl;
import dm.androidsonarqubedemo.ui.BaseActivity;


public class LoginActivity extends BaseActivity implements LoginActPresenter.OnUiNotifying {

    private EditText edt_email;
    private EditText edt_password;
    private TextView btn_login;
    private TextView btn_createacc;

    LoginActPresenterImpl actPresenter;

    @Override
    protected void onDestroy() {
        actPresenter.onViewDestroy();
        super.onDestroy();
    }

    @Override
    public Activity getActivityInstance() {
        return LoginActivity.this;
    }

    @Override
    protected void initPresenter() {
        actPresenter = new LoginActPresenterImpl(this);
    }

    @Override
    protected void initUiComponent() {
        setContentView(R.layout.activity_login);
        edt_email = (EditText) findViewById(R.id.login_edt_email);
        edt_password = (EditText) findViewById(R.id.login_edt_password);
        btn_login = (TextView) findViewById(R.id.login_btn_login);
        btn_createacc = (TextView) findViewById(R.id.login_btn_createaccount);
    }

    @Override
    protected void initListener() {
        btn_login.setOnClickListener(this);
        btn_createacc.setOnClickListener(this);
    }

    @Override
    protected void setBundleValues() {

    }

    @Override
    protected void removeListener() {
        btn_login.setOnClickListener(null);
        btn_createacc.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.login_btn_login:
                actPresenter.onLoginClickEvent(edt_email.getText().toString(), edt_password.getText().toString());
                break;
            case R.id.login_btn_createaccount:
                actPresenter.onCreateNewUser();
                break;
        }
    }

    @Override
    public void onToastShow(String msg) {
        Toast.makeText(getActivityInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}

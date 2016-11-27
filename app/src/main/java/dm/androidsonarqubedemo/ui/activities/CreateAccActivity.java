package dm.androidsonarqubedemo.ui.activities;


import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dm.androidsonarqubedemo.R;
import dm.androidsonarqubedemo.presenter.createact.CreateAccActPresenter;
import dm.androidsonarqubedemo.presenter.createact.CreateAccActPresenterImpl;
import dm.androidsonarqubedemo.ui.BaseActivity;

public class CreateAccActivity extends BaseActivity implements CreateAccActPresenter.OnUiNotifying {

    private EditText edt_fname;
    private EditText edt_lname;
    private EditText edt_email;
    private EditText edt_phone;
    private EditText edt_password;
    private TextView btn_create;

    CreateAccActPresenterImpl actPresenter;

    @Override
    protected void onDestroy() {
        actPresenter.onViewDestroy();
        super.onDestroy();
    }

    @Override
    public Activity getActivityInstance() {
        return CreateAccActivity.this;
    }

    @Override
    protected void initPresenter() {
        actPresenter = new CreateAccActPresenterImpl(this);
    }

    @Override
    protected void initUiComponent() {
        setContentView(R.layout.activity_createaccount);

        edt_fname = (EditText) findViewById(R.id.login_edt_fname);
        edt_lname = (EditText) findViewById(R.id.login_edt_lname);
        edt_email = (EditText) findViewById(R.id.login_edt_email);
        edt_phone = (EditText) findViewById(R.id.login_edt_phone);
        edt_password = (EditText) findViewById(R.id.login_edt_password);

        btn_create = (TextView) findViewById(R.id.login_btn_create);
    }

    @Override
    protected void initListener() {
        btn_create.setOnClickListener(this);
    }

    @Override
    protected void setBundleValues() {

    }

    @Override
    protected void removeListener() {
        btn_create.setOnClickListener(null);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_btn_create:
                actPresenter.onCreateClickEvent(edt_fname.getText().toString(), edt_lname.getText().toString(),
                        edt_email.getText().toString(), edt_phone.getText().toString(), edt_password.getText().toString());
                break;
        }
    }

    @Override
    public void onToastShow(String msg) {
        Toast.makeText(getActivityInstance(), msg, Toast.LENGTH_SHORT).show();
    }
}

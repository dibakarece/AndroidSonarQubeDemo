package dm.androidsonarqubedemo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPresenter();
        initUiComponent();
        initListener();
        setBundleValues();
    }

    @Override
    public void onClick(View view) {

    }

    protected abstract void initPresenter();

    protected abstract void initUiComponent();

    protected abstract void initListener();

    protected abstract void setBundleValues();

    protected abstract void removeListener();


}

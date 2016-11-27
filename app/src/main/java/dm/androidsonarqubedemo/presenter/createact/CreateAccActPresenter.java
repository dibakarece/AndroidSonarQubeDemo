package dm.androidsonarqubedemo.presenter.createact;


import android.app.Activity;

import dm.androidsonarqubedemo.presenter.BasePresenter;

public interface CreateAccActPresenter {

    interface OnUiInteraction extends BasePresenter.OnUiInteraction {
        void onCreateClickEvent(String fname, String lname, String email, String phone, String password);

        void onValidated(String fname, String lname, String email, String phone, String password);
    }

    interface OnUiNotifying extends BasePresenter.OnUiNotifying {
        Activity getActivityInstance();
    }
}

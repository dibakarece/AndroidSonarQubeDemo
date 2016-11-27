package dm.androidsonarqubedemo.presenter.loginact;


import android.app.Activity;

import dm.androidsonarqubedemo.presenter.BasePresenter;

public interface LoginActPresenter {

    interface OnUiInteraction extends BasePresenter.OnUiInteraction {
        void onLoginClickEvent(String email, String password);

        void onValidatedUser(String email, String password);

        void onCreateNewUser();
    }

    interface OnUiNotifying extends BasePresenter.OnUiNotifying {
        Activity getActivityInstance();
    }
}

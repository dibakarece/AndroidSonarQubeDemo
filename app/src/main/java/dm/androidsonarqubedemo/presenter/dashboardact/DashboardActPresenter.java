package dm.androidsonarqubedemo.presenter.dashboardact;


import android.app.Activity;

import dm.androidsonarqubedemo.presenter.BasePresenter;

public interface DashboardActPresenter {

    interface OnUiInteraction extends BasePresenter.OnUiInteraction {

    }

    interface OnUiNotifying extends BasePresenter.OnUiNotifying {
        Activity getActivityInstance();
    }
}

package dm.androidsonarqubedemo.presenter.dashboardact;


public class DashboardActPresenterImpl implements DashboardActPresenter.OnUiInteraction {

    private DashboardActPresenter.OnUiNotifying mPresenter;

    public DashboardActPresenterImpl(DashboardActPresenter.OnUiNotifying presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onViewDestroy() {
        mPresenter = null;
    }
}

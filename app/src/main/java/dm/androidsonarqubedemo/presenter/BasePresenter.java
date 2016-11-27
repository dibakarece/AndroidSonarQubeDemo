package dm.androidsonarqubedemo.presenter;


public interface BasePresenter {

    interface OnUiInteraction {
        void onViewDestroy();
    }

    interface OnUiNotifying {
        void onToastShow(String msg);
    }
}

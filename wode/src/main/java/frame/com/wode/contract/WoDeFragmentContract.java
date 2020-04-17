package frame.com.wode.contract;

import frame.com.libcommon.mvp.BaseView;

public interface WoDeFragmentContract {

    interface IPresenter {
        void gotoWifi();

        void gotoTest(Class<?> clas);

        void gotoSetting();

    }

    interface IModel {

        void gotoWifi();

        void gotoTest(Class<?> clas);

        void gotoSetting();
    }

    interface IView extends BaseView {
        void setShowWifi();

        void setShowTest();

        void setShowSetting();
    }
}
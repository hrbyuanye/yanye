package frame.com.modle_main.contract;

import frame.com.libcommon.mvp.BaseView;

public interface MainlContract {


    interface IPresenter {
        void downloadDb();

        void uploadDb();

        void logInMsg();

        void logOutMsg();
    }

    interface IModel {
        /***
         * 下载数据库
         */
        boolean downloadDb();

        /***
         * 上传数据库
         */
        boolean uploadDb();

        /**
         * 登录运行
         *
         * @return
         */
        boolean logInMsg();

        /**
         * 退出运行
         *
         * @return
         */
        boolean logOutMsg();
    }

    interface IView extends BaseView {
        /**
         * 处理
         *
         * @param result
         */
        void showDownloadDbResult(boolean result);

        void showUploadDbResult(boolean result);

        void showLogInMsg();

        void showLogOutMsg();
    }
}

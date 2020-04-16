package frame.com.modle_login.contract;

import frame.com.libcommon.mvp.BaseView;
import frame.com.modle_login.bean.LogInDetailBean;

public interface LogInDetailContract {

    interface IPresenter{
        //外部调
        void getLogInResult(String account , String pwd);
    }

    interface IModel{
        //请求结果
        LogInDetailBean getLogInResult(String account , String pwd);
    }

    interface IView extends BaseView {
        //处理结果
        void showLogInDetail(LogInDetailBean logInDetail);
    }
}

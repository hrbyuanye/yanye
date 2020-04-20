package frame.com.wode.contract;

import frame.com.libcommon.mvp.BaseView;

public interface WoDeNetTestContract  {

    interface IPresenter{

       void isDeviceBind(String deviceId) ;
        void getUserInfo(String account);

   }

    interface IModel {
        void isDeviceBind(String deviceId) ;
        void getUserInfo(String account);
    }

    interface IView extends BaseView {
        void setShowBindSucc();
        void setShowBindFail();
        void setShowGetUserSucc() ;
        void setShowGetUserFail() ;

    }

}

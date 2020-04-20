package frame.com.wode.contract;

import frame.com.libcommon.mvp.BaseView;

public interface WoDeNetTestContract  {

    interface IPresenter{

       void isDeviceBind(String deviceId) ;

   }

    interface IModel {
        void isDeviceBind(String deviceId) ;
    }

    interface IView extends BaseView {
        void setShowBindSucc();

        void setShowBindFail();

    }

}

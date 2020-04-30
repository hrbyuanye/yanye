package frame.com.wode.contract;

import frame.com.libcommon.mvp.BaseView;
import frame.com.libnetwork_api.base.BaseObserver;

public interface WoDeNetTestContract  {

    interface IPresenter{

       void isDeviceBind(String deviceId) ;
        void getUserInfo(String account);

   }

    interface IModel {
        void isDeviceBind(String deviceId , BaseObserver observer) ;
        void getUserInfo(String account ,BaseObserver observer);
    }

    interface IView extends BaseView { 

    }

}

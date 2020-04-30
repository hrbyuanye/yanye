package frame.com.wode.api;


import com.trello.rxlifecycle2.LifecycleProvider;

import frame.com.libcommon.BaseApplication;
import frame.com.libcommon.I.IUrlConfig;
import frame.com.libnetwork_api.base.ApiBase;
import io.reactivex.Observer;

public class  WoDeNetworkApi extends ApiBase {
    private static volatile WoDeNetworkApi instance = null;

    private WoDeApiServers mServers ;
    private WoDeNetworkApi() {
        super(IUrlConfig.IAppConfig.appURL, BaseApplication.getApplication());
        mServers=  retrofit.create(WoDeApiServers.class) ;
    }

    public static WoDeNetworkApi getInstance() {
        if (instance == null) {
            synchronized (WoDeNetworkApi.class) {
                if (instance == null) {
                    instance = new WoDeNetworkApi() ;
                }
            }
        }
        return instance;
    }

    /**
     * 判断设备是否绑定
     * @param deviceId
     * @param observer
     * @param lifecycle
     */
    public void  isDeviceBinding (String deviceId ,Observer observer ,LifecycleProvider lifecycle){
        ApiSubscribe(mServers.isDeviceBinding(deviceId) ,observer,lifecycle) ;
    }


    /**
     * 查询信息
     * @param account
     * @param observer
     * @param lifecycle
     */
    public  void getUserInfo(String account , Observer observer , LifecycleProvider  lifecycle){

        ApiSubscribe(mServers.getUserInfo(account) ,observer ,lifecycle);


    }
}

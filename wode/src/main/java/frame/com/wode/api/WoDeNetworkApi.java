package frame.com.wode.api;

import com.trello.rxlifecycle2.LifecycleProvider;

import frame.com.libcommon.I.IUrlConfig;
import frame.com.libnetwork_api.ApiBase;
import frame.com.libnetwork_api.BaseResult;
import frame.com.wode.api.bean.UserInfo;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class  WoDeNetworkApi extends ApiBase {
    private static volatile WoDeNetworkApi instance = null;

    private ZuoYeApiServers mServers ;
    private WoDeNetworkApi() {
        super(IUrlConfig.IAppConfig.appURL);
        mServers=  retrofit.create(ZuoYeApiServers.class) ;
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
     * @param lifecycl
     */
    public void  isDeviceBinding (String deviceId ,Observer observer ,LifecycleProvider lifecycl){
        ApiSubscribe(mServers.isDeviceBinding(deviceId) ,observer,lifecycl) ;
    }
}

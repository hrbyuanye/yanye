package frame.com.wode.api;

import frame.com.libcommon.I.IUrlConfig;
import frame.com.libnetwork_api.ApiBase;

public class  WoDeNetworkApi extends ApiBase {
    private static volatile WoDeNetworkApi instance = null;

    private WoDeNetworkApi() {
        super(IUrlConfig.IAppConfig.appURL);
    }

    public static WoDeNetworkApi getInstance() {
        if (instance == null) {
            synchronized (WoDeNetworkApi.class) {
                if (instance == null) {
                }
            }
        }
        return instance;
    }
}

package debug;


import java.util.HashMap;

import frame.com.libcommon.BaseApplication;
import frame.com.libnetwork_api.base.ApiBase;
import frame.com.libnetwork_api.base.INetworkRequestInfo;

public class MyApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        ApiBase.setNetworkRequestInfo(new INetworkRequestInfo() {
            @Override
            public HashMap<String, String> getRequestHeaderMap() {
                return null;
            }

            @Override
            public boolean isDebug() {
                return true;
            }
        });
    }
}

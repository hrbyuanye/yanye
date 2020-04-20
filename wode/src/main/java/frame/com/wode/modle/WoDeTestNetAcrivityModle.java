package frame.com.wode.modle;

import android.content.Context;

import frame.com.libcommon.mvp.BaseModel;
import frame.com.libnetwork_api.BaseObserver;
import frame.com.wode.api.WoDeNetworkApi;
import frame.com.wode.contract.WoDeNetTestContract;

public class WoDeTestNetAcrivityModle extends BaseModel implements WoDeNetTestContract.IModel {

    public WoDeTestNetAcrivityModle(Context context) {
        super(context);
    }


    @Override
    public void isDeviceBind(String deviceId, BaseObserver observer) {

        WoDeNetworkApi.getInstance().isDeviceBinding(deviceId ,observer ,getLifecycle());
    }

    @Override
    public void getUserInfo(String account, BaseObserver observer) {

        WoDeNetworkApi.getInstance().getUserInfo(account ,observer ,getLifecycle());

    }
}

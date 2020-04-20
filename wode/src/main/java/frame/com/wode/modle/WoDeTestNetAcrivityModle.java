package frame.com.wode.modle;

import android.content.Context;

import frame.com.libcommon.mvp.BaseModel;
import frame.com.libcommon.util.log.KLogUtil;
import frame.com.libnetwork_api.BaseObserver;
import frame.com.libnetwork_api.errorhandler.ExceptionHandler;
import frame.com.libnetwork_api.log.KLog;
import frame.com.wode.api.WoDeNetworkApi;
import frame.com.wode.api.bean.UserInfo;
import frame.com.wode.contract.WoDeNetTestContract;

public class WoDeTestNetAcrivityModle extends BaseModel implements WoDeNetTestContract.IModel {

    public WoDeTestNetAcrivityModle(Context context) {
        super(context);
    }


    @Override
    public void isDeviceBind(String deviceId) {

        WoDeNetworkApi.getInstance().isDeviceBinding(deviceId, new BaseObserver<UserInfo>() {
            @Override
            public void onResultData(UserInfo userInfo) {

            }

            @Override
            public void onReponseError(ExceptionHandler.ResponeThrowable responeThrowable) {

            }

            @Override
            public void onOtherError(Throwable throwable) {

            }
        }, getLifecycle());

    }

    @Override
    public void getUserInfo(String account) {
        WoDeNetworkApi.getInstance().getUserInfo(account, new BaseObserver<UserInfo>() {
                    @Override
                    public void onResultData(UserInfo userInfo) {
                        KLogUtil.printLine("请求完成数据 start", true);
                        KLog.e(userInfo.toString());
                        KLogUtil.printLine("请求完成数据 end", false);

                    }

                    @Override
                    public void onReponseError(ExceptionHandler.ResponeThrowable responeThrowable) {

                    }

                    @Override
                    public void onOtherError(Throwable throwable) {

                    }
                }
                , getLifecycle());
    }

}

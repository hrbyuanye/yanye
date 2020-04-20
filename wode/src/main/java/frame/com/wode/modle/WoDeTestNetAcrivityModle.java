package frame.com.wode.modle;

import android.content.Context;

import frame.com.libcommon.mvp.BaseModel;
import frame.com.libnetwork_api.errorhandler.ExceptionHandler;
import frame.com.libnetwork_api.log.KLog;
import frame.com.wode.api.WoDeNetworkApi;
import frame.com.wode.api.bean.UserInfo;
import frame.com.wode.contract.WoDeNetTestContract;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class WoDeTestNetAcrivityModle  extends BaseModel  implements WoDeNetTestContract.IModel{

    public WoDeTestNetAcrivityModle(Context context) {
        super(context);
    }


    @Override
    public void isDeviceBind(String deviceId) {

        WoDeNetworkApi.getInstance().isDeviceBinding(deviceId, new Observer<UserInfo>() {
            @Override
            public void onSubscribe(Disposable d) {
                //show dialog

            }

            @Override
            public void onNext(UserInfo userInfo) {
                if (userInfo!=null){
                    KLog.e(userInfo.toString());
                }
                //result
            }

            @Override
            public void onError(Throwable e) {
                //  hide dialog
                ExceptionHandler.ResponeThrowable exception = (ExceptionHandler.ResponeThrowable) e;
                KLog.e("ResponeThrowable ..code."+exception.code);
                KLog.e("ResponeThrowable ..code."+exception.message);

            }

            @Override
            public void onComplete() {
                //hide Dialog

            }
        }, getLifecycle());

    }

}

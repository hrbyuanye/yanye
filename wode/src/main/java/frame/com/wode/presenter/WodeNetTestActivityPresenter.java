package frame.com.wode.presenter;

import android.content.Context;

import frame.com.libcommon.BaseApplication;
import frame.com.libcommon.mvp.BasePresenter;
import frame.com.libnetwork_api.base.BaseObserver;
import frame.com.wode.api.bean.UserInfo;
import frame.com.wode.contract.WoDeNetTestContract;
import frame.com.wode.modle.WoDeTestNetAcrivityModle;

public class WodeNetTestActivityPresenter extends BasePresenter<WoDeTestNetAcrivityModle, WoDeNetTestContract.IView> implements WoDeNetTestContract.IPresenter {
    public WodeNetTestActivityPresenter(Context context) {
        super(context);
    }

    @Override
    public WoDeTestNetAcrivityModle initModel() {
        return new WoDeTestNetAcrivityModle(mContext);
    }

    @Override
    public void isDeviceBind(String deviceId) {
        mModel.isDeviceBind(deviceId, new BaseObserver<UserInfo>(BaseApplication.getApplication()) {
            @Override
            public void onLoadSuccess(UserInfo userInfo, int couts) {

            }

            @Override
            public void onLoadFail(Throwable throwable) {

            }
        });

    }

    @Override
    public void getUserInfo(String account) {
        mModel.getUserInfo(account, new BaseObserver<UserInfo>(BaseApplication.getApplication()) {
            @Override
            public void onLoadSuccess(UserInfo userInfo, int couts) {

            }

            @Override
            public void onLoadFail(Throwable throwable) {

            }
        }.setLoadView(mView));
    }
}

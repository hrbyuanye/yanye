package frame.com.wode.presenter;

import android.content.Context;

import fram.lib.utils.ToastUtils;
import fram.lib.utils.log.KLog;
import frame.com.libcommon.BaseApplication;
import frame.com.libcommon.mvp.BasePresenter;
import frame.com.libnetwork_api.base.BaseCachedData;
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
        BaseCachedData<UserInfo> cachedData = new BaseCachedData<>() ;
        cachedData.cacheKey = "user_info" ;
//        mModel.getUserInfo(account, new BaseObserver<UserInfo>(BaseApplication.getApplication()) {
//            @Override
//            public void onLoadSuccess(UserInfo userInfo, int couts) {
//
//                KLog.e("userInfo",userInfo.toString());
//            }
//
//            @Override
//            public void onLoadFail(Throwable throwable) {
//                ToastUtils.showShort(throwable.getMessage());
//
//            }
//        }.setLoadView(mView).setCacheData(cachedData ,UserInfo.class));
        mModel.getUserInfo(account, new BaseObserver<UserInfo>(BaseApplication.getApplication()) {
            @Override
            public void onLoadSuccess(UserInfo userInfo, int couts) {

                KLog.e("onLoadSuccess .."+userInfo.toString());
            }

            @Override
            public void onLoadFail(Throwable throwable) {

            }
        }.setLoadView(mView));
    }
}

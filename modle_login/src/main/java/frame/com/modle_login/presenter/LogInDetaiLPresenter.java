package frame.com.modle_login.presenter;

import android.content.Context;
import android.os.Handler;

import frame.com.libcommon.mvp.BasePresenter;
import frame.com.modle_login.bean.LogInDetailBean;
import frame.com.modle_login.contract.LogInDetailContract;
import frame.com.modle_login.modle.LogInDetailModel;

public class LogInDetaiLPresenter extends BasePresenter<LogInDetailModel, LogInDetailContract.IView> implements LogInDetailContract.IPresenter {
    public LogInDetaiLPresenter(Context context) {
        super(context);
    }

    @Override
    public LogInDetailModel initModel() {
        return new LogInDetailModel(mContext);
    }

    @Override
    public void getLogInResult(final String account, final String pwd) {
        mView.showInitLoadView();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LogInDetailBean result = mModel.getLogInResult(account, pwd);
                if (result != null) {
                    mView.showLogInDetail(result);
                } else {
                    mView.showNoDataView();
                }
                mView.hideInitLoadView();

            }
        }, 300);
    }
}

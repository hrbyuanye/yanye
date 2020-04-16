package frame.com.modle_main.presenter;

import android.content.Context;

import frame.com.libcommon.mvp.BasePresenter;
import frame.com.modle_main.contract.MainlContract;
import frame.com.modle_main.modle.MainModle;

public class MainPresenter extends BasePresenter<MainModle ,MainlContract.IView> implements MainlContract.IPresenter{
    public MainPresenter(Context context) {
        super(context);
    }

    @Override
    public MainModle initModel() {
        return new MainModle(mContext);
    }

    @Override
    public void downloadDb() {
        mModel.downloadDb() ;
    }

    @Override
    public void uploadDb() {
        mModel.uploadDb() ;
    }

    @Override
    public void logInMsg() {
        mModel.logInMsg() ;
    }

    @Override
    public void logOutMsg() {
        mModel.logOutMsg() ;
    }
}

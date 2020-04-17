package frame.com.wode.presenter;

import android.content.Context;

import frame.com.libcommon.mvp.BasePresenter;
import frame.com.wode.contract.WoDeFragmentContract;
import frame.com.wode.modle.WoDeFragmentModle;

public class WoDeFragmentPresenter extends BasePresenter<WoDeFragmentModle, WoDeFragmentContract.IView> implements WoDeFragmentContract.IPresenter{

    public WoDeFragmentPresenter(Context context) {
        super(context);
    }

    @Override
    public WoDeFragmentModle initModel() {
        return new WoDeFragmentModle(mContext);
    }

    @Override
    public void gotoWifi() {

    }

    @Override
    public void gotoTest(Class<?> clas) {

    }

    @Override
    public void gotoSetting() {

    }
}

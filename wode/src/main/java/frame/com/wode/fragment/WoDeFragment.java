package frame.com.wode.fragment;

import android.app.Activity;
import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.base.BaseMvpFragment;
import frame.com.libcommon.event.BaseActivityEvent;
import frame.com.libcommon.event.BaseFragmentEvent;
import frame.com.libcommon.util.log.KLog;
import frame.com.wode.R;
import frame.com.wode.contract.WoDeFragmentContract;
import frame.com.wode.modle.WoDeFragmentModle;
import frame.com.wode.presenter.WoDeFragmentPresenter;

public class WoDeFragment extends BaseMvpFragment<WoDeFragmentModle, WoDeFragmentContract.IView, WoDeFragmentPresenter> implements WoDeFragmentContract.IView {


    public static WoDeFragment newInstance() {
        KLog.e("我的");
        return new WoDeFragment();
    }

    @Override
    public View bindLayout() {
        return inflate(R.layout.fragment_wo);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }

    @Override
    public WoDeFragmentPresenter initPresenter() {
        return new WoDeFragmentPresenter(mActivity);
    }

    @Override
    public void setShowWifi() {

    }

    @Override
    public void setShowTest() {

    }

    @Override
    public void setShowSetting() {

    }

    @Override
    public void showNoDataView() {

    }

    @Override
    public void showInitLoadView() {

    }

    @Override
    public void hideInitLoadView() {

    }
}

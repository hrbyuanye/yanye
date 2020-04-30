package frame.com.wode.fragment;

import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.OnClick;
import frame.com.libcommon.base.BaseMvpFragment;
import fram.lib.utils.log.KLog;
import frame.com.wode.R;
import frame.com.wode.R2;
import frame.com.wode.activity.NetTeastActivity;
import frame.com.wode.contract.WoDeFragmentContract;
import frame.com.wode.modle.WoDeFragmentModle;
import frame.com.wode.presenter.WoDeFragmentPresenter;

public class WoDeFragment extends BaseMvpFragment<WoDeFragmentModle, WoDeFragmentContract.IView, WoDeFragmentPresenter> implements WoDeFragmentContract.IView {

    @BindView(R2.id.fm_test)
    FrameLayout fmTest;
    @BindView(R2.id.fm_setting)
    FrameLayout fmSetting;

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

    @OnClick({R2.id.fm_test, R2.id.fm_setting})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.fm_test) {
            mPresenter.gotoTest(NetTeastActivity.class);

        } else if (i == R.id.fm_setting) {
            mPresenter.gotoSetting();
        }
    }
}

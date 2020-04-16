package frame.com.modle_main;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;

import frame.com.libcommon.I.IRoutPath;
import frame.com.libcommon.base.BaseMvpActivity;
import frame.com.libcommon.provider.IBijiProvider;
import frame.com.libcommon.provider.IJiaoCaiProvider;
import frame.com.libcommon.provider.IWoDeProvider;
import frame.com.libcommon.provider.IYueDuProvider;
import frame.com.libcommon.provider.IZuoYeProvider;
import frame.com.libcommon.util.log.KLog;
import frame.com.modle_main.contract.MainlContract;
import frame.com.modle_main.modle.MainModle;
import frame.com.modle_main.presenter.MainPresenter;

@Route(path = IRoutPath.IMainPath.ActivityModleMainPath, name = IRoutPath.IMainPath.ActivityModleMainName)
public class ModleMainActivity extends BaseMvpActivity<MainModle, MainlContract.IView, MainPresenter> implements MainlContract.IView {
    BottomNavigationView navigation;

    @Autowired(name = IRoutPath.IProviderPath.JiaoCaiPath)
    IJiaoCaiProvider mJiaoCaiProvider;
    private Fragment mJiaoCaiFragment;

    @Autowired(name = IRoutPath.IProviderPath.YueDuPath)
    IYueDuProvider mYueDuProvider;
    private Fragment mYueDuFragment;

    @Autowired(name = IRoutPath.IProviderPath.BiJiPath)
    IBijiProvider mBijiProvider;
    private Fragment mBijiFragment;

    @Autowired(name = IRoutPath.IProviderPath.ZuoYePath)
    IZuoYeProvider mZuoYeProvider;
    private Fragment mZuoYeFragment;

    @Autowired(name = IRoutPath.IProviderPath.WoDePath)
    IWoDeProvider mWoDeProvider;
    private Fragment mWoDeFragment;
    private Fragment mCurrFragment;

    @Override
    public View bindLayout() {
        return inflate(R.layout.activity_modle_main);
    }

    @Override
    public void initView() {
        navigation = this.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(menuItem -> {
            int i = menuItem.getItemId();
            if (i == R.id.navigation_jc) {
                ModleMainActivity.this.switchContent(mCurrFragment, mJiaoCaiFragment);
                mCurrFragment = mJiaoCaiFragment;

                return true;
            } else if (i == R.id.navigation_yd) {
                ModleMainActivity.this.switchContent(mCurrFragment, mYueDuFragment);
                mCurrFragment = mYueDuFragment;

                return true;
            } else if (i == R.id.navigation_bj) {
                ModleMainActivity.this.switchContent(mCurrFragment, mBijiFragment);
                mCurrFragment = mBijiFragment;
                return true;
            } else if (i == R.id.navigation_zy) {
                ModleMainActivity.this.switchContent(mCurrFragment, mZuoYeFragment);
                mCurrFragment = mZuoYeFragment;
                return true;
            } else if (i == R.id.navigation_wd) {
                ModleMainActivity.this.switchContent(mCurrFragment, mWoDeFragment);
                mCurrFragment = mWoDeFragment;
                return true;
            }

            return false;
        });

        if (mJiaoCaiProvider != null) {
            mJiaoCaiFragment = mJiaoCaiProvider.getMainJiaoCaiFragment();
        }

        if (mYueDuProvider != null) {
            mYueDuFragment = mYueDuProvider.getMainYueDuFragment();
        }
        if (mBijiProvider != null) {
            mBijiFragment = mBijiProvider.getMainBiJiFragment();
        }

        if (mZuoYeProvider != null) {
            mZuoYeFragment = mZuoYeProvider.getMainZuoYeFragment();
        }

        if (mWoDeProvider != null) {
            mWoDeFragment = mWoDeProvider.getMainWoDeFragment();
        }

        mCurrFragment = mYueDuFragment;
        if (mYueDuFragment != null) {
            KLog.e("initView ..commit");
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mYueDuFragment).commit();
        }
    }


    public void switchContent(Fragment from, Fragment to) {
        if (from == null || to == null) {
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!to.isAdded()) {
            transaction.hide(from).add(R.id.frame_content, to).commit();
        } else {
            transaction.hide(from).show(to).commit();
        }
    }


    @Override
    public void loadData() {

    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showDownloadDbResult(boolean result) {

    }

    @Override
    public void showUploadDbResult(boolean result) {

    }

    @Override
    public void showLogInMsg() {

    }

    @Override
    public void showLogOutMsg() {

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

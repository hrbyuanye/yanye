package frame.com.wode.activity;

import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;

import com.kingja.loadsir.LoadSirUtil;

import frame.com.libcommon.I.IUrlConfig;
import frame.com.libcommon.base.BaseActivity;
import frame.com.libcommon.base.BaseMvpActivity;
import frame.com.wode.R;
import frame.com.wode.contract.WoDeNetTestContract;
import frame.com.wode.modle.WoDeTestNetAcrivityModle;
import frame.com.wode.presenter.WodeNetTestActivityPresenter;

public class NetTeastActivity extends BaseMvpActivity<WoDeTestNetAcrivityModle, WoDeNetTestContract.IView, WodeNetTestActivityPresenter> implements WoDeNetTestContract.IView {

    @Override
    public View bindLayout() {
        return inflate(R.layout.activity_wode_net_test);
    }

    @Override
    public void initView() {
        this.findViewById(R.id.btn_bind).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.isDeviceBind(IUrlConfig.IAppConfig.uuiId);
            }
        });

        this.findViewById(R.id.btn_userinfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getUserInfo("10000149");
            }
        });

        registLoadSir(this);
    }

    @Override
    public void loadData() {

        mPresenter.getUserInfo("10000149");

    }

    @Override
    public WodeNetTestActivityPresenter initPresenter() {
        return new WodeNetTestActivityPresenter(this);
    }


    @Override
    public void showNoDataView() {

    }

}

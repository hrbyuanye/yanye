package frame.com.wode.activity;

import android.view.View;

import frame.com.libcommon.I.IUrlConfig;
import frame.com.libcommon.base.BaseActivity;
import frame.com.libcommon.base.BaseMvpActivity;
import frame.com.wode.R;
import frame.com.wode.contract.WoDeNetTestContract;
import frame.com.wode.modle.WoDeTestNetAcrivityModle;
import frame.com.wode.presenter.WodeNetTestActivityPresenter;

public class NetTeastActivity extends BaseMvpActivity<WoDeTestNetAcrivityModle,WoDeNetTestContract.IView,WodeNetTestActivityPresenter> implements WoDeNetTestContract.IView {
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

    }

    @Override
    public void loadData() {

    }

    @Override
    public WodeNetTestActivityPresenter initPresenter() {
        return new WodeNetTestActivityPresenter(this);
    }

    @Override
    public void setShowBindSucc() {

    }

    @Override
    public void setShowBindFail() {

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

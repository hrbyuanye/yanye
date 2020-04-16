package frame.com.wode.fragment;

import android.view.View;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.util.log.KLog;
import frame.com.wode.R;

public class WoDeFragment extends BaseFragment {
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
}

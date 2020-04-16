package frame.com.wode.fragment;

import android.view.View;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.event.BaseActivityEvent;
import frame.com.libcommon.event.BaseFragmentEvent;
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

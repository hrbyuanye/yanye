package frame.com.zuoye.fragment;

import android.view.View;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.util.log.KLog;
import frame.com.zuoye.R;

public class ZuoYeFragment extends BaseFragment {
    public static ZuoYeFragment newInstance() {
        KLog.e("作业");
        return new ZuoYeFragment();
    }

    @Override
    public View bindLayout() {
        return inflate(R.layout.fragment_zuoye);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }
}

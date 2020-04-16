package frame.com.modle_reader.fragment;

import android.view.View;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.util.log.KLog;
import frame.com.modle_reader.R;

public class YueDuFragment extends BaseFragment {
    public static YueDuFragment newInstance() {
        KLog.e("阅读....YueDuFragment");
        return new YueDuFragment();
    }

    @Override
    public View bindLayout() {
        return inflate(R.layout.fragment_yuedu);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }
}

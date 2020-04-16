package frame.com.modle_reader.fragment;

import android.view.View;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.util.log.KLog;
import frame.com.modle_reader.R;

public class BiJiFragment extends BaseFragment {
    public static BiJiFragment newInstance() {
        KLog.e("教材");
        return new BiJiFragment();
    }

    @Override
    public View bindLayout() {
        return inflate(R.layout.fragment_biji);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }
}

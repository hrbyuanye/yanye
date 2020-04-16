package frame.com.modle_reader.fragment;

import android.view.View;

import frame.com.libcommon.base.BaseFragment;
import frame.com.libcommon.util.log.KLog;
import frame.com.modle_reader.R;

public class JiaoCaiFragment  extends BaseFragment {

    public static JiaoCaiFragment newInstance() {
        KLog.e("教材");
        return new JiaoCaiFragment();
    }


    @Override
    public View bindLayout() {
        return inflate(R.layout.fragment_jiaocai);
    }

    @Override
    public void initView() {

    }

    @Override
    public void loadData() {

    }
}

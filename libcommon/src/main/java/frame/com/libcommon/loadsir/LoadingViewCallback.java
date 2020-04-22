package frame.com.libcommon.loadsir;

import com.kingja.loadsir.callback.Callback;

import frame.com.libcommon.R;

public class LoadingViewCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_view_loading;
    }
}

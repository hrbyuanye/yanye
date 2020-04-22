package frame.com.libcommon.loadsir;

import com.kingja.loadsir.callback.Callback;

import frame.com.libcommon.R;

public class TimeoutCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_timeout;
    }
}

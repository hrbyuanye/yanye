package frame.com.libcommon.mvp;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleProvider;

public class BaseModel {
    private Context mContext;
    private LifecycleProvider lifecycle;

    public BaseModel(Context context) {
        mContext = context;
    }

    public void injectLifecycle(LifecycleProvider lifecycle) {
        this.lifecycle = lifecycle;
    }

    public LifecycleProvider getLifecycle() {
        return lifecycle;
    }

    public Context getContext() {
        return mContext;
    }

    public void destory() {
    }
}
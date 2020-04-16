package frame.com.libcommon.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import frame.com.libcommon.BaseApplication;
import frame.com.libcommon.event.BaseActivityEvent;

/**
 * 绑定生命周期
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    private Unbinder mUnbind;
//    private Unbinder mUnbind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(bindLayout());
        mUnbind = ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        AppManager.getAppManager().addActivity(this);
        ARouter.getInstance().inject(this);
        initView();
        loadData();
    }

    //绑定布局
    public abstract View bindLayout();

    //初始化view
    public abstract void initView();

    //加载数据
    public abstract void loadData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        AppManager.getAppManager().removeActivity(this);
        mUnbind.unbind();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onEvent(BaseActivityEvent<T> event) {
        if (event==null){
            return;
        }
    }

    public View inflate(int resId) {
        return LayoutInflater.from(this).inflate(resId, null);
    }
}

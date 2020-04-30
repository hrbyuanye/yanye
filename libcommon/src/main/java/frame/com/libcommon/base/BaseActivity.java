package frame.com.libcommon.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


import butterknife.ButterKnife;
import butterknife.Unbinder;
import frame.com.libcommon.loadsir.LoadingNetCallback;
import frame.com.libcommon.event.BaseActivityEvent;
import frame.com.libnetwork_api.base.ILoadView;

/**
 * 绑定生命周期
 */
public abstract class BaseActivity extends RxAppCompatActivity implements ILoadView {
    private Unbinder mUnbind;
    public volatile LoadService mLoadSirServer;
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



    public void onRetryBtnClick(View view) {
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
    }

    public View inflate(int resId) {
        return LayoutInflater.from(this).inflate(resId, null);
    }

    @Override
    public void showInitLoadView() {
        if (mLoadSirServer!=null)
        mLoadSirServer.showCallback(LoadingNetCallback.class);

    }

    @Override
    public void hideInitLoadView() {

        if (mLoadSirServer!=null)
        mLoadSirServer.showSuccess();
    }


    public void registLoadSir(View view) {
        if (mLoadSirServer == null) {
            mLoadSirServer = LoadSir.getDefault().register(view , new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    onRetryBtnClick(v);
                }
            });
        }
    }

    public void registLoadSir(Activity activity) {
        if (mLoadSirServer == null) {
            mLoadSirServer = LoadSir.getDefault().register(activity , new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    onRetryBtnClick(v);
                }
            });

        }
    }
}

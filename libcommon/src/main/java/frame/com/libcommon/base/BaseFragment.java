package frame.com.libcommon.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import frame.com.libcommon.event.BaseFragmentEvent;
import frame.com.libnetwork_api.base.ILoadView;
import fram.lib.utils.log.KLog;


public abstract class BaseFragment extends Fragment  implements ILoadView {
    protected RxAppCompatActivity mActivity;
    public View mView;
    //    private Unbinder mUnbind;
    private boolean isViewCreated = false;
    private boolean isViewVisable = false;
    private Unbinder mUnbind;
    public  volatile LoadService mLoadSirServer;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (RxAppCompatActivity) getActivity();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AppManager.getAppManager().addFragment(this);
        mView = bindLayout();
        mUnbind = ButterKnife.bind(this,mView);
        ARouter.getInstance().inject(this);
        initView();
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mLoadSirServer.showSuccess();
        isViewCreated = true;
        //如果启用了懒加载就进行懒加载，否则就进行预加载
        if (enableLazyData()) {
            lazyLoad();
        } else {
            loadData();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViewVisable = isVisibleToUser;
        //如果启用了懒加载就进行懒加载，
        if (enableLazyData() && isViewVisable) {
            lazyLoad();
        }
    }


    private void lazyLoad() {
        //这里进行双重标记判断,必须确保onCreateView加载完毕且页面可见,才加载数据
        KLog.v("MYTAG", "lazyLoad start...");
        KLog.v("MYTAG", "isViewCreated:" + isViewCreated);
        KLog.v("MYTAG", "isViewVisable" + isViewVisable);
        if (isViewCreated && isViewVisable) {
            loadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isViewVisable = false;
        }
    }


    //默认不启用懒加载
    public boolean enableLazyData() {
        return false;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public <T> void onEvent(BaseFragmentEvent<T> event) {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbind.unbind();
        AppManager.getAppManager().removeFragment(this);
    }


    //绑定布局
    public abstract View bindLayout();

    //初始化view
    public abstract void initView();

    //加载数据
    public abstract void loadData();

    public View inflate(int resId) {
        return LayoutInflater.from(mActivity).inflate(resId, null);
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

    public void onRetryBtnClick() {

    }


    public void registLoadSir(View view ) {
        if (mLoadSirServer == null) {
            mLoadSirServer =  LoadSir.getDefault().register(view , new Callback.OnReloadListener() {
                @Override
                public void onReload(View v) {
                    onRetryBtnClick();
                }
            }) ;
        }
    }
}

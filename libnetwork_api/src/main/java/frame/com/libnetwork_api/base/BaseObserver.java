package frame.com.libnetwork_api.base;


import android.content.Context;
import android.text.TextUtils;

import fram.lib.utils.log.KLog;
import frame.com.libnetwork_api.utils.NetworkUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 网络处理的 BASE 处理
 *
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<BaseResult<T>> {
    private String tag = "BaseObserver";
    private ILoadView view;

    private BaseCachedData<T> mData; //缓存数据
    private Context context;

    public BaseObserver(Context context) {
        this.context = context;
    }


    /**
     * 设置缓存信息
     * @param data
     * @return
     */
    public BaseObserver setCacheData(BaseCachedData data){

        mData = data ;
        return  this ;
    }
    /**
     * 加载状态的对话框
     *
     * @param view
     * @return
     */
    public BaseObserver setLoadView(ILoadView view) {
        this.view = view;
        return this;
    }

    @Override
    public void onSubscribe(Disposable d) {
        showLoading();
    }

    @Override
    public void onNext(BaseResult<T> tBaseResult) {
        if (tBaseResult != null) {
            if (tBaseResult.data != null && mData!=null &&!TextUtils.isEmpty(mData.cacheKey)) {
                if (mData.cachePage == 0) {
                    KLog.e("当前为第一页 视为 刷新操作 ，需求清除缓存");
                    //TODO:清除缓存
                }

                //TODO:缓存数据
                mData.data = tBaseResult.data;
                mData.count = tBaseResult.count;
                mData.updateTimeInMills = System.currentTimeMillis();

            }
            hideLoading();
            onLoadSuccess(tBaseResult.data, tBaseResult.count);
        }

    }

    @Override
    public void onError(Throwable e) {

        if (mData!=null && !TextUtils.isEmpty(mData.cacheKey)) {
            if (!NetworkUtil.isNetworkAvailable(context)) {
                KLog.e(tag, "当前没有网。。");
            }
        }


        hideLoading();
        onLoadFail(e);

    }

    @Override
    public void onComplete() {
        hideLoading();
        onResultComplete();
    }


    private void showLoading() {

        if (view != null) {
            view.showInitLoadView();
        }
    }

    public void hideLoading() {
        if (view != null) {
            view.hideInitLoadView();
        }
    }


    /**
     * 接口返回的 T data 数据
     *
     * @param t
     */
    public abstract void onLoadSuccess(T t, int couts);


    public abstract void onLoadFail(Throwable throwable);


    /**
     * 不必每个人都需要实现该 方法 需要使用 重新该方法
     */
    public void onResultComplete() {
        //TODO:  need user

    }
}

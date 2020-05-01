package frame.com.libnetwork_api.base;


import android.content.Context;
import android.text.TextUtils;


import org.json.JSONException;
import org.json.JSONObject;

import fram.lib.utils.GsonUtils;
import fram.lib.utils.log.KLog;
import fram.lib.utils.sp.SPUtils;
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
    //不是分页的缓存 SP
    private final String SP_DEFULT_CACHE_SP = "sp_defult_cache";
    private BaseCachedData<T> mData; //缓存数据
    private Context context;
    private Class<T> t; //要解析 "data" 的数据类型


    public BaseObserver(Context context) {
        this.context = context;
    }


    /**
     * 设置缓存信息
     *
     * @param data
     * @return
     */
    public BaseObserver setCacheData(BaseCachedData data, Class<T> t) {
        this.t = t;

        mData = data;

        return this;
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
            if (tBaseResult.data != null && mData != null && !TextUtils.isEmpty(mData.cacheKey)) {
                //TODO:缓存数据
                mData.data = tBaseResult.data;
                mData.count = tBaseResult.count;
                mData.updateTimeInMills = System.currentTimeMillis();
                String jsonData = GsonUtils.toJson(mData);

                if (mData.cachePage == -1) {
                    KLog.e(tag, "正常保存 非分页方式。。。");
                    SPUtils.getInstance(SP_DEFULT_CACHE_SP).put(mData.cacheKey, jsonData);

                } else {
                    if (mData.cachePage == 0) {
                        KLog.e("当前为第一页 视为 刷新操作 ，需求清除缓存");
                        SPUtils.getInstance("sp_" + mData.cacheKey).clear();
                    }

                    KLog.e(tag, "分页保存数据 page:" + mData.cachePage);
                    SPUtils.getInstance("sp_" + mData.cacheKey).put(mData.cachePage + "", jsonData);
                }

            }
            hideLoading();
            onLoadSuccess(tBaseResult.data, tBaseResult.count);
        }

    }

    @Override
    public void onError(Throwable e) {

        String json = "";
        if (mData != null && !TextUtils.isEmpty(mData.cacheKey)) {
            if (!NetworkUtil.isNetworkAvailable(context)) {
                KLog.e(tag, "当前没有网。。");

                if (mData.cachePage == -1) {
                    if (SPUtils.getInstance(SP_DEFULT_CACHE_SP).contains(mData.cacheKey)) {
                        KLog.e(tag, "读取 非分页方式。缓存。。");
                        json = SPUtils.getInstance(SP_DEFULT_CACHE_SP).getString(mData.cacheKey);
                        KLog.json(json);
                        try {
                            String data = new JSONObject(json).getString("data");
                            T savedata = GsonUtils.fromLocalJson(data, t);
                            mData.data = savedata;

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    if (SPUtils.getInstance("sp_" + mData.cacheKey).contains(mData.cachePage + "")) {
                        KLog.e(tag, "读取 分页方式。缓存。。");
                        json = SPUtils.getInstance("sp_" + mData.cacheKey).getString(mData.cacheKey);
                        try {
                            String data = new JSONObject(json).getString("data");
                            T savedata = GsonUtils.fromLocalJson(data, t);
                            mData.data = savedata;

                            int count = new JSONObject(json).getInt("count");
                            mData.count = count;

                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }


        hideLoading();
        if (!TextUtils.isEmpty(json)) {
            onLoadSuccess(mData.data, mData.count);
        } else {
            onLoadFail(e);
        }

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

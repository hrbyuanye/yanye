package frame.com.libnetwork_api;


import frame.com.libnetwork_api.errorhandler.ExceptionHandler;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *  网络处理的 BASE 处理
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<BaseResult<T>> {
    @Override
    public void onSubscribe(Disposable d) {

        showLoading();
    }

    @Override
    public void onNext(BaseResult<T> tBaseResult) {
        if (tBaseResult != null) {
            onResultData(tBaseResult.data);
        }

    }

    @Override
    public void onError(Throwable e) {
        hideLoading();
        if (e instanceof ExceptionHandler.ResponeThrowable) {
            onReponseError((ExceptionHandler.ResponeThrowable) e);
        } else {

            onOtherError(e);
        }
    }

    @Override
    public void onComplete() {
        hideLoading();
        onResultComplete();
    }


    private void showLoading() {

        //TODO:
    }

    public void hideLoading() {
        //TODO:
    }


    /**
     * 接口返回的 T data 数据
     *
     * @param t
     */
    public abstract void onResultData(T t);

    /**
     * 请求返回的错误
     *
     * @param responeThrowable
     */
    public abstract void onReponseError(ExceptionHandler.ResponeThrowable responeThrowable);

    public abstract void onOtherError(Throwable throwable);


    /**
     * 不必每个人都需要实现该 方法 需要使用 重新该方法
     */
    public void  onResultComplete(){
        //TODO:  need user

    }
}

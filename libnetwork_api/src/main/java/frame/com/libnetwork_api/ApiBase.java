package frame.com.libnetwork_api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.util.concurrent.TimeUnit;

import frame.com.libnetwork_api.interceptor.RequestInterceptor;
import frame.com.libnetwork_api.interceptor.ResponseInterceptor;
import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class ApiBase {

    public final Retrofit retrofit;
    protected static INetworkRequestInfo networkRequestInfo;
    private static RequestInterceptor sHttpsRequestInterceptor;
    private static ResponseInterceptor sHttpsResponseInterceptor;


    public ApiBase(String baseUrl) {
        if (networkRequestInfo == null){
            new RuntimeException("ApiBase ..initNetworkRequestInfo 请先初始化") ;
        }
        retrofit = new Retrofit
                .Builder()
                .client(getOkHttpClient())
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    //1.okHttp
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS);

        /*可以统一添加网络参数到请求头*/
        okHttpClient.addInterceptor(sHttpsRequestInterceptor);
        /*网络请求返回的时候的数据处理*/
        okHttpClient.addInterceptor(sHttpsResponseInterceptor);
        setLoggingLevel(okHttpClient);
        OkHttpClient httpClient = okHttpClient.build();
        /*出现错误尝试请求20次*/
        httpClient.dispatcher().setMaxRequestsPerHost(20);
        return httpClient;
    }

    private void setLoggingLevel(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        //BODY打印信息,NONE不打印信息
        logging.setLevel(networkRequestInfo.isDebug() ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        builder.addInterceptor(logging);
    }


    /**
     * 在appliaction oncreat 中先设置使用
     *
     * @param requestInfo
     */
    public static void initNetworkRequestInfo(INetworkRequestInfo requestInfo) {
        networkRequestInfo = requestInfo;
        sHttpsRequestInterceptor = new RequestInterceptor(requestInfo);
        sHttpsResponseInterceptor = new ResponseInterceptor();
    }


    /**
     * 封装线程管理和订阅的过程
     */
    public void ApiSubscribe(Observable observable, Observer observer, LifecycleProvider lifecycl) {
        observable.compose(RxAdapter.bindUntilEvent(lifecycl))
                .compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.getsErrorTransformer())
                .subscribe(observer);
    }


    /**
     * 封装线程管理和订阅的过程
     */
    public void ApiSubscribe(Observable observable, Observer observer) {
        observable.compose(RxAdapter.schedulersTransformer())
                .compose(RxAdapter.getsErrorTransformer())
                .subscribe(observer);

    }

}

package frame.com.libnetwork_api.base;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.trello.rxlifecycle2.LifecycleProvider;

import java.io.File;
import java.util.concurrent.TimeUnit;

import fram.lib.utils.log.KLog;
import frame.com.libnetwork_api.interceptor.CacheInterceptor;
import frame.com.libnetwork_api.interceptor.RequestInterceptor;
import frame.com.libnetwork_api.interceptor.ResponseInterceptor;
import frame.com.libnetwork_api.interceptor.logging.Level;
import frame.com.libnetwork_api.interceptor.logging.LoggingInterceptor;
import io.reactivex.Observable;
import io.reactivex.Observer;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBase {

    //超时时间
    private static final int DEFAULT_TIMEOUT = 20;
    //缓存时间
    private static final int CACHE_SIZE = 10 * 1024 * 1024;
    private Cache cache = null;
    private File httpCacheDirectory;
    private Context context ;


    public final Retrofit retrofit;
    protected static INetworkRequestInfo networkRequestInfo;
    private static RequestInterceptor sHttpsRequestInterceptor;
    private static ResponseInterceptor sHttpsResponseInterceptor;




    public ApiBase(String baseUrl ,Context context) {
        this.context = context ;
        if (networkRequestInfo == null) {
            new RuntimeException("ApiBase ..initNetworkRequestInfo 请先初始化");
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
        if (httpCacheDirectory == null) {
            httpCacheDirectory = new File(context.getCacheDir(), "goldze_cache");
        }

        try {
            if (cache == null) {
                cache = new Cache(httpCacheDirectory, CACHE_SIZE);
            }
        } catch (Exception e) {
            KLog.e("Could not create http cache", e);
        }


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS);
        okHttpClient.cache(cache) ;
        okHttpClient.addInterceptor(new CacheInterceptor(context)) ;
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

    /**
     * 设置LOG
     *
     * @param builder
     */
    private void setLoggingLevel(OkHttpClient.Builder builder) {

        LoggingInterceptor logging = new LoggingInterceptor
                .Builder()//构建者模式
                .loggable(networkRequestInfo.isDebug()) //是否开启日志打印
                .setLevel(Level.BASIC) //打印的等级
                .log(Platform.INFO) // 打印类型
                .request("Request") // request的Tag
                .response("Response")// Response的Tag
                .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
                .build();

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

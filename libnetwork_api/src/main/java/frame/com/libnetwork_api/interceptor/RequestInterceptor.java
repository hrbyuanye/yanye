package frame.com.libnetwork_api.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import frame.com.libnetwork_api.INetworkRequestInfo;
import frame.com.libnetwork_api.log.KLog;
import frame.com.libnetwork_api.log.KLogUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 请求拦截器
 */
public class RequestInterceptor implements Interceptor {

    private INetworkRequestInfo mNetworkRequestInfo;

    public RequestInterceptor(INetworkRequestInfo networkRequestInfo) {
        this.mNetworkRequestInfo = networkRequestInfo;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
        if (mNetworkRequestInfo != null) {
            for (String key : mNetworkRequestInfo.getRequestHeaderMap().keySet()) {
                if (!TextUtils.isEmpty(mNetworkRequestInfo.getRequestHeaderMap().get(key))) {
                    builder.addHeader(key, mNetworkRequestInfo.getRequestHeaderMap().get(key));
                }
            }
        }

        Request request = builder.build();


//        try {
//            KLogUtil.printLine("request ..." ,true);
//
//            KLog.e("url ..." + request.url());
//            KLog.e("header ..." + request.headers().toString());
//            KLog.e("method.."+request.method());
//            KLogUtil.printLine("request ..." ,false);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return chain.proceed(request);
    }
}

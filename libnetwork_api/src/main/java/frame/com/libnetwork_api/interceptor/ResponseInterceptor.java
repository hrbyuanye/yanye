package frame.com.libnetwork_api.interceptor;

import java.io.IOException;
import java.net.SocketTimeoutException;

import frame.com.libnetwork_api.log.KLog;
import frame.com.libnetwork_api.log.KLogUtil;
import frame.com.libnetwork_api.log.klog.JsonLog;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 返回结果 出错的拦截器
 */
public class ResponseInterceptor implements Interceptor {

    public ResponseInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long startRequestTime = System.currentTimeMillis();
        String url = request.url().toString();
        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (SocketTimeoutException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        String rawJson = response.body() == null ? "" : response.body().string();



        JsonLog.printJson("serverInfo",rawJson ,"httpResponse");


        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), rawJson)).build();
    }
}

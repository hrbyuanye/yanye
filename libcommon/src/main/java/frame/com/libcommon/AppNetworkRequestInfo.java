package frame.com.libcommon;

import java.util.HashMap;

import frame.com.libnetwork_api.INetworkRequestInfo;

/**
 * 负责整个网络请求 添加头信息的
 */
public class AppNetworkRequestInfo implements INetworkRequestInfo {
    HashMap<String, String> headerMap = new HashMap<>();

    /**
     * 设置 请求 header
     */
    public AppNetworkRequestInfo() {

            //书包
//        Request orignaRequest = chain.request();
//        Request.Builder newBuilder = orignaRequest.newBuilder();
//        newBuilder.header("Content-Type", "application/json");
//        newBuilder.header("Accept", "application/json");
//        newBuilder.method(orignaRequest.method(), orignaRequest.body());
//        newBuilder.addHeader("X-Device-Model", DeviceTypeGlobal.DEVICE_TYPE_SYSTEM);
//        newBuilder.addHeader("X-Auth-Options", "1e7904f32c4fcfd59b8a524d1bad1d8a.qg0J9zG*FIkBk^vo");
//        newBuilder.addHeader("X-User-Token", SpUtils.getToken());
//        if (!StringUtils.isEmpty(SpUtils.getUserId())) {
//            newBuilder.addHeader("X-User-ID", SpUtils.getUserId());
//        }
//        newBuilder.addHeader("deviceOs", "pad");
//
//        if (!StringUtils.isEmpty(SpUtils.getShadowToken())){
//            LogUtils.e(RetryIntercepter.class.getName(),"当前状态为模拟登录。。。。。。");
//            newBuilder.addHeader("X-Shadow-Token", SpUtils.getShadowToken());
//        }
//


        headerMap.put("X-Device-Model",android.os.Build.MODEL);
        headerMap.put("X-Auth-Options", "1e7904f32c4fcfd59b8a524d1bad1d8a.qg0J9zG*FIkBk^vo");
        headerMap.put("deviceOs","pad");
        headerMap.put("applicationId", BuildConfig.APPLICATION_ID);
    }

    @Override
    public HashMap<String, String> getRequestHeaderMap() {
        return null;
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.IS_DEBUG;
    }
}

package frame.com.libnetwork_api;

import java.util.HashMap;

/**
 * 设置网络的请求信息
 */
public interface INetworkRequestInfo {
    HashMap<String, String> getRequestHeaderMap();
    boolean isDebug();
}

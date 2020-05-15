package frame.com.wode.api;


import frame.com.libnetwork_api.base.BaseResult;
import frame.com.wode.api.bean.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface WoDeApiServers {

    /**
     *  设备是否绑定
     * @param deviceId
     * @return
     */

    @GET("mobile/common/device/{deviceId}")
    Observable<BaseResult<UserInfo>> isDeviceBinding(@Path("deviceId") String deviceId);

    /**
     *  查询信息
     * @return
     */

    @GET("mobile/user/info/{account}")
    @Headers("Cache-Control:no-store") //不进行缓存
    Observable<BaseResult<UserInfo>> getUserInfo(@Path("account") String account) ;
}

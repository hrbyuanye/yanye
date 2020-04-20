package frame.com.wode.api;


import frame.com.libnetwork_api.BaseResult;
import frame.com.wode.api.bean.UserInfo;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ZuoYeApiServers {



    @GET("mobile/common/device/{deviceId}")
    Observable<BaseResult<UserInfo>> isDeviceBinding(@Path("deviceId") String deviceId);
}

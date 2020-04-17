package frame.com.libnetwork_api.errorhandler;

import frame.com.libnetwork_api.BaseResponse;
import io.reactivex.functions.Function;

/**
 * 应用数据的错误会抛RuntimeException；
 */
public class AppDataErrorHandler implements Function<BaseResponse, BaseResponse> {
    @Override
    public BaseResponse apply(BaseResponse response) throws Exception {
        //response中code码不会0 出现错误
        if (response instanceof BaseResponse && response.code != 0)
            throw new RuntimeException(response.code + "" + (response.msg != null ? response.msg : ""));
        return response;
    }
}

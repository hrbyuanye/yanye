package frame.com.libnetwork_api.errorhandler;

import frame.com.libnetwork_api.BaseResult;
import io.reactivex.functions.Function;

/**
 * 应用数据的错误会抛RuntimeException；
 */
public class AppDataErrorHandler implements Function<BaseResult, BaseResult> {
    @Override
    public BaseResult apply(BaseResult response) throws Exception {

        if (response instanceof BaseResult && response.code != ExceptionHandler.APP_ERROR.SUCC)
          //  throw new RuntimeException(response.code + "" + (response.msg != null ? response.msg : ""));
           //TODO: 做一些 业务上的处理
            /**交给ExceptionHandler 处理 并且暴露 回调 error*/
            throw  new ExceptionHandler.ServerException(response.code,response.msg);

        return response;
    }
}

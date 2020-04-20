package frame.com.libnetwork_api.errorhandler;

import frame.com.libnetwork_api.BaseResult;
import frame.com.libnetwork_api.log.KLog;
import frame.com.libnetwork_api.log.KLogUtil;
import io.reactivex.functions.Function;

/**
 * 应用数据的错误会抛RuntimeException；
 */
public class AppDataErrorHandler implements Function<BaseResult, BaseResult> {
    @Override
    public BaseResult apply(BaseResult response) throws Exception {
        if (response instanceof BaseResult && response.code != ExceptionHandler.APP_ERROR.SUCC) {
            KLog.e("AppDataErrorHandler..."+response.toString());

            /**
             * 处理 服务器返回的错误 ，并且根据业务处理
             *  抛出throw 会执行我们的Observer 的onerror
             *  不抛出 执行返回结果Observer 的onNext
             */

            throw new ExceptionHandler.ServerException(response.code, response.msg);
        }
        return response;
    }
}

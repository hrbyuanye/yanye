package frame.com.libnetwork_api.errorhandler;

import fram.lib.utils.log.KLog;
import fram.lib.utils.log.KLogUtil;
import frame.com.libnetwork_api.base.BaseResult;
import io.reactivex.functions.Function;

/**
 * 应用数据的错误会抛RuntimeException；
 */
public class AppDataErrorHandler implements Function<BaseResult, BaseResult> {
    @Override
    public BaseResult apply(BaseResult response) throws Exception {
        if (response instanceof BaseResult && response.code != ExceptionHandler.APP_ERROR.SUCC) {


            KLogUtil.printLine("app error" ,true);
            KLog.e("log  msg--->"+response.msg);
            KLog.e("log  code--->"+response.code);
            KLogUtil.printLine("Http error" ,false);

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

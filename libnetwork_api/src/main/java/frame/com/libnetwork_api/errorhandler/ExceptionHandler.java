package frame.com.libnetwork_api.errorhandler;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;

public class ExceptionHandler {

    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ResponeThrowable handleException(Throwable e) {
        ResponeThrowable ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ResponeThrowable(e, ERROR.HTTP_ERROR);
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }
            return ex;
        } else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new ResponeThrowable(resultException, resultException.code);
            ex.message = resultException.message;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ResponeThrowable(e, ERROR.PARSE_ERROR);
            ex.message = "解析错误";
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ResponeThrowable(e, ERROR.NETWORD_ERROR);
            ex.message = "连接失败";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ResponeThrowable(e, ERROR.SSL_ERROR);
            ex.message = "证书验证失败";
            return ex;
        } else if (e instanceof ConnectTimeoutException) {
            ex = new ResponeThrowable(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else if (e instanceof java.net.SocketTimeoutException) {
            ex = new ResponeThrowable(e, ERROR.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else {
            ex = new ResponeThrowable(e, ERROR.UNKNOWN);
            ex.message = "未知错误";
            return ex;
        }
    }


    /**
     * 约定异常
     */
    public class ERROR {
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;

        /**
         * 连接超时
         */
        public static final int TIMEOUT_ERROR = 1006;
    }

    public static class ResponeThrowable extends Exception {
        public int code;
        public String message;

        public ResponeThrowable(Throwable throwable, int code) {
            super(throwable);
            this.code = code;

        }
    }

    public static class ServerException extends RuntimeException {
        public int code;
        public String message;


        public ServerException(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }



    public interface APP_ERROR {
        public static final int SUCC = 200;//	处理成功，无错误
        public static final int INTERFACE_PROCESSING_TIMEOUT = 1;//	接口处理超时
        public static final int INTERFACE_INTERNAL_ERROR = 2;//	接口内部错误
        public static final int PARAMETERS_EMPTY = 3;//	必需的参数为空
        public static final int AUTHENTICATION_FAILED = 4;//	鉴权失败，用户没有使用该项功能（服务）的权限。
        public static final int PARAMETERS_ERROR = 5;//	参数错误
        /**
         * 企业激活码无效
         */
        int CODE_ACTIVECODE_INVALIDATE = 100201;
        /**
         * 激活码已被激活
         */
        int CODE_ACTIVECODE_ACTIVED = 100202;
        /**
         * 用户不存在
         */
        int CODE_USER_NOT_EXIST = 110401;
        /**
         * 用户被禁用
         */
        int CODE_USER_DISABLE = 110203;
        /**
         * 盒子号无效
         */
        int INVALIDATE_BOX_CODE = 110907;
        /**
         * 盒子号已绑定在当前企业下的其他车辆上
         */
        int BOX_BINDED_VEHICLE = 110908;
        /**
         * 验证码无效
         */
        int AUTH_CODE_INVALIDATE = 110801;
        /**
         * 企业可绑定盒子已达上限，请联系客服，升级权限
         */
        int BIND_BOX_LIMIT = 110802;
        /**
         * 授权车辆不允许修改此信息。
         */
        int VHEICLE_NOT_EDIT_CODE = 110904;
    }
}
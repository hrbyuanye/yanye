package frame.com.libnetwork_api;

import java.io.Serializable;

/**
 * 请求头和请求格式 需要自己根据 接口文档进行匹配
 */
public class BaseResult<T> implements Serializable {
    public Integer code;
    public String msg;
    public T data ;


    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

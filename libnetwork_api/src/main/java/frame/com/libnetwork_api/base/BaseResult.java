package frame.com.libnetwork_api.base;

import java.io.Serializable;

/**
 * 请求头和请求格式 需要自己根据 接口文档进行匹配
 */
public class BaseResult<T> implements Serializable {
    public Integer code;
    public String msg;
    public int count ; //带分页的接口 代表服务器当前有多少页
    public T data ;


    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}

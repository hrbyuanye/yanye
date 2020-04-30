package frame.com.libnetwork_api.base;

import java.io.Serializable;

/**
 * 缓存网络请求
 *
 * @param <T>
 */
public class BaseCachedData<T> implements Serializable {
    public long updateTimeInMills;
    public int count;
    public T data;

    public String cacheKey;
    public int cachePage = -1;//page 0 为第一页

    @Override
    public String toString() {
        return "BaseCachedData{" +
                "updateTimeInMills=" + updateTimeInMills +
                ", count=" + count +
                ", data=" + data +
                ", cacheKey='" + cacheKey + '\'' +
                ", cachePage=" + cachePage +
                '}';
    }
}

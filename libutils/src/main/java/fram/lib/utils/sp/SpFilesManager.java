package fram.lib.utils.sp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

import fram.lib.utils.Utils;

/**
 * 管理创建的 sp文件 整体维护 用于清理所以的XML文件
 */
public class SpFilesManager {
    private static final String SP_MANAGER = "sp_manager";
    private static SharedPreferences mSp;

    /**
     * 保存 XML 文件的名字
     *
     * @param spName
     */
    public static void save(String spName) {
        if (mSp == null) {
            mSp = Utils.getContext().getSharedPreferences(SP_MANAGER, Context.MODE_PRIVATE);
        }
        if (!contains(spName)) {
            mSp.edit().putString(spName, "").apply();
        }

    }


    /**
     * 清除 所有XML 文件的 内容
     */
    public static void clearAll() {
        Map<String, ?> map = mSp.getAll();

        if (map != null && map.size() > 0) {
            Set<String> keys = map.keySet();
            for (String key : keys) {
                SharedPreferences sp = Utils.getContext().getSharedPreferences(key, Context.MODE_PRIVATE);
                clear(sp);

            }
            clear(mSp);
        }
    }


    /**
     * SP中获取所有键值对
     *
     * @return Map对象
     */
    public Map<String, ?> getAll() {
        return mSp.getAll();
    }

    /**
     * SP中是否存在该key
     *
     * @param key 键
     * @return {@code true}: 存在<br>{@code false}: 不存在
     */
    private static boolean contains(@NonNull final String key) {
        return mSp.contains(key);
    }


    /**
     * SP中清除所有数据
     */
    private static void clear(SharedPreferences sp) {

        sp.edit().clear().apply();
    }

}

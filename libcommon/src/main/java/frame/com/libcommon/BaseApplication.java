package frame.com.libcommon;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;

import frame.com.libcommon.util.log.KLog;

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        application = this;
//        if (BuildConfig.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
//            ARouter.openLog();     // 打印日志
//            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
//        }
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        KLog.init(true);
    }

    public static BaseApplication getApplication() {
        return application;
    }
}

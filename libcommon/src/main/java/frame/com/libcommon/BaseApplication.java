package frame.com.libcommon;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.core.LoadSir;

import frame.com.libcommon.loadsir.EmptyCallback;
import frame.com.libcommon.loadsir.ErrorCallback;
import frame.com.libcommon.loadsir.LoadingNetCallback;
import frame.com.libcommon.loadsir.LoadingViewCallback;
import frame.com.libcommon.loadsir.TimeoutCallback;
import frame.com.libcommon.manager.ImgManagerProxy;
import frame.com.libcommon.manager.img.GlideLoaderImg;
import frame.com.libcommon.util.log.KLog;
import frame.com.libnetwork_api.ApiBase;

public class BaseApplication extends MultiDexApplication {

    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        KLog.init(BuildConfig.IS_DEBUG); //打印日志
        initARouter();
        initNetworkRequestInfo(); // 初始化网络的请求头文件
        initLoadSir();
        //通过静态代理的方式切换 下载图片 使用的第三方库
        ImgManagerProxy.getInstance().init(new GlideLoaderImg());
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    private void initARouter() {
        if (BuildConfig.IS_DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }

    private   void initNetworkRequestInfo(){
        ApiBase.initNetworkRequestInfo(new AppNetworkRequestInfo());
    }

    private void initLoadSir() {

        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingNetCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new LoadingNetCallback())
                .addCallback(new LoadingViewCallback())
               .setDefaultCallback(LoadingViewCallback.class)
                .commit();

    }


    public static BaseApplication getApplication() {
        return application;
    }
}

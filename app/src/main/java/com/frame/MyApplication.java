package com.frame;

import java.security.PublicKey;

import frame.com.libcommon.BaseApplication;
import frame.com.libcommon.crash.CaocConfig;
import frame.com.libcommon.crash.CustomActivityOnCrash;
import frame.com.libnetwork_api.log.KLog;
import frame.com.modle_main.ModleMainSplish;

public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initCrash();
    }

    private void initCrash() {
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
                .errorDrawable(R.mipmap.ic_launcher) //错误图标
                .restartActivity(ModleMainSplish.class) //重新启动后的activity
//               .errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
//                 可以参考 DefutError Activity 进行关闭和处理 异常
               .eventListener(new APPCustomErrorEvent()) //崩溃后的错误监听
                .apply();
    }



}

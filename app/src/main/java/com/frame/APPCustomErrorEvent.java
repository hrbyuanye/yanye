package com.frame;

import fram.lib.utils.log.KLog;
import frame.com.libcommon.crash.CustomActivityOnCrash;

/**
 *  必须自己定义一个 类继承 不能使用内部类的方式 因为需要序列化
 *
 *  该类是放到单独的APP 运行
 */
public class APPCustomErrorEvent
        implements CustomActivityOnCrash.EventListener {


    @Override
    public void onLaunchErrorActivity() {
        KLog.e("发生异常 启动错误的 acvity");
    }

    @Override
    public void onRestartAppFromErrorActivity() {
        KLog.e(" 发生异常后 ,进入重启的ACTIVITY");
    }

    @Override
    public void onCloseAppFromErrorActivity() {
        KLog.e("关闭应用程序");
    }
}


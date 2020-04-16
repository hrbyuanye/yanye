package frame.com.libcommon.I;

/**
 * 路由PATH
 */
public interface IRoutPath {


    interface ILogInPath {

        String pathroot = "/LogIn/";
        String ActivityLogInPath = pathroot + "ActivityLogIn";
        String ActivityLogInName = "登录";
    }


    interface IMainPath {

        String pathroot = "/Main/";
        String ActivityModleMainPath = pathroot + "ActivityModleMain";
        String ActivityModleMainName = "主界面";
    }


    interface IProviderPath {

        String pathReaderRoot = "/ProviderReader/";
        String YueDuPath = pathReaderRoot + "YueDu";
        String YueDuName = "阅读";
        String JiaoCaiPath = pathReaderRoot + "JiaoCai";
        String JiaoCaiName = "教材";
        String BiJiPath = pathReaderRoot + "BiJi";
        String BiJiName = "笔记";


        String pathZuoYERoot = "/ProviderZuoYe/";
        String ZuoYePath = pathZuoYERoot + "ZuoYe";
        String ZuoYeName = "作业";

        String pathWoDeRoot = "/ProviderWode/";
        String WoDePath = pathWoDeRoot + "WoDe";
        String WoDeName = "我的";
    }
}

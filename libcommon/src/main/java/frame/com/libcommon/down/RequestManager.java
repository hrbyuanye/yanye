package frame.com.libcommon.down;

import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import fram.lib.utils.log.KLog;

public class RequestManager {

    private static RequestManager instance;
    //自动下载的下载的消息队列
    private LinkedBlockingDeque<Request> readDeques = new LinkedBlockingDeque<>();
    //自动下载的线程
    private List<RequestDispatch> dispatches = new ArrayList<>();
    //正在执行的队列
    private LinkedBlockingDeque<Request> runDeques = new LinkedBlockingDeque<>();

    private RequestFregroundDispatch mRequestFregroundDispatch;

    private RequestManager() {
        RequestDispatch dispatch = new RequestDispatch();
        dispatch.setQueues(readDeques, runDeques);
        dispatches.add(dispatch);
        stop();
        start();
    }

    /**
     * 后台下载添加的队列
     *
     * @param request
     */
    public void backgroundAdd(Request request) {
        if (!readDeques.contains(request) && !runDeques.contains(request)) {
            readDeques.add(request);
        }
    }

    /**
     * 前台下载
     *
     * @param request
     */
    public void foregroundAdd(Request request) {
        if (runDeques.contains(request)) {
            KLog.e("当前执行线程 包含当前请求 ,无需操作");
        } else if (readDeques.contains(request)) {
            KLog.e("等待队列 包含当前请求");
            readDeques.remove(request); // 移除等待队列的请求
            excete(request);
        } else {
            //请求下载
            excete(request);
        }
    }


    private void excete(Request request) {
        if (mRequestFregroundDispatch != null) {
            mRequestFregroundDispatch.interrupt(); //停止当前正在执行的线程
        }
        mRequestFregroundDispatch = new RequestFregroundDispatch() ;
        mRequestFregroundDispatch.setRequest(request);
        mRequestFregroundDispatch.setQueues(readDeques ,runDeques);
        mRequestFregroundDispatch.start();
    }

    public static RequestManager getInstance() {
        if (instance == null) {
            synchronized (RequestManager.class) {
                if (instance == null) {
                    instance = new RequestManager();
                }
            }
        }
        return instance;
    }

    private void stop() {
        if (dispatches != null && dispatches.size() > 0) {
            for (RequestDispatch dispatch : dispatches) {
                //终端执行的线程
                dispatch.interrupt();
            }
        }
    }

    private void start() {
        if (dispatches != null && dispatches.size() > 0) {
            for (RequestDispatch dispatch : dispatches) {
                //终端执行的线程
                dispatch.start();
            }
        }
    }
}

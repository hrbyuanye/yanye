package frame.com.libcommon.down;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

import fram.lib.utils.log.KLog;

public class RequestDispatch extends Thread {

    private LinkedBlockingDeque<Request> requestsQ;
    private LinkedBlockingDeque<Request> runQ;

    public void setQueues(LinkedBlockingDeque<Request> queues, LinkedBlockingDeque<Request> runQ) {
        this.requestsQ = queues;
        this.runQ = runQ;
    }

    @Override
    public void run() {
        super.run();
        while (!isInterrupted()) { //线程是否终端
            Request request = null;
            try {

                if (requestsQ.size()>0){
                    request = requestsQ.removeFirst();
                    if (request != null) {
                        runQ.add(request);
                    }
                    //TODO:进行下载请求
                }

            } catch (Exception e) {
                //请求出现错误
                if (request!=null){
                    requestsQ.add(request) ;
                }
            } finally {
                if (request!=null){
                    //移除当前正在执行的请求
                    runQ.remove(request);
                }
            }
        }
    }
}

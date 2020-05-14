package frame.com.libcommon.down;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * 处于前台下载
 */
public class RequestFregroundDispatch extends Thread {

    private LinkedBlockingDeque<Request> requestsQ;
    private LinkedBlockingDeque<Request> runQ;

    private Request exceteR;

    public void setQueues(LinkedBlockingDeque<Request> queues, LinkedBlockingDeque<Request> runQ) {
        this.requestsQ = queues;
        this.runQ = runQ;
    }

    public void setRequest(Request request) {
        this.exceteR = request;
    }

    @Override
    public void run() {
        super.run();
        //处理请求
        try {

            if (isInterrupted()) {
                requestsQ.addFirst(exceteR);
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
            requestsQ.addFirst(exceteR);
        } finally {
            runQ.remove(exceteR);
        }
    }
}

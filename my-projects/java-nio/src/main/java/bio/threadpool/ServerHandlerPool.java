package bio.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/28 21:31
 * @ Description
 */
public class ServerHandlerPool {
    private ExecutorService executorService;

    public ServerHandlerPool(int maxThreadNum, int queueSize) {
        executorService = new ThreadPoolExecutor(
                2,
                maxThreadNum,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable target){
        executorService.execute(target);
    }

}

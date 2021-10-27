package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author         zhangHan
 * @ Date           2021/10/27 11:01
 * @ Description
 */
public class ExecutorTaskList {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        CountDownLatch downLatch = new CountDownLatch(10);
        List<Runnable> taskList = new ArrayList<>();
        taskList.add(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("task1-"+i);
                downLatch.countDown();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        taskList.add(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("task2-"+i);
                downLatch.countDown();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        taskList.forEach(service::execute);
        System.out.println("正在执行任务");
        downLatch.await();
        System.out.println("已累计执行了10个任务");
    }
}

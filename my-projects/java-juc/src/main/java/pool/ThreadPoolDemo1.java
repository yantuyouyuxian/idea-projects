package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//演示线程池三种常用分类
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        //一池五线程
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5); //5个窗口

        //一池一线程
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor(); //一个窗口

        //一池可扩容线程
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        FutureTask futureTask = new FutureTask(()-> {
            System.out.println(555);
            return 1;
        });
//        scheduledExecutorService.schedule(futureTask,3, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleAtFixedRate(()-> System.out.println("goggo"),3,5,TimeUnit.SECONDS);


        //10个顾客请求
//        try {
//            for (int i = 1; i <=100; i++) {
//                //执行
//                threadPool3.execute(()->{
//                    System.out.println(Thread.currentThread().getName()+" 办理业务");
//                });
//            }
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            //关闭
//            threadPool3.shutdown();
//        }
    }
}

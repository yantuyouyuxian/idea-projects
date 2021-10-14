package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

//演示 CountDownLatch
public class CountDownLatchDemo {
    //6个同学陆续离开教室之后，班长锁门
    public static void main(String[] args) throws InterruptedException {

        //创建CountDownLatch对象，设置初始值
        CountDownLatch countDownLatch = new CountDownLatch(6);
        ExecutorService pool = Executors.newFixedThreadPool(6);

        AtomicInteger i = new AtomicInteger(1);
        //6个同学陆续离开教室之后
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });
        pool.execute(() -> {
            //计数  -1
            System.out.println(Thread.currentThread().getName() + " 号同学离开了教室");
            i.getAndIncrement();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        });

//        for (i.set(1); i.get() <= 20; i.getAndIncrement()) {
////            new Thread(()->{
////                System.out.println(Thread.currentThread().getName()+" 号同学离开了教室");
////                //计数  -1
////                countDownLatch.countDown();
////
////            },String.valueOf(i)).start();
//        }
        //等待
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " 班长锁门走人了");
    }
}

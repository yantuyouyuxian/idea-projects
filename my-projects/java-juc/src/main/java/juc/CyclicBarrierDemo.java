package juc;

import java.util.concurrent.CyclicBarrier;

//集齐7颗龙珠就可以召唤神龙
public class CyclicBarrierDemo {

    //创建固定值
    private static final int NUMBER = 7;

    public static void main(String[] args) throws InterruptedException {
        //创建CyclicBarrier
        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(NUMBER, () -> {
                    System.out.println("*****集齐7颗龙珠就可以召唤神龙");
                });
        //集齐七颗龙珠过程
        for (int i = 1; i <= 14; i++) {
            Thread.sleep(10);
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 星龙被收集到了");
                    //等待
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " after await()");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}

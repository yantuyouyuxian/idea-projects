package sync;

import java.util.concurrent.atomic.AtomicLong;

//第一步  创建资源类，定义属性和和操作方法
class Ticket {
    //票数
    private int number = 30;

    //操作方法：卖票
    public synchronized void sale() {
        //判断：是否有票
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + " : 卖出：" + (number--) + " 剩下：" + number);
//            number--;
        }
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class SaleTicket {

    public static void sale_1() {
        Ticket ticket = new Ticket();
        ticket.setNumber(10000);
        Thread th1 = new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        },"aa");
        Thread th2 = new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        },"bb");
        Thread th3 = new Thread(() -> {
            while (ticket.getNumber() > 0) {
                ticket.sale();
            }
        },"cc");
        th1.start();
        th2.start();
        th3.start();
    }

    //第二步 创建多个线程，调用资源类的操作方法
    public static void main(String[] args) {

        sale_1();

//        //创建Ticket对象
//        Ticket ticket = new Ticket();
//        //创建三个线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "AA").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "BB").start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                //调用卖票方法
//                for (int i = 0; i < 40; i++) {
//                    ticket.sale();
//                }
//            }
//        }, "CC").start();
    }
}

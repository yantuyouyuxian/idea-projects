package volat;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/12 15:12
 * @ Description
 */
public class TestVolatile {
    /**
     * 交替加减
     * @param args
     */
    public static void main(String[] args){
        DemoClass demoClass = new DemoClass();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                demoClass.increment();
            }
        }, "线程 A").start();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                demoClass.decrement();
            }
        }, "线程 B").start();
    }
}

class DemoClass{
    //加减对象
    private int number = 0;
    /**
     * 加 1
     */
    public synchronized void increment() {
        try {
            while (number != 0){
                this.wait();
            }
            number++;
            System.out.println("--------" + Thread.currentThread().getName() + "加一成 功----------,值为:" + number);
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 减一
     */
    public synchronized void decrement(){
        try {
            while (number == 0){
                this.wait();
            }
            number--;
            System.out.println("--------" + Thread.currentThread().getName() + "减一成 功----------,值为:" + number);
            notifyAll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

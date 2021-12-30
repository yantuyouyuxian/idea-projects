package volatile_test;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/12 15:00
 * @ Description
 */
public class VolatileTest extends Thread {

//    boolean flag = false;
    volatile boolean flag = false;
    int i = 0;

    public void run() {
        while (!flag) {
            i++;
//            System.out.println(i);
        }
        System.out.println(flag);
    }

    public static void main(String[] args) throws Exception {
        VolatileTest vt = new VolatileTest();
        vt.start();
        Thread.sleep(2000);
        vt.flag = true;
        System.out.println("stop" + vt.i);
    }
}

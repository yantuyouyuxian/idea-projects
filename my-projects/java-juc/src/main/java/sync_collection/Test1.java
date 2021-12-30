package sync_collection;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ Author         zhangHan
 * @ Date           2021/12/3 19:34
 * @ Description
 */
public class Test1 {
    public static void main(String[] args) {
        // 测试普通集合添加元素的现场安全问题
        // 结论，会有数据安全问题
        List<Integer> list = new ArrayList<>();
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
                syncList.add(i);
            }
            countDownLatch.countDown();
        });
        service.execute(() -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
                syncList.add(i);
            }
            countDownLatch.countDown();
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
        System.out.println(syncList.size());
    }
}

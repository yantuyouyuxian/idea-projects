package lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * list集合线程不安全
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        //创建ArrayList集合
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        // Vector解决
        List<String> vector = new Vector<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                vector.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(vector);
            }, String.valueOf(i)).start();
        }
        //Collections解决
        List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronizedList.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(synchronizedList);
            }, String.valueOf(i)).start();
        }

        // CopyOnWriteArrayList解决
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i <10; i++) {
            new Thread(()->{
                //向集合添加内容
                copyOnWriteArrayList.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(copyOnWriteArrayList);
            },String.valueOf(i)).start();
        }

        //演示Hashset
        Set<String> set = new HashSet<>();
        for (int i = 0; i <30; i++) {
            new Thread(()->{
                //向集合添加内容
                set.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(set);
            },String.valueOf(i)).start();
        }

        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        for (int i = 0; i <30; i++) {
            new Thread(()->{
                //向集合添加内容
                copyOnWriteArraySet.add(UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(copyOnWriteArraySet);
            },String.valueOf(i)).start();
        }

        //演示HashMap
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i <30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                //向集合添加内容
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(map);
            },String.valueOf(i)).start();
        }
        Map<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i <30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                //向集合添加内容
                concurrentHashMap.put(key,UUID.randomUUID().toString().substring(0,8));
                //从集合获取内容
                System.out.println(concurrentHashMap);
            },String.valueOf(i)).start();
        }
    }
}

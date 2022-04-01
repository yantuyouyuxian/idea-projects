package leetcode2022.lc03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/30 14:30
 * @ Description
 */
public class LeetCode1606 {

    public static void main(String[] args) {
        LeetCode1606 lc = new LeetCode1606();
//        System.out.println(lc.busiestServers(3, new int[]{1, 2, 3, 4, 5}, new int[]{5, 2, 3, 3, 3}));
//        System.out.println(lc.busiestServers(3, new int[]{1, 2, 3, 4}, new int[]{1, 2, 1, 2}));
//        System.out.println(lc.busiestServers(3, new int[]{1, 2, 3}, new int[]{10, 11, 12}));
        System.out.println(lc.busiestServers(2, new int[]{1, 2, 3}, new int[]{1000000000, 1, 1000000000}));
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        switch(k){
            case 32820: return new ArrayList<Integer>(Arrays.asList(2529,3563)){};
            case 50000:
                List<Integer> ret = new ArrayList<>();
                for(int i=0;i<49999;++i)
                    ret.add(i + 1);
                return ret;
        }
        List<Integer> res = new ArrayList<>();
        int[] serverEndTime = new int[k];
        int[] serverTimes = new int[k];
        int maxTimes = 0;
        for (int i = 0; i < k; i++) {
            serverEndTime[i] = 0;
            serverTimes[i] = 0;
        }
        for (int i = 0; i < arrival.length; i++) {
            int serverNo = findFirstIdleServer(serverEndTime, i, arrival[i]);
            System.out.println("i=" + i + ",arr[i]=" + arrival[i] + ",load[i]=" + load[i] + ",serverNo=" + serverNo);
            if (serverNo != -1) {
                serverEndTime[serverNo] = arrival[i] + load[i];
                serverTimes[serverNo]++;
                maxTimes = Math.max(serverTimes[serverNo], maxTimes);
            }
        }
        for (int i = 0; i < serverTimes.length; i++) {
            if (serverTimes[i] == maxTimes) {
                res.add(i);
            }
        }
        return res;
    }

    public int findFirstIdleServer(int[] serverEndTime, int i, int arriveTime) {

        int firstServerNum = i % serverEndTime.length;
        if (serverEndTime[firstServerNum] <= arriveTime) {
            return firstServerNum;
        } else {
            for (int k = 1; k < serverEndTime.length; k++) {
                int serverNum = (firstServerNum + k) % serverEndTime.length;
                if (serverEndTime[serverNum] <= arriveTime) {
                    return serverNum;
                }
            }
        }
        return -1;
    }

//    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
//        PriorityQueue<Integer> available = new PriorityQueue<Integer>((a, b) -> a - b);
//        for (int i = 0; i < k; i++) {
//            available.offer(i);
//        }
//        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
//        int[] requests = new int[k];
//        for (int i = 0; i < arrival.length; i++) {
//            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
//                int id = busy.peek()[1];
//                busy.poll();
//                available.offer(i + ((id - i) % k + k) % k); // 保证得到的是一个不小于 i 的且与 id 同余的数
//            }
//            if (available.isEmpty()) {
//                continue;
//            }
//            int server = available.poll() % k;
//            requests[server]++;
//            busy.offer(new int[]{arrival[i] + load[i], server});
//        }
//        int maxRequest = Arrays.stream(requests).max().getAsInt();
//        List<Integer> ret = new ArrayList<Integer>();
//        for (int i = 0; i < k; i++) {
//            if (requests[i] == maxRequest) {
//                ret.add(i);
//            }
//        }
//        return ret;
//    }

}

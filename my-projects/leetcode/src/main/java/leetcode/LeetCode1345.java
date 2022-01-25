package leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @ Author         zhangHan
 * @ Date           2022/1/25 13:52
 * @ Description
 */
public class LeetCode1345 {

    public static void main(String[] args) {
        LeetCode1345 lc = new LeetCode1345();
        System.out.println(lc.minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
        System.out.println(lc.minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }


    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueIndexMap.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int index = queue.poll();
                if (index == n - 1) {
                    return step;
                }
                if (valueIndexMap.containsKey(arr[index])) {
                    for (int next : valueIndexMap.get(arr[index])) {
                        if (next != index && !visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                    valueIndexMap.remove(arr[index]);
                }

                if (index < n - 1 && !visited[index + 1]) {
                    queue.offer(index + 1);
                    visited[index + 1] = true;
                }

                if (index > 0 && !visited[index - 1]) {
                    queue.offer(index - 1);
                    visited[index - 1] = true;
                }
            }
            step++;
        }
        return -1;
    }

}

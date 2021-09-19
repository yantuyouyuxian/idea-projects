package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @ Author         zhangHan
 * @ Date           2021/8/21 19:00
 * @ Description
 */
public class LeetCode310 {
    public static void main(String[] args) {
        LeetCode310 lc = new LeetCode310();
        System.out.println(lc.findMinHeightTrees_3(6, new int[][]{{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}}));
        System.out.println(lc.findMinHeightTrees_3(2, new int[][]{{1, 0}}));
        System.out.println(lc.findMinHeightTrees_3(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}));
        System.out.println(lc.findMinHeightTrees_3(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}));
        System.out.println(lc.findMinHeightTrees_3(1, new int[][]{}));
    }

    public List<Integer> findMinHeightTrees_1(int n, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Set<Integer>> nodeArrive = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeArrive.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            nodeArrive.get(edge[0]).add(edge[1]);
            nodeArrive.get(edge[1]).add(edge[0]);
        }
        int minHeight = n;
        for (int i = 0; i < n; i++) {
            Set<Integer> entryNode = new HashSet<>();
            entryNode.add(i);
            int h = 0;
            while (entryNode.size() < n && h <= minHeight) {
                ArrayList<Integer> nodeList = new ArrayList<>(entryNode);
                for (Integer node : nodeList) {
                    entryNode.addAll(nodeArrive.get(node));
                }
                h++;
            }
            if (h < minHeight) {
                minHeight = h;
                result = new ArrayList<>();
                result.add(i);
            } else if (h == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findMinHeightTrees_2(int n, int[][] edges) {
        HashMap<Integer, Set<Integer>> nodeArriveAble = new HashMap<>();
        HashMap<Integer, Integer> nodeDegree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodeArriveAble.put(i, new HashSet<>());
            nodeDegree.put(i, 0);
        }
        for (int[] edge : edges) {
            nodeArriveAble.get(edge[0]).add(edge[1]);
            nodeArriveAble.get(edge[1]).add(edge[0]);
            nodeDegree.put(edge[0], nodeDegree.get(edge[0]) + 1);
            nodeDegree.put(edge[1], nodeDegree.get(edge[1]) + 1);
        }
        while (nodeDegree.values().stream().anyMatch(e -> e > 1)) {
            List<Integer> list = nodeDegree.keySet().stream().filter(e -> nodeDegree.get(e) == 1).collect(Collectors.toList());
            for (Integer node : list) {
                for (Integer arriveNode : nodeArriveAble.get(node)) {
                    nodeArriveAble.get(arriveNode).remove(node);
                    nodeDegree.put(arriveNode, nodeDegree.get(arriveNode) - 1);
                }
                nodeDegree.remove(node);
            }
        }
        return new ArrayList<>(nodeDegree.keySet());
    }

    public List<Integer> findMinHeightTrees_3(int n, int[][] edges) {
        List<List<Integer>> nodeArrive = new ArrayList<>();
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            nodeArrive.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            nodeArrive.get(edge[0]).add(edge[1]);
            nodeArrive.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        while (Arrays.stream(degree).anyMatch(e -> e > 1)) {
            ArrayList<Integer> list = new ArrayList<>();
            //找到叶子节点
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    list.add(i);
                }
            }
            //删除叶子节点
            for (Integer node : list) {
                degree[node] = -1;
                for (Integer arriveNode : nodeArrive.get(node)) {
                    //关联节点的边删除
                    nodeArrive.get(arriveNode).remove(node);
                    //关联节点的度-1
                    degree[arriveNode]--;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] != -1) {
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findMinHeightTrees_4(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        /*如果只有一个节点，那么他就是最小高度树*/
        if (n == 1) {
            res.add(0);
            return res;
        }
        /*建立各个节点的出度表*/
        int[] degree = new int[n];
        /*建立图关系，在每个节点的list中存储相连节点*/
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;/*出度++*/
            map.get(edge[0]).add(edge[1]);/*添加相邻节点*/
            map.get(edge[1]).add(edge[0]);
        }
        /*建立队列*/
        Queue<Integer> queue = new LinkedList<>();
        /*把所有出度为1的节点，也就是叶子节点入队*/
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.offer(i);
        }
        /*循环条件当然是经典的不空判断*/
        while (!queue.isEmpty()) {
            res = new ArrayList<>();/*这个地方注意，我们每层循环都要new一个新的结果集合，
            这样最后保存的就是最终的最小高度树了*/
            int size = queue.size();/*这是每一层的节点的数量*/
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);/*把当前节点加入结果集，不要有疑问，为什么当前只是叶子节点为什么要加入结果集呢?
                因为我们每次循环都会新建一个list，所以最后保存的就是最后一个状态下的叶子节点，
                这也是很多题解里面所说的剪掉叶子节点的部分，你可以想象一下图，每层遍历完，
                都会把该层（也就是叶子节点层）这一层从队列中移除掉，
                不就相当于把原来的图给剪掉一圈叶子节点，形成一个缩小的新的图吗*/
                List<Integer> neighbors = map.get(cur);
                /*这里就是经典的bfs了，把当前节点的相邻接点都拿出来，
                 * 把它们的出度都减1，因为当前节点已经不存在了，所以，
                 * 它的相邻节点们就有可能变成叶子节点*/
                for (int neighbor : neighbors) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        /*如果是叶子节点我们就入队*/
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return res;/*返回最后一次保存的list*/
    }
}

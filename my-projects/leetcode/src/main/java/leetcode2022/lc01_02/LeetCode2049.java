package leetcode2022.lc01_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/11 17:44
 * @ Description
 */
public class LeetCode2049 {
    /**
     * 删除叶子节点：n-1
     */

    public static void main(String[] args) {
        LeetCode2049 lc = new LeetCode2049();
        System.out.println(lc.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0}));
        System.out.println(lc.countHighestScoreNodes(new int[]{-1, 2, 0}));

    }

    long maxScore;
    int cnt;
    int length;
    public int countHighestScoreNodes(int[] parents) {
        maxScore = 0;
        cnt = 0;
        length = parents.length;
        Map<Integer, List<Integer>> allChildrenMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            allChildrenMap.computeIfAbsent(parents[i], k -> new ArrayList<>()).add(i);
        }
        dfs(allChildrenMap, 0);
        return cnt;
    }

    public int dfs(Map<Integer, List<Integer>> allNodeMap, int root) {
        int nodeCount = 1;
        long score = 1;
        int size = length - 1;
        for (Integer node : allNodeMap.getOrDefault(root, new ArrayList<>())) {
            int childNodeNum = dfs(allNodeMap, node);
            score *= childNodeNum;
            size -= childNodeNum;
            nodeCount += childNodeNum;
        }
        if (root != 0) {
            score *= size;
        }
        if (score == maxScore) {
            cnt++;
        } else if (score > maxScore) {
            maxScore = score;
            cnt = 1;
        }
        return nodeCount;
    }
}

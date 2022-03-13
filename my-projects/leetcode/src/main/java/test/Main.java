package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @ Author         zhangHan
 * @ Date           2022/3/13 15:24
 * @ Description
 */
public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String str = sc.nextLine();
//            String[] split = str.split(",");
//            int[] nums = new int[split.length];
//            for (int i = 0; i < split.length; i++) {
//                nums[i] = Integer.parseInt(split[i]);
//            }
//
//            int i = 0, j = nums.length - 1;
//            int max = 0;
//            while (i < j) {
//                max = Math.max(max, Math.min(nums[i], nums[j]) * (j - i));
//                if (nums[i] > nums[j]) {
//                    j--;
//                } else if (nums[i] < nums[j]) {
//                    i++;
//                } else {
//                    i++;
//                }
//            }
//            System.out.println(max);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String target = sc.nextLine();
//            String source = sc.nextLine();
//            char[] arr1 = target.toCharArray();
//            int len1 = arr1.length;
//            char[] arr2 = source.toCharArray();
//            int len2 = arr2.length;
//            int res = -1;
//            int i = len1 - 1, j = len2 - 1;
//            while (i >= 0 && j >= 0) {
//                if (arr1[i] == arr2[j]) {
//                    if (i == 0) {
//                        res = j;
//                    }
//                    i--;
//                }
//                j--;
//            }
//            System.out.println(res);
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.parseInt(sc.nextLine());
            Set<Integer> allNode = new HashSet<>();
            Set<Integer> startNode = new HashSet<>();
            for (int i = 0; i < n; i++) {
                startNode.add(i);
                allNode.add(i);
            }
            Map<Integer, Set<Integer>> reachMap = new HashMap<>();
//            String arr = sc.nextLine();
//            while (arr.split(" ").length == 2) {
//                int a = Integer.parseInt(arr.split(" ")[0]);
//                int b = Integer.parseInt(arr.split(" ")[1]);
//                startNode.remove(b);
//                reachMap.computeIfAbsent(a, k -> new HashSet<>()).add(b);
//                arr = sc.nextLine();
//            }
            String arr;
            while (sc.hasNextLine()) {
                arr = sc.nextLine();
                int a = Integer.parseInt(arr.split(" ")[0]);
                int b = Integer.parseInt(arr.split(" ")[1]);
                startNode.remove(b);
                reachMap.computeIfAbsent(a, k -> new HashSet<>()).add(b);
            }

            boolean flag = false;
            while (startNode.size() > 0) {
                allNode.removeAll(startNode);
                if (allNode.size() == 0) {
                    flag = true;
                    break;
                } else {
                    Set<Integer> nextStart = new HashSet<>();
                    for (Integer start : startNode) {
                        nextStart.addAll(reachMap.getOrDefault(start, new HashSet<>()));
                        reachMap.remove(start);
                    }
                    startNode = nextStart;
                }
            }
            System.out.println(flag ? "yes" : "no");
        }
    }
}

package leetcode.algorithm.greedy;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description: #binary Indexed Array
 * @author: WhyWhatHow
 **/

public class Solution_881 {

    public static void main(String[] args) {
        Solution_881 sol = new Solution_881();

        System.out.println(sol.numRescueBoats(new int[]{
                        1, 2
                },
                3
        ));
        ;
        System.out.println("==================");
    }

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int res = 0;
        boolean[] vis = new boolean[people.length];
        int left = 0, right = people.length - 1;
        for (int i = people.length - 1; i >= 0; i--) {
            if (people[i] == limit) {
                res++;
                vis[i] = true;
            } else {
                right = i;
                break;
            }
        }
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                vis[left++] = true;

                vis[right--] = true;
            } else {
                vis[right--] = true;
            }
            res++;
        }

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) res++;
        }
        return res;
    }

//    public int numRescueBoats(int[] people, int limit) {
//        Arrays.sort(people);
//        int res = 0;
//
//        boolean[] vis = new boolean[people.length];
//        HashMap<Integer, Integer> map = new HashMap<>(); // (people[i], i)
//
//        for (int i = 0; i < people.length; i++) {
//            if (limit == people[i]) {
//                res++;
//                vis[i] = true;
//                continue;
//            }
//            // 两数之和处理
//            int key = limit - people[i];
//            if (map.containsKey(key)) {
//                Integer idx = map.get(key);
//                vis[i] = true;
//                vis[idx] = true;
//                res++;
//            } else {
//                map.put(people[i], i);
//            }
//        }
//        for (int i = vis.length - 1; i >= 0; i--) {
//            if(vis[i]) continue;
//
//        }
//
//        return res;
//    }

}



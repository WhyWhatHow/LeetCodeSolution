package leetcode.algorithm;

import java.util.*;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new LinkedList<>();

        if (nums.length < 4 || nums == null) {
            return lists;
        }

        Arrays.sort(nums);
        HashMap<Integer, Boolean> visMap = new HashMap<>(); // 值+访问标记位
        HashMap<Integer, Integer> map = new HashMap<>();// 值+ 下标

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                visMap.clear();
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    long temp = (long) (target) - nums[i] - nums[j] - nums[k];
//                    check nums
                    if (temp > 1000000000 || temp < -1000000000) continue;

                    Integer loc = map.getOrDefault((int) temp, -1);// 获取节点下标
                    if (loc != -1 && k < loc && !visMap.containsKey(nums[loc])) {
                        // 生成节点
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[loc]);
                        lists.add(list);
                        // 标记访问过
                        visMap.put(nums[loc], true);
                    }

                }
            }
        }
        return lists;
    }

    private Boolean check(int[] nums, int target) {
        if (nums.length < 4 || nums == null) {
            return false;
        }
        boolean res = true;
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (target != sum && nums.length == 4) res = false;
        return res;
    }

    public static void main(String[] args) {
        Solution_18 sol = new Solution_18();
//        List<List<Integer>> lists = sol.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        List<List<Integer>> lists = sol.fourSum(new int[]{
//                -2, -1, -1, 1, 1, 2, 2
                1, 0, -1, 0, -2, 2
        }, 0);

        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));


        System.out.println("==================");

        List<List<Integer>> lists1 = sol.fourSum(new int[]{
//                -2, -1, -1, 1, 1, 2, 2
//                1, 0, -1, 0, -2, 2
//                -1000000000, -1000000000, -1000000000, -1000000000
                -1000000000, -1000000000, 1000000000, -1000000000, -1000000000
        }, 294967296);

//        List<List<Integer>> lists = sol.fourSum(new int[]{2, 2,2, 2, 2}, 8);

        System.out.println(lists1.size());
        lists1.forEach(x -> System.out.println(x.toString()));


    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        List res = new ArrayList();
        if(nums.length<4|| nums ==null) return res ;

        HashMap<Integer,Integer> map =new HashMap();
        HashSet set = new HashSet();
        Arrays.sort(nums);
        for(int i = 0 ; i< nums.length; i++){
            map.put(nums[i],i);
        }

        for(int i = 0 ;i< nums.length ; i++){
            if(i>0 && nums[i]==nums[i-1]) continue ;// remove repeat elements
            for(int j =i+1 ; j< nums.length; j++){
                set.clear();
                if(j>i+1 && nums[j]==nums[j-1]) continue ;// remove repeat elements

                for(int k = j+1 ; k< nums.length; k++){
                    long temp = (long) (target) -nums[i]-nums[j]-nums[k];
                    if(temp >1000_000_000 || temp <-1000_000_000) continue ;
                    int idx =  map.getOrDefault((int)temp,-1);
                    if(idx !=-1 && k<idx && !set.contains(nums[idx])){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(nums[idx]);
                        res.add(list);
                        set.add(nums[idx]);
                    }
                }
            }
        }
        return res ;
    }
}



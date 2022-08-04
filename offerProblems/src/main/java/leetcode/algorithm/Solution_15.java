package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow

 **/

public class Solution_15 {

    /**
     * 题目描述： a+b+c=0,返回结果集,
     * [-1, 0, 1, 2, -1, -4]-> [-4,-1,-1,0,1,2];
     * [-4,-1, ]= 0 ,[-4, -1], [-4,0 ],[-4,1,][-4,2]=0'
     * [-1
     * 题解:
     * step 1: sort nums
     * step 2 : nums.fori  from 0 to length-2
     * step 3 : clean repeat num, nums[i] ==nums[i-1]
     * step 4 ; nums.forj  from i+1, to length-1
     * step 5 : binarySearh from j+1, to length , get index i of nums
     * step 6 : handle i && create List<a,b,c>
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List list = new ArrayList();
        Arrays.sort(nums);
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            map.clear();
            if (i > 0 && nums[i] == nums[i - 1]) {   // 去重
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int temp = -(nums[i] + nums[j]);
                int k = Arrays.binarySearch(nums, j + 1, nums.length, temp);
                //// TODO: 2020/8/27  判断尾部优化
                // 二分查找优化,

                if (k >= 0 && !map.containsKey(nums[k])) {
                    ArrayList<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);
                    list.add(list1);
                    map.put(nums[k],true);
                }
//                for (int k = j+1; k < nums.length; k++) {
//                    if(nums[k]+temp==0){
//                      }
//                }
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Solution_15 sol = new Solution_15();

        List<List<Integer>> lists = sol.threeSum(
//                new int[]{0,0,0,0,0}
//                new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}
                new  int[] {-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}
//                new int[]{-1, 0, 1, 2, -1, -4}
                );
        System.out.println(lists.size());
        lists.forEach(x -> System.out.println(x.toString()));

        System.out.println("==================");
    }
}



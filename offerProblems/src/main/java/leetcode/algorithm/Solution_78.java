package leetcode.algorithm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-07 12:09
 **/

public class Solution_78 {

    List<List<Integer>> ans  =new LinkedList<>() ;
    LinkedList<Integer> list =new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length==0||nums==null) {
            return ans ;
        }
        dfs(0,nums);
        return ans ;
    }
     // 回溯 ,dfs
    private void dfs(int idx, int[] nums) {
        if(idx== nums.length){
            ans.add(new ArrayList<>(list));
            return ;
        }
        //   加入 当前节点
        list.add(nums[idx]);
        dfs(idx+1,nums);
        //  移除 当前节点
        list.removeLast();
        dfs(idx+1,nums);
    }

    public static void main(String[] args) {
        Solution_78 sol = new Solution_78();
        List<List<Integer>> subsets = sol.subsets(new int[]{1,2,3});
//        List<List<Integer>> subsets = sol.subsets(new int[]{0});
        System.out.println(subsets.size());
        subsets.forEach(x-> System.out.println(x.toString()));
        System.out.println("==================");
    }
}



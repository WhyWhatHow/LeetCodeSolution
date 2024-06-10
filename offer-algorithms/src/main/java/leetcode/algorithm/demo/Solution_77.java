package leetcode.algorithm.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 **/

public class Solution_77 {

    public static void main(String[] args) {
        Solution_77 sol = new Solution_77();
        System.out.println("==================");
        List<List<Integer>> combine = sol.combine1(4, 3);
        combine.forEach(System.out::println);


    }

    /**
     * return [n,k] 的组合数
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List res = new LinkedList();
//        if (k <= 0) return res;
        LinkedList temp = new LinkedList<Integer>();
        dfs1(n, k, 1, temp, res);
        return res;
    }

    public void dfs1(int n, int k, int start, LinkedList temp, List res) {
        if (temp.size() == k) {
            // 数据放满, res++, return ;
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.push(i);
            dfs1(n, k, i + 1, temp, res);
            temp.pop();
        }
    }


    public List<List<Integer>> combine1(int n, int k) {
        List resList = new ArrayList<List>();
        LinkedList tempList = new LinkedList<Integer>();
        dfs(1,n,k,tempList,resList);
        return resList;
    }
    void dfs(int start, int n ,int k, LinkedList tempList,List resList){
        if(tempList.size() ==k){
            resList.add(new ArrayList(tempList));
            return ;
        }
        for(int i = start ; i<= n ;i++){
            tempList.push(i);
            dfs(i+1,n,k,tempList, resList);
            tempList.pop();
        }
    }
}



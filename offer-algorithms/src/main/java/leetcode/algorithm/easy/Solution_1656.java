package leetcode.algorithm.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1656 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        Solution_1656 sol = new Solution_1656();
        OrderedStream os = new OrderedStream(5);
        System.out.println(os.insert(3, "ccccc"));
        System.out.println(os.insert(1, "aaaaa")); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(os.insert(2, "bbbbb")); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(os.insert(5, "eeeee")); // 插入 (5, "eeeee")，返回 []
        System.out.println(os.insert(4, "ddddd")); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
        System.out.println("==================");
    }


}

class OrderedStream {
    ArrayList<String> list;
    boolean[] vis;
    int ptr = 1;
    int n;

    public OrderedStream(int n) {
        list = new ArrayList<>(n + 1);
        this.n = n;
        vis = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add("");
        }
    }

    public List<String> insert(int idKey, String value) {

        if (!vis[idKey]) {
            vis[idKey] = true;
        }
        list.set(idKey, value);

        if (idKey > ptr) {
            return Collections.emptyList();
        }

        List<String> tmpList = new LinkedList<>();
        for (int i = ptr; i <= n; i++) {
            if (vis[i]) tmpList.add(list.get(i));
            else break;
        }

        // update ptr
        while (ptr <= n && vis[ptr]) ptr++;
        return tmpList;
    }
}
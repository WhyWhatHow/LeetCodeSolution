package leetcode.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1233 {

    public static void main(String[] args) {
        Solution_1233 sol = new Solution_1233();
        System.out.println(sol.removeSubfolders(new String[]{
//                "/a","/a/b/c","/a/b/d"
                "/a", "/c/d", "/a/b", "/c/d/e", "/c/f"
        }));
        System.out.println("==================");
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> list = new ArrayList<>();
        list.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String last = list.getLast();
            int n = last.length();
            if (folder[i].startsWith(last) && folder[i].charAt(n) == '/') {
                continue;
            }
            list.add(folder[i]);
        }
        return list;
    }

}



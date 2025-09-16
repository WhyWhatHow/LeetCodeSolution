package leetcode.algorithm.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2349 {

    public static void main(String[] args) {
        Solution_2349 sol = new Solution_2349();
        HashSet<Integer> set = new HashSet<>();
        NumberContainers nc = new NumberContainers();
        nc.change(1, 10);
        nc.find(10);
        nc.change(1, 20);
        nc.find(10);
        nc.find(20);
        nc.find(30);

        System.out.println("==================");
    }


}

class NumberContainers {

    HashMap<Integer, TreeSet<Integer>> map = new HashMap<>(); // key : num ,val : {idxs}
    HashMap<Integer, Integer> imap = new HashMap<>();// key idx, val : number:

    public NumberContainers() {

    }

    public void change(int index, int number) {
        int nv;
        if ((nv = imap.getOrDefault(index, -1)) != -1) {
            //  remove map -> nv: index
            map.get(nv).remove(index);
        }
        // update imap & map
        imap.put(index, number);
        var set = map.getOrDefault(number, new TreeSet<>());
        set.add(index);
        map.put(number, set);
    }

    public int find(int number) {
        if (map.containsKey(number)) {
            TreeSet<Integer> set = map.get(number);
            return set.isEmpty() ? -1 : set.first();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
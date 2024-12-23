package leetcode.algorithm.medium;

import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_855 {

    public static void main(String[] args) {
        Solution_855 sol = new Solution_855();
        ExamRoom ex = new ExamRoom(10);
        for (int i = 0; i < 4; i++) {
            System.out.println(ex.seat());
        }
        ex.leave(4);
        System.out.println(ex.seat());
        System.out.println("==================");
    }


}

class ExamRoom {
    //
    TreeSet<Integer> set = new TreeSet<>(); // 已选座位
    int n;

    public ExamRoom(int n) {
        this.n = n;
    }

    /**
     * consider  maxDistance in [0,fist] , (first, last) , [last, n)
     *
     * @return
     */
    public int seat() {
        if (set.isEmpty()) {
            set.add(0);
            return 0;
        }
        int maxDistance = set.first(); // check [0,first] is qualified.
        int prev = -1;
        int pos = 0; // it should be 0 , not maxDistance/2 ;

        // check (first, last)
        for (Integer i : set) {
            if (prev != -1) {
                int distance = (i - prev) / 2;
                if (distance > maxDistance) {
                    maxDistance = distance;
                    pos = prev + distance;
                }
            }
            prev = i;
        }

        // check [last, n)
        if (n - 1 - set.last() > maxDistance) {
            pos = n - 1;
        }
        return pos;
    }


    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */


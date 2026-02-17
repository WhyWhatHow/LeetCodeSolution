package leetcode.algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/
public class Solution_401 {

    public static void main(String[] args) {
        Solution_401 sol = new Solution_401();//
        System.out.println(sol.readBinaryWatch(8));
        System.out.println("==================");
    }

    List<String> reslist = new ArrayList<>();

    // 1,2,4,8,16,32, 60, 120,240 ,480
    // 12h 59min, 12
    int maxHour = 11;
    int maxminute = 59;

    public List<String> readBinaryWatch(int turnedOn) {
        int[] as = new int[]{1, 2, 4, 8, 16, 32, 60, 120, 240, 480};
        boolean[] v = new boolean[as.length];
        dfs(turnedOn, as.length - 1, as, v, 0);
        return reslist;
    }

    private void dfs(int turnedOn, int i, int[] as, boolean[] v, int time) {
        if (turnedOn == 0 && checkMinute(v, as) && checkHour(v, as)) {

            reslist.add(genTime(time));
            return;
        }
        for (int j = i; j >= 0; j--) {
            if (!v[j]) {
                v[j] = true;
                time += as[j];
                turnedOn--;
                dfs(turnedOn, j - 1, as, v, time);
                v[j] = false;
                turnedOn++;
                time -= as[j];
            }
        }
    }

    private boolean checkHour(boolean[] v, int[] as) {
        int val = 0;
        for (int i = 6; i < v.length; i++) {
            if (v[i]) val += as[i]/60;
        }
        return val <= maxHour;
    }

    private boolean checkMinute(boolean[] v, int[] as) {
        int val = 0;
        for (int i = 0; i < 6; i++) {
            if (v[i]) val += as[i];
        }
        return val <= maxminute;
    }


    private String genTime(int time) {
        int h = time / 60;
        int min = time % 60;
        if (min < 10) return h + ":0" + min;
        else
            return h + ":" + min;
    }

}


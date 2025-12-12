package leetcode.algorithm.medium;

import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3433 {

    public static void main(String[] args) {
        Solution_3433 sol = new Solution_3433();
        System.out.println("MESSAGE".compareTo("OFFLINE"));
        System.out.println("OFFLINE".compareTo("MESSAGE"));
//        [["MESSAGE","2","HERE"],["OFFLINE","2","1"],["OFFLINE","1","0"],["MESSAGE","61","HERE"]]
        sol.countMentions(2,
                List.of(
                        List.of("MESSAGE", "10", "id1 id0"),
                        List.of("OFFLINE", "11", "0"),
                        List.of("MESSAGE", "71", "HERE")
                ));
        System.out.println("==================");
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers;
        long[] ts = new long[n];// 用户在线时间.
        int[] rs = new int[n];// 回应次数.
        events.sort((a, b) -> {
            if (a.get(1).equals(b.get(1)) != true)
                return Long.compare(Long.parseLong(a.get(1)), Long.parseLong(b.get(1)));
            else
                return b.get(0).compareTo(a.get(0));
        });
        for (List<String> e : events) {
            String type = e.get(0);
            long time = Long.parseLong(e.get(1));
            String mens = e.get(2);
            if ("OFFLINE".equals(type)) {
                int id = Integer.parseInt(mens);
                ts[id] = time + 60;
            } else { // message
                if ("ALL".equals(mens)) {
                    for (int i = 0; i < rs.length; i++) {
                        rs[i]++;
                    }
                } else if ("HERE".equals(mens)) {
                    for (int i = 0; i < n; i++) {
                        if (ts[i] <= time) rs[i]++;
                    }
                } else {
                    int[] ids = getMenIds(mens);
                    for (int id : ids) {
                        rs[id]++;
                    }
                }
            }
        }
        return rs;

    }

    private int[] getMenIds(String s) {
        String[] ts = s.split(" ");
        int[] ans = new int[ts.length];
        int cnt = 0;
        for (String t : ts) {
            char[] cs = t.toCharArray();
            int c = 0;
            for (int i = 2; i < cs.length; i++) {
                c = c * 10 + cs[i] - '0';
            }
            ans[cnt++] = c;
        }
        return ans;
    }


}



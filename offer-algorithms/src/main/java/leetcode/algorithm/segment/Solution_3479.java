package leetcode.algorithm.segment;

import java.util.ArrayList;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3479 {

    public static void main(String[] args) {
        Solution_3479 sol = new Solution_3479();
        System.out.println(sol.numOfUnplacedFruits(new int[]{
//                4, 2, 5,
                17, 14, 59, 20
        }, new int[]{
//                3, 5, 4,
                41, 6, 7, 33
        }));
        System.out.println("==================");
    }

    public int numOfUnplacedFruits(int[] f, int[] b) {
        int n = f.length;
        int m = b.length;
        boolean[] v = new boolean[m];
        // 把 b ->分成大小为t的块,每一块存其最大值, 这样就可以快速过滤.
        int t = (int) Math.sqrt(m);
        var list = buildSegmentList(t, b);
        for (int tar : f) {
            for (int i = 0; i < list.size(); i++) {
                if (tar <= list.get(i)[0] && list.get(i)[1] > 0) {

                    boolean yes = false;
                    int st = i * t;
                    int end = Math.min(st + t, m);
                    int cntt = list.get(i)[1];
                    for (int k = st; k < end; k++) {
                        if (!v[k] && b[k] >= tar) {
                            v[k] = true;
                            n--;
                            yes = true;
                            cntt--;
                            list.set(i, new int[]{list.get(i)[0], cntt});
                            break;
                        }
                    }
                    if (yes) break;
                }
            }
        }


        return n;
    }

    private ArrayList<int[]> buildSegmentList(int t, int[] b) {
        ArrayList<int[]> list = new ArrayList<>(); // int[] =>{ max , cnt 标记可以访问的元素数量. )
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < b.length; i++) {
            max = Math.max(max, b[i]);
            cnt++;
            if (cnt == t) {
                list.add(new int[]{max, cnt});
                max = 0;
                cnt = 0;
            }
        }
        list.add(new int[]{max, cnt});
        return list;
    }


}



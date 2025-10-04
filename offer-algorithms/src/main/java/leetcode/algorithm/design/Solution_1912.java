package leetcode.algorithm.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_1912 {

    public static void main(String[] args) {
        Solution_1912 sol = new Solution_1912();
        System.out.println(Integer.bitCount(5));
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, new int[][]{{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}});
        movieRentingSystem.search(1);  // 返回 [1, 0, 2] ，商店 1，0 和 2 有未借出的 ID 为 1 的电影。商店 1 最便宜，商店 0 和 2 价格相同，所以按商店编号排序。
        movieRentingSystem.rent(0, 1); // 从商店 0 借出电影 1 。现在商店 0 未借出电影编号为 [2,3] 。
        movieRentingSystem.rent(1, 2); // 从商店 1 借出电影 2 。现在商店 1 未借出的电影编号为 [1] 。
        movieRentingSystem.report();   // 返回 [[0, 1], [1, 2]] 。商店 0 借出的

        // 1 未借出的电影编号为 [1,2] 。
        movieRentingSystem.search(2);  // 返回 [0, 1] 。商店 0 和 1 有未借出的 ID 为 2 的电影。商店 0 最便宜，然后是商店 1 。
        // 初始化电影租赁系统
// 参数说明：69为商店数量，二维数组为电影信息 [商店ID, 电影ID, 价格]
//        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(69, new int[][]{
//                {16, 4156, 1511}, {20, 8501, 8417}, {34, 7901, 7776},
//                {54, 6691, 9511}, {44, 8931, 8434}, {42, 9640, 5251},
//                {22, 4534, 9161}, {32, 6506, 6831}, {13, 8501, 731},
//                {4, 7610, 8474}, {33, 820, 2341}, {17, 6490, 1161},
//                {29, 7120, 2703}, {8, 8723, 7613}, {38, 9544, 1804},
//                {30, 8723, 1047}, {1, 5015, 7763}, {60, 1625, 2383},
//                {29, 3336, 3542}, {39, 7535, 6066}, {1, 9074, 9400},
//                {39, 1625, 7944}, {26, 9160, 6874}, {55, 2465, 888},
//                {35, 8530, 6025}
//        });
//
//        movieRentingSystem.rent(32, 6506);  // 从商店32租赁电影6506
//        movieRentingSystem.search(8501);    // 搜索电影8501的可用副本
//        movieRentingSystem.search(6275);    // 搜索电影6275的可用副本
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(30, 8723);  // 从商店30租赁电影8723
//        movieRentingSystem.rent(8, 8723);   // 从商店8租赁电影8723
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.search(6699);    // 搜索电影6699的可用副本
//        movieRentingSystem.search(115);     // 搜索电影115的可用副本
//        movieRentingSystem.rent(20, 8501);  // 从商店20租赁电影8501
//        movieRentingSystem.rent(16, 4156);  // 从商店16租赁电影4156
//        movieRentingSystem.search(9447);    // 搜索电影9447的可用副本
//        movieRentingSystem.drop(30, 8723);  // 在商店30归还电影8723
//        movieRentingSystem.drop(8, 8723);   // 在商店8归还电影8723
//        movieRentingSystem.drop(32, 6506);  // 在商店32归还电影6506
//        movieRentingSystem.drop(16, 4156);  // 在商店16归还电影4156
//        movieRentingSystem.rent(42, 9640);  // 从商店42租赁电影9640
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(17, 6490);  // 从商店17租赁电影6490
//        movieRentingSystem.drop(20, 8501);  // 在商店20归还电影8501
//        movieRentingSystem.search(8175);    // 搜索电影8175的可用副本
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(17, 6490);  // 在商店17归还电影6490
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(42, 9640);  // 在商店42归还电影9640
//        movieRentingSystem.rent(54, 6691);  // 从商店54租赁电影6691
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.search(1625);    // 搜索电影1625的可用副本
//        movieRentingSystem.search(3291);    // 搜索电影3291的可用副本
//        movieRentingSystem.rent(60, 1625);  // 从商店60租赁电影1625
//        movieRentingSystem.rent(39, 1625);  // 从商店39租赁电影1625
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(60, 1625);  // 在商店60归还电影1625
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(39, 1625);  // 在商店39归还电影1625
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(54, 6691);  // 在商店54归还电影6691
//        movieRentingSystem.rent(8, 8723);   // 从商店8租赁电影8723
//        movieRentingSystem.drop(8, 8723);   // 在商店8归还电影8723
//        movieRentingSystem.search(2260);    // 搜索电影2260的可用副本
//        movieRentingSystem.rent(29, 7120);  // 从商店29租赁电影7120
//        movieRentingSystem.search(746);     // 搜索电影746的可用副本
//        movieRentingSystem.drop(29, 7120);  // 在商店29归还电影7120
//        movieRentingSystem.rent(38, 9544);  // 从商店38租赁电影9544
//        movieRentingSystem.drop(38, 9544);  // 在商店38归还电影9544
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(1, 9074);   // 从商店1租赁电影9074
//        movieRentingSystem.drop(1, 9074);   // 在商店1归还电影9074
//        movieRentingSystem.rent(54, 6691);  // 从商店54租赁电影6691
//        movieRentingSystem.rent(39, 1625);  // 从商店39租赁电影1625
//        movieRentingSystem.drop(54, 6691);  // 在商店54归还电影6691
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(26, 9160);  // 从商店26租赁电影9160
//        movieRentingSystem.drop(26, 9160);  // 在商店26归还电影9160
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.drop(39, 1625);  // 在商店39归还电影1625
//        movieRentingSystem.rent(42, 9640);  // 从商店42租赁电影9640
//        movieRentingSystem.search(9640);    // 搜索电影9640的可用副本
//        movieRentingSystem.drop(42, 9640);  // 在商店42归还电影9640
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(29, 7120);  // 从商店29租赁电影7120
//        movieRentingSystem.search(5630);    // 搜索电影5630的可用副本
//        movieRentingSystem.search(1842);    // 搜索电影1842的可用副本
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(16, 4156);  // 从商店16租赁电影4156
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.rent(1, 9074);   // 从商店1租赁电影9074
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.report();        // 查询已租赁的电影列表
//        movieRentingSystem.search(7992);    // 搜索电影7992的可用副本
//        movieRentingSystem.rent(4, 7610);   // 从商店4租赁电影7610
//        movieRentingSystem.rent(29, 3336);  // 从商店29租赁电影3336
//        movieRentingSystem.search(1333);    // 搜索电影1333的可用副本
        System.out.println("==================");
    }


}

class MovieRentingSystem {
    HashMap<Integer, TreeSet<int[]>> unRentedMap = new HashMap<>(); // key : movie , val : unRentedSet{ price ,shop }
    TreeSet<int[]> borrowedMovies = new TreeSet<>((a, b) -> { // price , shop, movie
        if (a[0] != b[0]) return a[0] - b[0];
        else if (a[1] != b[1]) return a[1] - b[1];
        else return a[2] - b[2];
    });

    HashMap<Long, Integer> map = new HashMap<>(); // key : shop | movie , value : price

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            int s = e[0], m = e[1], p = e[2]; // shop , movie , price
            map.put(genKey(s, m), p);
            TreeSet<int[]> set = unRentedMap.getOrDefault(m, new TreeSet<int[]>((a, b) -> { // price , shop
                if (a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }));
            set.add(new int[]{p, s});
            unRentedMap.put(m, set);
        }

    }
/// 数据溢出, mmf
    private long genKey(int s, int m) {
        return ((long) s << 25) | m;
    }

    public List<Integer> search(int movie) {
        TreeSet<int[]> set = unRentedMap.get(movie);
        if (set == null || set.isEmpty()) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for (int[] ints : set) {
            list.add(ints[1]);
            cnt++;
            if (cnt == 5) break;
        }
        return list;
    }

    public void rent(int shop, int movie) {
        Long key = genKey(shop, movie);
        int price = map.get(key);
        borrowedMovies.add(new int[]{price, shop, movie});
        TreeSet<int[]> set = unRentedMap.get(movie);
        set.remove(new int[]{price, shop});
//        unRentedMap.put(movie, set);
    }

    public void drop(int shop, int movie) {
        Long key = genKey(shop, movie);
        int p = map.get(key);
        borrowedMovies.remove(new int[]{p, shop, movie});
        TreeSet<int[]> set = unRentedMap.get(movie);
        set.add(new int[]{p, shop});
//        unRentedMap.put(movie, set);
    }

    public List<List<Integer>> report() {
        if (borrowedMovies.isEmpty()) return new ArrayList<>();
        int cnt = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int[] ints : borrowedMovies) {
            list.add(List.of(ints[1], ints[2]));
            cnt++;
            if (cnt == 5) break;
        }
        return list;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */

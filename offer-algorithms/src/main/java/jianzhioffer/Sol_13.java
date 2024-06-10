package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_13 {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};
    int cnt = 1;
    boolean[][] vis = new boolean[100][100];

    public int movingCount(int m, int n, int k) {
        vis[0][0] = true;
        dfs(0, 0, m, n, k);

        return cnt;
    }

    private void dfs(int x, int y, int m, int n, int k) {
        if (x == m || y == n || !judge(x, y, k)) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int xx = dx[i] + x;
            int yy = dy[i] + y;
            if (xx < 0 || yy < 0 || xx >= m || yy >= n) {
                continue;
            }
            if (judge(xx, yy, k) && !vis[xx][yy]){
                // 判断当前路段可走
                cnt++;
                vis[xx][yy] = true;
                dfs(xx, yy, m, n, k);

            }
        }
    }


    boolean judge(int x, int y, int k) {
        int temp = 0;
        temp += getNum(x) + getNum(y);
        return temp <= k;
    }

    private int getNum(int x) {
        if (x < 10) {
            return x;
        }
        int res = 0;
        while (x >0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        Sol_13 sol = new Sol_13();
        int i = sol.movingCount(2, 3, 1);
        System.out.println(i);
        System.out.println("=======");
    }
}

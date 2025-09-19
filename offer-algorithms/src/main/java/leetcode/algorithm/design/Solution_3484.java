package leetcode.algorithm.design;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_3484 {

    public static void main(String[] args) {
        Solution_3484 sol = new Solution_3484();
        Spreadsheet spreadsheet = new Spreadsheet(3); // 初始化一个具有 3 行和 26 列的电子表格
        spreadsheet.getValue("=5+7"); // 返回 12 (5+7)
        spreadsheet.setCell("A1", 10); // 设置 A1 为 10
        spreadsheet.getValue("=A1+6"); // 返回 16 (10+6)
        spreadsheet.setCell("B2", 15); // 设置 B2 为 15
        spreadsheet.getValue("=A1+B2"); // 返回 25 (10+15)
        spreadsheet.resetCell("A1"); // 重置 A1 为 0
        spreadsheet.getValue("=A1+B2"); // 返回 15 (0+15)
        System.out.println("==================");
    }


}


class Spreadsheet {

    char c = 'A';
    char zero = '0';
    int[][] g;

    public Spreadsheet(int rows) {
        this.g = new int[26][rows + 1];
    }

    public void setCell(String cell, int value) {
        int x = getX(cell);
        int y = getY(cell);
        g[x][y] = value;
    }

    private int getX(String cell) {
        int x = cell.charAt(0) - c;
        return x;
    }

    private int getY(String cell) {
        int y = 0;
        for (int i = 1; i < cell.length(); i++) {
            y = y * 10 + cell.charAt(i) - zero;
        }
        return y;
    }

    public void resetCell(String cell) {
        int x = getX(cell);
        int y = getY(cell);
        g[x][y] = 0;
    }

    public int getValue(String formula) {
        String[] ss = formula.split("\\+");

        int a = parse(ss[0].substring(1));
        int b = parse(ss[1]);
        return a + b;
    }

    private int parse(String s) {
        if (isCell(s)) {
            int x = getX(s);
            int y = getY(s);
            return g[x][y];
        } else {
            int res = 0;
            for (char c1 : s.toCharArray()) {
                res = res * 10 + c1 - zero;
            }
            return res;
        }
    }

    boolean isCell(String s) {
        if (s.charAt(0) >= 'A' && s.charAt(0) <= 'Z') return true;
        return false;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
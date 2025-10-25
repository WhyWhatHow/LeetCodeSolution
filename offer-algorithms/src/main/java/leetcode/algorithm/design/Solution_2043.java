package leetcode.algorithm.design;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2043 {

    public static void main(String[] args) {
        Solution_2043 sol = new Solution_2043();
        System.out.println("==================");
    }


}


class Bank {
    long[] balance;
    int n;

    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }

    boolean check(int x) {
        return x <= n;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!check(account1) || !check(account2)) return false;

        int a = account1 - 1;
        int b = account2 - 1;
        if (balance[a] >= money) {
            balance[a] -= money;
            balance[b] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!check(account)) return false;
        int i = account - 1;
        balance[i] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!check(account)) return false;
        int i = account - 1;
        if (balance[i] < money) return false;

        balance[i] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
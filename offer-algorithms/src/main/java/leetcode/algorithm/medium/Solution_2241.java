package leetcode.algorithm.medium;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_2241 {

    public static void main(String[] args) {
        Solution_2241 sol = new Solution_2241();
        System.out.println(500l * 1000_000_000 > Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
        ATM atm = new ATM();

        System.out.println("==================");
    }


}

class ATM {
    //    TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
    int[] cnts = new int[5];
    int[] arr = new int[]{20, 50, 100, 200, 500};
    int n = 5;

    public ATM() {
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < banknotesCount.length; i++) {
            cnts[i] += banknotesCount[i];
            int val = banknotesCount[i];
//            map.compute(arr[i], (k, v) -> v == null ? val : v + val);
        }
    }


    public int[] withdraw(int amount) {
        boolean yes = false;
        int sum = 0;
        int[] ans = new int[5];
        for (int i = n - 1; i >= 0; i--) {
            if (cnts[i] != 0) {
                while (cnts[i] > ans[i] && amount >= arr[i]) {
                    int time = amount / arr[i];
                    if (time > cnts[i]) {
                        time = cnts[i];
                    }
                    ans[i] = time;
                    amount -= time * arr[i];
                    if (amount == 0) {
                        yes = true;
                        break;
                    }
                }
            }
        }
        if (!yes) return new int[]{-1};
        for (int i = 0; i < cnts.length; i++) {
            cnts[i] -= ans[i];
        }
        return ans;

    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
package leetcode.algorithm.medium;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_227 {

    public static void main(String[] args) {
        Solution_227 sol = new Solution_227();
        System.out.println(sol.calculate("3+15*20"));
        System.out.println(sol.calculate("1-1+1"));
//        System.out.println(sol.calculate("3*20+300/50"));
//        System.out.println(Integer.valueOf('+'));
//
//        System.out.println(Integer.valueOf('-'));
//
//        System.out.println(Integer.valueOf('*'));
//
//        System.out.println(Integer.valueOf('/'));
        System.out.println("==================");
    }

    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        char[] cs = s.toCharArray();
        int num = 0;
        char preOp = '+'; // 默认第一个操作是+
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') continue;
            if (Character.isDigit(cs[i])) {
                num = 10 * num + cs[i] - '0';
            } else {
                doCal(preOp, nums, num);
                preOp = cs[i];
                num = 0;
            }
        }
        // handle the last number.
        doCal(preOp,nums,num);
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    private  void doCal(char preOp, Stack<Integer> nums, int num) {
        switch (preOp) {
            case '+':
                nums.push(num);
                break;
            case '-':
                nums.push(-num);
                break;
            case '*':
                nums.push(num * nums.pop());
                break;
            case '/':
                nums.push(nums.pop() / num);
                break;
        }
    }

    public int calculateStupid(String s) {
        char[] cs = s.toCharArray();
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ss = new Stack<>();

        boolean yes = false; // 处理乘除法优先级
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') continue;
            if (check(cs[i])) { // 判断是否是 op
                int num = getNumber(ss);
                nums.push(num);
                if (yes) {
                    int res = handle(nums, ss);
                    nums.push(res);
                    yes = false;
                }
                if (cs[i] == '*' || cs[i] == '/') {
                    yes = true;
                }
            }
            ss.push(cs[i]);
        }
        nums.push(getNumber(ss));
        if (yes) { //
            nums.push(handle(nums, ss));
        }
        // 剩余的都是加减法, 需要从左到右运算.  也就是说需要把ss元素都倒出来, nums 元素都倒出来重新塞进去.
        int cnt = 0;
        int ans = nums.get(cnt);
        for (int i = 0; i < ss.size(); i++) {
            ans = doCal(ss.get(i), ans, nums.get(++cnt));
        }

        return ans;
    }

    boolean check(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private int handle(Stack<Integer> nums, Stack<Character> ss) {
        Integer sec = nums.pop();
        Integer fir = nums.pop();
        Character pop = ss.pop();
        return doCal(pop, fir, sec);
    }

    int doCal(char pop, int fir, int sec) {
        if (pop == '*') return fir * sec;
        if (pop == '+') return fir + sec;
        if (pop == '-') return fir - sec;
        if (pop == '/') return fir / sec;
        return 0;
    }

    private int getNumber(Stack<Character> ss) {
        int res = 0;
        int time = 1;
        while (!ss.isEmpty()) {
            if (check(ss.peek())) break;
            int i = ss.pop() - '0';
            res += time * i;
            time *= 10;
        }
        return res;
    }

}



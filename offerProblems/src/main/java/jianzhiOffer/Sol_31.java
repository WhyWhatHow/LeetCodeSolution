package jianzhiOffer;

import java.util.Stack;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean res = true;
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int cnt = popped.length;
        for (int i = 0; i < popped.length; i++) {

            if (!stack.isEmpty() && stack.peek().equals(popped[i])) {
                stack.pop();
                cnt = i;
                continue;
            }
            while (idx < popped.length && popped[i] != pushed[idx]) {
                stack.push(pushed[idx]);
                idx++;
            }
            if (idx == popped.length) { // 处理非正常序列
                break;
            }
            if ( pushed[idx] == popped[i]) { // 斩首元素
                cnt = i;
                idx++;
                continue;
            }

        }
        return stack.isEmpty();
//        while (!stack.isEmpty()) {
//
//        }
    }

    public static void main(String[] args) {
        Sol_31 sol = new Sol_31();
        sol.validateStackSequences(new int[]{
                1,2,3,4,5
        }, new int[]{
                4,5,3,1,2
        });
        System.out.println("=======");
    }
}

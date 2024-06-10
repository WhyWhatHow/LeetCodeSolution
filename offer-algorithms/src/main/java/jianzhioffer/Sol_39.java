package jianzhioffer;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_39 {
    /**
     * 求众数 ,摩尔他投票法
     * 设众数为 x, 是众数 +1, 其他数-1, 众数 多的情况下, 结果一定大于0
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int cnt = 0;
        int x = nums[0];//
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    x = nums[i + 1];

                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        Sol_39 sol = new Sol_39();
        int i = sol.majorityElement(new int[]{
                1, 2, 3, 2, 2, 2, 5, 4, 2
        });
        System.out.println(i);
        int i1 = sol.sumNums(9);
        System.out.println(i1);
        System.out.println("=======");
    }
    public int sumNums(int n) {
        if(n==0)
            return 0;
        else return sumNums(n-1)+n;
    }
}

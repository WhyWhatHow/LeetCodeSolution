package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_21 {

    public int[] exchange(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> dList = new ArrayList<>();
        for (int num : nums) {
            if ((num&1)==0) {
                dList.add(num);
            }else{list.add(num);}
        }
        list.addAll(dList);
        int cnt =0;
        for (Integer integer : list) {
            nums[cnt++] =integer;
        }
        return nums;
    }

    public static void main(String[] args) {
        Sol_21 sol = new Sol_21();
        System.out.println("=======");
    }
}

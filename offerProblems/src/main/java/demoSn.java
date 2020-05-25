import sun.print.SunMinMaxPage;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-04-29 12:16
 **/
public class demoSn {

    public static void main(String[] args) {
        demoSn sn = new demoSn();
        sn.FindContinuousSequence(100);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int left = 1, right = 2;
        int midSum = left+right;
        for (; right < sum; ) {
            if (midSum < sum) {
                right++;
                midSum += right;

            } else if (midSum > sum) {
                midSum -= left;
                left++;
            }
            else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int j = left; j <=right; j++) {
                    list.add(j);
                }
//                travelList(list);
                lists.add(list);
                right++;
                midSum+=right;
            }
        }
        return lists;
    }

    public void travelList(ArrayList<Integer> list) {
        for (Integer integer : list) {
            System.out.print(integer + " ,");
        }
        System.out.println("============");
    }
}

package interview;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-15 09:22
 **/
public class ReverseOrderArray {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{2, 3, 4, 5, 6, 7};
        ReverseOrderArray sol = new ReverseOrderArray();
        int[] ints = sol.reverseMergeSortArray(a, b);
        for (Integer anInt : ints) {
            System.out.print(anInt + " ,");
        }
    }

    /**
     * 思路二： 不需要用链表，直接模拟归并排序过程，返回数组时倒序插入即可。。。
     *
     * @param a
     * @param b
     * @return
     */
    int[] reverseMergeSortArray(int[] a, int[] b) {

        int alen = a.length;
        int blen = b.length;
        int i = 0, j = 0, k = alen + blen;
        int[] ans = new int[k];
        k--;// ans.length =k ;
        // 结果数组
        while (i < alen && j < blen) {
            if (a[i] < b[j]) {
                ans[k--] = a[i++];
            } else if (a[i] == b[j]) {
                ans[k--] = a[i++];
                ans[k--] = b[j++];
            } else {
                ans[k--] = b[j++];
            }
        }
        while (i < alen) ans[k--] = a[i++];
        while (j < blen) ans[k--] = b[j++];
        return ans;
    }


    /**
     * 思路: 借助头插法实现从大到小排序
     * 复杂度分析: 遍历一遍数组,遍历一遍链表
     *
     * @param a 有序数组a
     * @param b 有序数组b
     * @return
     */
    Object[] reverseMergeSortArrayByLinkedList(int[] a, int[] b) {

        LinkedList<Integer> list = new LinkedList<Integer>();
        int alen = a.length;
        int blen = b.length;
        int i = 0, j = 0, k = 0;
        while (i < alen && j < blen) {
            if (a[i] < b[j]) {
                list.addFirst(a[i++]);
            } else if (a[i] == b[j]) {
                list.addFirst(a[i++]);
                list.addFirst(b[j++]);
            } else {
                list.addFirst(b[j++]);
            }
        }
        while (i < alen) list.addFirst(a[i++]);
        while (j < blen) list.addFirst(b[j++]);
        return list.toArray();
    }



}

/**
 * SELECT grade ,COUNT(grade) COUNT FROM students
 * WHERE  gender =0  AND NAME IS NULL
 * GROUP BY grade
 * ORDER BY COUNT DESC
 */

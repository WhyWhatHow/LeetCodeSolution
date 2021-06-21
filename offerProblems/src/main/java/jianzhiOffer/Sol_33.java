package jianzhiOffer;

import java.util.Arrays;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_33 {
    /**
     * 判断 二叉搜索树 ,后序遍历是否正确.
     * 思路一:
     * 将postOrder排序, 获取中序遍历的数组,  然后根据中序, 后序生成二叉树, 若成功生成二叉树, 则返回tree,不对则返回false
     * 缺点:存在重复劳作, 并且题目并没有给出 treenode 数据结构.所以,不可取
     * 思路二:
     * 后序遍历顺序: 左右根,
     * 二叉搜索树 性质:
     * left<root<right ,所以[left,right,root] 保证了 存在连续子数组
     * 所以就有了, 将当前数组分为左半部分 [left,mid] 这其中的数值小于 root节点,即(postorder[length-1]),右半部分:值大于root节点
     * 然后在判断[left,mid] [mid,right] 这两个子数组 是否满足定义
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        return solve(0, postorder.length - 1, postorder);
    }

    private boolean solve(int left, int right, int[] postorder) {
        if (left >= right) {// 表示当前子树中,节点个数小于或者等于1 , 即节点为叶子结点或者为空
            return true;
        }
        int val = postorder[right];
        int i = left;
        while (postorder[i] < val) i++; // 左子树
        int mid = i;
        while (postorder[i] > val) i++; // 右子树
        return  i==right // 表示从[left,right] 的数组满足 二叉搜索树的性质
                && solve(left,mid-1,postorder)// 左子树
                && solve(mid,right-1,postorder);
    }


    public static void main(String[] args) {
        Sol_33 sol = new Sol_33();
        boolean b = sol.verifyPostorder(new int[]{
//                1,6,3,2,5
                1,2,5,10,6,9,4,3
//                1, 3, 2, 6, 5
        });
        System.out.println(b);
        System.out.println("=======");
    }
}

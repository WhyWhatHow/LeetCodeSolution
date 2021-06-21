package jianzhiOffer;

import java.util.LinkedList;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-22 08:10
 **/
public class Sol_37 {
    public static void main(String[] args) {
        Sol_37 sol = new Sol_37();
        Codec codec = new Codec();
        TreeNode deserialize = codec.deserialize("[1,2,3,null,null,4,5]");

        System.out.println("=======");
    }
}

/**
 * 二叉树序列化
 */
class Codec {
    /**
     * 层次遍历
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (root == null) {
            builder.append("]");
            return builder.toString();
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        builder.append(root.val);
        while (!list.isEmpty()) {
            TreeNode pop = list.pop();
            if (pop.left == null) {
                builder.append(",null");
            } else {
                list.addLast(pop.left);
                builder.append("," + pop.left.val);
            }
            if (pop.right == null) {
                builder.append(",null");
            } else {
                list.addLast(pop.right);
                builder.append("," + pop.right.val);
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /**
     * 将 字符串转换为 二叉树
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] split = data.substring(1, data.length() - 1).split(",");

        String NULL = "null";
        if (split.length == 0) {
            return null;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        list.add(root);
        int i = 1;
        while (!list.isEmpty()) {
            TreeNode pop = list.pop();
            // 左子树
            if (NULL.equals(split[i])) { //子树为空
            } else {
                pop.left = new TreeNode(Integer.parseInt(split[i]));
                list.addLast(pop.left);
            }
            i++;
            if (i == split.length) break;
            // 右子树
            if (NULL.equals(split[i])) {// 子树为空
            } else {
                pop.right = new TreeNode(Integer.parseInt(split[i]));
                list.addLast(pop.right);
            }
            i++;
            if (i == split.length) break;
        }
        return root;
    }
}
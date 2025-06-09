package leetcode.algorithm.tree;

/**
 * @program: LeetCodeSolution
 * @description: #
 * @author: WhyWhatHow
 **/

public class Solution_208 {

    public static void main(String[] args) {
        Solution_208 sol = new Solution_208();
        Trie tree = new Trie();
//        tree.insert("apple");
        System.out.println(tree.search("apple"));
        System.out.println(tree.startsWith("app"));
        System.out.println(tree.search("app"));
        tree.insert("app");
        System.out.println(tree.search("app"));
        System.out.println("==================");
    }


}


class Trie {

    class Node {
        boolean end;
        Node[] son = new Node[26];
        
        // 只保留必要的构造方法
        public Node() {
        }
    }

    char ac = 'a';
    Node root = new Node();

    public Trie() {
    }

    public void insert(String word) {
        char[] cs = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < cs.length; i++) {
            int index = cs[i] - ac;
            if (cur.son[index] == null) {
                cur.son[index] = new Node();
            }
            cur = cur.son[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        char[] cs = word.toCharArray();
        Node cur = root;
        for (char c : cs) {
            int index = c - ac;
            if (cur.son[index] == null) {
                return false;
            }
            cur = cur.son[index];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        char[] cs = prefix.toCharArray();
        Node cur = root;
        for (char c : cs) {
            int index = c - ac;
            if (cur.son[index] == null) {
                return false;
            }
            cur = cur.son[index];
        }
        return true;
    }
}
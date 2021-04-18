package dataSturcture;

/**
 * @program: LeetCodeSolution
 * @description: 红黑树 的实现
 * @author: WhyWhatHow
 * @create: 2021-03-31 16:43
 **/

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.atomic.AtomicLong;

/**
 * RBTree的定义如下:
 * 任何一个节点都有颜色，黑色或者红色。
 * 根节点是黑色的。
 * 父子节点之间不能出现两个连续的红节点。
 * 任何一个节点向下遍历到其子孙的叶子节点，所经过的黑节点个数必须相等。
 * 空节点被认为是黑色的。
 *
 * @param <T>
 */
class RBTreeNode <T extends Comparable<T>> {
    public T value;
    public RBTreeNode<T> parent;
    public RBTreeNode<T> left;
    public RBTreeNode<T> right;
    boolean red; // true  标记 为 红色节点,  false 为黑色节点

    public RBTreeNode(T value, boolean isRed) {
        this.value = value;
        this.red = isRed;
    }

    public RBTreeNode(T value) {
        this.value = value;
    }

    public RBTreeNode() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public RBTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(RBTreeNode<T> parent) {
        this.parent = parent;
    }

    public RBTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(RBTreeNode<T> left) {
        this.left = left;
    }

    public RBTreeNode<T> getRight() {
        return right;
    }

    public void setRight(RBTreeNode<T> right) {
        this.right = right;
    }

    public void setRed(boolean red) {
        red = red;
    }

    /// constructor and setter and getter  above
    ///   判断 节点颜色
    public boolean isBlack() {
        return !red;
    }

    public boolean isRed() {
        return red;
    }

    ///
    public boolean isLeaf() {
        return left == null && right == null;
    }

    void makeRed() {
        red = true;
    }

    void makeBlack() {
        red = false;
    }

    @Override
    public String toString() {
        return "RBTreeNode{" +
                "value=" + value +
                '}';
    }
}


public class RBTree<T extends Comparable<T>> {

    private final RBTreeNode<T> root;
    AtomicLong size = new AtomicLong(0);
    // 在 overwrite 模式下, 所有 节点 值不同
    // 在 non-overwrite 模式下, 可以有相通值
    /// in overwrite mode,all node's value can not  has same	value
    /// in non-overwrite mode,node can have same value, suggest don't use non-overwrite mode.
    private volatile boolean overrideMode = true; //

    ////  constructor
    public RBTree(RBTreeNode<T> root) {
        this.root = root;
    }

    public RBTree(boolean overrideMode) {
        this();
        this.overrideMode = overrideMode;
    }

    public RBTree() {
        this.root = new RBTreeNode<>();
    }

    ////// setter and getter
    public boolean isOverrideMode() {
        return overrideMode;
    }

    public void setOverrideMode(boolean overrideMode) {
        this.overrideMode = overrideMode;
    }

    public long size() {
        return size.get();
    }

    /**
     * 返回根节点
     *
     * @return
     */
    private RBTreeNode getRoot() {
        return root.getLeft();
    }
    ////////////////////////////////// 核心 方法 //////////////////////////

    /**
     * 添加节点
     */
    public T addNode(T value) {
        RBTreeNode node = new RBTreeNode(value);
        return addNode(node);
    }

    private T addNode(RBTreeNode node) {
        return null;
    }

    /**
     * 查找
     *
     * @param value
     * @return
     */
    public T  find(T value) {
        RBTreeNode root = getRoot();
        while (root != null) {
            int cmp = root.getValue().compareTo(value);
            if (cmp < 0) {
                root = root.getRight();
            } else if (cmp > 0) {
                root =root.getLeft();
            }else{
                return (T) root.getValue();
            }
        }
        return null;
    }



}

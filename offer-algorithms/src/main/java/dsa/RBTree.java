package dsa;

/**
 * @program: LeetCodeSolution
 * @description: ����� ��ʵ��
 * @author: WhyWhatHow
 * @create: 2021-03-31 16:43
 **/

import java.util.concurrent.atomic.AtomicLong;

/**
 * RBTree�Ķ�������:
 * �κ�һ���ڵ㶼����ɫ����ɫ���ߺ�ɫ��
 * ���ڵ��Ǻ�ɫ�ġ�
 * ���ӽڵ�֮�䲻�ܳ������������ĺ�ڵ㡣
 * �κ�һ���ڵ����±������������Ҷ�ӽڵ㣬�������ĺڽڵ����������ȡ�
 * �սڵ㱻��Ϊ�Ǻ�ɫ�ġ�
 *
 * @param <T>
 */
class RBTreeNode <T extends Comparable<T>> {
    public T value;
    public RBTreeNode<T> parent;
    public RBTreeNode<T> left;
    public RBTreeNode<T> right;
    boolean red; // true  ��� Ϊ ��ɫ�ڵ�,  false Ϊ��ɫ�ڵ�

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
    ///   �ж� �ڵ���ɫ
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
    // �� overwrite ģʽ��, ���� �ڵ� ֵ��ͬ
    // �� non-overwrite ģʽ��, ��������ֵͨ
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
     * ���ظ��ڵ�
     *
     * @return
     */
    private RBTreeNode getRoot() {
        return root.getLeft();
    }
    ////////////////////////////////// ���� ���� //////////////////////////

    /**
     * ��ӽڵ�
     */
    public T addNode(T value) {
        RBTreeNode node = new RBTreeNode(value);
        return addNode(node);
    }

    private T addNode(RBTreeNode node) {
        return null;
    }

    /**
     * ����
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

package binarytree;

import java.util.Objects;

/**
 * 〈一句话功能简述〉:
 * 〈二叉树结点〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  10:33
 */
public class TreeNode {

    private Integer value;//节点元素
    private TreeNode left;//左儿子
    private TreeNode right;//右儿子

    public TreeNode() {
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return Objects.equals(value, treeNode.value) &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, left, right);
    }
}

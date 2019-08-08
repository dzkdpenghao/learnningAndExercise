package binarytree;

/**
 * 〈一句话功能简述〉:
 * 〈对二叉查找树的增删查找〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  10:37
 */
public class BinarySearchTree {

    public static boolean contains(Integer target, TreeNode root) {
        if (root == null) {
            return false;
        }

        int result = target.compareTo(root.getValue());
        if (result < 0) {
            return contains(target, root.getLeft());
        } else if (result > 0) {
            return contains(target, root.getRight());
        }
        return true;
    }

    public static TreeNode findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.getLeft() != null) {
            return findMin(root.getLeft());
        } else {
            return root;
        }
    }

    public static TreeNode findMax(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.getRight() != null) {
            root = root.getRight();
        }
        return root;
    }

    public static TreeNode insert(Integer x, TreeNode root) {
        if (root == null) {
            return new TreeNode(x, null, null);
        }

        int result = x.compareTo(root.getValue());
        if (result < 0) {
            root.setLeft(insert(x, root.getLeft()));
        } else if (result > 0) {
            root.setRight(insert(x, root.getRight()));
        } else {
            System.out.println("请勿插入重复元素！");
        }

        return root;
    }

    public static TreeNode remove(Integer x, TreeNode root) {
        if (!BinarySearchTree.contains(x, root)) {
            System.out.println("要删除的元素不存在！");
            return root;
        }

        int result = x.compareTo(root.getValue());
        if (result < 0) {
            root.setLeft(remove(x, root.getLeft()));
        } else if (result > 0) {
            root.setRight(remove(x, root.getRight()));
        } else if (root.getLeft() != null && root.getRight() != null) {//有两个儿子
            root.setValue(findMin(root.getRight()).getValue());//将右儿子中的最小值赋值给root
            root.setRight(remove(root.getValue(),root.getRight()));//从右儿子中删除其最小值
        } else {
            root=(root.getLeft()!=null)?root.getLeft():root.getRight();
        }

        return root;
    }

}

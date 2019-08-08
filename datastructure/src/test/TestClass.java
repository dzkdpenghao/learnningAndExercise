package test;

import binarytree.BinarySearchTree;
import binarytree.TreeNode;
import heap.Heap;
import sort.*;

/**
 * 〈一句话功能简述〉:
 * 〈测试〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  10:44
 */
public class TestClass {

    public static void main(String[] args) {
        //TreeNode root=init();
        //testContains(root);
        //testFindMin(root);
        //testFindMax(root);
        //testInsert(root);
        //testRemove(root);

        //testHeap();

        //testBubbleSort();

        //testSelectSort();

        //testInsertSort();

        //testBucketSort();

        int[] arr = {5, 9, 6, 3, 7, 7, 7, 1, 8, 16, 0};
        QiuckSort.sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

    private static void testBucketSort() {
        int[] arr = {5, 9, 6, 3, 7, 1, 8, 16, 0};
        BucketSort.sort(arr, 16);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void testInsertSort() {
        int[] arr = {5, 9, 6, 3, 7, 1, 8, 16, 0};
        InsertSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void testSelectSort() {
        int[] arr = {5, 9, 6, 3, 7, 1, 8, 16};
        SelectSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void testBubbleSort() {
        int[] arr = {5, 9, 6, 3, 7, 1, 8, 16};
        BubbleSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    private static void testHeap() {
        Heap heap = new Heap();
        heap.insert(4);
        heap.insert(5);
        heap.insert(2);
        heap.insert(1);
        heap.insert(3);
        heap.insert(6);
        System.out.println(heap);

        heap.deleMin();
        System.out.println(heap);
        heap.deleMin();
        System.out.println(heap);
        heap.deleMin();
        System.out.println(heap);
        heap.deleMin();
        System.out.println(heap);
        heap.deleMin();
        System.out.println(heap);
        heap.deleMin();
        System.out.println(heap);
    }

    private static void testRemove(TreeNode root) {
        System.out.println(BinarySearchTree.remove(7, root));
    }

    private static void testInsert(TreeNode root) {
        System.out.println(BinarySearchTree.insert(9, root));
    }

    private static void testFindMax(TreeNode root) {
        System.out.println(BinarySearchTree.findMax(root));
    }

    private static void testFindMin(TreeNode root) {
        System.out.println(BinarySearchTree.findMin(root));
    }

    private static void testContains(TreeNode root) {
        System.out.println(BinarySearchTree.contains(6, root));
    }

    private static TreeNode init() {
        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(6, null, null);
        TreeNode node4 = new TreeNode(1, null, null);
        TreeNode node5 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(5, null, null);

        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        return node1;
    }
}

package com.zzb.dataStructure.threadBinaryTree;

import com.zzb.dataStructure.TreeNode;

/**
 * @Author by 张志斌 .
 * @Date 11:08 2019/3/25
 */
public class TestThreadBinaryTree {
    public static void main(String[] args) {
        ThreadBinaryTree threadBinaryTree = new ThreadBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(3);
        root.setLeftNode(leftNode);
        root.setRightNode(rightNode);
        TreeNode leftNode2 = new TreeNode(4);
        TreeNode rightNode2 = new TreeNode(5);
        leftNode.setLeftNode(leftNode2);
        leftNode.setRightNode(rightNode2);

        TreeNode leftNode3= new TreeNode(6);
        rightNode.setLeftNode(leftNode3);
        threadBinaryTree.setRoot(root);
        threadBinaryTree.createThreadBinaryTree();
        System.out.println(leftNode3.getLeftNode().getValue());
    }
}

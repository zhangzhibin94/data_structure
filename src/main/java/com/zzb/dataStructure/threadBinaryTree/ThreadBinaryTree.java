package com.zzb.dataStructure.threadBinaryTree;

import com.zzb.dataStructure.TreeNode;

/**
 * @Author by 张志斌 .
 * @Date 10:14 2019/3/25
 * 线索二叉树
 */
public class ThreadBinaryTree {
    /**
     * 根节点
     */
    private TreeNode root;

    /**
     * 左节点
     */
    private TreeNode leftNode;

    /**
     * 右节点
     */
    private TreeNode rightNode;

    /**
     * 临时的上一个节点
     */
    private TreeNode preNode;

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    public void createThreadBinaryTree(){
        createThreadBinaryTree(root);
    }



    /**
     * 中序构造线索二叉树
     */
    public void createThreadBinaryTree(TreeNode node){
        if(node == null){
            return;
        }
        //递归调用，遍历左子树，一直找到左叶子节点后出栈
        createThreadBinaryTree(node.getLeftNode());
        if(node.getLeftNode() == null){
            node.setLeftType(true);
            node.setLeftNode(preNode);
        }
        if(preNode != null && preNode.getRightNode() == null){
            preNode.setRightType(true);
            preNode.setRightNode(node);
        }
        preNode = node;
        //遍历右子树
        createThreadBinaryTree(node.getRightNode());
    }
}

package com.zzb.dataStructure;

/**
 * @Author by 张志斌 .
 * @Date 10:10 2019/3/25
 */
public class TreeNode {
    /**
     * 权重
     */
    private Integer value;
    /**
     * 左子节点
     */
    private TreeNode leftNode;
    /**
     * 右子节点
     */
    private TreeNode rightNode;
    /**
     * 是否是前驱节点
     */
    private Boolean leftType;

    /**
     * 是否是后继节点
     */
    private Boolean rightType;

    public TreeNode(int value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

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

    public Boolean getLeftType() {
        return leftType;
    }

    public void setLeftType(Boolean leftType) {
        this.leftType = leftType;
    }

    public Boolean getRightType() {
        return rightType;
    }

    public void setRightType(Boolean rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}

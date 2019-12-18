package com.zzb.dataStructure.binarySortTree;

import com.zzb.dataStructure.TreeNode;


/**
 * @Author by 张志斌 .
 * @Date 11:09 2019/3/26
 * @Description 二叉排序树
 */
public class BinarySortTree {
    /**
     * 根节点
     */
    private TreeNode root;

    /**
     * 向二叉排序树中添加节点
     * @param node
     */
    public void add(TreeNode node){
        if(root == null){
            root = node;
        }else{
            addNode(root,node);
        }
    }

    /**
     * 向节点node1添加节点node2
     * @param node1
     * @param node2
     */
    private void addNode(TreeNode node1,TreeNode node2){
        if(node2 == null){
            return;
        }
        if(node2.getValue() < node1.getValue() ){
            if(node1.getLeftNode() == null){
                node1.setLeftNode(node2);
            }else{
                //将当前指针指向下一个节点
                node1 = node1.getLeftNode();
                addNode(node1, node2);
            }
        }else{
            if(node1.getRightNode() == null){
                node1.setRightNode(node2);
            }else{
                //将指针指向下一个节点
                node1 = node1.getRightNode();
                addNode(node1, node2);
            }
        }
        //将二叉排序树重构成平衡二叉树
        //如果左子树的高度比右子树的高度超过1，那么这棵树就不平衡了，需要进行右旋转
        if(getLeftHeight(root) - getRightHeight(root) > 1){
            //如果当前节点的左节点右子树的高度比左子树大1以上，需要对当前节点的左子树先进行左旋转，在进行右旋转
            if(getRightHeight(root.getLeftNode()) - getLeftHeight(root.getLeftNode()) > 1){
                leftRotate(root.getLeftNode());
            }
            //右旋转
            rightRotate(root);
        }
        //如果右子树的高度比左子树的高度超过1，那么需要左旋转
        if(getRightHeight(root) - getLeftHeight(root) > 1){
            //如果当前节点的右节点的左子树的高度比右子树的高度大1以上，需要对当前节点的右节点先进行右旋转，再进行左旋转
            if(getLeftHeight(root.getRightNode()) - getRightHeight(root.getRightNode()) > 1){
                rightRotate(root.getRightNode());
            }
            leftRotate(root);
        }

    }

    /**
     * 左旋转
     * @param node 需要旋转的根节点
     */
    private void leftRotate(TreeNode node) {
        //1.新建一个节点，权为当前节点的权
        TreeNode newNode = new TreeNode(node.getValue());
        //2.新节点的左节点为当前节点的左节点
        newNode.setLeftNode(new TreeNode(node.getLeftNode().getValue()));
        //3.新节点的左节点为当前节点的右节点的左节点
        newNode.setRightNode(new TreeNode(node.getRightNode().getLeftNode().getValue()));
        //4.设置当前节点的权为当前节点的右节点的权
        node.setValue(node.getRightNode().getValue());
        //5.设置当前节点的右节点为当前节点的右节点的右节点
        node.setRightNode(node.getRightNode().getRightNode());
        //6.设置当前节点的左节点为新节点
        node.setLeftNode(newNode);
    }

    /**
     * 右旋转
     * @param node 需要旋转的根节点
     */
    private void rightRotate(TreeNode node) {
        //1.新建一个节点，权为当前节点的权
        TreeNode newNode = new TreeNode(node.getValue());
        //2.新建一个节点，权为当前节点的右节点，并将这个节点设置为新节点的右节点
        newNode.setRightNode(new TreeNode(node.getRightNode().getValue()));
        //3.新建一个节点，权为当前节点的左节点的右节点，并将这个节点设置为新节点的左节点
        newNode.setLeftNode(new TreeNode(node.getLeftNode().getRightNode().getValue()));
        //4.设置当前节点的权为当前节点左节点的权
        node.setValue(node.getLeftNode().getValue());
        //5.设置当前节点的左节点为当前节点的左节点的左节点
        node.setLeftNode(node.getLeftNode().getLeftNode());
        //6.设置当前节点的右节点为新节点
        node.setRightNode(newNode);
    }

    /**
     * 获得当前节点的左子树的高度
     * @param node
     * @return
     */
    public int getLeftHeight(TreeNode node){
        if(node.getLeftNode() == null){
            return 0;
        }
        return getHeight(node.getLeftNode());
    }
    /**
     * 获得当前节点的右子树的高度
     * @param node
     * @return
     */
    public int getRightHeight(TreeNode node){
        if(node.getRightNode() == null){
            return 0;
        }
        return getHeight(node.getRightNode());
    }

    public int getHeight(TreeNode node){
        return Math.max(node.getLeftNode()==null ? 0 : getHeight(node.getLeftNode()),
                node.getRightNode() == null ? 0 : getHeight(node.getRightNode())) + 1;
    }

    /**
     * 中序遍历
     * @param node
     */
    private void midFind(TreeNode node){
        if(node == null){
            return;
        }
        //先查询左节点
        if(node.getLeftNode() != null){
            midFind(node.getLeftNode());
        }
        System.out.println(node.getValue());
        //再查询右节点
        if(node.getRightNode() != null){
            midFind(node.getRightNode());
        }
    }
    public void midFind(){
        midFind(root);
    }

    /**
     * 根据权值获得节点
     * @param value
     * @return
     */
    public TreeNode get(int value){
        return get(root, value);
    }
    public TreeNode get(TreeNode node, int value){
        if(node != null){
            if(node.getValue().equals(value)){
                return node;
            }else if(value < node.getValue()){
                if(node.getLeftNode() == null){
                    return null;
                }else{
                    node = node.getLeftNode();
                    return get(node, value);
                }
            }else{
                if(node.getRightNode() == null){
                    return null;
                }else {
                    node = node.getRightNode();
                    return get(node, value);
                }
            }
        }
        return null;
    }

    /**
     * 根据权值找到该节点的父节点
     * @param value
     * @return
     */
    public TreeNode getParent(int value){
        return getParent(root, value);
    }
    public TreeNode getParent(TreeNode node,int value){
        if(node != null){
            if(node.getLeftNode() != null || node.getRightNode() != null){
                if((node.getLeftNode() != null && node.getLeftNode().getValue() == value)
                        ||(node.getRightNode() != null && node.getRightNode().getValue() == value)){
                    return node;
                }else if( value < node.getValue()){
                    node = node.getLeftNode();
                    return getParent(node, value);
                }else{
                    if(node.getRightNode() == null){
                        return null;
                    }
                    node = node.getRightNode();
                    return getParent(node, value);
                }
            }
        }
        return null;
    }

    /**
     * 根据权删除节点,
     * 1)如果节点是叶子节点，即没有孩子节点，那么直接删除即可
     * @param value
     */
    public void delete(int value){

        TreeNode thisNode = get(value);
        if(thisNode == null){
            return;
        }
        TreeNode parentNode = getParent(value);
        //1)如果节点是叶子节点，即没有孩子节点，那么直接删除即可
        if(thisNode.getLeftNode() == null && thisNode.getRightNode() == null){
            if(parentNode != null){
                if(parentNode.getLeftNode() != null && parentNode.getLeftNode().getValue() == value){
                    parentNode.setLeftNode(null);
                }
                if(parentNode.getRightNode() != null && parentNode.getRightNode().getValue() == value){
                    parentNode.setRightNode(null);
                }
            }
            //2)如果两个节点都不为空，删除的时候需要考虑会不会破坏原来的结构，需要遍历右子树，找到其中最小的值，
            //再将本身节点的值替换为该值，然后删除那个节点
        }else if(thisNode.getLeftNode() != null && thisNode.getRightNode() != null){
            int minValue = deleteMin(thisNode.getRightNode());
            thisNode.setValue(minValue);
        }else{//3)如果只存在一个节点,直接将它的父节点指向他的指针指向当前节点的子节点就行了
            //如果当前节点的左子节点不为空
            if(thisNode.getLeftNode()!=null){
                //如果父节点的左指针指向当前节点，直接将父节点的左指针设置为当前节点左子节点
                if(parentNode.getLeftNode() != null && parentNode.getLeftNode().getValue() == value){
                    parentNode.setLeftNode(thisNode.getLeftNode());
                } else if(parentNode.getRightNode() != null && parentNode.getRightNode().getValue() == value){
                    parentNode.setRightNode(thisNode.getLeftNode());
                }
            }
            if(thisNode.getRightNode() != null){
                if(parentNode.getLeftNode() != null && parentNode.getLeftNode().getValue() == value){
                    parentNode.setLeftNode(thisNode.getRightNode());
                } else if(parentNode.getRightNode() != null && parentNode.getRightNode().getValue() == value){
                    parentNode.setRightNode(thisNode.getRightNode());
                }
            }
        }
    }

    private int deleteMin(TreeNode rightNode) {
        //找最小值只需要一直找左子树就行了，一直找到没有左孩子节点的节点
        while (rightNode.getLeftNode() != null){
            rightNode = rightNode.getLeftNode();
        }
        int result = rightNode.getValue();
        //然后将该节点删除
        delete(rightNode.getValue());
        return result;
    }

    public static void main(String[] args) {
        BinarySortTree tree = new BinarySortTree();
        int[] arr = {8,6,9,5,7,4};
        for(int i : arr){
            tree.add(new TreeNode(i));
        }
        System.out.println("左子树高度："+tree.getLeftHeight(tree.root));
        System.out.println("右子树高度："+tree.getRightHeight(tree.root));
        System.out.println("根节点："+tree.root.getValue());
        tree.midFind();
    }
}

package com.zzb.utils.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    /**
     * 先序遍历
     * @param node
     */
    public void prePrint(Node node){
        if(node != null){
            System.out.println(node.value);
            prePrint(node.left);
            prePrint(node.right);
        }

    }

    public void midPrint(Node node){
        if (node == null){
            return;
        }
        midPrint(node.left);
        System.out.println(node.value);
        midPrint(node.right);
    }

    public void afterPrint(Node node){
        if(node == null){
            return;
        }
        afterPrint(node.left);
        afterPrint(node.right);
        System.out.println(node.value);
    }

    /**
     * 非递归实现先序遍历
     * @param node
     */
    public void prePrintUnRecur(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.value);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }

    }

    /**
     * 反序列化字符串为二叉树
     * @return
     */
    public Node reconPreString(String str){
        if(str == "" || str == null){
            return null;
        }
        String[] strings = str.split("_");
        Queue<String> queue = new LinkedList<>();
        //将分割后的字符串压入队列中
        for(String s : strings){
            queue.offer(s);
        }
        return recon(queue);

    }

    public Node recon(Queue<String> queue){
        String str = queue.poll();
        if("#".equals(str)){
            return null;
        }
        Node node = new Node(Integer.parseInt(str));
        node.left = recon(queue);
        node.right = recon(queue);
        return node;
    }

    /**
     * 非递归实现中序遍历
     * @param node
     */
    public void midPrintUnRecur(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }else{
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    /**
     * 非递归实现后序遍历
     * @param node
     */
    public void afterPrintUnRecur(Node node){
        if(node == null){
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(node);
        while (!s1.isEmpty()){
            node = s1.pop();
            s2.push(node);
            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value);
        }
    }





    /**
     * 非递归实现后序遍历
     * @param node
     */
    public void afterPrintWithoutRe(Node node){
        if(node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            s2.push(node);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        while (!s2.isEmpty()){
            System.out.println(s2.pop().value);
        }
    }

    public Boolean balanceBinaryTree(Node head){
        if(head == null){
            return true;
        }
        if(Math.abs(getDepth(head.left) - getDepth(head.right)) > 1){
            return false;
        }
        return balanceBinaryTree(head.left) && balanceBinaryTree(head.right);
    }
    public Integer getDepth(Node node){
        if(node == null){
            return 0;
        }
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

    /**
     * 查找当前节点中序遍历的后继节点，node节点有一个特殊的指针指向它的父节点
     * @param node
     * @return
     */
    public Node findNextNode(Node node){
        if(node == null){
            return null;
        }
        //思路:1.如果当前节点有右子树，则它的后继节点一定是它右子树的最左的叶子节点
        if(node.right != null){
            Node result = null;
            node = node.right;
            while(node != null){
                result = node;
                node = node.left;
            }
            return result;
        }else {
            //2.如果当前节点没有右子树，那么找到以当前节点作为左️节点的节点
            Node parent = node.parent;
            while (parent != null){
                if(parent.left == node){
                    return parent;
                }
                parent = parent.parent;
                node = node.parent;
            }
            return null;
        }
    }

    public String serialByPre(Node node){
        if(node == null){
            return "#_";
        }
        StringBuilder sb = new StringBuilder();
        sb.append( node.value + "_");
        sb.append( serialByPre(node.left));
        sb.append( serialByPre(node.right));
        return sb.toString();
    }

    public static void main(String[] args) {
        Math.pow(1d,2d);
        Node root = new Node(1);
        Node left = new Node(2);
        left.parent = root;
        Node right = new Node(3);
        right.parent =root;
        Node leftLeft = new Node(4);
        leftLeft.parent = left;
        Node leftRight = new Node(5);
        leftRight.parent = left;
        Node rightLeft = new Node(6);
        rightLeft.parent = right;
        Node rightRight = new Node(7);
        rightRight.parent = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;
        root.left = left;
        root.right = right;
        BinaryTree b = new BinaryTree();
//        Node node = b.reconPreString("1_2_4_#_#_5_#_#_3_6_#_#_7_#_#_");
//        b.afterPrintWithoutRe(node);
        System.out.println(b.balanceBinaryTree(root));
    }
}

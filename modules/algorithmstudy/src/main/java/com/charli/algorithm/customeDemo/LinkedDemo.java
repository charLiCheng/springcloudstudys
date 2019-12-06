package com.charli.algorithm.customeDemo;

import org.bouncycastle.crypto.OutputLengthException;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description : 链表
 * @Author xiaoli.cheng
 * @Date 2019/12/6 13:59
 */
public class LinkedDemo {
    private final static int intDepth = 1000;
    private final static String lengthMsg = "长度过长!!";


    private final static Map<Integer,Integer> hashKey = new HashMap();
    private static int depth = 0;
    public int f(int n){
        ++depth;
        if (depth > intDepth){ throw new OutputLengthException(lengthMsg);}

        if (n == 1) {return 1;}
        if (n == 2) {return 2;}

        if (hashKey.containsKey(n)){return hashKey.get(n);}
        int ret = f(n-1)+f(n-2);
        hashKey.put(n,ret);
        return ret;
    }
}

class TreeNode{
    public int val;
    public TreeNode next;

    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5,node6);
//        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4,node5);
        TreeNode node3 = new TreeNode(3,node4);
        TreeNode node2 = new TreeNode(2,node3);
        TreeNode node1 = new TreeNode(1,node2);


    }

    public boolean zhongHuan(TreeNode headNode){
        if (headNode == null){
            return false;
        }
        TreeNode q = headNode.next;
        TreeNode s = headNode;
        while(q != null){
            if (q.next == null){
                return false;
            }

            if (s == q){
                return true;
            }
            q = q.next.next;
            s = s.next;
        }

        return false;
    }

}

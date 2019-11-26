package com.charli.algorithm.controller;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学

//leetcode submit region begin(Prohibit modification and deletion)
/*
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new Solution().getListNodeEntity(1);
        ListNode l2 = new ListNode(7);

        ListNode l3 = new Solution().addTwoNumbers(l1, l2);
        System.out.println(l3);

    }

    //[3,9,9,9,9,9,9,9,9,9]
    //[7]
    public ListNode getListNodeEntity(int i) {
        ListNode parent = new ListNode(3);
        ListNode node1 = new ListNode(9);
        parent.next = node1;
        ListNode node2 = new ListNode(9);
        node1.next = node2;
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        ListNode node4 = new ListNode(9);
        node3.next = node4;
        ListNode node5 = new ListNode(9);
        node4.next = node5;
        ListNode node6 = new ListNode(9);
        node5.next = node6;
        ListNode node7 = new ListNode(9);
        node6.next = node7;
        ListNode node8 = new ListNode(9);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        return parent;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long li1 = getInteger(l1);
        Long li2 = getInteger(l2);
        ListNode sum = getListNode(li1+li2);
        return sum;
    }

    private Long getInteger(ListNode l1) {
        StringBuilder sb = new StringBuilder();
        sb = getStr(l1, sb);

        Long bi = Long.parseLong(sb.reverse().toString());
        return bi;
    }

    private StringBuilder getStr(ListNode l1, StringBuilder sb) {
        if (l1 == null || l1.next == null) {
            sb.append(l1.val);
            return sb;
        }
        StringBuilder str = getStr(l1.next, sb);
        sb.append(l1.val);
        return str;
    }

    private ListNode getListNode(Long sum) {
        char[] chars = new StringBuilder(sum.toString()).reverse().toString().toCharArray();

        int count = 0;
        ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(chars[count])));
        listNode = getNode(chars, count, chars.length - 1, listNode);
        return listNode;
    }

    private ListNode getNode(char[] chars, int count, int length, ListNode listNode) {
        if (count >= length) {
            return listNode;
        }
        count++;
        ListNode node1 = new ListNode(Integer.parseInt(String.valueOf(chars[count])));
        ListNode node = getNode(chars, count, length, node1);
        listNode.next = node;

        return listNode;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class demos{

    public static void main(String[] args) {
        ListNode l1 = new Solution().getListNodeEntity(1);
        ListNode l2 = new ListNode(7);

        ListNode l3 = new demos().addTwoNumbers(l1, l2);
        System.out.println(l3);

    }

    //[3,9,9,9,9,9,9,9,9,9]
    //[7]
    public ListNode getListNodeEntity(int i) {
        ListNode parent = new ListNode(3);
        ListNode node1 = new ListNode(9);
        parent.next = node1;
        ListNode node2 = new ListNode(9);
        node1.next = node2;
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        ListNode node4 = new ListNode(9);
        node3.next = node4;
        ListNode node5 = new ListNode(9);
        node4.next = node5;
        ListNode node6 = new ListNode(9);
        node5.next = node6;
        ListNode node7 = new ListNode(9);
        node6.next = node7;
        ListNode node8 = new ListNode(9);
        node7.next = node8;
        ListNode node9 = new ListNode(9);
        node8.next = node9;
        return parent;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        return root.next;
    }
}

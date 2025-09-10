package cn.xxywithpq.删除链表的倒数第N个结点;


import cn.xxywithpq.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (n > 0) {

            ListNode temp = stack.pop();
            if (--n == 0) {
                ListNode next = temp.next;
                if (stack.isEmpty()) {
                    return next;
                } else {
                    ListNode pre = stack.pop();
                    pre.next = next;
                }

                break;
            }
        }
        return head;
    }
}
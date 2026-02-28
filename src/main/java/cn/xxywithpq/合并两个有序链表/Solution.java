package cn.xxywithpq.合并两个有序链表;

import cn.xxywithpq.ListNode;

class Solution {
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // 1. 创建虚拟头节点
    ListNode head = new ListNode();  // dummy node
    ListNode cur = head;             // 当前指针
    
    ListNode first = list1;
    ListNode second = list2;

    // 2. 遍历两个链表直到都为空
    while (first != null || second != null) {
        // 情况1：第一个链表已空，直接接第二个链表
        if (first == null) {
            cur.next = second;        // 连接当前节点
            second = second.next;     // 移动second指针
        } 
        // 情况2：第二个链表已空，直接接第一个链表
        else if (second == null) {
            cur.next = first;         // 连接当前节点
            first = first.next;       // 移动first指针
        } 
        // 情况3：second的值更小
        else if (first.val > second.val) {
            cur.next = second;        // 连接second的当前节点
            second = second.next;     // 移动second指针
        } 
        // 情况4：first的值更小或相等
        else {
            cur.next = first;         // 连接first的当前节点
            first = first.next;       // 移动first指针
        }
        // 移动结果链表的当前指针
        cur = cur.next;
    }
    
    // 3. 返回合并后的链表（跳过虚拟头节点）
    return head.next;
}
}
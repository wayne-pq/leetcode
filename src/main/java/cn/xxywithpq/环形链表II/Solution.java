package cn.xxywithpq.环形链表II;

import cn.xxywithpq.ListNode;

import java.util.HashSet;

public class Solution {
	public ListNode detectCycle(ListNode head) {
		HashSet<ListNode> objects = new HashSet<>();
		while (head != null && !objects.contains(head)) {
			objects.add(head);
			head = head.next;
		}
		return head;
	}
}
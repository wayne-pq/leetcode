package cn.xxywithpq.环形链表;

import cn.xxywithpq.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode nextNext = head.next;
		ListNode next = head;

		while (next != nextNext) {
			if (nextNext == null || nextNext.next == null) {
				return false;
			}
			nextNext = nextNext.next.next;
			next = next.next;
		}
		return true;
	}


	public boolean hasCycle2(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head)) {
				return true;
			}
			set.add(head);
			head = head.next;
		}
		return false;
	}

}
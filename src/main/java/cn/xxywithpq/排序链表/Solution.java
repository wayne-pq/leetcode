package cn.xxywithpq.排序链表;

import cn.xxywithpq.ListNode;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode sortList(ListNode head) {
		return doSortList(head, null);
	}

	public ListNode doSortList(ListNode head, ListNode tail) {
		if (head.next == tail) {
			head.next = null;
			return head;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode mid = slow;

		ListNode left = doSortList(head, mid);
		ListNode right = doSortList(mid, tail);

		return doMerge(left, right);
	}

	public ListNode doMerge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		while (left != null && right != null) {
			if (left.val > right.val) {
				temp.next = right;
				right = right.next;
			} else {
				temp.next = left;
				left = left.next;
			}
			temp = temp.next;
		}
		while (left != null) {
			temp.next = left;
			temp = temp.next;
			left = left.next;
		}
		while (right != null) {
			temp.next = right;
			temp = temp.next;
			right = right.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		// 创建链表 [4,2,1,3]
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);


		// 排序链表
		Solution solution = new Solution();
		ListNode sortedHead = solution.sortList(head);
		System.out.println();
	}
}
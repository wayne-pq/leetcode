package cn.xxywithpq.K个一组翻转链表;

import cn.xxywithpq.ListNode;

class Solution {
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		while (head != null) {
			ListNode start = head;
			int n = k;
			boolean flag = true;
			while (n > 0) {
				head = head.next;
				if (head == null) {
					flag = false;
					break;
				}
				n--;
			}
			while (cur.next != null) {
				cur = cur.next;
			}
			if (flag) {
				cur.next = doReverse(start, k);
			} else {
				cur.next = start;
			}
		}
		return dummy.next;
	}

	public ListNode doReverse(ListNode head, int k) {
		if (k == 1) {
			return head;
		}
		ListNode cur = head;
		ListNode newHead = null;

		while (k > 0 && cur != null) {
			ListNode next = cur.next;
			cur.next = newHead;
			newHead = cur;
			cur = next;
			k--;
		}
		return newHead;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode listNode = solution.reverseKGroup(head, 5);
		System.out.println();
	}
}
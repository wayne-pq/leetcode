package cn.xxywithpq;

import lombok.Data;

/**
 * @author wayne
 */
@Data
public class ListNode {
	public int val;
	public ListNode next;

	ListNode() {
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public ListNode(int x) {
		val = x;
		next = null;
	}
}
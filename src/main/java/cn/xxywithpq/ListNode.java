package cn.xxywithpq;

import lombok.Data;

/**
 * @author wayne
 */
@Data
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}
}
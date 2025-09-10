package cn.xxywithpq.归并排序;

import cn.xxywithpq.环形链表.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public int[] mergeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}

		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);

		// 递归排序左半部分
		left = mergeSort(left);
		// 递归排序右半部分
		right = mergeSort(right);

		// 合并两个有序数组
		return merge(left, right);
	}

	private int[] merge(int[] left, int[] right) {
		int[] arrs = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;

		// 比较左右数组元素并合并
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				arrs[k++] = left[i++];
			} else {
				arrs[k++] = right[j++];
			}
		}

		// 处理剩余元素
		while (i < left.length) {
			arrs[k++] = left[i++];
		}
		while (j < right.length) {
			arrs[k++] = right[j++];
		}
		return arrs;
	}

	public static void main(String[] args) {
		int[] arr = {38, 27, 43, 3, 9, 82, 10};
		MergeSort solution = new MergeSort();
		int[] ints = solution.mergeSort(arr);
		System.out.println("归并排序结果: " + Arrays.toString(ints));
		// 输出: [3, 9, 10, 27, 38, 43, 82]
	}
}
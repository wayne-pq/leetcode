package cn.xxywithpq.归并排序;

import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int a[] = {2, 2, 1, 5, 10, 6, 10};
		Sort a1 = new Sort();
		a1.sort(a);
		System.out.println(Arrays.toString(a));
	}


	public void sort(int[] a) {
		if (a.length < 2) {
			return;
		}
		int left = 0;
		int right = a.length;
		int mid = left + (right - left) / 2;

		int[] leftArr = Arrays.copyOfRange(a, left, mid);
		int[] rightArr = Arrays.copyOfRange(a, mid, right);
		sort(leftArr);
		sort(rightArr);

		doSort(a, leftArr, rightArr);
	}

	public void doSort(int[] a, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				a[k++] = left[i++];
			} else {
				a[k++] = right[j++];
			}
		}

		while (i < left.length) {
			a[k++] = left[i++];
		}
		while (j < right.length) {
			a[k++] = right[j++];
		}
	}
}

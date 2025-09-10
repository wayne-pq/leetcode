package cn.xxywithpq.二分查找;

public class Test {
	public static void main(String[] args) {
		int a[] = {0, 2, 3, 4, 5, 6, 10};
		Test a1 = new Test();
		System.out.println(a1.doSearch(a, 0, a.length - 1, 6));
	}


	public int doSearch(int[] a, int start, int end, int key) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] > key) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}

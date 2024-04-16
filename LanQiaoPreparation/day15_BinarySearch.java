package one_month;

import java.util.Arrays;

public class day15_BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1 , 2, 4, 5, 7};
		System.out.println(bs(arr, 7));
	}
	public static int bs(int[] arr, int tar) {
		int i = 0;
		int j = arr.length-1;
		//Arrays.sort(arr);
		while(i <= j) {
			int m = (i+j) >>> 1;
			if(tar < arr[m]) j = m-1;
			else if(tar > arr[m]) i = m+1;
			else return m;
			
		}
		return -1;
	}
	/*
	 * public ListNode removeElements(ListNode head, int val) { ListNode sentinel =
	 * new ListNode(-1, head); ListNode p1 = sentinel; ListNode p2; while ((p2 =
	 * p1.next) != null) { if (p2.val == val) { p1.next = p2.next; } else { p1 =
	 * p1.next; } } return sentinel.next; }
	 */
}

package com.general.arithmetic.sort;
import java.util.Arrays;
/****
 * 
 * @author GeneralAndroid
 * 归并排序（Merging Sort）就是利用归并的思想实现的排序方法。它的原理是假设
 * 初始序列含有n个记录,则可以看成是n个有序的子序列,每个子序列的长度为１,然后
 * 两两归并，得到[n/2]（[x]表示不小于ｘ的最小整数）个长度为２或１的有序子序列；
 * 再两两归并，......，如此重复，直至得到一个长度为ｎ的有序序列为止,这种排序方法
 * 称为２路归并排序.
 * 归并排序：是创建在归并操作上的一种有效的排序算法，效率为O(nlogn),该算法是采用分治法
 * 的一个非常典型的应用，且各层分治递归可以同时进行。归并操作，也叫归并算法，指的是将两个已经
 * 排序的序列合并成一个序列的操作。归并排序算法依赖归并操作。
 *
 */
public class MergingSort {

	static int wait_sort[]=new int[]{50,10,90,30,70,40,80,60,20,11,22,33};
	static int maxSize=wait_sort.length;
//	static int wait_sort_help[]=new int[maxSize];
	public static void main(String[] args) {
		System.out.println(Arrays.toString(wait_sort));
		merge_sort(wait_sort);
		System.out.println(Arrays.toString(wait_sort));
	}
	static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
		if (start >= end)
			return;
		int len = end - start, mid = (len >> 1) + start;
		int start1 = start, end1 = mid;
		int start2 = mid + 1, end2 = end;
		merge_sort_recursive(arr, result, start1, end1);
		merge_sort_recursive(arr, result, start2, end2);
		int k = start;
		while (start1 <= end1 && start2 <= end2)
			result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
		while (start1 <= end1)
			result[k++] = arr[start1++];
		while (start2 <= end2)
			result[k++] = arr[start2++];
		for (k = start; k <= end; k++)
			arr[k] = result[k];
	}
	public static void merge_sort(int[] arr) {
		int len = arr.length;
		int[] result = new int[len];
		merge_sort_recursive(arr, result, 0, len - 1);
	}

	
}


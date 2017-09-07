package com.general.arithmetic.sort;

import java.util.Arrays;


/**
 * 
 * @author GeneralAndroid
 * 快速排序：快速排序的基本思想是——通过一趟排序将待排记录分割成独立的两部分，其中一部分记录的关键字均比
 * 另一部分记录的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序的目的。
 *
 */
public class QuickSort {
	static int wait_sort[]=new int[]{50,10,90,30,70,40,80,60,20};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(wait_sort));
		QSort(0, wait_sort.length-1);
		System.out.println(Arrays.toString(wait_sort));
	}
	static void QSort(int low,int high){
		int pivot;
		if(low<high){
			pivot=Partition(low,high);
			QSort(low, pivot-1);
			QSort(pivot+1, high);
		}
	}
	static int Partition(int low,int high){
		int pivotkey;
//		int m=low+(high-low)/2;
//		if(wait_sort[low]<wait_sort[high])
//			swap(low, high);
//		if(wait_sort[m]>wait_sort[high])
//			swap(high, m);
//		if(wait_sort[m]>wait_sort[low])
//			swap(m, low);
			
		pivotkey=wait_sort[high];
		while(low<high){
			while(low<high&&wait_sort[low]<=pivotkey)
				low++;
			swap(low, high);
			while(low<high&&wait_sort[high]>=pivotkey)
				high--;
			swap(low, high);
			
			
			
			
		}
		return low;
		
	}
	static void swap(int i,int j){
		int temp=wait_sort[i];
		wait_sort[i]=wait_sort[j];
		wait_sort[j]=temp;
	}

}

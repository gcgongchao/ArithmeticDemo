package com.general.arithmetic.sort;

import java.util.Arrays;

/***
 * 
 * @author GeneralAndroid
 *
 *堆排序
 *要介绍堆排序，就需要先了解一下堆这种结构。
 *堆是具有下列性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；或者每个结点
 *的值都小于或等于其左右孩子结点的值，称为小顶堆。
 *
 *堆排序就是利用堆（假设利用大顶堆）进行排序的方法。它的基本思想是，将待排序的序列构造成一个大顶堆。此时，整个序列
 *的最大值就是堆顶的根结点。将它移走（其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值），然后将剩余的
 *n-1个序列重新构造成一个堆，这样就会得到n个元素中的次小值。如此反复执行，便能得到一个有序序列了。
 * *
 */
public class HeapSort {
	private static int[] wait_sort=new int[]{50,10,90,30,70,40,80,60,20};
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(wait_sort));
		HeapSort();
		System.out.println(Arrays.toString(wait_sort));
	}
	static void HeapSort(){
		int i;
		int n=wait_sort.length-1;
		for(i=(n-1)/2;i>=0;i--){
			HeapAdjust(i, n);
		}
		for(i=n;i>=0;i--){
			swap(0,i);
			HeapAdjust(0, i-1);
		}
	}
	
	static void HeapAdjust(int s,int m){
		int temp,j;
		temp=wait_sort[s];
		for(j=s*2;j<=m;j*=2){
			if(j<m&&wait_sort[j]<wait_sort[j+1])
				++j;
			if(temp>=wait_sort[j])
				break;
			wait_sort[s]=wait_sort[j];
			s=j;
		}
		wait_sort[s]=temp;
	}
	static void swap(int i,int j){
		int temp=wait_sort[i];
		wait_sort[i]=wait_sort[j];
		wait_sort[j]=temp;
	}

}

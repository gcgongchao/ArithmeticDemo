package com.general.arithmetic.sort;

import java.util.Arrays;

/***
 * 
 * @author GeneralAndroid
 *
 *插入排序有两种：(1)直接插入排序(2)希尔排序
 *(1)直接插入排序的基本操作是将一个记录插入到已经排好序的有序表中，从而得到一个新的，记录数增１的有序表.
 *直接插入排序的时间复杂度：平均情况与最坏情况是O(n^2) ,最好的情况下为：O(n)，辅助空间O(1)
 *直接插入排序是一个稳定的排序.
 *(2)希尔排序：希尔排序算法是按其设计者希尔的名字命名，该算法由1959年公布，是插入排序的一种更高效的改进版本。
 *它的作法不是每次一个元素挨着一个元素的比较。而是初期选用（增量较大）间隔比较，使记录跳跃式接近它的排序位置；
 *然后增量缩小;最后增量为１,这样记录移动次数大大减少，提高了排序效率。希尔排序对增量序列的选择没有严格规定，
 *但是要注意最后一个增量的选择要为１．
 *
 *
 *
 */
public class InsertSort {

	private static int [] wait_sort=new int[]{0,9,8,7,6,5,4,3,2,1};
	public static void main(String[] args) {
//		directInsertSortByAsc();
//		directInsertByDesc();
//		System.out.print(3%4);
		shellInsertByAsc();
//		shellInsertByDesc();
	}
	/**哨兵升序**/
	private static void directInsertSortByAsc(){
		System.out.println(Arrays.toString(wait_sort));
		int i,j;
		for(i=2;i<wait_sort.length;i++){
			if(wait_sort[i]<wait_sort[i-1]){
				wait_sort[0]=wait_sort[i];
				for(j=i-1;wait_sort[j]>wait_sort[0];j--){
					wait_sort[j+1]=wait_sort[j];
				}
				wait_sort[j+1]=wait_sort[0];
			}
		}
		System.out.println(Arrays.toString(wait_sort));
	}
	/**哨兵降序**/
	private static void directInsertByDesc(){
		System.out.println(Arrays.toString(wait_sort));
		int i,j;
		for(i=2;i<wait_sort.length;i++){ 
			if(wait_sort[i]>wait_sort[i-1]){
				wait_sort[0]=wait_sort[i];
				for(j=i-1;wait_sort[j]<wait_sort[0];j--){
					wait_sort[j+1]=wait_sort[j];
				}
				wait_sort[j+1]=wait_sort[0];
			}
		}
		System.out.println(Arrays.toString(wait_sort));
	}
	
	/**这里使用的增量为{1,3,7}**/
	private static void shellInsertByAsc(){
		System.out.println(Arrays.toString(wait_sort));
		int i,j;
		int n=3;
		int gap=0;
		do{
			gap=(1<<n) -1;
			for(i=gap+1;i<wait_sort.length;i++){
				if(wait_sort[i]<wait_sort[i-gap]){
					wait_sort[0]=wait_sort[i];
					for(j=i-gap;j>0&&wait_sort[0]<wait_sort[j];j-=gap){
						wait_sort[j+gap]=wait_sort[j];
					}
					wait_sort[j+gap]=wait_sort[0];
				}
			}
			System.out.println(Arrays.toString(wait_sort)+"gap:"+gap);
			n--;
		}while(gap>1);
		System.out.println(Arrays.toString(wait_sort));
	}
	private static void shellInsertByDesc(){
		System.out.println(Arrays.toString(wait_sort));
		int i,j;
		int n=3;
		int gap=0;
		do{
			gap=(1<<n)-1;
			for(i=gap+1;i<wait_sort.length;i++){
				if(wait_sort[i]>wait_sort[i-gap]){
					wait_sort[0]=wait_sort[i];
					for(j=i-gap;j>0&&wait_sort[0]>wait_sort[j];j-=gap){
						wait_sort[j+gap]=wait_sort[j];
					}
					wait_sort[j+gap]=wait_sort[0];
				}
			}
			n--;
		}while(gap>1);
		System.out.println(Arrays.toString(wait_sort));
	}
}

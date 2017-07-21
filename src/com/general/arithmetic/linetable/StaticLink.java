package com.general.arithmetic.linetable;
/****
 * 
 * @author GeneralAndroid
 *	静态链表
 */
public class StaticLink implements Ilinetable{
	private int MAX_NUM=1000;
	private Student staticLink[];
	private int valid_num=0;
	private int lastElem=MAX_NUM-1;
	public static void main(String[] args) {
		
	}

	@Override
	public void InitList() {
		// TODO Auto-generated method stub
		if (staticLink == null) {
			staticLink = new Student[MAX_NUM];
			// 数组第一个元素的cur用来存放备用链表第一个结点的下标
			for (int i = 0; i < lastElem; i++) {
				staticLink[i] = new Student(i + 1);
			}
			staticLink[lastElem] = new Student(0);
		}
	}

	@Override
	public boolean ListEmpty() {
		// TODO Auto-generated method stub
		if(staticLink[lastElem].cur==0){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public void ClearList() {
		// TODO Auto-generated method stub
		if(staticLink!=null){
			for(Student student:staticLink){
				if(student!=null)
					student=null;
			}
		}
		
	}

	@Override
	public Student GetElem(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int LocateElem(Student student) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void ListInsert(int i, Student student) {
	int j,k,l;
	k=lastElem;
	if(i<1||i>ListLength()+1){
		return ;
	}
	if(staticLink[0].cur>0){
		j=staticLink[0].cur;
		staticLink[0].cur=staticLink[j].cur;
	}else{
		j=0;
	}

	if(j>0){
		staticLink[j]=student;
		for(l=1;l<=i-1;l++){
			k=staticLink[k].cur;
		}
		staticLink[j].cur=staticLink[k].cur;
		staticLink[k].cur=j;
		System.out.println("insert success");
	}
	System.out.println("insert failed");
		
	}
	private int Malloc_SLL(){
		int i=staticLink[0].cur;
		if(staticLink[0].cur!=0){
			staticLink[0].cur=staticLink[i].cur;
		}
		return i;
	}

	@Override
	public Student ListDelete(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ListLength() {
		// TODO Auto-generated method stub
		int length=0;
		Student student=staticLink[lastElem];
		while(student.cur!=0){
			length++;
			student=staticLink[student.cur];
			
		}
		return length;
	}

}

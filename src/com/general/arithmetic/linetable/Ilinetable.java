package com.general.arithmetic.linetable;

public interface Ilinetable {
	/** 初始化操作，建立一个空的线性表 **/
	public void InitList();
	/**若线性表为空，返回true，否则返回false**/
	public boolean ListEmpty();
	/**将线性表清空**/
	public void ClearList();
	/**返回链表中的第i个元素**/
	public Student GetElem(int i);
	/**返回student在单链表中的位置**/
	public int LocateElem(Student student);
	/**在第i个位置插入新元素 student**/
	public void ListInsert(int i,Student student);
	/**删除第i个位置上的元素**/
	public Student ListDelete(int i);
	/**返回单链表的元素个数**/
	public int ListLength();
}

package com.general.arithmetic.linetable;

/**
 * 单链表的实现,采用尾插法
 * 
 * @author GeneralAndroid
 * 
 */
public class SingleLink implements Ilinetable {
	private Student singleLink;

	public static void main(String[] args) {
		SingleLink singleLink = new SingleLink();
		singleLink.InitList();
		singleLink.ListInsert(1, new Student("first", "1"));
		singleLink.ListInsert(2, new Student("second", "2"));
		singleLink.ListInsert(3, new Student("thrid", "3"));
//		singleLink.ListInsert(4, new Student("four", "4"));
//		singleLink.ListInsert(5, new Student("five", "5"));
//		singleLink.ListInsert(6, new Student("six", "6"));
//		singleLink.ListInsert(7, new Student("seven", "7"));
		singleLink.ListInsert(2, new Student("eight", "8"));
		System.out.println("Single List is empty:" + singleLink.ListEmpty());
		System.out.println("第３个元素是：" + singleLink.GetElem(3).name);
		System.out.println("new Student(\"four\",\"4\"):"
				+ singleLink.LocateElem(new Student("four", "4")));
		System.out.println("Single List length:" + singleLink.ListLength());
		System.out.println("delete elem is :" + singleLink.ListDelete(8).name);
		;
		System.out.println("Single List length:" + singleLink.ListLength());
		singleLink.ClearList();
		System.out.println("Single List is empty after clear:"
				+ singleLink.ListEmpty());
		System.out.println("Single List length:" + singleLink.ListLength());
	}

	/** 初始化操作，建立一个空的线性表 **/
	@Override
	public void InitList() {
		singleLink = new Student();
		singleLink.name = "Head Data";
		singleLink.num = "0";
		singleLink.next = null;
	}

	/** 若线性表为空，返回true，否则返回false **/
	@Override
	public boolean ListEmpty() {
		if (singleLink == null) {
			return true;
		} else if (singleLink.next == null) {
			System.out.println("Head is exist ,but the link data empty");
			return true;
		} else {
			return false;
		}
	}

	/** 将线性表清空 **/
	@Override
	public void ClearList() {
		if (singleLink != null) {
			singleLink.next = null;
			singleLink = null;
		}
	}

	/** 返回链表中的第i个元素 **/
	@Override
	public Student GetElem(int i) {
		int location = 0;
		if (singleLink != null && singleLink.next != null) {
			Student temp = singleLink.next;
			while (temp != null) {
				location++;
				if (location == i) {
					return temp;
				} else {
					temp = temp.next;
				}
			}
		}
		return null;
	}

	/** 返回student在单链表中的位置 **/
	@Override
	public int LocateElem(Student student) {
		int location = 0;
		if (singleLink != null && singleLink.next != null) {
			Student temp = singleLink.next;
			while (temp != null) {
				location++;
				if (temp.name.equals(student.name)
						&& temp.num.equals(student.num)) {
					return location;
				} else {
					temp = temp.next;
				}
			}
		}
		return location;
	}

	/** 在第i个位置插入新元素 student **/
	@Override
	public void ListInsert(int i, Student student) {
		int location = 0;
		if (singleLink != null) {
			Student previous = singleLink.next;
			while (location != i) {
				
				if (previous != null && previous.next != null) {
					previous = previous.next;
				}
				location++;
			}
			if (previous != null) {
				Student next = previous.next;
				previous.next = student;
				student.next = next;
			} else {
				singleLink.next = student;
				student.next = null;
			}

		}

	}

	/** 删除第i个位置上的元素 **/
	@Override
	public Student ListDelete(int i) {
		i--;
		int location = 0;
		Student delete = null;
		if (singleLink != null && singleLink.next != null) {
			Student temp = singleLink;
			while (temp != null) {
				if (location == i) {
					break;
				} else {
					location++;
					temp = temp.next;
				}
			}
			delete = temp;
			temp.next = temp.next.next;
		}
		return delete;
	}

	/** 返回单链表的元素个数 **/
	@Override
	public int ListLength() {
		int location = 0;
		if (singleLink != null && singleLink.next != null) {
			Student temp = singleLink.next;
			while (temp != null) {
				location++;
				temp = temp.next;
			}
		}
		return location;
	}

}

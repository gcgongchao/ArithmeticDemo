package com.general.arithmetic.linetable;
/***
 * 
 * @author GeneralAndroid
 * 属性next为链表结构的指针
 * 属性cur专门为静态链表使用的
 *
 */
public class Student {
	String name;
	String num;
	/** single link**/
	Student next;
	/**static link**/
	int cur;
	public Student(){}
	public Student(String name, String num) {
		super();
		this.name = name;
		this.num = num;
	}
	public Student(int cur){
		this.cur=cur;
	}
	public Student(String name, String num,  int cur) {
		super();
		this.name = name;
		this.num = num;
		this.cur = cur;
	}
	
}

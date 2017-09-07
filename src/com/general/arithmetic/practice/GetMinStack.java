package com.general.arithmetic.practice;

import java.util.Stack;

/****
 * 题目：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 * 要求：1.pop,push,getMin操作的时间复杂度都是O(1)2.设计的栈类型可以使用现成的栈结构
 * 
 * @author GeneralAndroid
 *
 */
public class GetMinStack {

	public static void main(String[] args) {
		MyStack2 myStack2=new MyStack2();
		myStack2.push(3);
		myStack2.push(4);
		myStack2.push(5);
		myStack2.push(1);
		myStack2.push(2);
		myStack2.push(1);
		System.out.println(myStack2.getmin()+":"+myStack2.pop());
		System.out.println(myStack2.getmin()+":"+myStack2.pop());
		System.out.println(myStack2.getmin()+":"+myStack2.pop());
		System.out.println(myStack2.getmin()+":"+myStack2.pop());
	}
}
class MyStack1{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack1(){
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum<=this.getmin()){
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty");
		}
		int value=this.stackData.pop();
		if(value==this.getmin()){
			this.stackMin.pop();
		}
		return value;
	}
	public int getmin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty");
		}
		return this.stackMin.peek();
	}
}

class MyStack2{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack2(){
		this.stackData=new Stack<Integer>();
		this.stackMin=new Stack<Integer>();
	}
	public void push(int newNum){
		if(this.stackMin.isEmpty()){
			this.stackMin.push(newNum);
		}else if(newNum<getmin()){
			this.stackMin.push(newNum);
		}else{
			int min=getmin();
			this.stackMin.push(min);
		}
		this.stackData.push(newNum);
	}
	public int pop(){
		if(this.stackData.isEmpty()){
			throw new RuntimeException("Your stack is empty");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	public int getmin(){
		if(this.stackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty");
		}
		return this.stackMin.peek();
	}
}
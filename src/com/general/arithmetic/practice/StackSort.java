package com.general.arithmetic.practice;

import java.util.Stack;

/*
 * 题目:一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。
 * 除此之外，可以申请新的变量，但不能申请额外的数据结构。如何完成排序？
 * */
public class StackSort {

	public static void sortStackByStack(Stack<Integer> stack){
		Stack<Integer> help=new Stack<Integer>();
		while(!stack.isEmpty()){
			int cur=stack.pop();
			while(!help.isEmpty()&&help.peek()>cur){
				stack.push(help.pop());
			}
		}
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
}

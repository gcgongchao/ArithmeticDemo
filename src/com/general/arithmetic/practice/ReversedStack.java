package com.general.arithmetic.practice;

import java.util.Stack;

/***
 * 题目：一个栈依次压入1,2,3,4,5，那么从栈顶到栈底分别为5,4,3,2,1.将这个栈转置后，
 * 从栈顶到栈底为1,2,3,4,5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，
 * 不能用其他数据结构。
 * @author gongchao
 *
 *总结：栈的逆序，这种操作不易采用两个递归，容易造成栈溢出，而且执行效率慢很多。
 */
public class ReversedStack {
	
	private Stack<Integer> reverse=new Stack<>();
	/*以空间换时间,多了一个O(n)的空间复杂度的开销，但是运行效率显著提高，
	 * 比书中采用两个递归函数来逆序快很多*/
	public Integer reverse(Stack< Integer> stack){
		if(!stack.isEmpty()){
			reverse.push(stack.pop());
			return reverse(stack);
		}else{
			return null;
		}
		
	}
	public void print(){
		while(!reverse.isEmpty())
		System.out.println(reverse.pop());
	}
	public  int getAndRemoveLastElement(Stack<Integer> stack){
		int result=stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int last=getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	public void reversebook(Stack<Integer> stack){
		if(stack.isEmpty()){
			return ;
		}
		int i=getAndRemoveLastElement(stack);
		reversebook(stack);
		stack.push(i);
	}
	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<>();
		for(int i=0;i<5000;i++){
			stack.add(i);
		}
		Stack<Integer> stack1=new Stack<>();
		for(int i=0;i<5000;i++){
			stack1.add(i);
		}
		ReversedStack reversedStack=new ReversedStack();
		long startTime1=System.currentTimeMillis();
		reversedStack.reversebook(stack1);
		long entTime1=System.currentTimeMillis();
		System.out.println(entTime1-startTime1);//939
		long startTime=System.currentTimeMillis();
		reversedStack.reverse(stack);
		long entTime=System.currentTimeMillis();
		System.out.println(entTime-startTime);//1
		
		
//		reversedStack.print();
		
	}
}

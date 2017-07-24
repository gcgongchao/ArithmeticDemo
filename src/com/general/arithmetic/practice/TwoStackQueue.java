package com.general.arithmetic.practice;

import java.util.Stack;


/***
 * 题目：编写一个类，用两个类实现队列，支持队列的基本操作（add,poll,peek）
 * @author GeneralAndroid
 *
 */
public class TwoStackQueue {

	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	public static void main(String[] args) {
		TwoStackQueue queue=new TwoStackQueue();
		queue.add(3);
		queue.add(2);
		queue.poll();
		queue.add(1);
		queue.add(4);
		queue.poll();
		System.out.println(queue.peek());
	}
	
	public TwoStackQueue(){
		this.stackPush=new Stack<Integer>();
		this.stackPop=new Stack<Integer>();
		
	}
	public void add(int pushInt){
		stackPush.push(pushInt);	
	}
	public int poll(){
		if(stackPop.empty()&&stackPush.empty()){
			throw new RuntimeException("Queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		System.out.println("push:"+stackPush.toString());
		return stackPop.pop();
	}
	public int peek(){
		if(stackPop.empty()&&stackPush.empty()){
			throw new RuntimeException("Queue is empty");
		}else if(stackPop.empty()){
			while(!stackPush.empty()){
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}

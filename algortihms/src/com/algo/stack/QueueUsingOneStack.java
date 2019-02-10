package com.algo.stack;

import java.util.Stack;

public class QueueUsingOneStack {
	private static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args){
		eneque(1);
		eneque(2);
		stack.pop();
		eneque(3);
		eneque(4);
		while(!stack.isEmpty()){
			System.out.print(dequeue()+"\t");
		}
		
	}
	
	private static void eneque(int n){
		if(stack.isEmpty()){
			stack.push(n);
		}else{
			int temp=stack.pop();
			eneque(n);
			stack.push(temp);
		}
	}
	
	private static int dequeue(){
		return stack.pop();
	}

}

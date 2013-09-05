package stack.queue;

import java.util.ArrayList;
import java.util.Stack;

import stack.queue.ListAsStack.Node;

public class StackWithMin2 {
	public Stack<Node> nodeStack = new Stack<Node>();
	public Stack<Integer> intStack = new Stack<Integer>();
	
	public class Node{
		public int value;
		public Node next;
		
		public Node(int value){
			this.value = value;
		}
		public Node() {
		}
	}
	
	public void push(int value){
		nodeStack.push(new Node(value));
		if(intStack.isEmpty()){
			intStack.push(value);
		}else{
			if(value <= intStack.peek()){
				intStack.push(value);
			}
		}		
	}
	
	public int pop(){
		int peek = intStack.peek();
		int out =nodeStack.pop().value;
		if(out == peek){
			intStack.pop();
		}
		return out;
	}
	
	public int min(){
		if(!intStack.isEmpty()){
		return intStack.peek();
		}else{
			System.out.println("the stack is empty");
			return -1;
		}
	}
	public boolean isEmpty(){
		return nodeStack.isEmpty();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackWithMin2 swm2 = new StackWithMin2();
		int[] testgroup = {1,2,3,4,1,4,5,2,5,6,2,4,5,0};
		for(int i: testgroup){
			swm2.push(i);
			System.out.println("stack push : " + i + "the min is :" + swm2.min());
		}
		System.out.println("nodesize is : " + swm2.nodeStack.size());
		while(!swm2.isEmpty()){

			System.out.println("the min is :" + swm2.min());
			int pop = swm2.pop();
			System.out.println("the stack pop :" + pop);

		}
	}

}

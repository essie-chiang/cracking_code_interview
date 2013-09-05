package stack.queue;

import java.util.Stack;

public class StackWithMin {
	public Stack<NodeWithMin> stack = new Stack<NodeWithMin>();
	
	public class NodeWithMin{
		public int value;
		public int min;
		public NodeWithMin next;
		
		public NodeWithMin(int value, int min){
			this.value = value;
			this.min = min;
		}
		
	}
	
	public void push(int value){
		if(stack.isEmpty()){
			stack.push(new NodeWithMin(value, value));
		}else{
			if(stack.peek().min > value){
				stack.push(new NodeWithMin(value, value));
			}else{
				stack.push(new NodeWithMin(value, stack.peek().min));
			}
		}
	}
	
	public int pop(){
		return stack.pop().value;
	}
	
	public int min(){
		if(stack.isEmpty()){
			System.out.println("the stack is empty");
			return -1;
		}
		return stack.peek().min;
	}
	public boolean isEmpty(){
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		StackWithMin swm = new StackWithMin();
		int[] test = {1,2,3,4,1,4,5,2,5,6,2,4,5,0};
		for(int i:test){
			swm.push(i);
			System.out.println("the min of the stack is " + swm.min());
		}
		while(!swm.isEmpty()){
			System.out.println("the min is :" + swm.min());
			int pop = swm.pop();
			System.out.println("the stack pop :" + pop);

		}
		
	}

}

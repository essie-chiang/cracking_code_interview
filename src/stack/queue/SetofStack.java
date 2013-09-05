package stack.queue;

import java.util.ArrayList;

public class SetofStack {
	public ArrayList<MyStack> stackArr= new ArrayList<MyStack>();
	public int capacity;
	public SetofStack(int cap){
		this.capacity = cap;
	}
	
	public void print(){
		for(int i = 0; i < stackArr.size(); ++i){
			stackArr.get(i).print();
			System.out.println();
		}
	}
	
	public void setCapacity(int capacity){
		for(int i = 0; i <= stackArr.size() - 1; i++){
			MyStack stack = stackArr.get(i);
			stack.setCapacity(capacity);
		}
	}
	private MyStack getLastStack(ArrayList<MyStack> stackArr){
		if(stackArr.isEmpty()){
			stackArr.add(new MyStack(capacity));
		}
		MyStack last = stackArr.get(stackArr.size()-1);
		return last;
	}
	public void push(int value){
		//remember the case that may create a stack
		MyStack last = getLastStack(stackArr);
		if(last.isFull() || last == null){
			MyStack attach = new MyStack(capacity);
			System.out.println("create a new stack");
			attach.push(value);
			stackArr.add(attach);
		}else{
			last.push(value);
		}		
	}
	
	public int pop(){
		int pop;
		//may remove a stack
		MyStack last = getLastStack(stackArr);
		//will the order matters?????
		if(last.isEmpty()){
			last = stackArr.get(stackArr.size()-2);
			stackArr.remove(stackArr.size()-1);	
			System.out.println("remove a stack");
		}
		pop = last.pop();
		return pop;
	}
	public boolean isEmpty(){
		if(stackArr.isEmpty() || stackArr.get(0).isEmpty())
			return true;
		return false;
	}
	//
	public void pushindexat(int index){
		
	}
	public int popindexat(int index){
		if(index >= stackArr.size()){
			System.out.println("out of boundary error");
			return -1;
		}
		int popele = stackArr.get(index).pop(); 
		shiftStack(index);
		return popele;
	}
	// give the buttom of index2 to the top of index1
	public void shiftStack(int index){
		//need to handle !!!!!!!!!!!!!!!!!!!!!!!!!!!!
		if(index <= stackArr.size()-2){
			MyStack left = stackArr.get(index);
			MyStack right = stackArr.get(index + 1);
			int value = right.removeBottom();
			System.out.println("remove bottom " + value);
			left.push(value);
			shiftStack(index + 1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetofStack stackSet = new SetofStack(2);
		for(int i = 0; i < 10; i++){
			stackSet.push(i);
		}
		stackSet.popindexat(2);
		stackSet.print();
		stackSet.popindexat(1);
		stackSet.print();
		while(!stackSet.isEmpty()){
	//		System.out.println("the pop element is : " + stackSet.pop());
		}
	}

}

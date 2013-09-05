package stack.queue;

public class MyStack {
	public Node2 buttom, top;
	public int capacity = 0;
	int size = 0;
	
	public MyStack(int cap){
		this.capacity = cap;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void join(Node2 tmp){
		if(top != null){
			tmp.below = top; 
			top.above = tmp; 
			top = tmp;
		}else{
			top = tmp;
			buttom = tmp;
		}
	}
	
	public void push(int value){
		if(isFull()){
			System.out.println("this stack is full, the push value is " + value);
			return;
		}else{
			Node2 tmp = new Node2(value);
			join(tmp);
			size ++;
			System.out.println("the push element is : " + value);	
		}
		
	}
	
	public int pop(){
		if(top == null){
			System.out.println("this stack pop error");
		}
		int pop = top.value;
		top = top.below;
		size --;
		return pop;
	}
	
	public void print(){
		Node2 cur = buttom;
		while(cur != null){
			System.out.print(cur.value + " ");
			cur = cur.above;
		}
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	public boolean isFull(){
		return this.size >= this.capacity;
	}
	
	public int removeBottom(){
		int buttomele = this.buttom.value;
		buttom = buttom.above;
		size --;
		return buttomele;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack(5);
		for(int i = 0; i <= 10; i++){
			stack.push(i);
		}
		while(!stack.isEmpty()){
			System.out.println("pop element is : " + stack.pop());
		}
	}

}

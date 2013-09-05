package stack.queue;

public class ListAsStack {
	
	public int stackSize;

	public Node[] stackNum = new Node[3];
	public Node freelist = null;
	
	public ListAsStack(int stackSize){
		this.stackSize = stackSize;
		Node[] arrNode= new Node[stackSize];
		arrNode[0] = new Node();
		for(int i = 0; i < (stackSize - 1); i++ ){
			arrNode[i + 1] = new Node();
			arrNode[i].next = arrNode[i + 1];
		}
		freelist = arrNode[0];
		for(int j = 0; j < 3 ; j++){
			stackNum[j] = null;
		}
	}
	
	public void push(int stackid, int v){

		if(freelist == null){
			System.out.println("there is no room for element in freelist");	
			return;
		}
		Node tmp = freelist;
		tmp.value = v;
		freelist = freelist.next;
		tmp.next =stackNum[stackid];
		stackNum[stackid] = tmp;
		
	}
	
	public int pop(int stackid){
		if(stackNum[stackid] == null){
			System.out.println("stack " + stackid + "is empty");
		}
		Node tmp = stackNum[stackid];
		stackNum[stackid] = stackNum[stackid].next;
		tmp.next = freelist;
		freelist = tmp;
		
		return tmp.value;
		
	}
	
	
	public class Node{
		public int value;
		public Node next;
		
		public Node(int value){
			this.value = value;
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	
	public boolean isEmpty(int stackid){
		return stackNum[stackid] == null;
	}
	
	public int peek(int stackid){
		return stackNum[stackid].value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int stacksize = 10;
		int value;
		ListAsStack las = new ListAsStack(stacksize*3);
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < stacksize; j++){
				System.out.println("push " + i + " : " + (i * 100 + j) );
				las.push(i, (i * 100 + j));
				
			}
			while(!las.isEmpty(i)){
				value = las.peek(i);
				System.out.println("stackid " + i + " : " + value);
				las.pop(i);
			}
		}
	}

}

package others;

import java.util.LinkedList;
import java.util.Stack;

import sun.misc.Queue;

public class BinaryTree {

	
	public class TNode{
		public String value;
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public TNode getLchild() {
			return lchild;
		}

		public void setLchild(TNode lchild) {
			this.lchild = lchild;
		}

		public TNode getRchild() {
			return rchild;
		}

		public void setRchild(TNode rchild) {
			this.rchild = rchild;
		}

		public TNode lchild;
		public TNode rchild;
		
		public TNode(String val){
			this.value = val;
		}
		
		public TNode(String val, TNode left, TNode right){
			this.value = val;
			this.lchild = left;
			this.rchild = right;
		}
	}
	
    public TNode init() {  
        TNode a = new TNode("A");  
        TNode b = new TNode("B", null, a);  
        TNode c = new TNode("C");  
        TNode d = new TNode("D", b, c);  
        TNode e = new TNode("E");  
        TNode f = new TNode("F", e, null);  
        TNode g = new TNode("G", null, f);  
        TNode h = new TNode("H", d, g);  
        return h;// root  
    } 
    
    public void visit(TNode p){
    	System.out.println(p.getValue());
    }
    //递归实现前序遍历
    public void rpreOrder(TNode root){
    	if(root != null){
	    	visit(root);
	    	rpreOrder(root.getLchild());
	    	rpreOrder(root.getRchild());
    	}
    }
    
    //非递归实现前序遍历
    public void preOrder(TNode root){
    	Stack<TNode> nstack = new Stack<TNode>();
    	nstack.push(root);
    	while(!nstack.isEmpty()){
    		TNode cur = nstack.pop();
    		visit(cur);
    		if(cur.getRchild()!= null){
    			nstack.push(cur.getRchild());
    		}
    		if(cur.getLchild()!=null){
    			nstack.push(cur.getLchild());
    		}
    	}
    }
    
    //中序非递归
    public void inOrder(TNode root){
    	Stack<TNode> nstack = new Stack<TNode>();
    	TNode cur = root;
    	while(!nstack.isEmpty() || cur != null){
	    	while(cur!=null){
	    		nstack.push(cur);
	    		cur = cur.getLchild();	    		
	    	}
	    	cur = nstack.pop();
	    	visit(cur);
	    	cur = cur.getRchild();
    	}
    }
    
    //后序非递归 why are you so smart
    public void postOrder(TNode root){
    	Stack<TNode> nstack = new Stack<TNode>();
    	Stack<Boolean> rvisited = new Stack<Boolean>();
    	TNode cur = root;
    	while(!nstack.isEmpty() || cur != null){
    		while(cur != null){
    			nstack.push(cur);
    			rvisited.push(false);
    			cur = cur.lchild;
    		}
    		//after that cur remains null, 
    		TNode top = nstack.pop();
    		boolean rvisit = rvisited.pop();
    		if(top.rchild != null && rvisit == false){  // rchild tree has not be referencesd
    			//until find the new blank right tree
    			cur = top.rchild;
    			//and push the root back 
    			nstack.push(top);
    			//but visited by now
    			rvisited.push(true);
    		}else{
    			visit(top);
    		}
    	}
    	
    }
    //层次遍历
    public void layerOrder(TNode root){
    	LinkedList<TNode> queue = new LinkedList<TNode>();
    	TNode cur = root;
    	queue.addLast(cur);
    	while(!queue.isEmpty()){
    		cur = queue.removeFirst();
	    	if(cur != null){
	    		visit(cur);
	    	}
	    	if(cur.lchild != null){
	    		queue.addLast(cur.lchild);
	    	}
	    	if(cur.rchild != null){
	    		queue.addLast(cur.rchild);
	    	}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree bt = new BinaryTree();
		TNode root = bt.init();
//		bt.postOrder(root);
		bt.layerOrder(root);
	}

}

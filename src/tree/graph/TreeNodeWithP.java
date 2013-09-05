package tree.graph;

import java.util.ArrayList;
import java.util.LinkedList;

import others.BinaryTree.TNode;

public class TreeNodeWithP {
	private int value;
	public TreeNodeWithP left;
	public TreeNodeWithP right;
	public TreeNodeWithP parent;
	
	public TreeNodeWithP(){}
	
	public TreeNodeWithP(int value){
		this.value = value;
	}
	public TreeNodeWithP(int value, TreeNodeWithP left, TreeNodeWithP right , TreeNodeWithP parent){
		this.left = left;
		this.right = right;
		this.value = value;
		this.parent = parent;
	}
	
	public TreeNodeWithP test(){
		int treesize = 10;
		ArrayList<TreeNodeWithP> tree = new ArrayList<TreeNodeWithP>();
		tree.add(0, null);
		//init all the nodes
		for(int i = 1; i <= treesize*2; i++){
			if(i <= treesize){
				tree.add(i, new TreeNodeWithP(i));
			}
			//else{
			//	tree.add(i, null);
			//}
		//	System.out.println("input" + i + " to tree " );
		}
		System.out.println("size of arraylist" + tree.size() );
		for(int j = 1; j <= treesize; j++){
			tree.get(j).parent = tree.get(j / 2);
			if(treesize > (2 * j + 1)){
				tree.get(j).left = tree.get(2*j);
				tree.get(j).right = tree.get(2*j + 1);
				
			}else{
				tree.get(j).left = null;
				tree.get(j).right = null;
			}
		//	System.out.println("relate" + j + " to tree " );
		}
		return tree.get(1);

	}
	public void layerOrder(TreeNodeWithP root){
    	LinkedList<TreeNodeWithP> queue = new LinkedList<TreeNodeWithP>();
    	TreeNodeWithP cur = root;
    	queue.addLast(cur);
    	while(!queue.isEmpty()){
    		cur = queue.removeFirst();
	    	if(cur != null){
	    		System.out.println(cur.value);
	    	}
	    	if(cur.left != null){
	    		queue.addLast(cur.left);
	    	}
	    	if(cur.right != null){
	    		queue.addLast(cur.right);
	    	}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNodeWithP tnp = new TreeNodeWithP();
		tnp.layerOrder(tnp.test());
	}

}

package tree.graph;

public class FindNodePN {

	//to find the pre and next node of a tree in three orders
	
	public TreeNodeWithP preOrderPre(TreeNodeWithP root){
		TreeNodeWithP pre = null;
		//left node pre is parent
		if(root == root.parent.left){
			pre = root.parent;
		}
		if(root == root.parent.right){
			if(root.parent.left == null){
				pre = root.parent;
			}else{
				pre = mostRight(root.parent.left);
			}
			
		}
		return pre;
	}
	
	public TreeNodeWithP mostRight(TreeNodeWithP root){
		TreeNodeWithP cur = root;
		while(cur.right != null){
			cur = cur.right;
		}
		return cur;
	}
	public TreeNodeWithP mostLeft(TreeNodeWithP root){
		TreeNodeWithP cur = root;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur;
	}
	public static void main(String[] args) {
		

	}

}

package tree.graph;

import java.awt.SystemTray;

public class CreatMinTree {
	
	public static TreeNode minTree(int[] arr, int start, int end){
		if(start > end){	//that is the end of the recurision
			return null;
		}
		int mid = (start + end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.setLeft(minTree(arr, start, mid - 1));
		root.setRight(minTree(arr, mid + 1, end));
		return root;
	}
    public static void rpreOrder(TreeNode root){
    	if(root != null){
	    	System.out.println(root.getValue());
	    	rpreOrder(root.getLeft());
	    	rpreOrder(root.getRight());
    	}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {0,1,2,3,4,5,6,7,8,9,10,11};
		CreatMinTree.rpreOrder(CreatMinTree.minTree(test, 0, test.length-1));
	}

}

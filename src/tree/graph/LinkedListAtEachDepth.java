package tree.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListAtEachDepth {
	//what we return is an array of linkedlist 
	public static ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
	
	public static ArrayList<LinkedList<TreeNode>> treeToList(TreeNode root){
		TreeNode cur = root;
		LinkedList<TreeNode> nodeStore = new LinkedList<TreeNode>();
		LinkedList<Integer> deptStore = new LinkedList<Integer>();
		int depth = 1;
		nodeStore.addLast(cur);
		deptStore.addLast(depth);
		while(!nodeStore.isEmpty()){
			LinkedList<TreeNode> deplist = new LinkedList<TreeNode>();
			cur = nodeStore.removeFirst();
			depth = deptStore.removeFirst();
			list.add(deplist);
			list.get(depth-1).add(cur);
			if(cur.getLeft() != null){
				nodeStore.addLast(cur.getLeft());
				deptStore.addLast(depth + 1);
			}
			if(cur.getRight() != null){
				nodeStore.addLast(cur.getRight());
				deptStore.addLast(depth + 1);
			}
		}
		return list;
	}
	
	public static void printArr(ArrayList<LinkedList<TreeNode>> list){
		for(int i = 0; i < list.size(); i ++){
			Iterator it = list.get(i).iterator();
			while(it.hasNext()){
				System.out.println("Array : " + i + " : " + ((TreeNode)it.next()).getValue() );
			}
		}
	}
	
	public static void main(String[] args) {
		int[] test = {0,1,2,3,4,5,6,7,8,9,10,11};
		LinkedListAtEachDepth.printArr(LinkedListAtEachDepth.treeToList(CreatMinTree.minTree(test, 0, test.length-1)));

	}

}

package tree.graph;
//this class may contains some error, we need to check.
public class CheckBalanceTree {
	public int maxLen(TreeNode root){
		if(root == null){
			return 0;
		}
		int length = 1 + max(maxLen(root.getLeft()),maxLen(root.getRight()));
		return length;
	}
	public int minLen(TreeNode root){
		if(root == null){
			return 0;
		}
		int length;
		//this terrible crap is used for a node with a single child!!!
		if(root.getLeft() != null && root.getRight() != null){
			length = 1 + min(minLen(root.getLeft()),minLen(root.getRight()));
		}else if(root.getLeft() != null && root.getRight() == null){
			length = 1 + minLen(root.getLeft());
		}else if(root.getLeft() == null && root.getRight() != null){
			length = 1 + minLen(root.getRight());
		}else{
			length = 1;
		}
		return length;
	}
	public int max(int left, int right){
		return left > right ? left : right;
	}
	public int min(int left, int right){
		return left < right ? left : right;
	}
	
	public boolean isBalance(TreeNode root){
		return (maxLen(root)-minLen(root)) <= 1;
	}
	public static void main(String[] args) {
		int[] test = {0,1,2,3,4,5,6,7,8,9,10,11};
		TreeNode tn = CreatMinTree.minTree(test, 0, test.length-1);
		CheckBalanceTree cbt = new CheckBalanceTree();
		System.out.print(cbt.isBalance(tn));
	}

}

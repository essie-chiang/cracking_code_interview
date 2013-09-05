package tree.graph;

public class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;
	
	public TreeNode(int value){
		this.value = value;
	}
	public TreeNode(int value, TreeNode left, TreeNode right){
		this.left = left;
		this.right = right;
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

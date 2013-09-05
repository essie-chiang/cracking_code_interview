package recursion;

public class Point {
	public int x;
	public int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	} 
	public void showp(){
		System.out.println("(" + x + " " + y + ")");
	}
	public void showr(){
		System.out.println("remove (" + x + " " + y + ")");
	}
}

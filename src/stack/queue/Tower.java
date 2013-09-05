package stack.queue;

import java.util.Stack;

public class Tower extends Stack<Integer> {
//	public Stack<Integer> tower = new Stack<Integer>();
	public int towername;
	public int disks;
	public Tower(int name){
		towername = name;
	}
	
	public void MoveTop(Tower newtower){
		int disk = pop();
		newtower.push(disk);
		System.out.println("move top from " + towername + " to " + newtower.towername);
	}
	
	public void MoveDisk(int n, Tower to, Tower buffer){
		if(n > 0){
			System.out.println("move" + n +" disks from" + towername + " to " + to.towername + " via " + buffer.towername);
			MoveDisk(n-1, buffer, to);
			MoveTop(to);
			buffer.MoveDisk(n-1,to,this);
		}
	}
	
	public static void main(String[] args) {
		Tower[] hanoi = new Tower[3];
		int disks = 3;
		for(int i = 0; i < 3; i ++){
			hanoi[i] = new Tower(i);
		}
		for(int i = disks;i >= 0; i--){
			hanoi[0].push(i);
		}
		hanoi[0].MoveDisk(disks, hanoi[2], hanoi[1]);
	}

}

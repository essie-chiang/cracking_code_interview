package tree.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	ArrayList<LinkedList<Integer>> list = new ArrayList<LinkedList<Integer>>();
	
	public void addEdge(int u, int v){
		//increasing to max(u,v);
		while((list.size() - 1) < u){
			list.add(new LinkedList<Integer>());
		}
		while((list.size() - 1) < v){
			list.add(new LinkedList<Integer>());
		}
		list.get(u).add(v);
	}
	//get the nearby node
	public LinkedList<Integer> getAdj(int u){
		return list.get(u);
	}
	
	public int getNodeNum(){
		return list.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

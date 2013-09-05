package tree.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class FindRoute {
	private static LinkedList<Integer> queue = new LinkedList<Integer>();
	private static ArrayList<Boolean> visited = new ArrayList<Boolean>();

	public static boolean isLink(Graph graph, int u, int v){
		int head;
		queue.addLast(u);
		for(int i  = 0; i < graph.getNodeNum(); i++){
			visited.add(false);
		}
		while(queue.size() > 0){
			head = queue.removeFirst();
			visited.set(head, true);
			LinkedList<Integer> link = graph.getAdj(head);
			Iterator it = link.iterator();
			while(it.hasNext()){
				int next = (Integer)it.next();
				if(next == v){
					return true;
				}
				if(visited.get(next) == false){
					queue.add(next);
					System.out.println("next :" + next);
					visited.set(next, true);
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gra = new Graph();
		gra.addEdge(0, 1);
		gra.addEdge(0, 2);
		gra.addEdge(0, 3);
		gra.addEdge(2, 4);
		gra.addEdge(4, 5);
		gra.addEdge(3, 5);
		gra.addEdge(1, 4);
		System.out.println(FindRoute.isLink(gra, 0, 5));
		
	}

}
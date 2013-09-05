package recursion;

import java.util.ArrayList;
import java.util.Iterator;

public class SubSets {
	public ArrayList<String> allsubs = new ArrayList<String>();
	public ArrayList<String> getSubs(int index, String set){
	//	System.out.println( "set.length = " + set.length() + " index = " + index );
		if(set.length() == index){
	//		System.out.println( "set.length = " + set.length() + " index = " + index );
			ArrayList<String> fresh = new ArrayList<String>();
			fresh.add("");
			return fresh;
		}		
		String item = set.substring(index, index + 1);
		ArrayList<String> allsets = getSubs((index + 1), set);
		ArrayList<String> moresets = new ArrayList<String>();
//		if(allsets.size() == 0) moresets.add(item);
		for(int i = 0; i < allsets.size(); i ++){
			String sub = item + allsets.get(i);
//			System.out.println( "allsets.get(i) is " + allsets.get(i) );
			moresets.add(allsets.get(i));
			moresets.add(item + allsets.get(i));
		}
//		show(moresets);
		return moresets;
	}
	public void show(ArrayList<String> list){
		Iterator ait = list.iterator();
		while(ait.hasNext()){
			System.out.println( ait.next());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubSets sub = new SubSets();
		ArrayList<String> alist = sub.getSubs(0, "abc");
		sub.show(alist);
	}

}

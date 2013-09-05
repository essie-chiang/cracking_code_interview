package recursion;

import java.util.ArrayList;

public class Permutation {

	public ArrayList<String> getPerm(String sub){
		if(sub.length() == 0){
			ArrayList<String> begin = new ArrayList<String>();
			begin.add("");
			return begin;
		}
		String head = sub.substring(0, 1);
		testString("the head is" , head);
		ArrayList<String> subList = getPerm(sub.substring(1));
		ArrayList<String> allList = new ArrayList<String>();
		allList.addAll(subList);
		for(int j = 0; j < subList.size(); j ++){
			String subin = subList.get(j);
			for(int i = 0; i <= subin.length(); i ++){
				String add = insertAt(i,subin, head);
				allList.add(add);
			}
		}
		return allList;
	} 
	
	public void showList(ArrayList<String> array){
		for(int i = 0; i < array.size(); i ++){
			testString(String.valueOf(i),array.get(i));
		}
	}
	public void testString(String announce, String test){
		System.out.println(announce + " : " + test);
	}
	public String insertAt(int index, String org, String add){
		String insert;
		insert = org.substring(0, index) + add + org.substring(index);
//		if(index < (org.length() - 1)){
//			insert = org.substring(0, index) + add + org.substring(index);
//		}
//		else if( index == org.length() - 1){
//			
//		}else{
//			
//		}
//		testString("insert", insert);
		return insert;
	}
	public void examSubString(String org, int head, int end){
		System.out.println("String form head : " + head + " to end : " + end + " is : " + org.substring(head, end));
	}
	public static void main(String[] args) {
		Permutation per = new Permutation();
//		per.examSubString("a", 1, 1);
		per.showList(per.getPerm("abcd"));
	}

}

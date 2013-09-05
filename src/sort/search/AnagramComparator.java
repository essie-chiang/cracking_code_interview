package sort.search;

import java.util.Arrays;
import java.util.Comparator;

public class AnagramComparator implements Comparator<String> {
	//anagram is a word or phrase spelled by rearranging the letters of another word or phrase 
	public String sortChars(String s){
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return content.toString();
	}
	

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return sortChars(o1).compareTo(sortChars(o2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] array = {"test", "miuton", "fact"};
		Arrays.sort(array, new AnagramComparator());
		for(int i = 0; i < array.length; i ++){
			System.out.println(array[i] + " ");
		}
	}


}

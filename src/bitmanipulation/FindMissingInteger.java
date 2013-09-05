package bitmanipulation;

import org.apache.log4j.Logger;

public class FindMissingInteger {
	//from 0 to n, which one the array missing.
	public static int find(int[] missing){
		int store = 0;
		for(int i = 0; i <= missing.length; i ++){
			store ^= i;
		}
		for(int j = 0; j < missing.length; j ++){
			store ^= missing[j];
		}
		return store;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger log = Logger.getLogger(FindMissingInteger.class);
		int[] missing = {0,1,3,4,5,6,7,8,9};
		log.debug(FindMissingInteger.find(missing));
	}

}

package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;

public class BitsRequiredConvertInteger {

	public void test(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.sort(list);
	}
	public static int getBits(int a, int b){
		int bits = a ^ b;
		int count = 0;
		while(bits != 0){
			count ++;
			bits = bits & (bits - 1);
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("different bits between is " +
		BitsRequiredConvertInteger.getBits(1+16+32,4+8+64));
		
	}

}

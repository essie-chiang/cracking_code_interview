package bitmanipulation;

import java.util.ArrayList;

public class FindMissingIntegerByBits {

	public class BitInteger{
		public static final int  BIT_SIZE = 32;
		//fetch the ith bit of the 
		public int value;
		public BitInteger(int val){
			this.value = val;
		}
		public boolean fetch(int i){
			int mask = 1 << i;
			int v  = value & mask;
		//	System.out.println("fetch " + v);
			if(v == 0){
				return false;
			}else{
				return true;
			}
		}
	}
	
	public static int findMissing(ArrayList<BitInteger> arr ){
		return findMissing(arr, BitInteger.BIT_SIZE);
	}
	public static int findMissing(ArrayList<BitInteger> arr , int col){
		ArrayList<BitInteger> odd = new ArrayList<BitInteger>();
		ArrayList<BitInteger> even = new ArrayList<BitInteger>();
		if(col <= 0) return 0;
		int conone = 0, conzero = 0;
	//	System.out.println("fetch " + (BitInteger.BIT_SIZE - col) + "column");
		for(int i = 0; i < arr.size(); i++){
			if(arr.get(i).fetch(BitInteger.BIT_SIZE - col) == false){
				even.add(arr.get(i));
				conzero ++;
			}else{
				odd.add(arr.get(i));
				conone ++;
			}
		}
		if(conzero > conone){
			System.out.println("1");
			return findMissing(odd, col - 1) << 1 | 1;
		}else{
			System.out.println("0");
			return findMissing(even, col - 1) << 1 | 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<BitInteger> list = new ArrayList<BitInteger>();
		FindMissingIntegerByBits fmibb = new FindMissingIntegerByBits();
		for(int i = 0; i < 5; i ++){
			list.add(fmibb.new BitInteger(i));
		}
		list.add(fmibb.new BitInteger(6));
		System.out.println(FindMissingIntegerByBits.findMissing(list));
	}

}

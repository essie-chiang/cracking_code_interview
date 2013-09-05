package bitmanipulation;

public class SameOneBits {
	public static int current;
	public SameOneBits(int cur){
		current = cur;
	}
	public static boolean getBit(int index){
		return (((current >> index) & 1) == 1); 
	}
	public static boolean setBit(int index, boolean set){
		if(set == true){
			current = current | (1 << index);
			System.out.println("set " + index + " : 1");
		}else{
			int mask = ~(1 << index);
			current = current & mask;
			System.out.println("set " + index + " : 0");
		}
		if(current > 0){
			return true;
		}else{
			return false;
		}
	}
	public static int preInt(){
		//find the first 0
		int index = 0;
		int countone = 0;
		while(getBit(index)){
			index ++;
			countone ++;
		}
		System.out.println("first zero is " + index);
		while(!getBit(index)){
			index ++;
		}
		countone ++;
		System.out.println("next one is " + index);
		//turn off the next 1
		setBit(index,false);
		//turn on the pre 0
		setBit(index - 1, true);
		countone --;
		//ones to the high level
		for(int j = index - 2; j >= 0; j --){
			if(countone > 0){
				setBit(j, true);
				countone --;
			}else{
				setBit(j, false);
			}
		}
		return current;
	}
	public static int nextInt(){
		//find the first 1
		int index = 0;
		while(!getBit(index)){
			index ++;
		}
		System.out.println("first one is " + index);
		int countone = 0;
		//turn on the next 0
		while(getBit(index)){
			index ++;
			countone ++;
		}
		System.out.println("first zero is " + index);
		System.out.println("count one is " + countone);
		setBit(index, true);
		countone --;
		//turn off the pre 1
		setBit(index - 1, false);
		//ones to low place
		for(int i = 0; i < index - 1; i++){
			if(countone > 0){
				setBit(i, true);
				countone --;
			}else{
				setBit(i, false);
			}
		}
		return current;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SameOneBits.current = 35;
//		System.out.println("the next is " + SameOneBits.nextInt());
		System.out.println("the next is " + SameOneBits.preInt());
	}

}

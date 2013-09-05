package bitmanipulation;

public class CheckPowerOfTwo {

	public static boolean check(int val){
		return ((val & (val - 1)) == 0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val = 1024; 
		System.out.print("check value " + val + " is 2 power " + CheckPowerOfTwo.check(val));
	}

}

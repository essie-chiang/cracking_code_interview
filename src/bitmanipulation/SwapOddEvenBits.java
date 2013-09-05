package bitmanipulation;

public class SwapOddEvenBits {

	public static int swap(int val){
		return ((val & 0x5555)<<1)|((val & 0xaaaa)>>1);
	}
	public static void main(String[] args) {
		int value = 2334;
		System.out.println(Integer.toBinaryString(value));
		int swap = SwapOddEvenBits.swap(value);
		System.out.println(Integer.toBinaryString(swap));
	}

}

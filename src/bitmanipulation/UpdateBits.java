package bitmanipulation;

public class UpdateBits {
	public static char digits[] = {
		'0','1','2','3'
		
	};
	public static void bits(int m, int n, int i, int j){
		//m is long, n is short
		int mask = ((1 << (j-i+1))-1)<<i;
		int radix = ~mask;
		int mid = m & radix; // clear the positions for n
		int newone = m | (n << i);
		UpdateBits.play(newone);
	}
	
	public static void bits2(int m, int n, int i, int j){
		for(int k = i; k < j ; k ++){
			if((n & 1) == 1){
				m  = m | (1 << k);
				n >>>= 1;
			}else{
				m = m & (~(1 << k));
			}
		}
		UpdateBits.play(m);
	}
	public static String toBinaryString(int i, int shift){
		char[] des = new char[32];
		int charPos = 32;
		int mask = (1 << shift) - 1;
		while(charPos > 0){
			des[--charPos] = digits[i & mask];
		//	System.out.println("----" + des[charPos + 1]);
			i >>>= 1; 
		}
		return new String(des, charPos, (32-charPos));
	}
	public static void play(int i){
	//	System.out.println(Integer.toBinaryString(i));
		System.out.println("----" + toBinaryString(i , 1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpdateBits.bits(1024,15, 2, 6);
	}

}

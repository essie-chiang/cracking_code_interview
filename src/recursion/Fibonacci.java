package recursion;

public class Fibonacci {

	public static int recurF(int n){
		if (n == 0){
			return 0;
		}
		else if(n == 1 || n ==2){
			return 1;
		}else{
			return recurF(n - 1) + recurF(n - 2); 
		}
	}
	
	public static int iterF(int n){
		int pre = 0;
		int after = 1;
		int result = 0;
		while(n > 0){
			result = pre + after;
			int hold = pre;
			pre = after;
			after = pre + hold;
			n --;
		}
		return result;
	}
	//补充下高级的写法。。。
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 6; i ++){
		//	System.out.println( i + " fib is : " + Fibonacci.recurF(i));
			System.out.println( i + " fib is : " + Fibonacci.recurF(i));
		}
	}

}

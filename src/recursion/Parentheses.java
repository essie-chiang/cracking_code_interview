package recursion;

public class Parentheses {
//核心在于控制左右括号的数量
	public void printArr(char[] input){
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i]);
		}
		System.out.print("\n");
	}
	
	public void printPare(int left, int right, int index, char[] input){
	//	System.out.println("left is : " + left + " right is : " + right + " index is : " + index);
	//	printArr(input);
		if(left == 0 && right == 0){
			printArr(input);
			index--;
		}
		if(left > right){  // which is wrong
			return;
		}
		if(left > 0){
			input[index] = '(';
			printPare(left - 1, right, ++index, input);
			index--;
		}
		if(right > 0){
			input[index] = ')';
			printPare(left, right - 1, ++index, input);
			index--;
		}
	//	System.out.println("left is : " + left + " right is : " + right + " index is : " + index);
	}
	public static void main(String[] args) {
		Parentheses pare = new Parentheses();
		int count = 3;
		char[] input = new char[count * 2]; 
		pare.printPare(count, count, 0, input);

	}

}

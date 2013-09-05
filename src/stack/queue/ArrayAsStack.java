package stack.queue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//an array as 3 stacks
public class ArrayAsStack <T> {

	public int stackSize;
//	public Object[] buffer = new Object[100];
	public T[] buffer; 
	public int[] stackPointer = {0,0,0};
	
	@SuppressWarnings("unchecked")
	public ArrayAsStack(Class<T> cls, int size){
		stackSize = size;
		buffer = (T[]) Array.newInstance(cls, size*3);
	}
	
	public void push(int stackNum, T value){
		System.out.println(stackNum + " " + value);
		int index = stackNum * stackSize + stackPointer[stackNum];
		buffer[index] = value;
		stackPointer[stackNum]++;
	}
	
	public T pop(int stackNum){
		stackPointer[stackNum]--;
		int index = stackNum * stackSize + stackPointer[stackNum];		
		return buffer[index];
	}
	//peek the top element in stack
	public T peek(int stackNum){
		int index = stackNum * stackSize + stackPointer[stackNum];
		T value = buffer[index-1];
	    return value;
	}
	
	public boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayAsStack aas = new ArrayAsStack(Integer.class, 10);
		int peek;
		for(int i = 0; i < 3 ;i++){
//		System.out.println(i + " is empty:" + aas.isEmpty(i) );
			for(int j = 0; j < 10; j++){
				int test = i*100 + j;
				aas.push(i, test);
			}
			while(!aas.isEmpty(i)){
				System.out.println(i + " pop :" + aas.peek(i) );
				aas.pop(i);	
			}
			
		}


	}

}

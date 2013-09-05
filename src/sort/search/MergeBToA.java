package sort.search;

public class MergeBToA {
	//two sorted array a,b, a is enough buffer at end for b
	//merge a,b into a
	public void merge(int[] a, int[] b, int m, int n){
		int k = m + n + 1;
		while(m >= 0 && n >= 0){
			if(a[m] > b[n]){
				System.out.println("print a[m] " + a[m] + " when b[n] " + b[n]);
				a[k--] = a[m--];
			}else{
				System.out.println("print b[0] " + b[n] + " when a[m] " + a[m]);
				a[k--] = b[n--];
			}
		}
		while(n >= 0){
			System.out.println("print " + b[n]);
			a[k--] = b[n--];
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[100];
		for(int i = 0; i < 10; i ++){
			a[i] = 2 * i + 3; 
		}
		int[] b = {0,1,2,30,34,60,99};
		MergeBToA ba = new MergeBToA();
		ba.merge(a, b, 9, 6);
		for(int i = 0; i < a.length; i ++){
			System.out.print(a[i] + " ");
		}
	}

}

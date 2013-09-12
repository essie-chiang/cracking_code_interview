package pandc;

public class Store {
	private int full = 10;
	private int empty = 0;
	private int store = 0;
	public Store(){}
	public Store(int size){
		this.full = size;
	}
	
	public synchronized void put() throws InterruptedException{
		if(store < full){
			store ++;
			this.notifyAll();
		}else{
			System.out.println(this.getClass().toString() + "store = " + store +" full!!!" );
			this.wait();
		}
	}
	
	public synchronized void remove() throws InterruptedException{
		if(store > empty){
			store--;
			this.notifyAll();
		}else{
			System.out.println(this.getClass().toString() + "store = " + store +" empty!!!" );
			this.wait();
		}
		
	}
	
	public static void main(String[] args){
		Store store = new Store();
//		Producer pro1 = new Producer(store);
		ProducerPool propool = ProducerPool.getProPool(store, 2);
		Consumer con1 = new Consumer(store);
//		Thread pro = new Thread(pro1);
		Thread con = new Thread(con1);
//		pro.start();
		con.start();
	}
	
}

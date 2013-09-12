package pandc;

public class Consumer implements Runnable{
	private Store ss = null;
	public Consumer(Store s){
		this.ss = s;
	}
	
	public void run(){
		while(true){
			System.out.println(Thread.currentThread().getName() + "is consuming");
			try{
				ss.remove();
				Thread.sleep(150);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

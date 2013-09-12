package pandc;

public class Producer implements Runnable{
	private Store ss = null;
	public Producer(Store s){
		this.ss = s;
	}
	
	public void run(){
		while(true){
			System.out.println(Thread.currentThread().getName() + "is producing");
			try{
				ss.put();
				Thread.sleep(2000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}

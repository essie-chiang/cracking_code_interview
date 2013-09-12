package pandc;

public final class ProducerPool {
	private static int worker_num = 5;
	private static ProducerPool proPool;
	private Producer[] proarr;
	
	private ProducerPool(Store store, int workers){
		worker_num = workers;
		proarr = new Producer[worker_num]; 
		for(int i = 0; i < worker_num; i ++){
			proarr[i] = new Producer(store);
			new Thread(proarr[i]).start();
		}
	}
	
	public static ProducerPool getProPool(Store store,int workers){
		if(workers < worker_num){
			workers = worker_num;
		}
		if(proPool == null){
			proPool = new ProducerPool(store,workers);
		}
		return proPool;
	}
}

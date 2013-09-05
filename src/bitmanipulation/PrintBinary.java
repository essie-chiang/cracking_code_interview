package bitmanipulation;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class PrintBinary {
	public static Logger log = Logger.getLogger(PrintBinary.class);
	public  static String printBinary(String n){
		int intPart = Integer.parseInt(n.substring(0,n.indexOf('.')));
		double decPart = Double.parseDouble(n.substring(n.indexOf('.'),n.length()));
		log.debug("integer " + intPart + " double " + decPart);
//		long intStore = 0;
		String intStore = "";
		while(intPart > 0){
			int tail = intPart %2;
//			intStore = tail * 10 + intStore;
			intStore = tail + intStore;
			intPart = intPart >> 1;
		}
		String intp = String.valueOf(intStore);
		log.debug("intStore " + intStore);
		StringBuilder sb = new StringBuilder();
		int accurate = 5;
		while(decPart > 0 && accurate > 0 ){
			decPart *= 2;
			if(decPart > 1){
				sb.append('1');
				decPart --;
			}else{
				sb.append('0');
			}
			accurate --;
		}
		return intp + "." + sb.toString();
	}
	public static void main(String[] args) {
		log.debug(PrintBinary.printBinary("11322.2233"));
		
	}

}

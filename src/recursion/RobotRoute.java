package recursion;

import java.util.ArrayList;

public class RobotRoute {
	
	public static boolean is_free(int x, int y){
		if(x > 0 && y > 0){
			return true;
		}else{
			return false;
		}
	}
	public static boolean getPath(int x, int y){
		Point p = new Point( x, y);
		p.showp();
		boolean success = false;
		if(x == 0 && y == 0){
			return true;
		}
		if(x >= 1 && is_free(x - 1, y)){
			success = getPath(x - 1, y); 
		}
		if(!success && y >= 1 && is_free(x, y - 1)){
			success = getPath(x, y - 1);
		}
		if(!success){
			p.showr();
		}
		return success;
	}
	
	//fail how, why
	public static String getRoute(int x, int y){
		Point  p = new Point(x,y);
		if(x == 0 && y == 0){
			return "done";
		}
		if(x >= 1 ){
			//System.out.println("x > 1");
			return "x" + getRoute(x - 1, y);
		}
		if(y >= 1 ){
			//System.out.println("y > 1");
			return "y" + getRoute(x, y - 1);
		}
		p.showr();
		return null;
	}
	
	public static int routeNum(int x, int y, int n){
		if(x == 0 && y == 0){
			return 1;
		}
		return routeNum(x - 1, y , n) + routeNum(x, y - 1, n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RobotRoute.getPath(2, 2);
//		System.out.println(RobotRoute.getRoute(3, 3));
		System.out.println(RobotRoute.routeNum(3, 3, 3));
	}

}

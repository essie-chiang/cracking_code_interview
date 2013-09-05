package recursion;

public class PaintFull {

//	public enum color{
//		Green, Black, Red
//	}
//	public void printEnumArr(color[][] screen){
//		for(int i = 0; i < screen[0].length; i ++){
//			for(int j = 0; j < screen.length; j ++){
//				System.out.print(screen[i][j].name().toString());
//			}
//			System.out.print("\n");
//		}
//	}
//	public void paint(color[][] screen, int x, int y,color ocolor, color ncolor){
//		System.out.println("x : " + x + " y : " +  y);
//			if( x < 0 || y < 0 || x > (screen[0].length - 1) || y > (screen.length - 1)){
////				System.out.println("x = " + x + " > " + (screen[0].length - 1));
////				System.out.println("y = " + y + " > " + (screen.length - 1));
//				return;
//			}
//		screen[y][x] = ncolor;
////		printEnumArr(screen);
//		paint(screen, x - 1, y, ocolor, ncolor);
//
//		paint(screen, x + 1, y, ocolor, ncolor);
//		paint(screen, x , y - 1, ocolor, ncolor);
//		paint(screen, x , y + 1, ocolor, ncolor);
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PaintFull pf = new PaintFull();
//		int size = 3;
//		color[][] screen = {{color.Green, color.Black, color.Red},{color.Green, color.Black, color.Red},{color.Green, color.Black, color.Red}};
//		pf.paint(screen, 0, 0, color.Black,color.Green);
//	}
	public static void paintFull(int [][]screen, int i, int j, int srcColor){
		if(i < 0 || j < 0 || i >= screen.length || j >= screen[0].length || screen[i][j] != -1){
			return;
		}

		screen[i][j] = srcColor;
		paintFull(screen, i-1, j, srcColor);
	
		paintFull(screen, i, j-1, srcColor);
		paintFull(screen, i+1, j, srcColor);
		paintFull(screen, i, j+1, srcColor);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]screen = {{-1,0,1}, {-1,-1,2}, {0, -1, 3}};
		paintFull(screen, 1, 0, 1);  //必须从-1的开始涂起
		for(int i = 0; i < screen.length; ++i){
			for(int j = 0; j < screen[0].length; ++j){
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}


}

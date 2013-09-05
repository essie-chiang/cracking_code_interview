package recursion;

public class EightQueue {
	int[] columnForRow  = new int[8];
	public void queue(){
		placeQ(0);
	}
	public void placeQ(int row){
		if(row == 8){
			printBoard();
			System.out.print("\n");
			return;
		}
		for(int i = 0; i < 8; i ++){
			columnForRow[row] = i;
				if(check(row)){
//					System.out.println("row" + row);
					placeQ(row + 1);
				}
		}
	}
	public void printBoard(){
		for(int i = 0; i < 8; i ++){
			//print by row
			for(int j = 0; j < 8; j ++){
				if(j == columnForRow[i]){
					System.out.print("1");
				}else{
					System.out.print("0");
				}
			}
			System.out.print("\n");
		}
	}
	public  boolean check(int row){
		for(int i = 0; i < row; i ++){
			int diff = Math.abs(columnForRow[i] - columnForRow[row]);
			if(diff == 0 || diff == (row - i)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EightQueue().queue();
	}

}

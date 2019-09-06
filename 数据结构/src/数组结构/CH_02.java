package 数组结构;

public class CH_02 {
	
	public static void Add(int arrA[],int arrB[],int arrC[],int dimX,int dimY) {
		int  row,col;
		if(dimX<=0||dimY<=0) {
			System.out.println("矩阵维数必须大于0");
			return;
		}
		for(row=1;row<=dimX;row++) {
			for (col = 0; col <=dimY; col++) {
				//arrC[(row-1)][(col-1)]=arrA[(row-1)][(col-1)]+arrB[(row-1)][(col-1)];
			}
		}
	}
	public static void main(String args[]) {
		int i;
		int j;
		final int ROWS = 3;
		final int COLS = 3;
		int [][] A= {{1,3,5}};
			
		
	}
}

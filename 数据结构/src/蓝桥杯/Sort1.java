package 蓝桥杯;

public class Sort1 {

	public static void main(String[] args) {
		int t[] = {5,3,4,7,3,5,6};
		int num = 7;
		int tt[] = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			tt[i]=t[i];
		}
		
		int num1 = num;
		for (int i = 0; i < num1-1; i++) {
			int max = i;
			for (int j = i+1; j < num1; j++) {
				if (tt[max]<tt[j]) {
				max = j;	
				} else if(tt[max]==tt[j]){
					if (j == num1-1) {
						tt[j] = 0;
					} else {
						for (int k = j; k < num1-1; k++) {
							tt[k] = tt[k+1];
					}
				}
					num1--;
					j--;
				}
			}
			int temp = 0;
			temp = tt[i];
			tt[i]=tt[max];
			tt[max]=temp;
		}
		for (int i = 0; i < num; i++) {
			int temp = t[i];
			for (int j = 0; j < num1; j++) {
				if (t[i] == tt[j]) {
					System.out.println("第"+(i+1)+"个分数是："+tt[j]+"分名次是"+(j+1));
				} else {

				}
			}
		}
	}

}

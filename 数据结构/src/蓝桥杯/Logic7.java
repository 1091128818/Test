package À¶ÇÅ±­;


public class Logic7 {

	public static void main(String[] args) {
		for (int i = 32; i < 100; i++) {
		int r =	i*i;
		int a=r/1000;
		int b=r/100%10;
		int c=r/10%10;
		int d=r%10;
		if((a==b)&&(c==d)) {
			System.out.println("31"+a+b+c+d);
		}
		}

	}

}

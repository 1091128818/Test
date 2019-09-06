package 蓝桥杯;

public class Logic1 {

	public static void main(String[] args) {
		//思路很重要
		/*boolean jia = true;
		boolean yi = false;
		boolean bing = false;
		boolean ding = false;
		
		((!yi&&ding)||(yi&&!ding))&&
		((!yi&&bing)||(yi&&!bing))&&
		((!yi&&bing)||(yi&&!bing))&&
		*/
		
		for (int i = 0; i < 4; i++) {
			boolean[] p = {false,false,false,false};
			p[i]=true;
			
			if(((!p[1]&&p[3])||(p[1]&&!p[3]))&&
				((!p[1]&&p[2])||(p[1]&&!p[2]))&&
				((!p[0]&&p[1])||(p[0]&&!p[1]))&&
				(!p[3]||p[3])) { 
				switch (i) {
				case 0:
					System.out.println("甲是小偷");
					break;
				case 1:
					System.out.println("乙是小偷");
					break;
				case 2:
					System.out.println("丙是小偷");
					break;
				case 3:
					System.out.println("丁是小偷");
					break;
				}
				break;}
		}
		
		

	}

}

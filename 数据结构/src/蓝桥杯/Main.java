package À¶ÇÅ±­;

import java.math.BigInteger;
import java.util.Scanner;
 
public class Main{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int i,k;
		int n;
		BigInteger y1,y2,tempY1,tempY2;
		while(in.hasNext()){
			n=in.nextInt();
			if(0==n){
				System.out.println(1+" "+1);
				continue;
			}
			y1=new BigInteger("0");
			y2=new BigInteger("0");
			tempY1=new BigInteger("1");
			tempY2=new BigInteger("1");
			for(i=1;i<=n;i++){
				if(i%2==0){
					for(k=1;k<=i;k++){
						tempY1=tempY1.multiply(BigInteger.valueOf(k));
					}//for k
					y1=y1.add(tempY1);
					tempY1=BigInteger.valueOf(1);
					
				}//if
				else{
					for(k=1;k<=i;k++){
						tempY2=tempY2.multiply(BigInteger.valueOf(k));
					}
					y2=y2.add(tempY2);
					tempY2=BigInteger.valueOf(1);
					
				}
			}//for i
			System.out.println(y2+" "+y1);
		}//while
	}

}
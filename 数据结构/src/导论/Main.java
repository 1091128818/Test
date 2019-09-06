package µ¼ÂÛ;

import java.util.Scanner;
  
 public class Main
 {
     public static void main(String[] args)
     {
         double s =0,x=0,y=0;
         Scanner input = new Scanner(System.in);
         double n = input.nextDouble();
         y=n;
         s=n;
         int m = input.nextInt();
         for(int i=0;i<m;i++)
         {
             n *= 0.5;
         }
         for(int i=0;i<m-1;i++)
         {
             s *= 0.5;
             x += s;
         }
         y +=x*2;
         String  str = String.format("%.2f ",n);
         String  str1 = String.format("%.2f ",y);
         System.out.print(str+" "+str1);
     }
 }
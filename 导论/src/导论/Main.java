package 导论;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void change(int[] a) throws Exception
	{
	int temp=0;
	temp=a[0];a[0]=a[1];a[1]=temp;
	}
	public static void main(String args[]) throws Exception
	{
	int[] a = new int[2];
	System.out.println("输入a:");
	InputStreamReader inreader=new InputStreamReader(System.in);
	BufferedReader breader=new BufferedReader(inreader);
	a[0]=Integer.parseInt(breader.readLine());
	System.out.println("输入b:");
	a[1]=Integer.parseInt(breader.readLine());
	System.out.println("交换前a="+a[0]+" 交换前b="+a[1]);
	change(a);
	System.out.println("交换后a="+a[0]+" 交换后b="+a[1]);
	}
}

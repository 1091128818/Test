package ����;

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
	System.out.println("����a:");
	InputStreamReader inreader=new InputStreamReader(System.in);
	BufferedReader breader=new BufferedReader(inreader);
	a[0]=Integer.parseInt(breader.readLine());
	System.out.println("����b:");
	a[1]=Integer.parseInt(breader.readLine());
	System.out.println("����ǰa="+a[0]+" ����ǰb="+a[1]);
	change(a);
	System.out.println("������a="+a[0]+" ������b="+a[1]);
	}
}

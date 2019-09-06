package 数组结构;

import java.util.*;

public class CH02_01 {

	public static void main(String[] args) {
		
		int intCreate = 1000000;//产生随机数次数
		int intRand;	//产生随机数号码
		int[][] intArray = new int[2][42];	//放置随机数组
		
		//将产生的随机数存放至数组
		while(intCreate-->0) {
			intRand = (int) (Math.random()*42);
			intArray[0][intRand]++;
			intArray[1][intRand]++;
			
		}
		//对intArray[0]做数组排序
		Arrays.sort(intArray[0]);
		
		//找出最大数的6个数字号码
		for (int i = 41; i >(41-6); i--) {
			//逐一检查次数相同者
			for (int j = 41; j >=0; j--) {
				//当次数符合时打印
				if (intArray[0][i]==intArray[1][j]) {
					System.out.println((j+1)+" "+intArray[0][i]);
					intArray[1][j] =0;//将找到的数值次数归零
					break; //中断内循环
				}
			}
			
		}

	}

}

package 操作系统实验;

import java.io.*;
import java.util.Scanner;

public class 动态 {
	private static int MaxNum = 100;
	// 空闲分区个数
	private static int n;
	// 作业个数
	private static int m;
	// 空闲分区大小
	private static int FreePartition[] = new int[MaxNum];
	// 作业名称
	private static char ProcessName[] = new char[MaxNum];
	// 作业需求空间大小
	private static int ProcessNeed[] = new int[MaxNum];
	// 作业分配标志
	private static boolean state[] = new boolean[MaxNum];
	// 空闲分区个数
	private static int PartitionNum;
	// 作业个数
	private static int ProcessNum;
	// ?????
	private static char order[][] = new char[MaxNum][MaxNum];
	// ?????
	private static char ch[] = new char[MaxNum];
	// 临时变量
	private static int temp;
	// 算法选择
	// 1-首次适应算法
	// 2-循环首次适应算法
	// 3-最佳适应算法
	// 4-最坏适应算法
	private static int option = 0;
	// for循环中使用
	private static int i;
	private static int j;
	private static int k;
	private static int d;

	private static Scanner stdin;

	public static void main(String[] args) throws FileNotFoundException {
		// 输入数据
		input();

		// 选择算法
		// 1-首次适应算法
		// 2-循环首次适应算法
		// 4-最坏适应算法
		switch (option) {
		case 1:
			System.out.println("对作业用首次适应算法进行空间分配:");
			First();
			output();
			break;
		case 2:
			System.out.println("对作业用循环首次适应算法进行空间分配:");
			CycleFirst();
			output();
			break;
		case 3:
			System.out.println("对作业用最佳适应算法进行空间分配:");
			Best();
			output();
			break;
		case 4:
			System.out.println("对作业用最坏适应算法进行空间分配:");
			Worst();
			output();
			break;
		default:
			System.out.println("********error!*****");
		}

	}

	// 输入数据
	public static void input() throws FileNotFoundException {
		
		System.out.println("算法选择:");	
		stdin = new Scanner(System.in);

		// 算法选择
		// 1-首次适应算法
		// 2-循环首次适应算法
		// 3-最佳适应算法
		// 4-最坏适应算法
		
			
		
				
		option = stdin.nextInt();
		System.out.println("请输入空闲分区个数:");
		// 请输入空闲分区个数
		n = stdin.nextInt();
		System.out.println("请依次输入空闲分区大小(KB):");
		// 请依次输入空闲分区大小(KB)
	System.out.println("请输入作业个数:");
		for (i = 0; i < n; i++) {
			FreePartition[i] = stdin.nextInt();
		}
		// 请输入作业个数
		m = stdin.nextInt();
		System.out.println("请依次输入作业名称:");
		// 请依次输入作业名称
		System.out.println("请依次输入作业大小(KB):");
		for (i = 0; i < m; i++) {
			ProcessName[i] = stdin.next().charAt(0);
			ch[i] = ProcessName[i];
		}
		// 请依次输入作业大小(KB)
		for (i = 0; i < m; i++) {
			ProcessNeed[i] = stdin.nextInt();
			state[i] = false;
		}
		for (i = 0; i < n; i++) {
			System.out.print("|" + FreePartition[i]);
		}
		System.out.print("|\n");
		System.out.println("作业信息如下:");
		for (i = 0; i < m; i++) {
			System.out.print(ProcessName[i] + "\t");
		}
		System.out.print("\n");
		for (i = 0; i < m; i++) {
			System.out.print(ProcessNeed[i] + "\t");
		}
		System.out.println("\n");
	}

	// 1——首次适应算法
	public static void First() {
		for (i = 0; i < m; i++) {
			for (j = 0; j < n; j++) {
				// 找到第一个合适的空闲分区
				if ((ProcessNeed[i] <= FreePartition[j]) && (!state[i])) {
					for (k = 0; k < 3; k++) // 记录作业分配
					{
						if (order[j][k] == 0) // 为空
						{
							order[j][k] = ProcessName[i];
							break;
						} else
							continue;
					}
					FreePartition[j] = FreePartition[j] - ProcessNeed[i];
					state[i] = true;
				}
			}
		}
	}

	// 2——循环首次适应算法
	public static void CycleFirst() {
		i = 0;
		j = 0;
		while ((i < n) && (j < m)) {
			if ((ProcessNeed[i] <= FreePartition[j]) && (!state[i])) {
				for (k = 0; k < 3; k++) // 记录作业分配
				{
					if (order[j][k] == 0) {
						order[j][k] = ProcessName[i];
						break;
					} else
						continue;
				}
				FreePartition[j] = FreePartition[j] - ProcessNeed[i];
				state[i] = true;
				i++;
			} else
				j++;
		}
	}

	// 3——最佳适应算法
	public static void Best() {
		for (i = 0; i < m; i++) {
			temp = FreePartition[0];
			k = 0;
			// 找到第一个合适的空闲分区
			while (ProcessNeed[i] > temp) {
				k++;
				temp = FreePartition[k];
			}
			for (j = 0; j < n; j++) {
				// 按最佳适应算法找到符合的空闲区
				if ((ProcessNeed[i] <= FreePartition[j]) && (temp > FreePartition[j]) && (!state[i]))

				{
					temp = FreePartition[j];
					k = j;
				} else
					continue;
			}
			for (d = 0; d < 3; d++) // 记录作业分配
			{
				if (order[k][d] == 0) {
					order[k][d] = ProcessName[i];
					break;
				} else
					continue;
			}
			FreePartition[k] = FreePartition[k] - ProcessNeed[i];
			state[i] = true;
		}
	}

	// 4——最坏适应算法
	public static void Worst() {
		i = 0;
		j = 0;
		while ((i < n) && (j < m)) {
			if ((ProcessNeed[i] <= FreePartition[j]) && (!state[i])) {
				for (k = 0; k < 3; k++) // 记录作业分配
				{
					if (order[j][k] == 0) {
						order[j][k] = ProcessName[i];
						break;
					} else
						continue;
				}
				FreePartition[j] = FreePartition[j] - ProcessNeed[i];
				state[i] = true;
				i++;
			} else
				j++;
		}
	}

	{
		i = 0;
		j = 0;
		while ((i < n) && (j < m)) {
			if ((ProcessNeed[i] <= FreePartition[j]) && (!state[i])) {
				for (k = 0; k < 3; k++) // 记录作业分配
				{
					if (order[j][k] == 0) {
						order[j][k] = ProcessName[i];
						break;
					} else
						continue;
				}
				FreePartition[j] = FreePartition[j] - ProcessNeed[i];
				state[i] = true;
				i++;
			} else
				j++;
		}
	}

	

	// 结果输出
	public static void output() {
		for (i = 0; i < n; i++) {
			System.out.print("|");
			for (j = 0; j < 3; j++) {
				if (order[i][j] == 0)
					System.out.print("  ");
				else
					System.out.print(order[i][j]);
			}
		}
		System.out.print("|\n");
	}
}

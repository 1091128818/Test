package 操作系统实验;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Began {

	public static List<double []> task_info=new ArrayList<>();//进程列表
    public static  int task_num=4;//进程数
    
	 public static  void init_task()//初始化进程列表
	    {
	        for(int i=0;i<task_num;i++)
	        {
	            double[] t=new double[4];
	            t[0]=i;//进程号
	            t[1]=0;//到达时间
	            t[2]=0;//响应比
	            t[3]=(int)(Math.random()*100)%20+1;//需要运行时间
	            task_info.add(t);
	        }
	    }
	public static void main(String[] args) {
		 Began.init_task();//初始化进程列表

		Scanner reader = new Scanner(System.in);
		System.out.println("请输入算法：1）先来先服务。2）短作业优先调度。3）优先级调度。4）高响应比优先调度算法。5）时间片轮转调度算法。");
		int input = reader.nextInt();

		
		switch (input) {
		case 1:
			FCFS fcfs = new FCFS();

			break;
		case 2:
			System.out.println("短作业优先================================================");
	        SJF.init_task(task_info,task_num);
	        SJF.SJF();//短作业优先
			break;
		case 3:
			PSA psa = new PSA();
			
			break;
		case 4:
			
	 
	 
	        System.out.println("\n\n最高响应比================================================");
	        HRRN.init_task(task_info,task_num);
	        HRRN.HRRN();//高响应比
			break;
		case 5:
			System.out.println("\n\n时间片轮转================================================");
	        RR.init_task(task_info,task_num);
	        RR.CircleTime();//时间片轮转
			break;

		default:
			System.out.println("非法输入");
			break;
		}
		reader.close();
	}
}

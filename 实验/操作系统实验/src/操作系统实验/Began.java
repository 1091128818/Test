package ����ϵͳʵ��;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Began {

	public static List<double []> task_info=new ArrayList<>();//�����б�
    public static  int task_num=4;//������
    
	 public static  void init_task()//��ʼ�������б�
	    {
	        for(int i=0;i<task_num;i++)
	        {
	            double[] t=new double[4];
	            t[0]=i;//���̺�
	            t[1]=0;//����ʱ��
	            t[2]=0;//��Ӧ��
	            t[3]=(int)(Math.random()*100)%20+1;//��Ҫ����ʱ��
	            task_info.add(t);
	        }
	    }
	public static void main(String[] args) {
		 Began.init_task();//��ʼ�������б�

		Scanner reader = new Scanner(System.in);
		System.out.println("�������㷨��1�������ȷ���2������ҵ���ȵ��ȡ�3�����ȼ����ȡ�4������Ӧ�����ȵ����㷨��5��ʱ��Ƭ��ת�����㷨��");
		int input = reader.nextInt();

		
		switch (input) {
		case 1:
			FCFS fcfs = new FCFS();

			break;
		case 2:
			System.out.println("����ҵ����================================================");
	        SJF.init_task(task_info,task_num);
	        SJF.SJF();//����ҵ����
			break;
		case 3:
			PSA psa = new PSA();
			
			break;
		case 4:
			
	 
	 
	        System.out.println("\n\n�����Ӧ��================================================");
	        HRRN.init_task(task_info,task_num);
	        HRRN.HRRN();//����Ӧ��
			break;
		case 5:
			System.out.println("\n\nʱ��Ƭ��ת================================================");
	        RR.init_task(task_info,task_num);
	        RR.CircleTime();//ʱ��Ƭ��ת
			break;

		default:
			System.out.println("�Ƿ�����");
			break;
		}
		reader.close();
	}
}

package ʵ��һ;

/**
 * ����һ��
 * 	1. ��һ���̣߳�����֮����wait��������״̬
 * 	2. �ڶ����̣߳�����֮�����ߣ�����֮���ѵ�һ���߳�
 * 
 * �������
 * 	1. �������ĸ���ǩ����ǩ1 2 3 4��ͨ�����߳�ʹ�ĸ���ǩһ����ʾ������
 * 
 * ��������
 * 	1. �̣߳�����2 ���� 10000 ֮��������ĸ���
 * 	2. �̣߳�����10000 - 20000 ֮��������ĸ��� 
 * @author Administrator
 *
 */

public class First {
	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("���� wait() ������ʼ����");
				try {
					synchronized(this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("�����ѿ�ʼ����.....");
				System.out.println("�߳�1 ����ʼ��������");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�߳�2 ����");
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("�߳�2 ����ʼ��������");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
				
				System.out.println("��ʼ���� thread1 ");
				synchronized(thread1) {
					thread1.notifyAll();
				}
				
				System.out.println("�߳�2 ����");
			}
		};
		
		thread1.start();
		thread2.start();
	}
}

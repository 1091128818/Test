package ʵ��һ;
/*
 * ���������̵߳�һ��ִ��wait����
 * */
public class Main1 {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {

			public void run() {

				System.out.println("����wait()��ʼ����");
				try {
					synchronized (this) {
						this.wait(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("�����ѣ�Ȼ���һ���߳�ִ��3��");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Ȼ���һ���߳̽���");
			}
		};
		Thread thread2 = new Thread() {

			public void run() {
				System.out.println("�̶߳�����֮������3��");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Ȼ���ѵ�һ���߳�");
				synchronized (thread1) {
					thread1.notifyAll();
				}
				System.out.println("�ڶ����߳̽���");
			}
		};
		thread1.start();
		thread2.start();
	}
}

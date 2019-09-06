package 实验一;
/*
 * 创建两个线程第一个执行wait方法
 * */
public class Main1 {

	public static void main(String[] args) {
		Thread thread1 = new Thread() {

			public void run() {

				System.out.println("调用wait()开始休眠");
				try {
					synchronized (this) {
						this.wait(2000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("被唤醒，然后第一个线程执行3秒");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("然后第一个线程结束");
			}
		};
		Thread thread2 = new Thread() {

			public void run() {
				System.out.println("线程二启动之后休眠3秒");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("然后唤醒第一个线程");
				synchronized (thread1) {
					thread1.notifyAll();
				}
				System.out.println("第二个线程结束");
			}
		};
		thread1.start();
		thread2.start();
	}
}

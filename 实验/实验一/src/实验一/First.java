package 实验一;

/**
 * 问题一：
 * 	1. 第一个线程：启动之后用wait处于休眠状态
 * 	2. 第二个线程：启动之后休眠，结束之后唤醒第一个线程
 * 
 * 问题二：
 * 	1. 窗口有四个标签：标签1 2 3 4，通过多线程使四个标签一次显示或隐藏
 * 
 * 问题三：
 * 	1. 线程：计算2 —— 10000 之间的质数的个数
 * 	2. 线程：计算10000 - 20000 之间的质数的个数 
 * @author Administrator
 *
 */

public class First {
	public static void main(String[] args) {
		Thread thread1 = new Thread() {
			public void run() {
				System.out.println("调用 wait() 方法开始休眠");
				try {
					synchronized(this) {
						this.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("被唤醒开始继续.....");
				System.out.println("线程1 ：开始休眠五秒");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("线程2 结束");
			}
		};
		
		Thread thread2 = new Thread() {
			public void run() {
				System.out.println("线程2 ：开始休眠五秒");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
				System.out.println("开始唤醒 thread1 ");
				synchronized(thread1) {
					thread1.notifyAll();
				}
				
				System.out.println("线程2 结束");
			}
		};
		
		thread1.start();
		thread2.start();
	}
}

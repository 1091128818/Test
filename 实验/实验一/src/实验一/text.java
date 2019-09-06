package 实验一;

import javax.swing.*;

/*
 * 在窗口中用不同的颜色绘制圆，椭圆，圆弧
 * 设计一个窗口叫计算流式布局四个按钮加减乘除三个文本行前两个
 * 定义一个标题为改变颜色的窗口，三个红绿蓝要求单击任意改变文本行的背景色
 * 
 * 
 * */

class ThreadT implements Runnable{
	private JFrame Myframe = null;
	//共享资源(临界资源)
    private static int i=1;
    private static String j = i + "";
    
    public ThreadT(JFrame Myframe) {
    	this.Myframe = Myframe;
    }
    
    /**
     * synchronized 修饰实例方法
     * @throws InterruptedException 
     */
    public synchronized void show() throws InterruptedException{
        // 添加面板
        JPanel Mypanel = new JPanel();
        Myframe.add(Mypanel);
        Mypanel.setLayout(null);//边框
    	
		JLabel label = new JLabel(j);
		label.setBounds(10 * i,20,80,25);
		Mypanel.add(label);
    	System.out.println(i);
        i++;
        j = i + "";

        Myframe.validate();
        Myframe.repaint(); 
        Mypanel.validate(); 
        Mypanel.repaint();
        //眠
        Thread.sleep(1000);
        //隐藏
        Myframe.getContentPane().removeAll();  
    }
    
    public void run() {
        try {
			show();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}


public class text{
    public static void main(String[] args) throws InterruptedException {  	
    	//创建窗体
    	JFrame Myframe = new JFrame();
		Myframe.setSize(400, 350);
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close操作
        Myframe.setVisible(true);
    	//多线程
        ThreadT show=new ThreadT(Myframe);
        Thread t1=new Thread(show);
        Thread t2=new Thread(show);
        Thread t3=new Thread(show);
        Thread t4=new Thread(show);
        t1.start();     
        t2.start();     
        t3.start();       
        t4.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join(); 
		
    }
}

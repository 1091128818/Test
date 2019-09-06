package ʵ��һ;

import javax.swing.*;

/*
 * �ڴ������ò�ͬ����ɫ����Բ����Բ��Բ��
 * ���һ�����ڽм�����ʽ�����ĸ���ť�Ӽ��˳������ı���ǰ����
 * ����һ������Ϊ�ı���ɫ�Ĵ��ڣ�����������Ҫ�󵥻�����ı��ı��еı���ɫ
 * 
 * 
 * */

class ThreadT implements Runnable{
	private JFrame Myframe = null;
	//������Դ(�ٽ���Դ)
    private static int i=1;
    private static String j = i + "";
    
    public ThreadT(JFrame Myframe) {
    	this.Myframe = Myframe;
    }
    
    /**
     * synchronized ����ʵ������
     * @throws InterruptedException 
     */
    public synchronized void show() throws InterruptedException{
        // ������
        JPanel Mypanel = new JPanel();
        Myframe.add(Mypanel);
        Mypanel.setLayout(null);//�߿�
    	
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
        //��
        Thread.sleep(1000);
        //����
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
    	//��������
    	JFrame Myframe = new JFrame();
		Myframe.setSize(400, 350);
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close����
        Myframe.setVisible(true);
    	//���߳�
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

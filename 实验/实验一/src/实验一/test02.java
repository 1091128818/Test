package 实验一;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.swing.JPanel;
class Creatlabel implements Runnable{
	private Frame frame;
	JPanel p;
	private Label l;
	public Creatlabel(Frame fream,JPanel p,Label l) {
		this.frame = fream;
		this.p = p;
		this.l = l;
	}
	@Override
	public void run() {
		frame.setLocation(500, 200);
		frame.setSize(1000, 500);
		frame.setVisible(true);
		frame.addWindowListener(new java.awt.event.WindowAdapter() {   
			public void windowClosing(java.awt.event.WindowEvent e) {   
			System.exit(0);   
			}   
		}); 
		p.add(l);
		try {
			Thread.sleep(500);
			System.out.println(l);
		} catch (InterruptedException e) {}
	}
}

public class test02{
	public static void main(String[] args)  {
		Frame frame = new Frame();
		JPanel p = new JPanel();
		Label s1 = new Label();
		Label s2 = new Label();
		Label s3 = new Label();
		Label s4 = new Label();
		Label s5 = new Label();
		Runnable runner1 = new Creatlabel(frame,p,s1);
		Runnable runner2 = new Creatlabel(frame,p,s2);
		Runnable runner3 = new Creatlabel(frame,p,s3);
		Runnable runner4 = new Creatlabel(frame,p,s4);
		Runnable runner5 = new Creatlabel(frame,p,s5);
		Thread thread1 = new Thread(runner1);
		Thread thread2 = new Thread(runner2);
		Thread thread3 = new Thread(runner3);
		Thread thread4 = new Thread(runner4);
		Thread thread5 = new Thread(runner5);
		s1.setText("标签1");
		s1.setFont(new Font(null, Font.PLAIN, 25));
		s2.setText("标签2");
		s3.setText("标签3");
		s3.setFont(new Font(null, Font.PLAIN, 25));
		s4.setText("标签4");
		s5.setText("标签5");
	
		
		thread1.start();
		try {
			frame.add(p);
			thread1.join();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		thread2.start();
		try {
			frame.add(p);
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread3.start();
		try {
			frame.add(p);
			thread3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread4.start();
		try {
			frame.add(p);
			thread4.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread5.start();
		try {
			thread5.join();
			frame.add(p);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			thread4.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.removeAll();
	}
}

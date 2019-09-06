package 实验二;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//创建窗体
    	JFrame Myframe = new JFrame();
    	Myframe.setTitle("文本行换颜色");
		Myframe.setSize(400, 350);
		Myframe.setLayout(new FlowLayout());
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close操作
        Myframe.setVisible(true);
        
        JButton Button1 = new JButton("红");
		JButton Button2 = new JButton("绿");
		JButton Button3 = new JButton("蓝");
		JLabel lblLabe = new JLabel("文本行(颜色)"); 
		lblLabe.setOpaque(true);  //此句是重点，设置背景颜色必须先将它设置为不透明的
        Myframe.add(Button1);
        Myframe.add(Button2);
        Myframe.add(Button3);
        Myframe.add(lblLabe);
        
        Button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLabe.setBackground(Color.red);
			}
		});
		Button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLabe.setBackground(Color.green);
			}
		});
		Button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblLabe.setBackground(Color.blue);
			}
		}); 
	}
}
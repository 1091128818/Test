package ʵ���;


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
		// TODO �Զ����ɵķ������
		//��������
    	JFrame Myframe = new JFrame();
    	Myframe.setTitle("�ı��л���ɫ");
		Myframe.setSize(400, 350);
		Myframe.setLayout(new FlowLayout());
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close����
        Myframe.setVisible(true);
        
        JButton Button1 = new JButton("��");
		JButton Button2 = new JButton("��");
		JButton Button3 = new JButton("��");
		JLabel lblLabe = new JLabel("�ı���(��ɫ)"); 
		lblLabe.setOpaque(true);  //�˾����ص㣬���ñ�����ɫ�����Ƚ�������Ϊ��͸����
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
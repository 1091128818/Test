package ʵ���;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main2 extends JFrame {
	public Main2() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // ������ʽ����
		add(new JLabel("�������һ������"));
		JTextField tf1 = new JTextField(3); // �ı���JTextFiled
		add(tf1);

		add(new JLabel("������ڶ�������"));
		JTextField tf2 = new JTextField(3); // �ı���JTextFiled
		add(tf2);

		add(new JLabel("���Ϊ��"));
		JTextField tf3 = new JTextField(5); // �ı���JTextFiled
		add(tf3);

		JButton btnAdd = new JButton("+"); // Add��ť���ö�����ΪbtnAdd
		add(btnAdd);

		btnAdd.addActionListener(new ActionListener() { // ��һ��������

			public void actionPerformed(ActionEvent e) { // ʵ�ֹ��ܵķ���

				double result = Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText());
				tf3.setText(result + ""); // ��result�Ľ��ת��Ϊstring��ʽ��ʾ��tf3��Ӧ���ı�����
			}
		});

		JButton btnSubtract = new JButton("-");
		add(btnSubtract);

		btnSubtract.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double result = Double.parseDouble(tf1.getText()) - Double.parseDouble(tf2.getText());

				tf3.setText(result + "");
			}
		});

		JButton btnMultiply = new JButton("*");
		add(btnMultiply);

		btnMultiply.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double result = Double.parseDouble(tf1.getText()) * Double.parseDouble(tf2.getText());

				tf3.setText(result + "");
			}
		});

		JButton btnDivide = new JButton("/");
		add(btnDivide);

		btnDivide.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				double result = Double.parseDouble(tf1.getText()) / Double.parseDouble(tf2.getText());

				tf3.setText(result + "");
			}
		});
	}

	public static void main(String[] args) {

		Main2 frame = new Main2();

		frame.setTitle("����"); // ���ñ���
		frame.setLocation(500, 400);// ��ָ��λ����ʾ
		frame.setSize(500, 300); // ���ÿ�ĳ�ʼ��С
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* ���ùرհ�ť */
		frame.setVisible(true); // ��ʾ����
	}
}

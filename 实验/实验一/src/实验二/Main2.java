package 实验二;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main2 extends JFrame {
	public Main2() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20)); // 建立流式布局
		add(new JLabel("请输入第一个数："));
		JTextField tf1 = new JTextField(3); // 文本框JTextFiled
		add(tf1);

		add(new JLabel("请输入第二个数："));
		JTextField tf2 = new JTextField(3); // 文本框JTextFiled
		add(tf2);

		add(new JLabel("结果为："));
		JTextField tf3 = new JTextField(5); // 文本框JTextFiled
		add(tf3);

		JButton btnAdd = new JButton("+"); // Add按钮引用对象名为btnAdd
		add(btnAdd);

		btnAdd.addActionListener(new ActionListener() { // 加一个监听器

			public void actionPerformed(ActionEvent e) { // 实现功能的方法

				double result = Double.parseDouble(tf1.getText()) + Double.parseDouble(tf2.getText());
				tf3.setText(result + ""); // 将result的结果转换为string形式显示在tf3对应的文本框中
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

		frame.setTitle("计算"); // 设置标题
		frame.setLocation(500, 400);// 在指定位置显示
		frame.setSize(500, 300); // 设置框的初始大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /* 设置关闭按钮 */
		frame.setVisible(true); // 显示界面
	}
}

package 实验一;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main2 extends JFrame implements ActionListener {// 窗口直接实现了监听接口，整个窗口做监听器
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	JButton yellowButton, blueButton, redButton,greenButton;
	public void Frame() {
		setLocation(500, 300);
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// 创建按钮对象
		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
		greenButton = new JButton("Green");
		buttonPanel = new JPanel();
		// 添加按钮到画板
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		add(buttonPanel);
		// 为每个按钮设置监听器，这里要用this，表示窗口本身
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// //窗口做监听器，要使用e.getSource()方法判断触发事件的事件源
		if (e.getSource() == yellowButton)
			buttonPanel.setBackground(Color.YELLOW);
		if (e.getSource() == blueButton)
			buttonPanel.setBackground(Color.BLUE);
		if (e.getSource() == redButton)
			buttonPanel.setBackground(Color.RED);
		if (e.getSource() == greenButton)
			buttonPanel.setBackground(Color.GREEN);
	}
	public static void main(String agrs[]) {
		new Main2().Frame();
	}
}

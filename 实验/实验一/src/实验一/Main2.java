package ʵ��һ;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main2 extends JFrame implements ActionListener {// ����ֱ��ʵ���˼����ӿڣ�����������������
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;
	JButton yellowButton, blueButton, redButton,greenButton;
	public void Frame() {
		setLocation(500, 300);
		setVisible(true);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		// ������ť����
		yellowButton = new JButton("Yellow");
		blueButton = new JButton("Blue");
		redButton = new JButton("Red");
		greenButton = new JButton("Green");
		buttonPanel = new JPanel();
		// ��Ӱ�ť������
		buttonPanel.add(yellowButton);
		buttonPanel.add(blueButton);
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		add(buttonPanel);
		// Ϊÿ����ť���ü�����������Ҫ��this����ʾ���ڱ���
		yellowButton.addActionListener(this);
		blueButton.addActionListener(this);
		redButton.addActionListener(this);
		greenButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// //��������������Ҫʹ��e.getSource()�����жϴ����¼����¼�Դ
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

package 实验三;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//网格布局
class Myframe extends JFrame {
	private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private JPanel pan3 = new JPanel();
	private JPanel pan4 = new JPanel();
	private JPanel pan5 = new JPanel();
	private JPanel pan6 = new JPanel();
	private JPanel pan7 = new JPanel();
	private JPanel pan8 = new JPanel();
	private JPanel pan9 = new JPanel();
	private JPanel panhobby = new JPanel();
	private JPanel panall = new JPanel(); // 所有的pan
	public JLabel img = new JLabel();
	private JLabel name = new JLabel("姓 名");
	private JLabel sex = new JLabel("性 别");
	private JLabel birth = new JLabel("出生日期");
	private JLabel ty = new JLabel("团 员");
	private JLabel zy = new JLabel("专 业");
	private JLabel hobby = new JLabel("爱好");
	private JLabel home = new JLabel("家庭地址");
	private JLabel grjj = new JLabel("个人简述"); // 所有的label
	private JTextField two = new JTextField(5);
	private JTextField three = new JTextField(10);
	private JTextField four = new JTextField(30); // 所有的text
	private JTextArea area = new JTextArea(4, 50);

	private JTextField result1 = new JTextField(20);
	private JRadioButton radio1 = new JRadioButton("男", true);
	private JRadioButton radio2 = new JRadioButton("女");
	private ButtonGroup radio3 = new ButtonGroup(); // 单选

	private JCheckBox jcb1 = new JCheckBox("睡觉");// 定义一组复选框
	private JCheckBox jcb2 = new JCheckBox("吃饭");
	private JCheckBox jcb3 = new JCheckBox("看书");

	private JTextField result2 = new JTextField(20);
	private JRadioButton radio4 = new JRadioButton("是", true);
	private JRadioButton radio5 = new JRadioButton("否");// 按钮

	private JTextField result3 = new JTextField(20);
	private String[] str = { "计算机", "软件工程", "网络工程" };
	private JComboBox com = new JComboBox(str);// 下拉菜单弹出；下拉菜单合上；下拉菜单取消
	ImageIcon images = new ImageIcon("images/1.gif");// 创建图片对象

	private JScrollPane scrollPane = new JScrollPane(area);

	public Myframe() {// 网格布局的参数
		this.setTitle("个人简历");
		this.setBounds(100, 200, 750, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout gridlay = new GridLayout(9, 1);
		panall.setLayout(new FlowLayout(FlowLayout.LEFT));
		thing();
		this.setVisible(true);

	}

	public void thing() {// 添加标签元素
		img.setIcon(images);
		pan1.add(img);

		pan2.add(name);
		pan2.add(two);

		pan3.add(sex);
		pan3.add(radio1);
		pan3.add(radio2);
		radio3.add(radio1);
		radio3.add(radio2);
		result1.setEditable(false);

		panhobby.add(hobby);
		panhobby.add(jcb1);
		panhobby.add(jcb2);
		panhobby.add(jcb3);

		pan4.add(birth);
		pan4.add(three);

		pan5.add(ty);
		pan5.add(radio4);
		pan5.add(radio5);
		result2.setEditable(false);

		pan6.add(zy);
		pan6.add(com);
		pan6.add(result3);
		com.addItemListener(new ItemHandler());

		pan7.add(home);
		pan7.add(four);
		this.add(pan7);
		pan8.add(grjj);
		pan8.add(area);
		area.setLineWrap(true);

		this.add(panall);// 把所有面板放入10
		panall.add(pan2);
		panall.add(pan3);
		panall.add(pan4);
		panall.add(pan5);
		panall.add(pan1);
		panall.add(pan6);
		panall.add(panhobby);
		panall.add(pan7);
		panall.add(pan8);
		panall.add(pan9);
	}
	// 单选动作事件处理
	class ItemHandler implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			StringBuffer str3 = new StringBuffer("你选择的专业是:");
			if (com.getSelectedIndex() == 0) {
				str3.append("计算机");
			}
			if (com.getSelectedIndex() == 1) {
				str3.append("软件工程");
			}
			if (com.getSelectedIndex() == 2) {
				str3.append("网络工程");
			}
			result3.setText(str3.toString());
		}
	}

}

public class Main {
	public static void main(String[] args) {

		new Myframe();
	}
}
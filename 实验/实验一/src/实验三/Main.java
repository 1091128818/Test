package ʵ����;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//���񲼾�
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
	private JPanel panall = new JPanel(); // ���е�pan
	public JLabel img = new JLabel();
	private JLabel name = new JLabel("�� ��");
	private JLabel sex = new JLabel("�� ��");
	private JLabel birth = new JLabel("��������");
	private JLabel ty = new JLabel("�� Ա");
	private JLabel zy = new JLabel("ר ҵ");
	private JLabel hobby = new JLabel("����");
	private JLabel home = new JLabel("��ͥ��ַ");
	private JLabel grjj = new JLabel("���˼���"); // ���е�label
	private JTextField two = new JTextField(5);
	private JTextField three = new JTextField(10);
	private JTextField four = new JTextField(30); // ���е�text
	private JTextArea area = new JTextArea(4, 50);

	private JTextField result1 = new JTextField(20);
	private JRadioButton radio1 = new JRadioButton("��", true);
	private JRadioButton radio2 = new JRadioButton("Ů");
	private ButtonGroup radio3 = new ButtonGroup(); // ��ѡ

	private JCheckBox jcb1 = new JCheckBox("˯��");// ����һ�鸴ѡ��
	private JCheckBox jcb2 = new JCheckBox("�Է�");
	private JCheckBox jcb3 = new JCheckBox("����");

	private JTextField result2 = new JTextField(20);
	private JRadioButton radio4 = new JRadioButton("��", true);
	private JRadioButton radio5 = new JRadioButton("��");// ��ť

	private JTextField result3 = new JTextField(20);
	private String[] str = { "�����", "�������", "���繤��" };
	private JComboBox com = new JComboBox(str);// �����˵������������˵����ϣ������˵�ȡ��
	ImageIcon images = new ImageIcon("images/1.gif");// ����ͼƬ����

	private JScrollPane scrollPane = new JScrollPane(area);

	public Myframe() {// ���񲼾ֵĲ���
		this.setTitle("���˼���");
		this.setBounds(100, 200, 750, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GridLayout gridlay = new GridLayout(9, 1);
		panall.setLayout(new FlowLayout(FlowLayout.LEFT));
		thing();
		this.setVisible(true);

	}

	public void thing() {// ��ӱ�ǩԪ��
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

		this.add(panall);// ������������10
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
	// ��ѡ�����¼�����
	class ItemHandler implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			StringBuffer str3 = new StringBuffer("��ѡ���רҵ��:");
			if (com.getSelectedIndex() == 0) {
				str3.append("�����");
			}
			if (com.getSelectedIndex() == 1) {
				str3.append("�������");
			}
			if (com.getSelectedIndex() == 2) {
				str3.append("���繤��");
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
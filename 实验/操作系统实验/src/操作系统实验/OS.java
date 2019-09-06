package 操作系统实验;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OS extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4;//,b5
	JTable table;
	JTextField j2, j3;
	String str = JOptionPane.showInputDialog("请输入进程数：");
	int N = Integer.parseInt(str);
	String process_num = null;
	String arrive_time = null;
	String service_time = null;
	String start_time = null, end_time = null, total_time = null, weightotal_time = null;
	String a[][] = new String[N][7];
	String[] name = { "进程号", "提交时间", "运行时间", "开始时间", "结束时间", "周转时间", "带权周转时间" };
	double avgtotal_time, avgweightotal_time;

	public OS() {
		super("模拟进程调度算法实验");
		Container c = getContentPane();
		GridBagLayout f = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		c.setLayout(f);

		table = new JTable(a, name);
		JScrollPane p1 = new JScrollPane(table);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 60;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		f.setConstraints(p1, gbc);
		c.add(p1);

		JLabel label6;
		label6 = new JLabel("请输入" + N + "组[进程号]+[提交时间]+[运行时]：");
		label6.setFont(new Font("楷体", Font.CENTER_BASELINE, 16));
		label6.setForeground(new Color(250, 0, 0));
		gbc.gridwidth = GridBagConstraints.REMAINDER;

		gbc.gridheight = 1;
		f.setConstraints(label6, gbc);
		c.add(label6);

		JLabel label7 = new JLabel("  ");
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		f.setConstraints(label7, gbc);
		c.add(label7);

		JLabel label2 = new JLabel("平均周转时间:");
		label2.setFont(new Font("楷体", Font.BOLD, 12));
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(label2, gbc);
		c.add(label2);

		j2 = new JTextField(10);
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(j2, gbc);
		j2.setText("" + avgtotal_time);
		c.add(j2);

		JLabel label3 = new JLabel("平均带权周转时间:");
		label3.setFont(new Font("楷体", Font.BOLD, 12));
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(label3, gbc);
		c.add(label3);
		gbc.gridheight = 1;

		j3 = new JTextField(1);
		gbc.ipadx = 1;
		gbc.ipady = 1;
		;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		f.setConstraints(j3, gbc);
		j3.setText("" + avgweightotal_time);
		c.add(j3);

		b1 = new JButton("先来先服务");
		b1.setFont(new Font("楷体", Font.BOLD, 15));
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(b1, gbc);
		c.add(b1);

		b2 = new JButton("短作业优先");
		b2.setFont(new Font("楷体", Font.BOLD, 15));
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(b2, gbc);
		c.add(b2);

		b3 = new JButton("时间片轮转");
		b3.setFont(new Font("楷体", Font.BOLD, 15));
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		f.setConstraints(b3, gbc);
		c.add(b3);

		b4 = new JButton("高响应比优先");
		b4.setFont(new Font("楷体", Font.BOLD, 15));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		f.setConstraints(b4, gbc);
		c.add(b4);
		
		/*b5 = new JButton("高优先权优先");
		b5.setFont(new Font("楷体", Font.BOLD, 15));
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.gridheight = 1;
		f.setConstraints(b5, gbc);
		c.add(b5);*/
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		//b5.addActionListener(this);

		setSize(500, 580);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for (int i = 0; i < N; i++)
			for (int j = 0; j < 3; j++) {
				System.out.println(a[i][j]);
			}
	}

	public void actionPerformed(ActionEvent e) {
		int i, j, n, p, h;

		double t, s, m;
		double b[][] = new double[N][7];

		if (e.getSource().equals(b1))// /////////////////////////////先来先服务
		{
			try {
				for (i = 0; i < N; i++) {
					for (j = 0; j < 3; j++) {
						b[i][j] = Double.parseDouble(a[i][j]);
					}
				}
				for (i = 0; i < N; i++) {
					for (j = 0; j < N; j++) {
						if (b[i][1] <= b[j][1]) {
							t = b[i][1];
							b[i][1] = b[j][1];
							b[j][1] = t;
							s = b[i][2];
							b[i][2] = b[j][2];
							b[j][2] = s;
							m = b[i][0];
							b[i][0] = b[j][0];
							b[j][0] = m;
						}
					}
				}

				b[0][3] = b[0][1];
				b[0][4] = b[0][3] + b[0][2];
				b[0][5] = b[0][4] - b[0][1];
				b[0][6] = b[0][5] / b[0][2];
				for (i = 1; i < N; i++) {
					if (b[i - 1][4] >= b[i][1]) {
						b[i][3] = b[i - 1][4];
						b[i][4] = b[i][3] + b[i][2];
						b[i][5] = b[i][4] - b[i][1];
						b[i][6] = b[i][5] / b[i][2];
					} else {
						b[i][3] = b[i][1];
						b[i][4] = b[i][3] + b[i][2];
						b[i][5] = b[i][4] - b[i][1];
						b[i][6] = b[i][5] / b[i][2];
					}

				}
				for (i = 0; i < N; i++) {
					for (j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}

			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		if (e.getSource().equals(b2))// /////////////////////////////短作业优先
		{
			try {
				for (i = 0; i < N; i++) {
					for (j = 0; j < 3; j++) {
						b[i][j] = Double.parseDouble(a[i][j]);
					}
				}
				for (i = 0; i < N; i++) {
					for (j = 0; j < N; j++) {
						if (b[i][1] < b[j][1]) {
							t = b[i][1];
							b[i][1] = b[j][1];
							b[j][1] = t;
							s = b[i][2];
							b[i][2] = b[j][2];
							b[j][2] = s;
							m = b[i][0];
							b[i][0] = b[j][0];
							b[j][0] = m;
						}
					}
				}

				b[0][3] = b[0][1];

				b[0][4] = b[0][3] + b[0][2];

				b[0][5] = b[0][4] - b[0][1];
				b[0][6] = b[0][5] / b[0][2];

				for (i = 1; i < N; i++) {
					if (b[i - 1][4] >= b[i][1]) {
						for (j = i; j < N; j++) {
							if (b[i - 1][4] < b[j][1]) {
								h = j;
								for (p = i; p < h; p++) {
									for (n = i; n < h; n++) {
										if (b[p][2] < b[n][2]) {
											t = b[p][1];
											b[p][1] = b[n][1];
											b[n][1] = t;
											s = b[p][2];
											b[p][2] = b[n][2];
											b[n][2] = s;
											m = b[p][0];
											b[p][0] = b[n][0];
											b[n][0] = m;
										}
									}
								}
								b[i][3] = b[i - 1][4];
								b[i][4] = b[i][3] + b[i][2];
								b[i][5] = b[i][4] - b[i][1];
								b[i][6] = b[i][5] / b[i][2];
							}
						}

						if (b[i - 1][4] >= b[N - 1][1]) {
							for (p = i; p < N; p++) {
								for (n = i; n < N; n++) {
									if (b[p][2] < b[n][2]) {
										t = b[p][1];
										b[p][1] = b[n][1];
										b[n][1] = t;
										s = b[p][2];
										b[p][2] = b[n][2];
										b[n][2] = s;
										m = b[p][0];
										b[p][0] = b[n][0];
										b[n][0] = m;
									}

								}
							}
							b[i][3] = b[i - 1][4];
							b[i][4] = b[i][3] + b[i][2];
							b[i][5] = b[i][4] - b[i][1];
							b[i][6] = b[i][5] / b[i][2];
						}
					}
					if (b[i - 1][4] < b[i][1]) {
						b[i][3] = b[i][1];
						b[i][4] = b[i][3] + b[i][2];
						b[i][5] = b[i][4] - b[i][1];
						b[i][6] = b[i][5] / b[i][2];
					}
				}

				for (i = 0; i < N; i++) {
					for (j = 0; j < 7; j++) {
						table.setValueAt("" + b[i][j], i, j);
					}
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}

		if (e.getSource().equals(b3))// /////////////////////////////时间片轮转
		{
			JTextField txt = new JTextField(5);
			String val = JOptionPane.showInputDialog("请输入时间片：");
			txt.setText(val);
			Double slice = Double.parseDouble(txt.getText());

			// /////////////////////////////时间片轮转法
			int t0 = 1, t1 = 0, m1 = 1, m0 = 0;
			Double c[] = new Double[N];
			for (i = 0; i < c.length; i++)
				c[i] = 0.0;
			for (i = 0; i < N; i++) {
				for (j = 0; j < 3; j++) {
					b[i][j] = Double.parseDouble(a[i][j]);
				}
			}

			for (i = 0; i < N; i++) {
				for (j = 0; j < N; j++) {
					if (b[i][1] <= b[j][1]) {
						t = b[i][1];
						b[i][1] = b[j][1];
						b[j][1] = t;
						s = b[i][2];
						b[i][2] = b[j][2];
						b[j][2] = s;
						m = b[i][0];
						b[i][0] = b[j][0];
						b[j][0] = m;
					}
				}
			}
			Double r = b[0][1];

			b[0][3] = b[0][1];

			while (t0 == 1) {
				t1 = 0;
				for (i = m0; i < m1 + m0; i++) {
					if (c[i] < b[i][2]) {
						t1 = 1;
						break;
					}
				}
				if (t1 == 1) {
					for (i = m0; i < m1 + m0; i++) {
						if (c[i] < b[i][2]) {
							c[i] = c[i] + slice;
							r = r + slice;
							if (c[i] == b[i][2])
								b[i][4] = r;
						}
					}

					while (m1 <= N - 1) {
						if (b[m1][1] <= r) {
							b[m1][3] = r;
							c[m1] = c[m1] + slice;
							r = r + slice;
							m1 = m1 + 1;
						}
					}
				}

				else {
					for (i = 0; i < N; i++) {
						if (c[i] == 0.0) {
							m0 = i;
							r = r + b[i][1];
							break;
						}
						b[m0][3] = b[m0][1];
					}
				}

				t0 = 0;
				for (i = 0; i < N; i++)
					if (c[i] < b[i][2]) {
						t0 = 1;
						break;
					}

			}

			for (i = 0; i < N; i++) {
				b[i][5] = b[i][4] - b[i][1];
				b[i][6] = b[i][5] / b[i][2];
			}

			for (i = 0; i < N; i++) {
				for (j = 0; j < 7; j++) {
					table.repaint();
					table.setValueAt("" + b[i][j], i, j);
				}
			}

		}

		if (e.getSource().equals(b4))// /////////////////////////////高响应比优先调度
		{
			double tt, ss, mm;
			double d[] = new double[N];
			try {
				for (i = 0; i < N; i++) {
					for (j = 0; j < 3; j++) {
						b[i][j] = Double.parseDouble(a[i][j]);
					}
				}

				for (i = 0; i < N; i++) {
					for (j = 0; j < N; j++) {
						if (b[i][1] < b[j][1]) {
							t = b[i][1];
							b[i][1] = b[j][1];
							b[j][1] = t;
							s = b[i][2];
							b[i][2] = b[j][2];
							b[j][2] = s;
							m = b[i][0];
							b[i][0] = b[j][0];
							b[j][0] = m;
						}
					}
				}

				b[0][3] = b[0][1];
				b[0][4] = b[0][3] + b[0][2];
				b[0][5] = b[0][4] - b[0][1];
				b[0][6] = b[0][5] / b[0][2];
				for (i = 1; i < N; i++) {
					for (j = i; j < N; j++) {
						d[j] = (b[i - 1][4] - b[j][1] + b[j][2]) / b[j][2];
					}
					if (b[i - 1][4] >= b[i][1]) {
						for (j = i; j < N; j++) {
							for (p = i; p < N; p++) {
								if (d[j] >= d[p]) {
									t = d[j];
									d[j] = d[p];
									d[p] = t;
									tt = b[j][0];
									b[j][0] = b[p][0];
									b[p][0] = tt;
									s = d[j];
									d[j] = d[p];
									d[p] = s;
									ss = b[j][1];
									b[j][1] = b[p][1];
									b[p][1] = ss;
									m = d[j];

									d[j] = d[p];
									d[p] = m;
									mm = b[j][2];
									b[j][2] = b[p][2];
									b[p][2] = mm;
								}
							}
						}

						b[i][3] = b[i - 1][4];
						b[i][4] = b[i][3] + b[i][2];
						b[i][5] = b[i][4] - b[i][1];
						b[i][6] = b[i][5] / b[i][2];

					} else {
						b[i][3] = b[i][1];
						b[i][4] = b[i][3] + b[i][2];
						b[i][5] = b[i][4] - b[i][1];
						b[i][6] = b[i][5] / b[i][2];

					}
				}
				for (i = 0; i < N; i++) {
					for (j = 0; j < 7; j++) {
						table.repaint();
						table.setValueAt("" + b[i][j], i, j);
					}
				}
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		}
		for (i = 0; i < N; i++) {
			avgtotal_time = avgtotal_time + b[i][5];
			avgweightotal_time = avgweightotal_time + b[i][6];
		}
		avgtotal_time = avgtotal_time / N;
		j2.setText("" + avgtotal_time);
		avgweightotal_time = avgweightotal_time / N;
		j3.setText("" + avgweightotal_time);
	}

	public static void main(String args[]) {
		OS a = new OS();

	}
}

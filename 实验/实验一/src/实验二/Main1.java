package  µ—È∂˛;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Main1 extends JFrame {
	public Main1() {
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	@Override
	public void paint(Graphics g) {
		g.drawOval(100, 50, 100, 100);
		// ÃÓ≥‰Õ÷‘≤–Œ
		g.fillOval(100, 50, 100, 100);
		g.setColor(Color.RED);
		// ª≠Õ÷‘≤–Œ
		g.drawOval(220, 110, 100, 50);
		// ÃÓ≥‰‘≤–Œ
		g.fillOval(220, 110, 100, 50);
		// ª≠‘≤ª°
		g.setColor(Color.BLUE);
		g.drawArc(5, 220, 100, 100, 30, 150);
		g.fillArc(5, 220, 100, 100, 30, 150);

	}

	public static void main(String[] args) {
		new Main1().setVisible(true);
	}
}

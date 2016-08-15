package helloWorld;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		f.add(p);
		f.setResizable(true);
		f.setEnabled(true);
		f.setVisible(true);
		f.setSize(200,200);
	}

}

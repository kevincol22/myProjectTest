package myProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import util.ReadFile;

public class MainFrame extends JFrame {

	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setVisible(true);
		this.setBounds(500, 300, 500, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
	}

	private void init() {
		// ��ʼ���˵���
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		JMenu systemMenu = new JMenu("System");
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitMenuItem = new JMenuItem("exit");
		JMenuItem openFileMenuItem = new JMenuItem("openFile");
		menuBar.add(systemMenu);
		menuBar.add(fileMenu);
		systemMenu.add(exitMenuItem);
		fileMenu.add(openFileMenuItem);

		// ��Ӽ���
		openFileMenuItem.addActionListener(new OpenFileMenuItemListener());
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	/*
	 * ���ļ� ����ͼƬ
	 */
	private class OpenFileMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// ѡ���ļ�
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int n = jfc.showDialog(new JLabel(), "ѡ��");
			if (n == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();

				// if (file.isDirectory()) {
				// System.out.println("�ļ���:" + file.getAbsolutePath());
				// } else if (file.isFile()) {
				// System.out.println("�ļ�:" + file.getAbsolutePath());
				// }
				// System.out.println(jfc.getSelectedFile().getName());

				// �õ��ļ�·��
				String filePath = file.getAbsolutePath();
				ArrayList<String[]> fileList = new ReadFile()
						.readFile(filePath);

				// �õ�ÿһ�е�ʵ�ʺ�Ԥ���Ƕ�ֵ �������ݼ� defaultcategorydataset
				DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
				for (int i = 0; i < fileList.size(); i++) {
					String[] sa = fileList.get(i);
					String s1 = sa[3];
					Double d1 = Double.parseDouble(s1);
					defaultcategorydataset.addValue(d1, "ʵ�ʷ�λ��",
							String.valueOf(i));

					String s2 = sa[5];
					Double d2 = Double.parseDouble(s2);
					defaultcategorydataset.addValue(d2, "Ԥ����λ��",
							String.valueOf(i));

				}
				// ����ͼ��
				JFreeChart jfreechart = ChartFactory.createLineChart(
						"����ͼ Demo 1", "Type", "Value", defaultcategorydataset,
						PlotOrientation.VERTICAL, true, true, false);
				CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
				categoryplot.setBackgroundPaint(Color.lightGray);
				categoryplot.setRangeGridlinePaint(Color.white);
				// ChartFrame
				ChartFrame frame = new ChartFrame("����ͼ ", jfreechart, true);
				frame.pack();
				frame.setVisible(true);
			}
		}
	}
}

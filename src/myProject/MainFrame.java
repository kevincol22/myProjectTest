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
	 * 主界面
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		this.setVisible(true);
		this.setBounds(500, 300, 500, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		init();
	}

	private void init() {
		// 初始化菜单栏
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

		// 添加监听
		openFileMenuItem.addActionListener(new OpenFileMenuItemListener());
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	/*
	 * 打开文件 制作图片
	 */
	private class OpenFileMenuItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// 选择文件
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int n = jfc.showDialog(new JLabel(), "选择");
			if (n == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();

				// if (file.isDirectory()) {
				// System.out.println("文件夹:" + file.getAbsolutePath());
				// } else if (file.isFile()) {
				// System.out.println("文件:" + file.getAbsolutePath());
				// }
				// System.out.println(jfc.getSelectedFile().getName());

				// 拿到文件路径
				String filePath = file.getAbsolutePath();
				ArrayList<String[]> fileList = new ReadFile()
						.readFile(filePath);

				// 拿到每一行的实际和预报角度值 构建数据集 defaultcategorydataset
				DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
				for (int i = 0; i < fileList.size(); i++) {
					String[] sa = fileList.get(i);
					String s1 = sa[3];
					Double d1 = Double.parseDouble(s1);
					defaultcategorydataset.addValue(d1, "实际方位角",
							String.valueOf(i));

					String s2 = sa[5];
					Double d2 = Double.parseDouble(s2);
					defaultcategorydataset.addValue(d2, "预报方位角",
							String.valueOf(i));

				}
				// 构建图表
				JFreeChart jfreechart = ChartFactory.createLineChart(
						"折线图 Demo 1", "Type", "Value", defaultcategorydataset,
						PlotOrientation.VERTICAL, true, true, false);
				CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
				categoryplot.setBackgroundPaint(Color.lightGray);
				categoryplot.setRangeGridlinePaint(Color.white);
				// ChartFrame
				ChartFrame frame = new ChartFrame("折线图 ", jfreechart, true);
				frame.pack();
				frame.setVisible(true);
			}
		}
	}
}

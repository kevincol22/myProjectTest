package jFreeChartTest;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import util.ReadFile;

public class Test {
	static {
		// ����������ʽ
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// ���ñ�������
		standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
		// ����ͼ��������
		standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		// �������������
		standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
		// Ӧ��������ʽ
		ChartFactory.setChartTheme(standardChartTheme);
		/*
		 * �����ǽ��������������ķ���
		 */
	}

	public static void main(String[] args) {
		// �������ݼ�
		String series1 = "First";
		String series2 = "Second";
		// String series3 = "Third";
		// String type1 = "2001";
		// String type2 = "2002";
		// String type3 = "2003";
		// String type4 = "2004";
		// String type5 = "2005";
		// String type6 = "2006";
		// String type7 = "2007";
		// String type8 = "2008";
		DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();

		ReadFile rf = new ReadFile();
		ArrayList<String[]> fileList = rf
				.readFile("e:\\FY3C_14739_SSS_39260_20160728014903_20160728020120.txt");
		for (int i = 0; i < fileList.size(); i++) {
			String[] sa = fileList.get(i);
			String s1 = sa[4];
			Double d1 = Double.parseDouble(s1);
			System.out.println(d1);
			defaultcategorydataset.addValue(d1, "ʵ�ʸ�����", String.valueOf(i));

			String s2 = sa[6];
			Double d2 = Double.parseDouble(s2);
			defaultcategorydataset.addValue(d2, "Ԥ��������", String.valueOf(i));

		}
		// defaultcategorydataset.addValue(1.0D, series1, type1);
		// defaultcategorydataset.addValue(4D, series1, type2);
		// defaultcategorydataset.addValue(3D, series1, type3);
		// defaultcategorydataset.addValue(5D, series1, type4);
		// defaultcategorydataset.addValue(5D, series1, type5);
		// defaultcategorydataset.addValue(7D, series1, type6);
		// defaultcategorydataset.addValue(7D, series1, type7);
		// defaultcategorydataset.addValue(8D, series1, type8);
		//
		// defaultcategorydataset.addValue(5D, series2, type1);
		// defaultcategorydataset.addValue(7D, series2, type2);
		// defaultcategorydataset.addValue(6D, series2, type3);
		// defaultcategorydataset.addValue(8D, series2, type4);
		// defaultcategorydataset.addValue(4D, series2, type5);
		// defaultcategorydataset.addValue(4D, series2, type6);
		// defaultcategorydataset.addValue(2D, series2, type7);
		// defaultcategorydataset.addValue(1.0D, series2, type8);
		//
		// defaultcategorydataset.addValue(4D, series3, type1);
		// defaultcategorydataset.addValue(3D, series3, type2);
		// defaultcategorydataset.addValue(2D, series3, type3);
		// defaultcategorydataset.addValue(3D, series3, type4);
		// defaultcategorydataset.addValue(6D, series3, type5);
		// defaultcategorydataset.addValue(3D, series3, type6);
		// defaultcategorydataset.addValue(4D, series3, type7);
		// defaultcategorydataset.addValue(3D, series3, type8);
		//
		JFreeChart jfreechart = ChartFactory.createLineChart("����ͼ Demo 1",
				"Type", "Value", defaultcategorydataset,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinePaint(Color.white);
		//
		ChartFrame frame = new ChartFrame("����ͼ ", jfreechart, true);
		frame.pack();
		frame.setVisible(true);
		// ���chartFrame�ر�ʱ�Ķ���
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int i = JOptionPane
						.showConfirmDialog(null, "ȷ���رգ�", "��ʾ��Ϣ",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (i == 0) {
					frame.dispose();
				} else
					return;
			}
		});
	}
}

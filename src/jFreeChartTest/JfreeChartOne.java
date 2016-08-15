package jFreeChartTest;

/**
 * ������״ͼ
 */
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.general.DefaultPieDataset;

public class JfreeChartOne {
	public static void main(String[] args) {
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

		// ������ͼ���ݶ���
		DefaultPieDataset dfp = new DefaultPieDataset();
		dfp.setValue("������Ա", 25);
		dfp.setValue("�г���Ա", 35);
		dfp.setValue("������Ա", 20);
		dfp.setValue("������Ա", 5);
		dfp.setValue("������Ա", 15);
		// Create JFreeChart object
		JFreeChart a = ChartFactory.createPieChart("CityInfoPort��˾��֯�ܹ�ͼ", dfp,
				true, true, true);
		ChartFrame frame = new ChartFrame("CityInfoPort��˾��֯�ܹ�ͼ ", a, true);
		frame.pack();
		frame.setVisible(true);

//		FileOutputStream fos_jpg = null;
//		try {
//			fos_jpg = new FileOutputStream("e:\\Pie3DChart.jpg");
//			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, a, 400, 300, null);
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				fos_jpg.close();
//			} catch (Exception e) {
//			}
//		}
	
	}

}

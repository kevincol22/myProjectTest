package jFreeChartTest;
/**
 *����3d��״ͼ
 */
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JfreeChartTwo{
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
		// �������ͼ��Category�����ݶ���
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(100, "����", "ƻ��");
		dataset.addValue(100, "�Ϻ�", "ƻ��");
		dataset.addValue(100, "����", "ƻ��");
		dataset.addValue(200, "����", "����");
		dataset.addValue(200, "�Ϻ�", "����");
		dataset.addValue(200, "����", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(300, "�Ϻ�", "����");
		dataset.addValue(300, "����", "����");
		dataset.addValue(400, "����", "�㽶");
		dataset.addValue(400, "�Ϻ�", "�㽶");
		dataset.addValue(400, "����", "�㽶");
		dataset.addValue(500, "����", "��֦");
		dataset.addValue(500, "�Ϻ�", "��֦");
		dataset.addValue(500, "����", "��֦");
		JFreeChart chart = ChartFactory.createBarChart3D("ˮ������ͼ", "ˮ��", "ˮ��",
				dataset, PlotOrientation.VERTICAL, true, true, true);
		ChartFrame frame = new ChartFrame("ˮ������ͼ ", chart, true);
		frame.pack();
		frame.setVisible(true);
	}
}

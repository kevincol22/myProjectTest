package jFreeChartTest;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
/**
 * ��Test1�ع� refactor Test1
 * @author dell
 *
 */
public class JfreeChartOne1 extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

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

	public JfreeChartOne1(String s) {
		super(s);
		setContentPane(createJPanel());
	}

	public static void main(String[] args) {
		JfreeChartOne1 one = new JfreeChartOne1("CityInfoPort��˾��֯�ܹ�ͼ");
		one.pack();
		one.setVisible(true);
	}

	// ���þ�̬�����趨����Դ(��״ͼ)
	public static PieDataset createPieDataset() {
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		defaultpiedataset.setValue("������Ա", 10.02D);
		defaultpiedataset.setValue("�г���Ա", 20.23D);
		defaultpiedataset.setValue("������Ա", 60.02D);
		defaultpiedataset.setValue("OEM��Ա", 10.02D);
		defaultpiedataset.setValue("������Ա", 5.11D);
		return defaultpiedataset;
	}

	// ͨ��ChartFactory����JFreeChart��ʵ��
	public static JFreeChart createJFreeChart(PieDataset p) {
		JFreeChart a = ChartFactory.createPieChart("CityInfoPort��˾��֯�ܹ�ͼ", p,
				true, true, true);
		PiePlot pie = (PiePlot) a.getPlot();
		pie.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
		pie.setNoDataMessage("No data available");
		pie.setCircular(true);
		pie.setLabelGap(0.01D);// ���
		return a;
	}

	public static JPanel createJPanel() {
		JFreeChart jfreechart = createJFreeChart(createPieDataset());
		return new ChartPanel(jfreechart);
	}
}

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
 * 对Test1重构 refactor Test1
 * @author dell
 *
 */
public class JfreeChartOne1 extends ApplicationFrame {
	private static final long serialVersionUID = 1L;

	static {
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
		/*
		 * 以上是解决中文乱码问题的方法
		 */
	}

	public JfreeChartOne1(String s) {
		super(s);
		setContentPane(createJPanel());
	}

	public static void main(String[] args) {
		JfreeChartOne1 one = new JfreeChartOne1("CityInfoPort公司组织架构图");
		one.pack();
		one.setVisible(true);
	}

	// 利用静态方法设定数据源(饼状图)
	public static PieDataset createPieDataset() {
		DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
		defaultpiedataset.setValue("管理人员", 10.02D);
		defaultpiedataset.setValue("市场人员", 20.23D);
		defaultpiedataset.setValue("开发人员", 60.02D);
		defaultpiedataset.setValue("OEM人员", 10.02D);
		defaultpiedataset.setValue("其他人员", 5.11D);
		return defaultpiedataset;
	}

	// 通过ChartFactory创建JFreeChart的实例
	public static JFreeChart createJFreeChart(PieDataset p) {
		JFreeChart a = ChartFactory.createPieChart("CityInfoPort公司组织架构图", p,
				true, true, true);
		PiePlot pie = (PiePlot) a.getPlot();
		pie.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
		pie.setNoDataMessage("No data available");
		pie.setCircular(true);
		pie.setLabelGap(0.01D);// 间距
		return a;
	}

	public static JPanel createJPanel() {
		JFreeChart jfreechart = createJFreeChart(createPieDataset());
		return new ChartPanel(jfreechart);
	}
}

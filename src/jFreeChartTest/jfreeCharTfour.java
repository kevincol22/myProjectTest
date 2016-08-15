package jFreeChartTest;
/**
 * 折线图2
 */
import java.awt.Font;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class jfreeCharTfour {
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

	public static void main(String[] args) {
		XYSeries xyseries = new XYSeries("First"); // 先产生XYSeries 对象
		xyseries.add(1.0D, 1.0D);
		xyseries.add(2D, 4D);
		xyseries.add(3D, 3D);
		xyseries.add(4D, 5D);
		xyseries.add(5D, 5D);
		xyseries.add(6D, 7D);
		xyseries.add(7D, 7D);
		xyseries.add(8D, 8D);

		XYSeries xyseries1 = new XYSeries("Second");
		xyseries1.add(1.0D, 5D);
		xyseries1.add(2D, 7D);
		xyseries1.add(3D, 6D);
		xyseries1.add(4D, 8D);
		xyseries1.add(5D, 4D);
		xyseries1.add(6D, 4D);
		xyseries1.add(7D, 2D);
		xyseries1.add(8D, 1.0D);

		XYSeries xyseries2 = new XYSeries("Third");
		xyseries2.add(3D, 4D);
		xyseries2.add(4D, 3D);
		xyseries2.add(5D, 2D);
		xyseries2.add(6D, 3D);
		xyseries2.add(7D, 6D);
		xyseries2.add(8D, 3D);
		xyseries2.add(9D, 4D);
		xyseries2.add(10D, 3D);

		XYSeriesCollection xyseriescollection = new XYSeriesCollection(); // 再用XYSeriesCollection添加入XYSeries
																			// 对象
		xyseriescollection.addSeries(xyseries);
		xyseriescollection.addSeries(xyseries1);
		xyseriescollection.addSeries(xyseries2);
		JFreeChart jfreechart = ChartFactory.createXYLineChart(
				"Line Chart Demo 2", "X", "Y", xyseriescollection,
				PlotOrientation.VERTICAL, true, true, false);
		ChartFrame frame = new ChartFrame("折线图 ", jfreechart, true);
		frame.pack();
		frame.setVisible(true);

	}

}

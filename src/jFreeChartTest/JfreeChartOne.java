package jFreeChartTest;

/**
 * 创建饼状图
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

		// 创建饼图数据对象
		DefaultPieDataset dfp = new DefaultPieDataset();
		dfp.setValue("管理人员", 25);
		dfp.setValue("市场人员", 35);
		dfp.setValue("开发人员", 20);
		dfp.setValue("后勤人员", 5);
		dfp.setValue("财务人员", 15);
		// Create JFreeChart object
		JFreeChart a = ChartFactory.createPieChart("CityInfoPort公司组织架构图", dfp,
				true, true, true);
		ChartFrame frame = new ChartFrame("CityInfoPort公司组织架构图 ", a, true);
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

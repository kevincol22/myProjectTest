package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 读轨迹文件 按行（String[]）装到list中
 * 一行由一个String数组保存，一个文件有一个ArrayList保存
 */
import java.util.ArrayList;

public class ReadFile {
	private ArrayList<String[]> fileList = new ArrayList<String[]>();// 保存文件的list

	/**
	 * 
	 * @param filePath
	 * @return 保存整个轨迹文件到一个list中（除了第一行）
	 */
	public ArrayList<String[]> readFile(String filePath) {
		BufferedReader br = null;
		try {
			String s = null;// 保存一行
			String[] sa = null;// 把一行数据按空格分开（split）
			br = new BufferedReader(new FileReader(filePath));
			br.readLine();// 不要第一行
			while ((s = br.readLine()) != null) {
				sa = s.split("\\s");// 将s分割
				// System.out.println(sa.length);
				sa = trimArray(sa);// 去除数组sa中的空元素
				// System.out.println(sa.length);
				fileList.add(sa);// 逐行保存到list中
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return fileList;
	}

	/**
	 * 利用StringBuffer去除字符串数组中的空值
	 * 
	 * @param sa
	 * @return
	 */
	private String[] trimArray(String[] sa) {
		// 用StringBuffer来存放数组中的非空元素，用“;”分隔
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sa.length; i++) {
			if ("".equals(sa[i])) {
				continue;
			}
			sb.append(sa[i]);
			if (i != sa.length - 1) {
				sb.append(";");
			}
		}
		// 用String的split方法分割，得到数组
		sa = sb.toString().split(";");
		return sa;
	}

	/**
	 * 利用ArrayList去除字符串数组中的空值
	 * 
	 * @param sa
	 * @return
	 */
	private String[] trimArray2(String[] sa) {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < sa.length; i++) {
			if (!("".equals(sa[i]))) {
				list.add(sa[i]);
			}
		}
		sa = list.toArray(new String[0]);
		return sa;
	}

	public static void main(String[] args) {
		// String[] sa = { "1", "2", "", "", "3" };
		// System.out.println(sa.length);
		// sa = new ReadFile().trimArray2(sa);
		// System.out.println(sa.length);

		ArrayList<String[]> fileList = new ReadFile()
				.readFile("e:\\FY3C_14739_SSS_39260_20160728014903_20160728020120.txt");
		ArrayList<Double> list = new ArrayList<Double>();
		for (String[] sa : fileList) {
			String s = sa[4].substring(1);
			Double i = Double.parseDouble(s);
			list.add(i);
		}
		for (Double d : list) {
			System.out.println(d);
		}
		System.out.println(list.size());
	}

}

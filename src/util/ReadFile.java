package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * ���켣�ļ� ���У�String[]��װ��list��
 * һ����һ��String���鱣�棬һ���ļ���һ��ArrayList����
 */
import java.util.ArrayList;

public class ReadFile {
	private ArrayList<String[]> fileList = new ArrayList<String[]>();// �����ļ���list

	/**
	 * 
	 * @param filePath
	 * @return ���������켣�ļ���һ��list�У����˵�һ�У�
	 */
	public ArrayList<String[]> readFile(String filePath) {
		BufferedReader br = null;
		try {
			String s = null;// ����һ��
			String[] sa = null;// ��һ�����ݰ��ո�ֿ���split��
			br = new BufferedReader(new FileReader(filePath));
			br.readLine();// ��Ҫ��һ��
			while ((s = br.readLine()) != null) {
				sa = s.split("\\s");// ��s�ָ�
				// System.out.println(sa.length);
				sa = trimArray(sa);// ȥ������sa�еĿ�Ԫ��
				// System.out.println(sa.length);
				fileList.add(sa);// ���б��浽list��
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
	 * ����StringBufferȥ���ַ��������еĿ�ֵ
	 * 
	 * @param sa
	 * @return
	 */
	private String[] trimArray(String[] sa) {
		// ��StringBuffer����������еķǿ�Ԫ�أ��á�;���ָ�
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
		// ��String��split�����ָ�õ�����
		sa = sb.toString().split(";");
		return sa;
	}

	/**
	 * ����ArrayListȥ���ַ��������еĿ�ֵ
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

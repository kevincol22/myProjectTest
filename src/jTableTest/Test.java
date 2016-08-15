package jTableTest;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Test extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// static {
	// try {
	// try {
	// UIManager.setLookAndFeel(new SubstanceDustCoffeeLookAndFeel());
	// } catch (UnsupportedLookAndFeelException ex) {
	// System.out.println(ex.getMessage());
	// }
	// } catch (Exception ex) {
	// System.out.println(ex.getMessage());
	// }
	// 设置皮肤
	// SubstanceSaharaLookAndFeel.setSkin(new CremeSkin());
	// SubstanceSaharaLookAndFeel.setSkin(new AutumnSkin());
	// SubstanceSaharaLookAndFeel.setCurrentButtonShaper(new
	// StandardButtonShaper());
	// SubstanceSaharaLookAndFeel.setFontPolicy(new DefaultMacFontPolicy());
	// 设置水印
	// SubstanceLookAndFeel
	// .setCurrentWatermark(new SubstanceBubblesWatermark());
	// // 设置主题
	// // SubstanceLookAndFeel.setCurrentTheme(new SubstanceCremeTheme());
	// SubstanceLookAndFeel.setCurrentTheme(new SubstanceLightAquaTheme());
	// // SubstanceLookAndFeel.setCurrentTheme(new SubstanceOliveTheme());
	//
	// // SubstanceLookAndFeel.setCurrentTheme(new
	// SubstanceJadeForestTheme());
	// // 设置题头
	// SubstanceLookAndFeel.setCurrentTitlePainter(new
	// Glass3DTitlePainter());
	// }

	public Test() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(600, 500, 600, 300);
		this.setVisible(true);
		// this.pack();
		init();
	}

	private void init() {
		// JTable jtable = new JTable(20, 10);
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setViewportView(jtable);
		// this.getContentPane().add(scrollPane, BorderLayout.CENTER);

		// String[][] row = new String[20][10];
		// row[0][0] = "1";
		// String[] column = { "id", "name", "eduid", "sex", "age", "birthday",
		// "addres", "remark" };
		// DefaultTableModel tmd = new DefaultTableModel(row, column);
		// JTable table = new JTable(tmd);
		// JScrollPane scrollPane = new JScrollPane();
		// scrollPane.setViewportView(table);
		// this.getContentPane().add(scrollPane, BorderLayout.CENTER);

		String[][] data = { { "a", "f", "23" }, { "b", "m", "34" },
				{ "c", "m", "24" } };
		String[] title = { "name", "gender", "age" };
		JTable jtable = new JTable(data, title);
		JScrollPane jscrollpane = new JScrollPane(jtable);
		this.getContentPane().add(jscrollpane, BorderLayout.CENTER);
		JPanel jpanel = new JPanel();
		jpanel.add(jscrollpane, BorderLayout.CENTER);
		this.add(jpanel);

	}

	public static void main(String[] args) {

		new Test();
	}

}

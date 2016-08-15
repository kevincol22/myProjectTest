package jTableTest;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * swing界面美化 利用substance.jar
 * 
 * @author beickham
 */
public class Demo extends JFrame implements ActionListener, HyperlinkListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 定义miniIE所用的控件
	 */
	JMenuBar mentuBar;
	JButton Enter;
	JButton ScreenCapture;
	JTextField TextField;
	JPanel ButtonPanel;
	JEditorPane pane;
	JMenuItem skin1;
	JMenuItem skin2;
	JMenuItem skin3;
	JMenuItem skin4;
	JMenuItem skin5;
	JMenuItem skin6;
	// 用于选择皮肤时传递参数
	Object ob;
	// 用于截图时标记本地保存名
	int b = 0;

	public Demo() {
		MenuBar();
		/*
		 * 定义显示网页的部分
		 */
		pane = new JEditorPane();
		pane.setEditable(false); // Editable
		pane.setContentType("text/html");
		// 设置pane的超级链接监听
		pane.addHyperlinkListener(this);
		/*
		 * 把以上控件放到框架集中
		 */
		// 设置窗体大小.
		setSize(640, 480);

		this.add(new JScrollPane(pane), "Center");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * 定义miniIE工具栏
	 */
	public void MenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("文件");
		JMenu skin = new JMenu("更换皮肤");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem fileExitMenuItem = new JMenuItem("退出", KeyEvent.VK_X);
		skin1 = new JMenuItem("还有很多皮肤，想要更改，看源代码的main函数的注释");
		skin.add(skin1);
		menuBar.add(fileMenu);
		menuBar.add(skin);
		setJMenuBar(menuBar);
		fileMenu.add(fileExitMenuItem);
		// 设置点击退出后可以退出java虚拟机
		fileExitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		/*
		 * 使用默认皮肤开启浏览器
		 */
		/*
		 * 下面几句，你们可能看不太懂，这里，其实暂时不懂也没关系，这其实是因为swing不是线程安全的！为了线程安全而采取了以下的措施，去掉的话，可能会报错
		 * 。
		 */
	
		// String skinName =
		// "org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel";
		String skinName = "org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel";

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame.setDefaultLookAndFeelDecorated(true);
				JDialog.setDefaultLookAndFeelDecorated(true);
				try {
					/*
					 * 想要修改皮肤的话，只需要更改，下面这个函数的参数，具体改成什么样，可以打开，Referenced
					 * Libraries -> 点击substance.jar ->
					 * 找到org.jvnet.substance.skin这个包 ->
					 * 将下面的SubstanceDustCoffeeLookAndFeel 替换成
					 * 刚刚打开的包下的任意一个“Substance....LookAndFeel”即可
					 */

					UIManager.setLookAndFeel((LookAndFeel) Class.forName(
							skinName).newInstance());

					// UIManager
					// .setLookAndFeel(new
					// org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel());
					// 例如按照上面的步骤，可以看见一个叫，"SubstanceOfficeBlue2007LookAndFeel.class"，想要替换成这个皮肤，就可以向下面这样写
					// UIManager
					// .setLookAndFeel(new
					// org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel());
					// 运行一下，皮肤就可以换了
					// 想要详细了解的同学，可以去百度这个第三方包：substance.jar
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Demo browser = new Demo();
				browser.setVisible(true);
			}
		});

	}

	@Override
	public void hyperlinkUpdate(HyperlinkEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
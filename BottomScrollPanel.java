import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * ボトムパネル(ゲーム状況領域)を現すクラス。
 */
public class BottomScrollPanel extends JScrollPane {
	private static ScrollTextArea text = new ScrollTextArea();

	private static final int BOTTOM_WIDTH = 760;

	private static final int BOTTOM_HEIGHT = 100;
        //----------------------------
        //ボトムパネルのメソッド。
        //----------------------------
        /**
         *  ボトムパネルのコンストラクタ。
         */
	public BottomScrollPanel() {
		super(text);
		this.setPreferredSize(new Dimension(BOTTOM_WIDTH, BOTTOM_HEIGHT));
	}
        /**
         *  文字列を追加して表示。
         * @param str 表示したい文字列（String型)
         * @return なし（void型）
         */
	public void append(String str) {
		this.text.append(str);
	}

	private static class ScrollTextArea extends JTextArea {
		private ScrollTextArea() {
			this.setLineWrap(true);
		}

		public void append(String arg0) {
			super.append(arg0+"\n");
			int h = this.getRowHeight();
			Rectangle rect = this.getVisibleRect();
			rect.y += h;
			this.scrollRectToVisible(rect);

		}

	}
}

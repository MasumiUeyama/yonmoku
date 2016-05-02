import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 * �{�g���p�l��(�Q�[���󋵗̈�)�������N���X�B
 */
public class BottomScrollPanel extends JScrollPane {
	private static ScrollTextArea text = new ScrollTextArea();

	private static final int BOTTOM_WIDTH = 760;

	private static final int BOTTOM_HEIGHT = 100;
        //----------------------------
        //�{�g���p�l���̃��\�b�h�B
        //----------------------------
        /**
         *  �{�g���p�l���̃R���X�g���N�^�B
         */
	public BottomScrollPanel() {
		super(text);
		this.setPreferredSize(new Dimension(BOTTOM_WIDTH, BOTTOM_HEIGHT));
	}
        /**
         *  �������ǉ����ĕ\���B
         * @param str �\��������������iString�^)
         * @return �Ȃ��ivoid�^�j
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

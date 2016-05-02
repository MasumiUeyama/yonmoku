import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * サイドパネルを現すクラス。
 */
public class SidePanel extends JPanel {
        //----------------------------
        //  サイドパネルのフィールド。
        //----------------------------
        /**
         *  チェンジ画像用領域。
         */
	JButton label = null;
        /**
         *  画像（コマ）用領域。
         */
	JButton iconLabel = null;
        /**
         *  文字（プレイヤー名）用領域。
         */
	JButton nameLabel = null;
        //----------------------------
        //サイドパネルのメソッド。
        //----------------------------
        /**
         *  サイドパネルのコンストラクタ。
         */
	protected SidePanel() {
		this.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		nameLabel = new JButton();
		nameLabel.setPreferredSize(new Dimension(100, 30));
		nameLabel.setBackground(Color.LIGHT_GRAY);
		panel.add(nameLabel, BorderLayout.NORTH);

		iconLabel = new JButton();
		iconLabel.setPreferredSize(new Dimension(100, 100));
		iconLabel.setBackground(Color.WHITE);
		panel.add(iconLabel, BorderLayout.CENTER);

		this.add(panel, BorderLayout.NORTH);

		label = new JButton();
		label.setPreferredSize(new Dimension(100, 420));
		label.setBackground(Color.WHITE);

		this.add(label, BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(100, 560));
	}
        /**
         *  チェンジ画像領域の画像設定。
         * @param path 　パス名（String型）
         * @return なし　（void型）
         */
	public void changeImage(String path) {
		ImageIcon icon = new ImageIcon(path);
		label.setIcon(icon);
	}
        /**
         *  画像（コマ）領域の画像設定。
         * @param icon 　画像（ImageIcon型）
         * @return なし　（void型）
         */
	public void setIcon(ImageIcon icon) {
		iconLabel.setIcon(icon);
	}
        /**
         *  文字（プレイヤー名）領域の設定。
         * @param name 　プレイヤー名（String型）
         * @return なし　（void型）
         */
	public void setName(String name) {
		nameLabel.setText(name + "さん");
	}
}

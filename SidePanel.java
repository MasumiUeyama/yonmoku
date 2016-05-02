import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * �T�C�h�p�l���������N���X�B
 */
public class SidePanel extends JPanel {
        //----------------------------
        //  �T�C�h�p�l���̃t�B�[���h�B
        //----------------------------
        /**
         *  �`�F���W�摜�p�̈�B
         */
	JButton label = null;
        /**
         *  �摜�i�R�}�j�p�̈�B
         */
	JButton iconLabel = null;
        /**
         *  �����i�v���C���[���j�p�̈�B
         */
	JButton nameLabel = null;
        //----------------------------
        //�T�C�h�p�l���̃��\�b�h�B
        //----------------------------
        /**
         *  �T�C�h�p�l���̃R���X�g���N�^�B
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
         *  �`�F���W�摜�̈�̉摜�ݒ�B
         * @param path �@�p�X���iString�^�j
         * @return �Ȃ��@�ivoid�^�j
         */
	public void changeImage(String path) {
		ImageIcon icon = new ImageIcon(path);
		label.setIcon(icon);
	}
        /**
         *  �摜�i�R�}�j�̈�̉摜�ݒ�B
         * @param icon �@�摜�iImageIcon�^�j
         * @return �Ȃ��@�ivoid�^�j
         */
	public void setIcon(ImageIcon icon) {
		iconLabel.setIcon(icon);
	}
        /**
         *  �����i�v���C���[���j�̈�̐ݒ�B
         * @param name �@�v���C���[���iString�^�j
         * @return �Ȃ��@�ivoid�^�j
         */
	public void setName(String name) {
		nameLabel.setText(name + "����");
	}
}

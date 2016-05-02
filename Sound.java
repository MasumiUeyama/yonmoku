import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ����炷���߂̃N���X
 * @author taki
 *
 */
public class Sound extends Frame {
	private AudioClip audioClip = null;
        /**
         *�@�T�E���h�N���X�̃R���X�g���N�^�B
         *  @param file �T�E���h�t�@�C�����iString�^)
         */
	public Sound(String file) throws MalformedURLException {
		this.audioClip = Applet.newAudioClip(new URL("file:"
				+ System.getProperty("user.dir") + "/" + file));
	}

	/**
	 * �������Đ����邽�߂̃��\�b�h�B
	 * stop ���\�b�h�Ŏ~�܂�B
         * @return �Ȃ��ivoid�^)
	 */
	public void play() {
		this.audioClip.play();
	}
	
	/**
	 * �����~�߂邽�߂̃��\�b�h�B
         * @return �Ȃ��ivoid�^)
	 */
	public void stop() {
		this.audioClip.stop();
	}

	/**
	 * �J��Ԃ�����炷���߂̃��\�b�h�B
	 * stop ���\�b�h�Ŏ~�܂�B
         * @return �Ȃ��ivoid�^)
	 */
	public void loop() {
		this.audioClip.loop();
	}
}
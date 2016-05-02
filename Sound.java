import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Frame;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 音を鳴らすためのクラス
 * @author taki
 *
 */
public class Sound extends Frame {
	private AudioClip audioClip = null;
        /**
         *　サウンドクラスのコンストラクタ。
         *  @param file サウンドファイル名（String型)
         */
	public Sound(String file) throws MalformedURLException {
		this.audioClip = Applet.newAudioClip(new URL("file:"
				+ System.getProperty("user.dir") + "/" + file));
	}

	/**
	 * 音源を再生するためのメソッド。
	 * stop メソッドで止まる。
         * @return なし（void型)
	 */
	public void play() {
		this.audioClip.play();
	}
	
	/**
	 * 音を止めるためのメソッド。
         * @return なし（void型)
	 */
	public void stop() {
		this.audioClip.stop();
	}

	/**
	 * 繰り返し音を鳴らすためのメソッド。
	 * stop メソッドで止まる。
         * @return なし（void型)
	 */
	public void loop() {
		this.audioClip.loop();
	}
}
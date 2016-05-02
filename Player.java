import java.io.IOException;
/**
 * プレイヤーインターフェース。
 */
public interface Player
{
    /**
     * コマを置く場所を決める。
     * @return ２桁の数値文字列
     */
    public String play() throws IOException;

    /**
     * 名前を答える。
     * @return 名前
     */
    public String getPlayerName();

}

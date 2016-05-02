import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 三目並べの人間（プレイヤー）を表すクラス
 */
public class Man implements Player,Runnable
{

    //----------------------------------------------
    //人間（プレイヤー）クラスのフィールド（属性）。
    //----------------------------------------------
    /**
     * 人間（プレイヤー）の名前
     */
    private String playerName;

    /**
     * Boardクラスの参照
     */
    private Board board;

    /**
     * 人間（プレイヤー）クラスのコンストラクタ。
     */
    public Man(String name,Board bor)
    {
        playerName=name;
        board=bor;
    }
    public void run(){
    }

    //------------------------------------------
    //人間（プレイヤー）クラスのメソッド（動作）
    //------------------------------------------
    /**
     * 人間（プレイヤー）がコマを盤のどこに置くか
     * 行列入力（何行何列かを指定）する。
     * @return lineColumn ２行の数の文字列
     */
    public String play()
    {
        String lineColumn="";
        board.setPushButtonNoNull();
        System.out.println("何行何列にコマを置きますか");
        while(true){
            try{
                if((lineColumn=board.getPushButtonNo())!="") break;
                Thread.sleep(200); //200ms遅らせる
                
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        System.out.println(lineColumn);
        return lineColumn;
    }

    /**
     * 人間（プレイヤー）の名前を返す
     * @return playerName 名前
     */
    public String getPlayerName()
    {
        return playerName;
    }
}


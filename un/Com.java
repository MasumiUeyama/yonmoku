import java.io.IOException;

/**
 * 三目並べのCom（プレイヤー）を表すクラス
 */
public class Com extends java.lang.Object implements Player
{
    //----------------------------------------------
    //Com（プレイヤー）クラスのフィールド（属性）。
    //----------------------------------------------
    /**
     * Com（プレイヤー）の名前
     */
    private String playerName;

    /**
     * Com(プレイヤー)の順。
     */
    private int myOrder;

    /**
     * 審判(Judge)の参照。
     */
    private Judge judge;

    //-------------------------------------------
    //Com（プレイヤー）クラスのメソッド（動作）。
    //-------------------------------------------
    /**
     * Com（プレイヤー）クラスのコンストラクタ。
     */
    public Com(java.lang.String name,int order,Judge jud)
    {
        playerName=name;
        myOrder=order;
        judge=jud;

        System.out.println("２班");

    }
    /**
     * Com（プレイヤー）がコマを盤のどこに置くか
     * 行列入力（プレイヤーが何行何列目をを指定する）。
     * @return 一桁の数の文字列 (おきたい列を返す 1列から7列)
     */
    public java.lang.String play() throws IOException //throws IOException 例外処理
    {
        final int WIN_MOKU=4;
        final int MAX_LINE=6;
        final int MAX_COLUMN=7;

        String lineColumn="";
        String area[]=judge.getArea(); //judgeクラスのgetArea
        int index=0;
        int yourOrder;
        if(myOrder==0){
            yourOrder=1; //先手の場合 order:0 yourOrder:1
        }else{
            yourOrder=0; //後手の場合 order:1 yourOrder:0
        }

        int priority[]={1,2,3,4,5,6,7,8,8,9,9,10}; //areaの優先順位

        System.out.println("何列にコマを置きますか");


//P理論

            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
                if(area[priority[i]]=="・"){
                    index=priority[i];
                    
                    break;
                }
            }

//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);
        lineColumn=Integer.toString(index/MAX_COLUMN+1);
        System.out.println(lineColumn);
        return lineColumn;

    }

    /**
     * Com（プレイヤー）の名前を返す
     * @return playerName 名前
     */
    public java.lang.String getPlayerName()
    {
        return playerName;
    }
}


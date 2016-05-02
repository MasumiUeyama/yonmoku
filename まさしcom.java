import java.io.IOException;
import java.util.Random;

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
        playerName = name;
        myOrder = order;
        judge = jud;

        System.out.println("*****２班*****");
    }

    /**
     * Com（プレイヤー）がコマを盤のどこに置くか
     * 行列入力（プレイヤーが何行何列目をを指定する）。
     * @return ２行の数の文字列
     */
    public String play() throws IOException
    {
        final int WIN_MOKU=4;
        final int MAX_LINE=6;
        final int MAX_COLUMN=7;

        String lineColumn="";
        String area[]=judge.getArea(); //judgeクラスのgetArea
        int index=0;


//        int priority[]={4,0,2,6,8,1,3,5,7}; //areaの優先順位

        System.out.println("何列にコマを置きますか");

        //それ以外なら決めている場所
//            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
//                if(area[priority[i]]=="・"){
//                    index=priority[i];
//                    break;
//                }
//            }
//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);

        Random rnd = new Random();
        int n =rnd.nextInt(7);
        lineColumn = Integer.toString(n+1);
/*
//横
        for(int i=0;i<42;i+=7){
            index=isReach(myOrder,i,1,WIN_MOKU);
            if(index!=-1) break;
            if(i==3 || i==10 || i==17 || i==24 || i==31 || i=38) i+=3;
        }
//縦
        for(int i=0;i<21;i++){
            index=isReach(myOrder,i,7,WIN_MOKU);
            if(index!=-1) break;
        }
//右下斜め
        for(int i=0;i<18;i++){
            index=isReach(myOrder,i,8,WIN_MOKU);
            if(index!=-1) break;
            
        }
//左下斜め
        for(int i=20;i>2;i--){
            index=isReach(myOrder,i,6,WIN_MOKU);
            if(index!=-1) break;
            if(i==3 || i==10 || i==17) i-=3;
        }




        lineColumn=index%7+1
*/
        System.out.println(lineColumn);
        return lineColumn;
    }

    /**
     * リーチのチェック。
     *
     * @param order 先手後手の順
     * @param start マス目の始まりの場所
     * @param distance マス目の間隔
     * @param moku 勝つために必要な個数
     * @return result -1:リーチなし ０～８:該当の添字
     */
    private int isReach(int order,int start,int distance,int moku)
    {
        int result=-1;
        String piece=judge.getOrderPiece(order);
        String area[]=judge.getArea();
        int index=start;
        int mokuCount=0;

        for(int i=0;i<moku;i++){
            if(area[index]==piece){
                mokuCount++;
            } else if(area[index]=="・"){
                result=index;
            }
            index+=distance;
        }

        if(mokuCount!=moku-1){//リーチでない
            result=-1;
        }

        return result;
    }

    /**
     * Com（プレイヤー）の名前を返す
     * @return playerName 名前
     */
    public String getPlayerName()
    {
        return playerName;
    }
}


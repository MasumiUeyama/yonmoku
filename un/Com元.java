import java.io.IOException;
/**
 * 三目並べのCom（プレイヤー）を表すクラス
 */
public class Com implements Player
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
    public Com(String name,int order,Judge jud)
    {
        playerName=name;
        myOrder=order;
        judge=jud;
    }
    /**
     * Com（プレイヤー）がコマを盤のどこに置くか
     * 行列入力（プレイヤーが何行何列目をを指定する）。
     * @return ２行の数の文字列
     */
    public String play() throws IOException //throws IOException 例外あってもJavaが何とかしてくれる
    {
        final int WIN_MOKU=3;
        final int MAX_LINE=3;
        final int MAX_COLUMN=3;

        String lineColumn="";
        String area[]=judge.getArea(); //judgeクラスのgetArea
        int index;
        int yourOrder;
        if(myOrder==0){
            yourOrder=1; //先手の場合　order:0 yourOrder:1
        }else{
            yourOrder=0; //後手の場合　order:1 yourOrder:0
        }

        int priority[]={4,0,2,6,8,1,3,5,7}; //areaの優先順位

        System.out.println("何行何列にコマを置きますか");

        while(true){
            //自分のコマが２マス揃っているか
            if((index=isReach(myOrder,0,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,3,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,6,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,0,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,1,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,2,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,0,4,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,2,2,WIN_MOKU))>=0) break;

            //相手のコマが２マス揃っているか
            if((index=isReach(yourOrder,0,1,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,3,1,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,6,1,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,0,3,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,1,3,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,2,3,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,0,4,WIN_MOKU))>=0) break;
            if((index=isReach(yourOrder,2,2,WIN_MOKU))>=0) break;

            if(index<0) break;
        }

        //それ以外なら決めている場所
        if(index<0){
            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
                if(area[priority[i]]=="・"){
                    index=priority[i];
                    break;
                }
            }
        }
        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);
        System.out.println(lineColumn);
        return lineColumn;
    }
    /**
     * リーチチェック。
     *
     * @param order 先手後手の順
     * @param start マス目の始まりの場所
     * @param distance マス目の間隔
     * @param moku 勝つために必要な個数
     * @return result -1:リーチなし　0～8:該当の数
     */
    //リーチ判定
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
            }else if(area[index]=="・"){
                result=index;
            }
            index+=distance;
        }
        if(mokuCount!=moku-1){ //リーチでない
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


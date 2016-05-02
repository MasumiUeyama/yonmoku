import java.io.IOException;
import java.util.Random;

/**
 * 三目並べのCom（プレイヤー）を表すクラス
 */
public class Comb extends java.lang.Object implements Player
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
    public Comb(java.lang.String name,int order,Judge jud)
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
        int index=-1;
        int result=0;
        int yourOrder;
        int moku=WIN_MOKU;
//        int priority[]={4,0,2,6,8,1,3,5,7}; //areaの優先順位
        int auto[] = new int[100];
        int auto_n=0;
        if(myOrder==0){
            yourOrder=1;
        }else{
            yourOrder=0;
        }
        
        System.out.println("何列にコマを置きますか");

        //それ以外なら決めている場所
//            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
//                if(area[priority[i]]=="・"){
//                    index=priority[i];
//                    break;
//                }
//            }
//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);

 
/*
//横
        for(int i=0;i<42;i+=7){
            index=isReach(myOrder,i,1,WIN_MOKU);
            if(index!=-1) break;
            if(i==3 || i==10 || i==17 || i==24 || i==31 || i==38) i+=3;
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
        
        lineColumn=Integer.toString(index%7+1);

/*ランダーム

*/


//ここまでまさし
//こっからわたしうえやまさん

//とりあえず真ん中おく
        if(area[38]=="・"){
            index=4;
            lineColumn=Integer.toString(4);
        } else if(area[37]=="・"){
            index=3;
            lineColumn=Integer.toString(3);
        }
        
//自分がリーチならかつお
        if(index==-1){
            
            //横check
            if(index==-1){
                for(int i=0;i<=5;i++){
                    for(int j=0+i*7;j<=3+i*7;j++){
                        index=isReach(myOrder,j,1,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        //System.out.println("自分横");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //縦check
            if(index==-1){
                for(int i=0;i<=6;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,7,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("自分縦");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //斜めcheck
            if(index==-1){
                for(int i=0;i<=3;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,8,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("自分なな１");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //斜めcheck2
            if(index==-1){
                for(int i=6;i>=3;i--){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,6,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("自分なな２");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
           lineColumn=Integer.toString(index%7+1);
           if(index!=-1) System.out.println("自分リーチしてたお＾＾");
        }
        
        //相手がリーチなら止めるべし
        if(index==-1){
            
            //横check
            if(index==-1){
                for(int i=0;i<=5;i++){
                    for(int j=0+i*7;j<=3+i*7;j++){
                        index=isReach(yourOrder,j,1,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                    //System.out.println("相横");
                    if(index!=-1) break;
                }
            }
            
            //縦check
            if(index==-1){
                for(int i=0;i<=6;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,7,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("相縦");
                if(index!=-1) break;
                }
            }
                      
            //斜めcheck1
            if(index==-1){
                for(int i=0;i<=3;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,8,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("相斜1");
                if(index!=-1) break;
                }
            }
            
            //斜めcheck2
            if(index==-1){
                for(int i=6;i>=3;i--){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,6,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "・"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("相斜2");
                if(index!=-1) break;
                }
            }
            
            lineColumn=Integer.toString(index%7+1);
            if(index!=-1) System.out.println("相手リーチしてたお＾＾");

        
        }
        
        
        
        
        
        int first=0;
        int yabaicount=0;
        //なんもなし
        while(index == -1){
            Random rnd = new Random();
            int n =rnd.nextInt(7);
            index = n;
            if(yabaicount<=3){
                for(int m=0;m<7;m++){
                    if (n+1==auto[m]) index =-1;
                }
            } 
            lineColumn = Integer.toString(n+1);
            System.out.println("ランダム入ったお");
        yabaicount++;
        }


        
        //System.out.println(lineColumn);
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
        if(result!=-1)
        {
        System.out.println(piece);
        System.out.println(result);
        }
        return result;
    }


    /**
     * リーチのチェック。その２です。間隔のアイた奴でｽﾈｵｰ
     *
     * @param order 先手後手の順
     * @param start マス目の始まりの場所
     * @param distance マス目の間隔
     * @param moku 勝つために必要な個数
     * @return result -1:リーチなし ０～８:該当の添字
     */
    private int spaceReach (int order,int start,int distance,int moku)
    {
        int result=-1;
        String piece=judge.getOrderPiece(order);
        String area[]=judge.getArea();
        int index=start;
        int mokuCount=0;

        for(int i=0;i<=moku;i++){
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
        System.out.println(result);
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


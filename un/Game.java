//import java.io.IOException;

/**
 * 三目並べのゲームを進行を表すクラス。
 */
public class Game extends java.awt.Frame
{
    //--------------------------------
    //ゲームクラスのメソッド（動作）。
    //--------------------------------
    /**
     * ゲームクラスのメイン。
     */
    public static void main(java.lang.String[] args) throws java.io.IOException,
                                                            java.lang.reflect.InvocationTargetException,
                                                            java.lang.NoSuchMethodException,
                                                            java.lang.ClassNotFoundException,
                                                            java.lang.InstantiationException,
                                                            java.lang.IllegalAccessException
    {

        /**
         * 最大行数=6。
         */
        final int MAX_LINE=6;

        /**
         * 最大列数=7。
         */
        final int MAX_COLUMN=7;

        /**
         * 目数。
         */
        final int WIN_MOKU=4;

        /**
         * 対戦人数。
         */
        final int PLAYER_COUNT=2;

        /**
         * 盤クラスの定義とインスタンス化。
         */
        Board board=new Board(MAX_LINE,MAX_COLUMN);

        /**
         * 審判クラスの定義とインスタンス化。
         */
        Judge judge=new Judge(MAX_LINE,MAX_COLUMN);

        /**
         * 人間クラスの定義とインスタンス化。
         */
        Player player[]={new Man("おのえ",board),new Man("COM",board)};
//        Player player[]={new Man("おのえ",board),new Com("COM",1,judge)};

        boolean won=false;
        int  putEnabled;
        board.setVisible(true);   //盤を表示する（見える状態にする）
        while((judge.count()<MAX_LINE*MAX_COLUMN)&&won!=true){
            int lineColumn;
            int line;
            int column;
            do{
                int order=judge.count()%PLAYER_COUNT;
                System.out.println(player[order].getPlayerName()+"さん");
                lineColumn=Integer.parseInt(player[order].play());
                line=lineColumn/10-1;
                column=lineColumn%10-1;
                putEnabled=judge.judgePutEnabled(order,column);
            }while(putEnabled==-1);


            int order=(judge.count()-1)%PLAYER_COUNT;
            String piece=judge.getOrderPiece(order);
            board.draw(piece,line,column);


            won=judge.judgeWon(order,WIN_MOKU);
        }
        if(won==true){
            System.out.println(player[(judge.count()-1)%2].getPlayerName()+"さんの勝ち");

        }else{
            System.out.println("引き分け");
        }
    }
}


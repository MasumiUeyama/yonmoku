
// Board.java
// Version 1.0
// 2012/10/15 
// programming by fujisue

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;


/**
 * 盤を表すクラス(背景画像を分割して表示する）。

 */
public class Board extends JFrame implements ActionListener,Runnable 
{
    //--------------------------------
    // 盤クラスのフィールド（属性）。
    //--------------------------------
    /**
     * 盤の行数。
     **/
    private int maxLine;
    /**
     * 盤の列数。
     **/
    private int maxColumn ; 
    /**
     * マス目用のボタン。
     **/
    private static JButton button[][]; 
    /**
     * サイドパネル用のボタン。
     **/
    private static JButton sidePanel[]; 
    /**
     * クリックされたマスの番号。
     **/
    private String pushButtonNo; 
    /**
     * 手の数。
     **/
    private int counter;
    /**
     * 画像のファイル名用
     **/
    private String fileName;
    /**
     * 棋譜表示用のBottomScrollPanelクラスの参照。
     */
    private static BottomScrollPanel bottomScrollPanel;

    //--------------------------
    // 盤クラスのメソッド（動作）。
    //--------------------------
    /**
     * ボードクラスのコンストラクタ。
     */
    public Board(int x,int y)
    {
        //  ウインドウの表示名
        super("重力四目並べストン");
        //  縦（行）の数
        maxLine = x;
        //  横（列）の数
        maxColumn = y;
        
        counter = 1;
        //  マス目の数だけボタンを定義する
        button = new JButton[maxLine][maxColumn];
        //  左右のパネルをボタンとして定義する
        sidePanel = new JButton[2];
        //  閉じるボタン（ウインドウ右上の×印）が押された時の処理
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  コンテナの定義をし、ボーダーレイアウトをレイアウトにセットする
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        //  center用のパネルを定義し、横700×縦600ドットの大きさでグリッドレイアウトをセットする
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(maxLine , maxColumn);
        panel.setPreferredSize(new Dimension(700,600));
        panel.setLayout(layout); 
          //  各マス目に画像をセットし、ボタンとして機能するように設定する
          for(int i=0;i < maxLine;i++){
              for(int j=0;j < maxColumn;j++){
                  //  imageフォルダに縦横100×100ドットの画像を入れておく。
                  //  ファイル名は、左上から純に"kabe00.jpg"から"kabe41.jpg"とする
                  fileName="image/kabe"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".png";
                  button[i][j]=new JButton( new ImageIcon(fileName));
                  button[i][j].setPreferredSize(new Dimension(100,100));
                  //  パネルにこのボタンを付加する
                  panel.add(button[i][j]);
                  //  このボタンをマウスで認識できるようにする
                  button[i][j].addActionListener(this);
              }
          }

        //ボーダーレイアウトのnorth（上側）の定義
        JLabel north = new JLabel(new ImageIcon("image/top.png"));
        north.setPreferredSize(new Dimension(810,60));
        container.add(north,BorderLayout.NORTH);

        //ボーダーレイアウトのsouth（下側）の定義
        bottomScrollPanel = new BottomScrollPanel();
        container.add(bottomScrollPanel,BorderLayout.SOUTH);

        //ボーダーレイアウトのwest（左側）の定義
        sidePanel[0] = new JButton(new ImageIcon("image/side000.png"));
        sidePanel[0].setPreferredSize(new Dimension( 55,600));
        sidePanel[0].setBackground(Color.yellow);
        container.add(sidePanel[0],BorderLayout.WEST);

/*
        //ボーダーレイアウトのeast（右側）の定義
        sidePanel[1] = new JButton(new ImageIcon("image/side000.png"));
        sidePanel[1].setPreferredSize(new Dimension( 55,600));
        sidePanel[1].setBackground(Color.yellow);
        container.add(sidePanel[0],BorderLayout.EAST);
*/        
        
        sidePanel[1] = new JButton(new ImageIcon("image/side100.png"));
        sidePanel[1].setPreferredSize(new Dimension( 55,600));
        sidePanel[1].setBackground(Color.red);
        container.add(sidePanel[1],BorderLayout.EAST);
        
        //ボーダーレイアウトのcenter（中央）の定義
        container.add(panel,BorderLayout.CENTER);

        pack();
    }
    //  コンストラクタ終了

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  スレッドを使う
    public void run() {
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 勝数を表示する。
     * @param  side      サイドパネルの位置
     * @param  winCount  勝数
     */
    public void sidePanelDisp(int side,int winCount)
    {
        fileName="image/side"+Integer.toString(side)+Integer.toString(winCount/10)+Integer.toString(winCount%10)+".jpg";
        sidePanel[side].setIcon(new ImageIcon(fileName));
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 棋譜を表示する。
     * @param  message   メッセージ
     */
    public void dispKifu(String message)
    {
        bottomScrollPanel.append(message);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 駒をボードの指定行、指定列に置く。
     * @param piece  コマの形
     * @param y      列
     */
    public void draw(String piece,int i,int j)  throws MalformedURLException,InterruptedException 
    {
        ImageIcon icona = null;
        Sound fall = new Sound("sound/fall.wav");
        fall.play();
        for(int loopi=0;loopi<i;loopi++){
            try{
                //  先手なら青、後手なら赤の画像を表示する
                if (piece == "○"){
                    fileName="orange/orange"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".png";
                }
                else{
                    fileName="blue/blue"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".png";
                }
                icona = new ImageIcon(fileName);
                button[loopi][j].setIcon(icona);
                Thread.sleep(30);
                icona = new ImageIcon("image/kabe"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".png");
                button[loopi][j].setIcon(icona);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        ImageIcon icon1 = null;
        //通常のこま表示プログラム
        if (piece == "○"){
            fileName="orange/orange"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".png";
        }
        else{
            fileName="blue/blue"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".png";
        }
        icon1 = new ImageIcon(fileName);
        button[i][j].setIcon(icon1);
        fall.stop();
        /*
        j++;
        dispKifu(piece + "さんが" + j + "に置きました。");
        j--;
        */
        
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 駒を初期状態にする。
     */
    public void resetDraw()
    {
        ImageIcon icon1 = null;
        counter = 1;
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                icon1 = new ImageIcon("image/kabe"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".png");
                button[i][j].setIcon(icon1);
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ボタンを押された時そのマス目の行列を覚える。
     * @param event     イベント
     */
    public void actionPerformed(ActionEvent event)
    {
        pushButtonNo = "";
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                if(event.getSource()==button[i][j]){
                    pushButtonNo = Integer.toString(j+1);
                    break;
                }
            }
            if(pushButtonNo!=""){
                break;
            }
         }
     }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * 押されたボタンの行列の初期化。
     * @param event     イベント
     */
    public void setPushButtonNoNull()
    {
        pushButtonNo = "";
     }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     /**
     * 押されたボタンの行列を答える。
     * @return pushButtonNo
     */
    public String getPushButtonNo()
    {
        return pushButtonNo;
     }
}
// Boardクラスの終わり

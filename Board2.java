import java.awt.Container;        //コンテナ
import java.awt.GridLayout;       //格子状配置
import java.awt.Button;           //ボタン
import javax.swing.JFrame;        //フレーム(ウィンドウ)
import javax.swing.JPanel;        //JPanelの中の配置にもレイアウトマネージャーを利用できる
import java.awt.BorderLayout;     //ウィンドウ5分割
import java.awt.Color;            //色変えれる
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 盤を表すクラス。
 */
public class Board extends javax.swing.JFrame implements java.awt.event.ActionListener
{
    //----------------------------
    //盤クラスのフィールド(属性)。
    //----------------------------

    /**
     * 最大行数。
     */
    private int maxLine;

    /**
     * 最大列数。
     */
    private int maxColumn;

    /**
     * マス目の形状。
     */
    private Button button[][];

    /**
     * 押されたマスの番号。
     */
    private String pushButtonNo;

    /**
     * 棋譜表示用のBottomScrollPanelクラスの参照。
     */
    private static BottomScrollPanel bottomScrollPanel;


    /**
    //--------------------------
    //盤クラスのメソッド(動作)。
    //--------------------------

    /**
     * ボードクラスのコンストラクタ。
     */
    public Board(int line,int column)
    {
        super("三目並べ"); //親クラス(スーパークラス)のコンストラクタ呼び出し
        maxLine = line;
        maxColumn = column;
        button = new Button[maxLine][maxColumn]; //ボタンをインスタンス化
        setDefaultCloseOperation(EXIT_ON_CLOSE); //ウィンドウを閉じればプログラムも終了
        Container container = getContentPane();  //JFrameの表示領域を取得する
        container.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(maxLine,maxColumn);
        panel.setLayout(layout);
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                button[i][j]=new Button("・");
                panel.add(button[i][j]);
                button[i][j].addActionListener(this);
            }
        }

        //Button north = new Button("north");
        JLabel north = new JLabel(new ImageIcon("title.gif"));    //画像表示
        north.setPreferredSize(new Dimension(200,80));    //画像サイズ設定
        //north.setBackground(Color.blue);
        container.add(north,BorderLayout.NORTH);

        Button west = new Button("west");
        west.setBackground(Color.yellow);
        container.add(west,BorderLayout.WEST);

        container.add(panel,BorderLayout.CENTER);

        Button east = new Button("east");
        east.setBackground(Color.red);
        container.add(east,BorderLayout.EAST);

        //ボーダーレイアウトのsouth（下側）の定義
        bottomScrollPanel = new BottomScrollPanel();
        container.add(bottomScrollPanel,BorderLayout.SOUTH);


        pack(); //ボタンの大きさをウィンドウの大きさに自動で合わせる
    }

    /**
     * コマをボードの指定行、指定列に置く。
     * @param piece     コマの形
     * @param line      行
     * @param column    列
     */
    public void draw(java.lang.String piece,int line,int column)
    {
        button[line][column].setLabel(piece);
    }

    /**
     * 棋譜を表示する。
     * @param  message   メッセージ
     */
    public void dispKifu(String message)
    {
        bottomScrollPanel.append(message);
    }

    /**
     * ボタンを押されたときにそのマス目の行列を覚える。
     * @param event イベント
     */
    public void actionPerformed(ActionEvent event)
    {
        pushButtonNo = "";
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                if(event.getSource()==button[i][j]){
                    pushButtonNo = Integer.toString(i+1)+Integer.toString(j+1);
                    break;
                }
            }
            if(pushButtonNo!=""){
                break;
            }
        }
    }

    /**
     * 押されたボタンの行列初期化。
     * @param event イベント
     */
    public void setPushButtonNoNull()
    {
        pushButtonNo = "";
    }

    /**
     * 押されたボタンの行列を答える。
     * @return pushButtonNo
     */
    public java.lang.String getPushButtonNo()
    {
        return pushButtonNo;
    }

}
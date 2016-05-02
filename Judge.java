/**
 * 審判クラス。
 */
public class Judge
{
     //--------------------------------
     //審判クラスのフィールド（属性）。
     //--------------------------------

    /**
     * 先手のコマの形。
     */

    public final String PLAYER1_PIECE="○";

    /**
     * 後手のコマの形。
     */

    public final String PLAYER2_PIECE="×";

    /**
     * マスの領域の配列。
     */

    private String area[];

    /**
     * 置かれたコマの総数。
     */

    private int pieceCount;

    /**
     * 最大行数。
     */

    private int maxLine;

    /**
     * 最大列数。
     */

    private int maxColumn;

    /**
     * 審判クラスのコンストラクタ。
     */

    public Judge(int line,int column)
    {
        maxLine=line;
        maxColumn=column;
        area=new String[maxLine*maxColumn];
        pieceCount=0;
        for(int i=0;i<maxLine*maxColumn;i++){
            area[i]="・";
        }
    }
    /**
     * 置かれたコマの総数を返す。
     * @return pieceCount 置かれたコマの総数
     */
    public int count()
    {
        return pieceCount;
    }
    /**
     * コマが置けるかどうか判定する（置き場所判定）。
     * 
     * @param order 先手(0)後手(1)の順
     * @param line 行
     * @param column 列
     * @return result 置ける：true 置けない：false
     */
    public int judgePutEnabled(int order,int column)
    {
        int result=-1;
        
        String piece=getOrderPiece(order);
        //35＋からむから始まる
        if(column>=0&&column<=maxColumn){
            for(int i=5;i>=0;i--){ 
                if(area[column+7*i]=="・"){
                    area[column+7*i]=piece;
                    pieceCount++;
                    result=i;
                    //System.out.println(i+"が愛です");
                    break;
                }
            }
        }
        
        
        return result;
    }
    
    /**
     * 指定されたコマが三(n)目そろったか判定する（勝負判定）。
     *
     * @param order 先手後手の順
     * @param moku 勝つために必要な個数
     * @return result 勝：true 負：false
     */
    public boolean judgeWon(int order,int moku)
    {
        boolean result=false;
        
        //横check
        for(int i=0;i<=5;i++){
            for(int j=0+i*7;j<=3+i*7;j++){
                result=isStraight(order,j,1,moku);
                if(result==true) break;
            }
            if(result==true) break;
        }
        //縦check
        if(result==false){
            for(int i=0;i<=6;i++){
                for(int j=i ; j<i+7*3 ;j+=7){
                    result=isStraight(order,j,7,moku);
                    if(result==true) break;
                }
                if(result==true) break;
            }
        }
        
        //斜めcheck
        if(result==false){
            for(int i=0;i<=3;i++){
                for(int j=i ; j<i+7*3 ;j+=7){
                    result=isStraight(order,j,8,moku);
                    if(result==true) break;
                }
                if(result==true) break;
            }
        }
        
        //斜めcheck2
        if(result==false){
            for(int i=6;i>=3;i--){
                for(int j=i ; j<i+7*3 ;j+=7){
                    result=isStraight(order,j,6,moku);
                    if(result==true) break;
                }
                if(result==true) break;
            }
        }

        return result;
    }
    /**
     * 並びのチェック。
     *
     * @param order 先手後手の順
     * @param start マス目の始まりの場所
     * @param distance マス目の間隔
     * @param moku 勝つために必要な個数
     * @return result 並んだ：true 並んでない：false
     */
    private boolean isStraight(int order,int start,int distance,int moku)
    {
        boolean result =true;			//resultの初期値 は true
        String piece = getOrderPiece(order);	//コマの形を得る
        int index = start;
        for(int i = 0 ; i < moku; i++){		//勝利マス数まで
        //System.out.println(start);
            if(area[index] != piece){		//自分以外のマスならば
                result = false;			//並んでいない:falseを返す
                break;
            } else {
                index += distance;		//間隔だけ進む
            }
        }
        return result;				//並んだ:true 並んでいない:false
    }
    /**
     * 指定されたコマの形を得る。
     * @param order 先手後手の順
     * @return piece コマの形
     */
    public String getOrderPiece(int order)
    {
        String piece;
        if(order==0){
            piece=PLAYER1_PIECE;
        }else{
            piece=PLAYER2_PIECE;
        }
        return piece;
    }
    /**
     * マス目領域の状態を答える
     * @return area[]
     */
    public String[] getArea()
    {
        return area;
    }

}


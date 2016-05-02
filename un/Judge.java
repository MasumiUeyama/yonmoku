/**
 * �R���N���X�B
 */
public class Judge extends java.lang.Object
{
     //--------------------------------
     //�R���N���X�̃t�B�[���h�i�����j�B
     //--------------------------------

    /**
     * ���̃R�}�̌`�B
     */

    public final String PLAYER1_PIECE="��";

    /**
     * ���̃R�}�̌`�B
     */

    public final String PLAYER2_PIECE="�~";

    /**
     * �}�X�̗̈�̔z��B
     */

    private String area[];

    /**
     * �u���ꂽ�R�}�̑����B
     */

    private int pieceCount;

    /**
     * �ő�s���B
     */

    private int maxLine;

    /**
     * �ő�񐔁B
     */

    private int maxColumn;

    /**
     * �R���N���X�̃R���X�g���N�^�B
     */

    public Judge(int line,int column)
    {
        maxLine=line;
        maxColumn=column;
        area=new String[maxLine*maxColumn];
        pieceCount=0;
        for(int i=0;i<maxLine*maxColumn;i++){
            area[i]="�E";
        }
    }
    /**
     * �u���ꂽ�R�}�̑�����Ԃ��B
     * @return pieceCount �u���ꂽ�R�}�̑���
     */
    public int count()
    {
        return pieceCount;
    }
    /**
     * �R�}���u���邩�ǂ������肷��i�u���ꏊ����j�B
     * 
     * @param order ���(0)���(1)�̏�
     * @param line �s
     * @param column ��
     * @return result �u����Ftrue �u���Ȃ��Ffalse
     */
    public int judgePutEnabled(int order,int column)
    {
        int result=-1;
        
        String piece=getOrderPiece(order);
        
        if(column>=0&&column<=maxColumn){
            for(int i=5;i>=0;i--){ 
                if(area[column+7*i]=="�E"){
                    area[column+7*i]=piece;
                    pieceCount++;
                    result=i;
                    System.out.println(i);
                    break;
                }
            }
        }
        
        
        return result;
    }
    /**
     * �w�肳�ꂽ�R�}���O(n)�ڂ�����������肷��i��������j�B
     *
     * @param order �����̏�
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result ���Ftrue ���Ffalse
     */
    public boolean judgeWon(int order,int moku)
    {
        boolean result=false;

/*
        //���`�F�b�N
        for(int i=0;i<maxLine;i++){
            result=isStraight(order,i*3,1,moku);
            if(result==true) break;
        }
        if(result==true) return result;;

        //�c�`�F�b�N
        for(int i=0;i<maxColumn;i++){
            result=isStraight(order,i,3,moku);
            if(result==true) break;
        }
        if(result==true) return result;;

        //�΂߂P�`�F�b�N
        result=isStraight(order,0,4,moku);
        if(result==true) return result;
        //�΂߂Q�`�F�b�N
        result=isStraight(order,2,2,moku);
*/
        return result;
    }


    /**
     * ���т̃`�F�b�N�B
     *
     * @param order �����̏�
     * @param start �}�X�ڂ̎n�܂�̏ꏊ
     * @param distance �}�X�ڂ̊Ԋu
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result ���񂾁Ftrue ����łȂ��Ffalse
     */
/*    private boolean isStraight(int order,int start,int distance,int moku)
    {
        boolean result=true;
        String piece=getOrderPiece(order);
        int index=start;
        for(int i=0;i<moku;i++){
            if(area[index]!=piece){
                result=false;
                break;
            }else{
                index+=distance;
            }
        }
        return result;
    }
*/

    /**
     * �w�肳�ꂽ�R�}�̌`�𓾂�B
     * @param order �����̏�
     * @return piece �R�}�̌`
     */
    public java.lang.String getOrderPiece(int order)
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
     * �}�X�ڗ̈�̏�Ԃ𓚂���
     * @return area[]
     */
    public java.lang.String[] getArea()
    {
        return area;
    }

}


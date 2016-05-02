/**
 * �R���N���X�B
 */
public class Judge
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
        //35�{����ނ���n�܂�
        if(column>=0&&column<=maxColumn){
            for(int i=5;i>=0;i--){ 
                if(area[column+7*i]=="�E"){
                    area[column+7*i]=piece;
                    pieceCount++;
                    result=i;
                    //System.out.println(i+"�����ł�");
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
        
        //��check
        for(int i=0;i<=5;i++){
            for(int j=0+i*7;j<=3+i*7;j++){
                result=isStraight(order,j,1,moku);
                if(result==true) break;
            }
            if(result==true) break;
        }
        //�ccheck
        if(result==false){
            for(int i=0;i<=6;i++){
                for(int j=i ; j<i+7*3 ;j+=7){
                    result=isStraight(order,j,7,moku);
                    if(result==true) break;
                }
                if(result==true) break;
            }
        }
        
        //�΂�check
        if(result==false){
            for(int i=0;i<=3;i++){
                for(int j=i ; j<i+7*3 ;j+=7){
                    result=isStraight(order,j,8,moku);
                    if(result==true) break;
                }
                if(result==true) break;
            }
        }
        
        //�΂�check2
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
     * ���т̃`�F�b�N�B
     *
     * @param order �����̏�
     * @param start �}�X�ڂ̎n�܂�̏ꏊ
     * @param distance �}�X�ڂ̊Ԋu
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result ���񂾁Ftrue ����łȂ��Ffalse
     */
    private boolean isStraight(int order,int start,int distance,int moku)
    {
        boolean result =true;			//result�̏����l �� true
        String piece = getOrderPiece(order);	//�R�}�̌`�𓾂�
        int index = start;
        for(int i = 0 ; i < moku; i++){		//�����}�X���܂�
        //System.out.println(start);
            if(area[index] != piece){		//�����ȊO�̃}�X�Ȃ��
                result = false;			//����ł��Ȃ�:false��Ԃ�
                break;
            } else {
                index += distance;		//�Ԋu�����i��
            }
        }
        return result;				//����:true ����ł��Ȃ�:false
    }
    /**
     * �w�肳�ꂽ�R�}�̌`�𓾂�B
     * @param order �����̏�
     * @return piece �R�}�̌`
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
     * �}�X�ڗ̈�̏�Ԃ𓚂���
     * @return area[]
     */
    public String[] getArea()
    {
        return area;
    }

}


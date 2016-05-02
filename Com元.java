import java.io.IOException;
/**
 * �O�ڕ��ׂ�Com�i�v���C���[�j��\���N���X
 */
public class Com implements Player
{
    //----------------------------------------------
    //Com�i�v���C���[�j�N���X�̃t�B�[���h�i�����j�B
    //----------------------------------------------
    /**
     * Com�i�v���C���[�j�̖��O
     */
    private String playerName;

    /**
     * Com(�v���C���[)�̏��B
     */
    private int myOrder;

    /**
     * �R��(Judge)�̎Q�ƁB
     */
    private Judge judge;

    //-------------------------------------------
    //Com�i�v���C���[�j�N���X�̃��\�b�h�i����j�B
    //-------------------------------------------
    /**
     * Com�i�v���C���[�j�N���X�̃R���X�g���N�^�B
     */
    public Com(String name,int order,Judge jud)
    {
        playerName=name;
        myOrder=order;
        judge=jud;
    }
    /**
     * Com�i�v���C���[�j���R�}��Ղ̂ǂ��ɒu����
     * �s����́i�v���C���[�����s����ڂ����w�肷��j�B
     * @return �Q�s�̐��̕�����
     */
    public String play() throws IOException //throws IOException ��O�����Ă�Java�����Ƃ����Ă����
    {
        final int WIN_MOKU=3;
        final int MAX_LINE=3;
        final int MAX_COLUMN=3;

        String lineColumn="";
        String area[]=judge.getArea(); //judge�N���X��getArea
        int index;
        int yourOrder;
        if(myOrder==0){
            yourOrder=1; //���̏ꍇ�@order:0 yourOrder:1
        }else{
            yourOrder=0; //���̏ꍇ�@order:1 yourOrder:0
        }

        int priority[]={4,0,2,6,8,1,3,5,7}; //area�̗D�揇��

        System.out.println("���s����ɃR�}��u���܂���");

        while(true){
            //�����̃R�}���Q�}�X�����Ă��邩
            if((index=isReach(myOrder,0,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,3,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,6,1,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,0,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,1,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,2,3,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,0,4,WIN_MOKU))>=0) break;
            if((index=isReach(myOrder,2,2,WIN_MOKU))>=0) break;

            //����̃R�}���Q�}�X�����Ă��邩
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

        //����ȊO�Ȃ猈�߂Ă���ꏊ
        if(index<0){
            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
                if(area[priority[i]]=="�E"){
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
     * ���[�`�`�F�b�N�B
     *
     * @param order �����̏�
     * @param start �}�X�ڂ̎n�܂�̏ꏊ
     * @param distance �}�X�ڂ̊Ԋu
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result -1:���[�`�Ȃ��@0�`8:�Y���̐�
     */
    //���[�`����
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
            }else if(area[index]=="�E"){
                result=index;
            }
            index+=distance;
        }
        if(mokuCount!=moku-1){ //���[�`�łȂ�
            result=-1;
        }
        return result;
    }

    /**
     * Com�i�v���C���[�j�̖��O��Ԃ�
     * @return playerName ���O
     */
    public String getPlayerName()
    {
        return playerName;
    }
}


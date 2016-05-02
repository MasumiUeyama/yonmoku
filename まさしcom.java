import java.io.IOException;
import java.util.Random;

/**
 * �O�ڕ��ׂ�Com�i�v���C���[�j��\���N���X
 */
public class Com extends java.lang.Object implements Player
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
    public Com(java.lang.String name,int order,Judge jud)
    {
        playerName = name;
        myOrder = order;
        judge = jud;

        System.out.println("*****�Q��*****");
    }

    /**
     * Com�i�v���C���[�j���R�}��Ղ̂ǂ��ɒu����
     * �s����́i�v���C���[�����s����ڂ����w�肷��j�B
     * @return �Q�s�̐��̕�����
     */
    public String play() throws IOException
    {
        final int WIN_MOKU=4;
        final int MAX_LINE=6;
        final int MAX_COLUMN=7;

        String lineColumn="";
        String area[]=judge.getArea(); //judge�N���X��getArea
        int index=0;


//        int priority[]={4,0,2,6,8,1,3,5,7}; //area�̗D�揇��

        System.out.println("����ɃR�}��u���܂���");

        //����ȊO�Ȃ猈�߂Ă���ꏊ
//            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
//                if(area[priority[i]]=="�E"){
//                    index=priority[i];
//                    break;
//                }
//            }
//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);

        Random rnd = new Random();
        int n =rnd.nextInt(7);
        lineColumn = Integer.toString(n+1);
/*
//��
        for(int i=0;i<42;i+=7){
            index=isReach(myOrder,i,1,WIN_MOKU);
            if(index!=-1) break;
            if(i==3 || i==10 || i==17 || i==24 || i==31 || i=38) i+=3;
        }
//�c
        for(int i=0;i<21;i++){
            index=isReach(myOrder,i,7,WIN_MOKU);
            if(index!=-1) break;
        }
//�E���΂�
        for(int i=0;i<18;i++){
            index=isReach(myOrder,i,8,WIN_MOKU);
            if(index!=-1) break;
            
        }
//�����΂�
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
     * ���[�`�̃`�F�b�N�B
     *
     * @param order �����̏�
     * @param start �}�X�ڂ̎n�܂�̏ꏊ
     * @param distance �}�X�ڂ̊Ԋu
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result -1:���[�`�Ȃ� �O�`�W:�Y���̓Y��
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
            } else if(area[index]=="�E"){
                result=index;
            }
            index+=distance;
        }

        if(mokuCount!=moku-1){//���[�`�łȂ�
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


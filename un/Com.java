import java.io.IOException;

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
        playerName=name;
        myOrder=order;
        judge=jud;

        System.out.println("�Q��");

    }
    /**
     * Com�i�v���C���[�j���R�}��Ղ̂ǂ��ɒu����
     * �s����́i�v���C���[�����s����ڂ����w�肷��j�B
     * @return �ꌅ�̐��̕����� (�����������Ԃ� 1�񂩂�7��)
     */
    public java.lang.String play() throws IOException //throws IOException ��O����
    {
        final int WIN_MOKU=4;
        final int MAX_LINE=6;
        final int MAX_COLUMN=7;

        String lineColumn="";
        String area[]=judge.getArea(); //judge�N���X��getArea
        int index=0;
        int yourOrder;
        if(myOrder==0){
            yourOrder=1; //���̏ꍇ order:0 yourOrder:1
        }else{
            yourOrder=0; //���̏ꍇ order:1 yourOrder:0
        }

        int priority[]={1,2,3,4,5,6,7,8,8,9,9,10}; //area�̗D�揇��

        System.out.println("����ɃR�}��u���܂���");


//P���_

            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
                if(area[priority[i]]=="�E"){
                    index=priority[i];
                    
                    break;
                }
            }

//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);
        lineColumn=Integer.toString(index/MAX_COLUMN+1);
        System.out.println(lineColumn);
        return lineColumn;

    }

    /**
     * Com�i�v���C���[�j�̖��O��Ԃ�
     * @return playerName ���O
     */
    public java.lang.String getPlayerName()
    {
        return playerName;
    }
}


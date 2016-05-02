import java.io.IOException;
import java.util.Random;

/**
 * �O�ڕ��ׂ�Com�i�v���C���[�j��\���N���X
 */
public class Comb extends java.lang.Object implements Player
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
    public Comb(java.lang.String name,int order,Judge jud)
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
        int index=-1;
        int result=0;
        int yourOrder;
        int moku=WIN_MOKU;
//        int priority[]={4,0,2,6,8,1,3,5,7}; //area�̗D�揇��
        int auto[] = new int[100];
        int auto_n=0;
        if(myOrder==0){
            yourOrder=1;
        }else{
            yourOrder=0;
        }
        
        System.out.println("����ɃR�}��u���܂���");

        //����ȊO�Ȃ猈�߂Ă���ꏊ
//            for(int i=0;i<MAX_LINE*MAX_COLUMN;i++){
//                if(area[priority[i]]=="�E"){
//                    index=priority[i];
//                    break;
//                }
//            }
//        lineColumn=Integer.toString(index/MAX_COLUMN+1)+Integer.toString(index%MAX_COLUMN+1);

 
/*
//��
        for(int i=0;i<42;i+=7){
            index=isReach(myOrder,i,1,WIN_MOKU);
            if(index!=-1) break;
            if(i==3 || i==10 || i==17 || i==24 || i==31 || i==38) i+=3;
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
        
        lineColumn=Integer.toString(index%7+1);

/*�����_�[��

*/


//�����܂ł܂���
//��������킽��������܂���

//�Ƃ肠�����^�񒆂���
        if(area[38]=="�E"){
            index=4;
            lineColumn=Integer.toString(4);
        } else if(area[37]=="�E"){
            index=3;
            lineColumn=Integer.toString(3);
        }
        
//���������[�`�Ȃ炩��
        if(index==-1){
            
            //��check
            if(index==-1){
                for(int i=0;i<=5;i++){
                    for(int j=0+i*7;j<=3+i*7;j++){
                        index=isReach(myOrder,j,1,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        //System.out.println("������");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //�ccheck
            if(index==-1){
                for(int i=0;i<=6;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,7,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("�����c");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //�΂�check
            if(index==-1){
                for(int i=0;i<=3;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,8,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("�����ȂȂP");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
            //�΂�check2
            if(index==-1){
                for(int i=6;i>=3;i--){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(myOrder,j,6,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                    //System.out.println("�����ȂȂQ");
                        if(index!=-1) break;
                    }
                    if(index!=-1) break;
                }
            }
            
           lineColumn=Integer.toString(index%7+1);
           if(index!=-1) System.out.println("�������[�`���Ă����O�O");
        }
        
        //���肪���[�`�Ȃ�~�߂�ׂ�
        if(index==-1){
            
            //��check
            if(index==-1){
                for(int i=0;i<=5;i++){
                    for(int j=0+i*7;j<=3+i*7;j++){
                        index=isReach(yourOrder,j,1,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                    //System.out.println("����");
                    if(index!=-1) break;
                }
            }
            
            //�ccheck
            if(index==-1){
                for(int i=0;i<=6;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,7,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("���c");
                if(index!=-1) break;
                }
            }
                      
            //�΂�check1
            if(index==-1){
                for(int i=0;i<=3;i++){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,8,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("����1");
                if(index!=-1) break;
                }
            }
            
            //�΂�check2
            if(index==-1){
                for(int i=6;i>=3;i--){
                    for(int j=i ; j<i+7*3 ;j+=7){
                        index=isReach(yourOrder,j,6,moku);
                        if(index <= 34 && index != -1){
                            if(area[index+7] == "�E"){
                                auto[auto_n]=index%7+1;
                                auto_n++;
                                index = -1;
                            }
                        }
                        if(index!=-1) break;
                    }
                //System.out.println("����2");
                if(index!=-1) break;
                }
            }
            
            lineColumn=Integer.toString(index%7+1);
            if(index!=-1) System.out.println("���胊�[�`���Ă����O�O");

        
        }
        
        
        
        
        
        int first=0;
        int yabaicount=0;
        //�Ȃ���Ȃ�
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
            System.out.println("�����_����������");
        yabaicount++;
        }


        
        //System.out.println(lineColumn);
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
        if(result!=-1)
        {
        System.out.println(piece);
        System.out.println(result);
        }
        return result;
    }


    /**
     * ���[�`�̃`�F�b�N�B���̂Q�ł��B�Ԋu�̃A�C���z�Žȵ�
     *
     * @param order �����̏�
     * @param start �}�X�ڂ̎n�܂�̏ꏊ
     * @param distance �}�X�ڂ̊Ԋu
     * @param moku �����߂ɕK�v�Ȍ�
     * @return result -1:���[�`�Ȃ� �O�`�W:�Y���̓Y��
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
            } else if(area[index]=="�E"){
                result=index;
            }
            index+=distance;
        }

        if(mokuCount!=moku-1){//���[�`�łȂ�
            result=-1;
        }
        System.out.println(result);
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



import java.io.IOException;
import java.lang.InterruptedException;

/**
 * �O�ڕ��ׂ̃Q�[����i�s��\���N���X�B
 */
public class Game extends java.awt.Frame
{
    //--------------------------------
    //�Q�[���N���X�̃��\�b�h�i����j�B
    //--------------------------------
    /**
     * �Q�[���N���X�̃��C���B
     */
    public static void main(java.lang.String[] args) throws java.io.IOException,
                                                            java.lang.reflect.InvocationTargetException,
                                                            java.lang.NoSuchMethodException,
                                                            java.lang.ClassNotFoundException,
                                                            java.lang.InstantiationException,
                                                            java.lang.IllegalAccessException
    {

        /**
         * �ő�s��=6�B
         */
        final int MAX_LINE=6;

        /**
         * �ő��=7�B
         */
        final int MAX_COLUMN=7;

        /**
         * �ڐ��B
         */
        final int WIN_MOKU=4;

        /**
         * �ΐ�l���B
         */
        final int PLAYER_COUNT=2;

        /**
         * �ՃN���X�̒�`�ƃC���X�^���X���B
         */
        Board board=new Board(MAX_LINE,MAX_COLUMN);

        /**
         * �R���N���X�̒�`�ƃC���X�^���X���B
         */
        Judge judge=new Judge(MAX_LINE,MAX_COLUMN);

        /**
         * �l�ԃN���X�̒�`�ƃC���X�^���X���B
         */
//        Player player[]={new Man("�I����",board),new Man("�u���[",board)};
//        Player player[]={new Man("�I����",board),new Com("�u���[",1,judge)};
//        Player player[]={new Com("�I����",1,judge),new Man("�u���[",board)};
        Player player[]={new Com("�I����",1,judge),new Com("�u���[",1,judge)};
//        Player player[]={new Com("�I����",1,judge),new Comb("�u���[",1,judge)};



        boolean won=false;
        int  putEnabled;
        board.setVisible(true);   //�Ղ�\������i�������Ԃɂ���j
        while((judge.count()<MAX_LINE*MAX_COLUMN)&&won!=true){
            int lineColumn;
            int line=0;
            int column;
            do{
                int order=judge.count()%PLAYER_COUNT;
                System.out.println(player[order].getPlayerName()+"����");
                lineColumn=Integer.parseInt(player[order].play());
                //line=lineColumn/10-1;
                column=lineColumn%10-1;
                String area[]=judge.getArea(); //judge�N���X��getArea
                
                for(int i=5;i>=0;i--){ 
                    if(area[column+7*i]=="�E"){
                        line=i;
                        break;
                    }
                }

                putEnabled=judge.judgePutEnabled(order,column);
            }while(putEnabled==-1);


            int order=(judge.count()-1)%PLAYER_COUNT;
            String piece=judge.getOrderPiece(order);
//            line++;
 //           column++;

            try{
                board.draw(piece,line,column);
                //System.out.println("line=" + line +"putEnabled=" + putEnabled);
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println(line+"����΂�\n");
                //System.out.println(lineColumn+"���炢�ɂ炩��\n");
            }
            catch(InterruptedException e){
                System.out.println(line);
            }
//line--;
//column--;
            column++;
            board.dispKifu(player[(judge.count()-1)%2].getPlayerName()+ "����" + column + "��ɒu���܂����B");
            column--;
            
            won=judge.judgeWon(order,WIN_MOKU);
        }
        if(won==true){
            System.out.println(player[(judge.count()-1)%2].getPlayerName()+"����̏����ł��B");
            board.dispKifu(player[(judge.count()-1)%2].getPlayerName()+"����̏����ł��B");

        }else{
            System.out.println("���������ł��B");
        }
        
        
        board.resetDraw();
    }
}


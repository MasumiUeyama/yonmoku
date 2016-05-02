import java.io.IOException;
/**
 * �O�ڕ��ׂ̃Q�[����i�s��\���N���X�B
 */
public class Game
{
    //--------------------------------
    //�Q�[���N���X�̃��\�b�h�i����j�B
    //--------------------------------
    /**
�@�@ * �Q�[���N���X�̃��C���B
�@�@ */
    public static void main(String args[]) throws IOException
    {

        /**
         * �ő�s��=3�B
         */
        final int MAX_LINE=3;

        /**
         * �ő��=3�B
         */
        final int MAX_COLUMN=3;

        /**
         * �ڐ��B
         */
        final int WIN_MOKU=3;

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
        Player player[]={new Man("���̂�",board),new Com("COM",1,judge)};

        boolean won=false;
        boolean putEnabled=false;
        board.setVisible(true);   //�Ղ�\������i�������Ԃɂ���j
        while((judge.count()<MAX_LINE*MAX_COLUMN)&&won!=true){
            int lineColumn;
            int line;
            int column;
            do{
                int order=judge.count()%PLAYER_COUNT;
                System.out.println(player[order].getPlayerName()+"����");
                lineColumn=Integer.parseInt(player[order].play());
                line=lineColumn/10-1;
                column=lineColumn%10-1;
                putEnabled=judge.judgePutEnabled(order,line,column);
            }while(putEnabled==false);


            int order=(judge.count()-1)%PLAYER_COUNT;
            String piece=judge.getOrderPiece(order);
            board.draw(piece,line,column);


            won=judge.judgeWon(order,WIN_MOKU);
        }
        if(won==true){
            System.out.println(player[(judge.count()-1)%2].getPlayerName()+"����̏���");

        }else{
            System.out.println("��������");
        }
    }
}


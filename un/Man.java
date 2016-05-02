import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * �O�ڕ��ׂ̐l�ԁi�v���C���[�j��\���N���X
 */
public class Man extends java.lang.Object implements Player
{

    //----------------------------------------------
    //�l�ԁi�v���C���[�j�N���X�̃t�B�[���h�i�����j�B
    //----------------------------------------------
    /**
     * �l�ԁi�v���C���[�j�̖��O
     */
    private String playerName;

    /**
     * Board�N���X�̎Q��
     */
    private Board board;

    /**
     * �l�ԁi�v���C���[�j�N���X�̃R���X�g���N�^�B
     */
    public Man(java.lang.String name,Board bor)
    {
        playerName=name;
        board=bor;
    }

    //------------------------------------------
    //�l�ԁi�v���C���[�j�N���X�̃��\�b�h�i����j
    //------------------------------------------
    /**
     * �l�ԁi�v���C���[�j���R�}��Ղ̂ǂ��ɒu����
     * �s����́i���s���񂩂��w��j����B
     * @return lineColumn �Q�s�̐��̕�����
     */
    public String play()
    {
        String lineColumn="";
        board.setPushButtonNoNull();
        System.out.println("����ɃR�}��u���܂���");
        while(true){
            try{
                if((lineColumn=board.getPushButtonNo())!="") break;
                Thread.sleep(200); //200ms�x�点��
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        return lineColumn;
    }

    /**
     * �l�ԁi�v���C���[�j�̖��O��Ԃ�
     * @return playerName ���O
     */
    public String getPlayerName()
    {
        return playerName;
    }
}


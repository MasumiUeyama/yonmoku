import java.io.IOException;
/**
 * �v���C���[�C���^�[�t�F�[�X�B
 */
public interface Player
{
    /**
     * �R�}��u���ꏊ�����߂�B
     * @return �Q���̐��l������
     */
    public String play() throws IOException;

    /**
     * ���O�𓚂���B
     * @return ���O
     */
    public String getPlayerName();

}

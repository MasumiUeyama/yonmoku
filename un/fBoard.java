
// Board.java
// Version 1.0
// 2012/10/15 
// programming by fujisue

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;


/**
 * �Ղ�\���N���X(�w�i�摜�𕪊����ĕ\������j�B

 */
public class Board extends JFrame implements ActionListener,Runnable 
{
    //--------------------------------
    // �ՃN���X�̃t�B�[���h�i�����j�B
    //--------------------------------
    /**
     * �Ղ̍s���B
     **/
    private int maxLine;
    /**
     * �Ղ̗񐔁B
     **/
    private int maxColumn ; 
    /**
     * �}�X�ڗp�̃{�^���B
     **/
    private static JButton button[][]; 
    /**
     * �T�C�h�p�l���p�̃{�^���B
     **/
    private static JButton sidePanel[]; 
    /**
     * �N���b�N���ꂽ�}�X�̔ԍ��B
     **/
    private String pushButtonNo; 
    /**
     * ��̐��B
     **/
    private int counter;
    /**
     * �摜�̃t�@�C�����p
     **/
    private String fileName;
    /**
     * �����\���p��BottomScrollPanel�N���X�̎Q�ƁB
     */
    private static BottomScrollPanel bottomScrollPanel;

    //--------------------------
    // �ՃN���X�̃��\�b�h�i����j�B
    //--------------------------
    /**
     * �{�[�h�N���X�̃R���X�g���N�^�B
     */
    public Board(int x,int y)
    {
        //  �E�C���h�E�̕\����
        super("�d�͎l�ڕ��׃X�P���g��");
        //  �c�i�s�j�̐�
        maxLine = x;
        //  ���i��j�̐�
        maxColumn = y;
        
        counter = 1;
        //  �}�X�ڂ̐������{�^�����`����
        button = new JButton[maxLine][maxColumn];
        //  ���E�̃p�l�����{�^���Ƃ��Ē�`����
        sidePanel = new JButton[2];
        //  ����{�^���i�E�C���h�E�E��́~��j�������ꂽ���̏���
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //  �R���e�i�̒�`�����A�{�[�_�[���C�A�E�g�����C�A�E�g�ɃZ�b�g����
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        //  center�p�̃p�l�����`���A��700�~�c600�h�b�g�̑傫���ŃO���b�h���C�A�E�g���Z�b�g����
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(maxLine , maxColumn);
        panel.setPreferredSize(new Dimension(700,600));
        panel.setLayout(layout); 
          //  �e�}�X�ڂɉ摜���Z�b�g���A�{�^���Ƃ��ċ@�\����悤�ɐݒ肷��
          for(int i=0;i < maxLine;i++){
              for(int j=0;j < maxColumn;j++){
                  //  image�t�H���_�ɏc��100�~100�h�b�g�̉摜�����Ă����B
                  //  �t�@�C�����́A���ォ�珃��"kabe00.jpg"����"kabe41.jpg"�Ƃ���
                  fileName="image/kabe"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".jpg";
                  button[i][j]=new JButton( new ImageIcon(fileName));
                  button[i][j].setPreferredSize(new Dimension(100,100));
                  //  �p�l���ɂ��̃{�^����t������
                  panel.add(button[i][j]);
                  //  ���̃{�^�����}�E�X�ŔF���ł���悤�ɂ���
                  button[i][j].addActionListener(this);
              }
          }

        //�{�[�_�[���C�A�E�g��north�i�㑤�j�̒�`
        JLabel north = new JLabel(new ImageIcon("image/top.jpg"));
        north.setPreferredSize(new Dimension(810,60));
        container.add(north,BorderLayout.NORTH);

        //�{�[�_�[���C�A�E�g��south�i�����j�̒�`
        bottomScrollPanel = new BottomScrollPanel();
        container.add(bottomScrollPanel,BorderLayout.SOUTH);

        //�{�[�_�[���C�A�E�g��west�i�����j�̒�`
        sidePanel[0] = new JButton(new ImageIcon("image/side000.jpg"));
        sidePanel[0].setPreferredSize(new Dimension( 55,600));
        sidePanel[0].setBackground(Color.yellow);
        container.add(sidePanel[0],BorderLayout.WEST);

        //�{�[�_�[���C�A�E�g��east�i�E���j�̒�`
        sidePanel[1] = new JButton(new ImageIcon("image/side100.jpg"));
        sidePanel[1].setPreferredSize(new Dimension( 55,600));
        sidePanel[1].setBackground(Color.red);
        container.add(sidePanel[1],BorderLayout.EAST);

        //�{�[�_�[���C�A�E�g��center�i�����j�̒�`
        container.add(panel,BorderLayout.CENTER);

        pack();
    }
    //  �R���X�g���N�^�I��

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //  �X���b�h���g��
    public void run() {
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ������\������B
     * @param  side      �T�C�h�p�l���̈ʒu
     * @param  winCount  ����
     */
    public void sidePanelDisp(int side,int winCount)
    {
        fileName="image/side"+Integer.toString(side)+Integer.toString(winCount/10)+Integer.toString(winCount%10)+".jpg";
        sidePanel[side].setIcon(new ImageIcon(fileName));
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ������\������B
     * @param  message   ���b�Z�[�W
     */
    public void dispKifu(String message)
    {
        bottomScrollPanel.append(message);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ����{�[�h�̎w��s�A�w���ɒu���B
     * @param piece  �R�}�̌`
     * @param y      ��
     */
    public void draw(String piece,int i,int j)  throws MalformedURLException,InterruptedException 
    {
        ImageIcon icona = null;
        Sound fall = new Sound("sound/fall.wav");
        fall.play();
        for(int loopi=0;loopi<i;loopi++){
            try{
                //  ���Ȃ�A���Ȃ�Ԃ̉摜��\������
                if (piece == "��"){
                    fileName="blue/kabe_blue_"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".jpg";
                }
                else{
                    fileName="red/kabe_red_"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".jpg";
                }
                icona = new ImageIcon(fileName);
                button[loopi][j].setIcon(icona);
                Thread.sleep(150);
                icona = new ImageIcon("image/kabe"+Integer.toString((loopi*7+j)/10)+Integer.toString((loopi*7+j)%10)+".jpg");
                button[loopi][j].setIcon(icona);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        ImageIcon icon1 = null;
        //�ʏ�̂��ܕ\���v���O����
        if (piece == "��"){
            fileName="blue/kabe_blue_"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".jpg";
        }
        else{
            fileName="red/kabe_red_"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".jpg";
        }
        icon1 = new ImageIcon(fileName);
        button[i][j].setIcon(icon1);
        fall.stop();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * ���������Ԃɂ���B
     */
    public void resetDraw()
    {
        ImageIcon icon1 = null;
        counter = 1;
        for(int i=0;i<6;i++){
            for(int j=0;j<7;j++){
                icon1 = new ImageIcon("image/kabe"+Integer.toString((i*7+j)/10)+Integer.toString((i*7+j)%10)+".jpg");
                button[i][j].setIcon(icon1);
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * �{�^���������ꂽ�����̃}�X�ڂ̍s����o����B
     * @param event     �C�x���g
     */
    public void actionPerformed(ActionEvent event)
    {
        pushButtonNo = "";
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                if(event.getSource()==button[i][j]){
                    pushButtonNo = Integer.toString(j+1);
                    break;
                }
            }
            if(pushButtonNo!=""){
                break;
            }
         }
     }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * �����ꂽ�{�^���̍s��̏������B
     * @param event     �C�x���g
     */
    public void setPushButtonNoNull()
    {
        pushButtonNo = "";
     }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     /**
     * �����ꂽ�{�^���̍s��𓚂���B
     * @return pushButtonNo
     */
    public String getPushButtonNo()
    {
        return pushButtonNo;
     }
}
// Board�N���X�̏I���
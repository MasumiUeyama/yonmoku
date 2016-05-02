import java.awt.Container;        //�R���e�i
import java.awt.GridLayout;       //�i�q��z�u
import java.awt.Button;           //�{�^��
import javax.swing.JFrame;        //�t���[��(�E�B���h�E)
import javax.swing.JPanel;        //JPanel�̒��̔z�u�ɂ����C�A�E�g�}�l�[�W���[�𗘗p�ł���
import java.awt.BorderLayout;     //�E�B���h�E5����
import java.awt.Color;            //�F�ς����
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * �Ղ�\���N���X�B
 */
public class Board extends javax.swing.JFrame implements java.awt.event.ActionListener
{
    //----------------------------
    //�ՃN���X�̃t�B�[���h(����)�B
    //----------------------------

    /**
     * �ő�s���B
     */
    private int maxLine;

    /**
     * �ő�񐔁B
     */
    private int maxColumn;

    /**
     * �}�X�ڂ̌`��B
     */
    private Button button[][];

    /**
     * �����ꂽ�}�X�̔ԍ��B
     */
    private String pushButtonNo;

    /**
     * �����\���p��BottomScrollPanel�N���X�̎Q�ƁB
     */
    private static BottomScrollPanel bottomScrollPanel;


    /**
    //--------------------------
    //�ՃN���X�̃��\�b�h(����)�B
    //--------------------------

    /**
     * �{�[�h�N���X�̃R���X�g���N�^�B
     */
    public Board(int line,int column)
    {
        super("�O�ڕ���"); //�e�N���X(�X�[�p�[�N���X)�̃R���X�g���N�^�Ăяo��
        maxLine = line;
        maxColumn = column;
        button = new Button[maxLine][maxColumn]; //�{�^�����C���X�^���X��
        setDefaultCloseOperation(EXIT_ON_CLOSE); //�E�B���h�E�����΃v���O�������I��
        Container container = getContentPane();  //JFrame�̕\���̈���擾����
        container.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(maxLine,maxColumn);
        panel.setLayout(layout);
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                button[i][j]=new Button("�E");
                panel.add(button[i][j]);
                button[i][j].addActionListener(this);
            }
        }

        //Button north = new Button("north");
        JLabel north = new JLabel(new ImageIcon("title.gif"));    //�摜�\��
        north.setPreferredSize(new Dimension(200,80));    //�摜�T�C�Y�ݒ�
        //north.setBackground(Color.blue);
        container.add(north,BorderLayout.NORTH);

        Button west = new Button("west");
        west.setBackground(Color.yellow);
        container.add(west,BorderLayout.WEST);

        container.add(panel,BorderLayout.CENTER);

        Button east = new Button("east");
        east.setBackground(Color.red);
        container.add(east,BorderLayout.EAST);

        //�{�[�_�[���C�A�E�g��south�i�����j�̒�`
        bottomScrollPanel = new BottomScrollPanel();
        container.add(bottomScrollPanel,BorderLayout.SOUTH);


        pack(); //�{�^���̑傫�����E�B���h�E�̑傫���Ɏ����ō��킹��
    }

    /**
     * �R�}���{�[�h�̎w��s�A�w���ɒu���B
     * @param piece     �R�}�̌`
     * @param line      �s
     * @param column    ��
     */
    public void draw(java.lang.String piece,int line,int column)
    {
        button[line][column].setLabel(piece);
    }

    /**
     * ������\������B
     * @param  message   ���b�Z�[�W
     */
    public void dispKifu(String message)
    {
        bottomScrollPanel.append(message);
    }

    /**
     * �{�^���������ꂽ�Ƃ��ɂ��̃}�X�ڂ̍s����o����B
     * @param event �C�x���g
     */
    public void actionPerformed(ActionEvent event)
    {
        pushButtonNo = "";
        for(int i=0;i<maxLine;i++){
            for(int j=0;j<maxColumn;j++){
                if(event.getSource()==button[i][j]){
                    pushButtonNo = Integer.toString(i+1)+Integer.toString(j+1);
                    break;
                }
            }
            if(pushButtonNo!=""){
                break;
            }
        }
    }

    /**
     * �����ꂽ�{�^���̍s�񏉊����B
     * @param event �C�x���g
     */
    public void setPushButtonNoNull()
    {
        pushButtonNo = "";
    }

    /**
     * �����ꂽ�{�^���̍s��𓚂���B
     * @return pushButtonNo
     */
    public java.lang.String getPushButtonNo()
    {
        return pushButtonNo;
    }

}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;
import java.util.Timer;

public class BoxLayoutPanel extends JFrame {
    //public static java.util.Timer timer = new Timer();
    public BoxLayoutPanel(String s) {
        super(s);
        JPanel p2 = new JPanel();
        JLabel l1 = new JLabel();
        JTextArea area = new JTextArea();
//        l1.setForeground(Color.BLUE);
//        p2.add(l1);
//        p2.add(new JButton("Выполнить"));
//        p2.add(new JButton("Отменить"));
//        p2.add(new JButton("Выйти"));
        l1.setLayout(new BorderLayout());
        p2.add(l1);
        //JLabel[] labels = new JLabel[10];
//        JLabel lab1 = new JLabel("a");
//        p2.add(lab1);
//        p2.add(new JLabel("b"));
//        p2.add(new JLabel("C"));
//        String str = "zhopka";
        String str = "papapapapapa";
        char [] charArr = str.toCharArray();
        JLabel[] labels = new JLabel[charArr.length];
        int catcher = 0;
        for (int i = 0; i < charArr.length; i++){
            System.out.println(charArr[i]);
            JLabel tempLabel = new JLabel(Character.toString(charArr[i]));
            labels[i] = tempLabel;
            p2.add(labels[i]);
        }
        p2.setBounds(5,5,5,5);

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(p2,BorderLayout.SOUTH);
        JTextField txtf = new JTextField(20);
        txtf.setToolTipText("Поле ввода");
//        txtf.addKeyListener(new KeyListener(){
//            int catcher = 0;
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//                //System.out.println(lab1.getText());
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                //System.out.println(txtf.getText());
//                //System.out.println(labels[catcher].getText());
//                if (catcher == labels.length){
//                    JOptionPane.showMessageDialog(BoxLayoutPanel.this,"Ля, КРАСАВА!");
//                }
//                else if (Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
//                    labels[catcher].setForeground(Color.GREEN);
//                    this.catcher +=1;
//
//                }
//                else{
//                    labels[catcher].setForeground(Color.RED);
//                }
//            }
//        });
        KeyCatcher kc = new KeyCatcher(txtf,labels); //try to fix
        txtf.addKeyListener(kc);
//        txtf.addKeyListener(new KeyListener() {
//            int catcher = 0;
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//                if (catcher == labels.length){
//                    System.out.println("Done");
//                    //JOptionPane.showMessageDialog(BoxLayoutPanel.this,"Ля, КРАСАВА!");
//                }
//                else if (Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
//                    labels[catcher].setForeground(Color.GREEN);
//                    this.catcher +=1;
//
//                }
//                else{
//                    labels[catcher].setForeground(Color.RED);
//                    JOptionPane.showMessageDialog(txtf,
//                            "Введена лишняя буква",
//                            "Inane error",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
        p1.add(txtf,BorderLayout.NORTH);
        //JScrollPane sp = new JScrollPane(new TextArea("Область ввода",20,5))
        //p1.add(sp,BorderLayout.CENTER);
        JButton restart = new JButton("Очистить поле");
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //txtf.setText("");
                int len = kc.getCatcher() + kc.getFlagValue();
                for (int  i = 0; i < len;i++){
                    labels[i].setForeground(Color.BLACK);
                }
                kc.setCatcher(0);
                txtf.setText("");
            }
        });
        p1.add(restart,BorderLayout.EAST);
        p1.setBorder(BorderFactory.createEtchedBorder(100,Color.RED,Color.BLACK));
        p1.setBounds(5,5,5,5);
        add(p1,BorderLayout.CENTER);
        JButton b = new JButton("Совсем выйти");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        add(b, BorderLayout.SOUTH);
        setSize(400,200);
//        JLabel timerLabel = new JLabel();
//        timerLabel.setSize(20, 50);
//        timerLabel.setForeground(Color.RED); // Устанавливаем цвет текста
//
//        add(new Timer().schedule(new GameTimer(timerLabel), 10),BorderLayout.WEST);
        setVisible(true);
    }
}

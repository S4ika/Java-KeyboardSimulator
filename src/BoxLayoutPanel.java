import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BoxLayoutPanel extends JFrame {
    public BoxLayoutPanel(String s) {
        super(s);
        JPanel p2 = new JPanel();
        JLabel l1 = new JLabel();
        l1.setLayout(new BorderLayout());
        p2.add(l1);
        //String str = "papapapapapa";
        String str = "you just a poor boy, you need no sympathy!";
        char [] charArr = str.toCharArray();
        JLabel[] labels = new JLabel[charArr.length];
        for (int i = 0; i < charArr.length; i++){
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
        KeyCatcher kc = new KeyCatcher(txtf,labels); //try to fix
        txtf.addKeyListener(kc);
        p1.add(txtf,BorderLayout.NORTH);
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
                kc.clearWrongLit();
                txtf.setText("");
                kc.killTimer();
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
        setSize(550,200);
        setVisible(true);
    }
}

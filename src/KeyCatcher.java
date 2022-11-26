import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class KeyCatcher extends JFrame implements KeyListener {

    private JTextField txtf = new JTextField();
    private JLabel[] labels = new JLabel[0];
    private int catcher = 0;

    private boolean flag = false;

    public KeyCatcher(JTextField smfng, JLabel[] lbls) {
        this.txtf = smfng;
        this.labels = lbls;
        this.catcher = 0;
    }

//    void KeyCather(JTextField smfng, JLabel [] lbls){
//            this.txtf = smfng;
//            this.labels = lbls;
//    }
//    public void cleanArea(){
//        txtf.setText("");
//    }

    public void setCatcher(int catcher1){
        this.catcher = catcher1;
    }

    public int getCatcher(){
        return this.catcher;
    }

    public int getFlagValue(){ return (this.flag) ? 1 : 0;}
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        //System.out.println(txtf.getText());
        //System.out.println(labels[catcher].getText());
//        if (Objects.equals(catcher, labels.length)){
//            System.out.println("Done");
//            //JOptionPane.showMessageDialog(BoxLayoutPanel.this,"Ля, КРАСАВА!");
//        }
//        else
        if (Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
            labels[catcher].setForeground(Color.GREEN);
            this.catcher +=1;

        }
        else{

            labels[catcher].setForeground(Color.RED);
            flag = true;
            JOptionPane.showMessageDialog(txtf,
                    "Введена лишняя буква",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
        }
//        if( Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
//                labels[catcher].setForeground(Color.GREEN);
//                this.catcher +=1;
//            }
//        if (this.catcher > txtf.getText().length()){ //Флаг который проверяет, исправляем ли мы строку, если начали исправлять, то false
//            System.out.println("dfas");
//            flag = !flag;
//            labels[catcher].setForeground(Color.BLACK);
//            //this.catcher -= 1;
//        }
//        else{
//            flag = true;
//        }
//        if (flag){
//            if( Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
//                labels[catcher].setForeground(Color.GREEN);
//                this.catcher +=1;
//            }
//            else{
//                labels[catcher].setForeground(Color.RED);
//            }
//        }


//        else if(!Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText()) || !flag){
//
//            labels[catcher].setForeground(Color.RED);
//        }
    }
}

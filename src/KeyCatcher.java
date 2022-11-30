import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Objects;

public class KeyCatcher extends JFrame implements KeyListener {

    private JTextField txtf = new JTextField();
    private JLabel[] labels = new JLabel[0];
    private int catcher = 0;
    private long startTime;
    private boolean flag = false;

    private boolean wrongLit = false;
    private int labelsSize;
    public KeyCatcher(JTextField smfng, JLabel[] lbls) {
        this.txtf = smfng;
        this.labels = lbls;
        this.catcher = 0;
        this.labelsSize = lbls.length;
    }

    public void setCatcher(int catcher1){
        this.catcher = catcher1;
    }
    //Возвращаем количество введенных правильно букв
    public int getCatcher(){
        return this.catcher;
    }
    //Обнуляем таймер
    public void killTimer(){this.flag = false;}
    //Получает на вход время и возвращает строку в "красивом виде"
    private String timeMillstoSecAndMin(int ourTime){
        String time = "";
        ourTime = (int) ourTime / 1000;
        if (ourTime/60 > 0) {
            time = Integer.toString(ourTime / 60) + " минут(ы) " + Integer.toString(ourTime % 60) + " секунд(ы)";
        }
        else{
            time = Integer.toString(ourTime % 60) + " секунд(ы)";
        }
        return time;
    }
    //Если была введена неправильная буква метод возвратит 1, нужно в случае очистки Labels
    public int getFlagValue(){
        return (this.wrongLit) ? 1 : 0;}

    public void clearWrongLit(){
        this.wrongLit = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!flag){
            this.startTime = System.currentTimeMillis();
            flag = !flag;
        }
        if (Objects.equals(Character.toString(txtf.getText().toCharArray()[catcher]), labels[catcher].getText())){
            labels[catcher].setForeground(Color.GREEN);
            this.catcher +=1;
            if (this.catcher == labelsSize){
                //this.catcher --;
                String finishTime = "Поздравляю у вас ушло на набор каких то "+Integer.toString(this.labelsSize) +" букв всего то "+ timeMillstoSecAndMin((int)(System.currentTimeMillis() - startTime));
                JOptionPane.showMessageDialog(txtf,
                    finishTime);}
        }
        else{
            labels[catcher].setForeground(Color.RED);
            wrongLit = true;
            JOptionPane.showMessageDialog(txtf,
                    "Введена лишняя буква",
                    "Inane error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}

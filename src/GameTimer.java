import javax.swing.*;
import java.util.TimerTask;

public class GameTimer extends TimerTask {
    JLabel timer = null;
    public GameTimer(JLabel inputLabel) {
        this.timer = inputLabel;
    }

    @Override
    public void run() {
        int seconds = 0, minutes = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            seconds++;
            if (minutes != 0)
                timer.setText(Integer.toString(minutes) + ":");
            timer.setText(Integer.toString(seconds));
            if (seconds == 59) {
                seconds = -1;
                minutes++;
            }
        }
    }
}
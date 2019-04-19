package space.shooter;

import java.util.Timer;
import java.util.TimerTask;
import static space.shooter.Core.shootE;

public class ENEMYPociskTimer {
    Timer timer;
    public ENEMYPociskTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*50);
        shootE = true;
    }
 
    class RemindTask extends TimerTask {
        public void run() {
            shootE = false;
            timer.cancel(); //Wyłączamy taska
        }
    }
 
    public static void main(String args[]) {
        new Reminder(5);
        if(!shootE) System.out.print("No!");
        System.out.format("Task scheduled.%n");
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.shooter;

import java.util.Timer;
import java.util.TimerTask;
import static space.shooter.Core.wait;

/**
 *
 * @author Minty
 */
public class wait {
    Timer timer;
    public wait(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*100);
        wait = true;
    }
 
    class RemindTask extends TimerTask {
        public void run() {
            wait = false;
            timer.cancel(); //Wyłączamy taska
        }
    }
 
    public static void main(String args[]) {
        new Reminder(5);
        if(!wait) System.out.print("No!");
        System.out.format("T.%n");
    }    
}

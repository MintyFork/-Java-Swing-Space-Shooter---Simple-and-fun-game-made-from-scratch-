/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.shooter;

import java.util.Timer;
import java.util.TimerTask;
import static space.shooter.MyKeyListener.shoot;

/**
 *
 * @author Minty
 */
public class Reminder {
    Timer timer;
    public Reminder(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds*100);
        shoot = true;
    }
 
    class RemindTask extends TimerTask {
        public void run() {
            shoot = false;
            timer.cancel(); //Wyłączamy taska
        }
    }
 
    public static void main(String args[]) {
        new Reminder(5);
        if(!shoot) System.out.print("No!");
        System.out.format("Task scheduled.%n");
    }
}

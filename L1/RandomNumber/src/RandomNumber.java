
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Create RandomNumber class to play the game. The game takes 20 seconds to
 * finish. After each second, there is a random number from 1 to 20 will
 * display. If the first number is equal to 15 then display the message “Game
 * success”. If the time is out, display “Game is over”.
 *
 * @author nguyen
 */
public class RandomNumber extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RandomNumber.class.getName()).log(Level.SEVERE, null, ex);
            }
            Random rd = new Random();
            int num = rd.nextInt(20);
            System.out.println(num);
            if (num == 15) {
                System.out.println("Game success");
                System.exit(0);
            }            
        }
        System.out.println("Game is over");
    }

    public static void main(String[] args) {
        new RandomNumber().start();
    }
}

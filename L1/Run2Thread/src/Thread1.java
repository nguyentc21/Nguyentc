
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nguyen
 */
public class Thread1 extends Thread{

    @Override
    public void run() {
        for (int i = 10; i < 20; i++) {
            System.out.println(i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Thread1.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        System.out.println("End Thread1!");
    }
    
}

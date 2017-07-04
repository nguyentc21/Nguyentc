
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
public class Run2Thread extends Thread {

    @Override
    public void run() {
        String s = "Java is object orriented programming";
        String[] subS = s.split("\\s");
        for (String ss : subS) {
            System.out.println(ss);
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Run2Thread.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        System.out.println("End Thread2!");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread1();
        Thread t2 = new Run2Thread();
//
//        t1.start();
//        try {
//            t1.join();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Run2Thread.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        t2.start();


        t1.setPriority(1);
        t2.setPriority(9);
        
        t1.start();
        t2.start();

    }

}

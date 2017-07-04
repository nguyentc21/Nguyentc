
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Create DisplayString class to enter a string from the keyboard. Display each
 * character of string on the screen. Each character is displayed in one line
 * and display later 1 second from before character
 *
 * @author nguyen
 */
public class DisplayString {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Nhap mot chuoi ki tu bat ki:");
        try {
            String s = br.readLine();
            System.out.println("Cac ki tu trong chuoi vua nhap:");
            for (int i = 0; i < s.length(); i++) {
                System.out.println(s.charAt(i));
                Thread.sleep(1000);
            }
        } catch (IOException ex) {
            Logger.getLogger(DisplayString.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(DisplayString.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package util;

import dto.Account;
import dto.Employee;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;
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
public class ProcessFile {

    public boolean saveAcc(LinkedList<Account> ac) {
        FileWriter fwriter = null;
        BufferedWriter writer = null;
        try {
            fwriter = new FileWriter(System.getProperty("user.dir") + "/Account.txt");
            writer = new BufferedWriter(fwriter);

            for (Account a : ac) {
                writer.write(a.toString());
                writer.newLine();
            }

            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("The requested file cannot be found.");
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to the file.");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (fwriter != null) {
                    fwriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean saveEmp(LinkedList<Employee> e) {
        FileWriter fwriter = null;
        BufferedWriter writer = null;
        try {
            fwriter = new FileWriter(System.getProperty("user.dir") + "/Employee.txt");
            writer = new BufferedWriter(fwriter);

            for (Employee em : e) {
                writer.write(em.toString());
                writer.newLine();
            }

            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("The requested file cannot be found.");
        } catch (IOException ex) {
            System.out.println("An error occurred while writing to the file.");
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (fwriter != null) {
                    fwriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public LinkedList<String> load(String s) {
        LinkedList<String> loadFile = new LinkedList<>();
        FileReader freader = null;
        BufferedReader reader = null;
        try {
            freader = new FileReader(System.getProperty("user.dir") + "/" + s);
            reader = new BufferedReader(freader);
            String line = reader.readLine();
            while (line != null) {
                StringTokenizer st = new StringTokenizer(line, ",");
                while (st.hasMoreTokens()) {
                    loadFile.addLast(st.nextToken());
                }
                line = reader.readLine();
            }

            return loadFile;

        } catch (FileNotFoundException ex) {
            System.out.println("The requested file cannot be found.");
        } catch (IOException ex) {
            System.out.println("An error occurred while reading from the file.");
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (freader != null) {
                    freader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ProcessFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
}

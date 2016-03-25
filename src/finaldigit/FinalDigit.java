/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldigit;

import bgi.SimpleDigit;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Paul
 */
public class FinalDigit {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        demoGUI();
    }

    
     private static void demoGUI() {
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(250,250);
        f.setVisible(true);
        f.setResizable(true);
        ClockDigit test = new ClockDigit();
//        SimpleDigit s = new SimpleDigit(7,);
//        s.setDigit(8);
        test.setDigit(3);
        f.add(test);
        f.pack();
    }
}
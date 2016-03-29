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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
        GridBagLayout experimentLayout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(true);
        f.setLayout(experimentLayout);
        ClockDigit t1 = new ClockDigit();
        ClockDigit t2 = new ClockDigit();
        ClockDigit t3 = new ClockDigit();
        ClockDigit t4 = new ClockDigit();
        ClockDigit t5 = new ClockDigit();
//        SimpleDigit s = new SimpleDigit(7,);
//        s.setDigit(8);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        t1.setDigit(1);
        t2.setDigit(2);
        t4.setDigit(0);
        t5.setDigit(0);
        String[] text = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN"};
        
        t2.setText(text);  
        t2.setTextAlignment(t2.RIGHT);
        t3.setText(text);
        t3.setTextAlignment(t3.CENTER);
        t4.setText(text);
        t4.setTextAlignment(t4.LEFT);
        f.add(t1,c);
        f.add(t2,c);
        f.add(t3,c);
        f.add(t4,c);
        c.gridwidth = GridBagConstraints.REMAINDER;
        f.add(t5,c);
        f.pack();
        f.setVisible(true);
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldigit;

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
        MyPanel panel = new MyPanel();
        ClockDigit test = new ClockDigit();
        f.add(test);
        f.pack();
    }
}
     
 class MyPanel extends JPanel {

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }

    public void paintComponent(Graphics g) {
        int xpoints[] = {10,15,20,20,15,10};
        int ypoints[] = {20,15,20,50,55,50};
//        xpoints[0] = 10;
//        xpoints[1] = 15;
//        xpoints[2] = 20;
//        xpoints[3] = 20;
//        xpoints[4] = 15;
//        xpoints[5] = 10;
//        ypoints[0] = 20;
//        ypoints[1] = 15;
//        ypoints[2] = 20;
//        ypoints[3] = 50;
//        ypoints[4] = 55;
//        ypoints[5] = 50;
        
        super.paintComponent(g);       
        g.setColor(Color.red);
        // Draw Text
        g.fillPolygon(xpoints, ypoints, xpoints.length);

    }  
}
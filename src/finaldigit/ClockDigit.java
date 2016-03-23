/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldigit;

import bgi.TouchDigit;
import bgi.TouchListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JComponent;

/**
 *
 * @author Paul
 */
public class ClockDigit extends JComponent implements TouchDigit {
    
    private int digit;
    private String[] text;
    private Rectangle[] regions;
    private int touched;
    private int rows;
    private int columns;
    private int alignment;
    private Polygon[] segments;
    private Vector listeners;
    
    public void ClockDigit(){
        
    }
    
    public void ClockDigit(int x, int y){
        
    }
    
    public void setDigit(int i){
        digit = i;
    }
    
    public int getDigit(){
        return digit;
    }
    
    public void setText(String[] strings){
        text = strings;
    }
    
    @Override
    public String[] getText(){
        return text;
    }
    
    /**
     *
     * @param i Set the text alignment. Possible values are LEFT, CENTER, and RIGHT.
     */
    @Override
    public void setTextAlignment(int i) {
        alignment = i;
    }

    @Override
    public int getTextAlignment() {
       return alignment;
    }

    @Override
    public void addTouchListener(TouchListener tl) {
        listeners.add(tl);
    }

    @Override
    public void removeTouchListener(TouchListener tl) {
        listeners.remove(tl);
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(250,200);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        init();
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillPolygon(segments[0]);
    }
    
    private void init(){
        int xpoints[] = {10,15,20,20,15,10};
        int ypoints[] = {20,15,20,50,55,50};
        segments = new Polygon[6];
        segments[0] = new Polygon(xpoints,ypoints,xpoints.length);
    }
}

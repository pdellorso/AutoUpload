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
    
    @Override
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
        g.setColor(Color.black);
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        g.setColor(Color.red);
        int i = 0;
        switch (digit){
            case 0:{
                while (i<7){
                    if(i!=3)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }     
            case 1:{
                g.fillPolygon(segments[5]);
                g.fillPolygon(segments[6]);
                break;
            }
            case 2:{
                while (i<7){
                    if(i!=0 && i!=6)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 3:{
                while (i<7){
                    if(i!=0 && i!=1)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 4:{
                while (i<7){
                    if(i!=1 && i!=2 && i!=4)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 5:{
                while (i<7){
                    if(i!=1 && i!=5)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 6:{
                while (i<7){
                    if(i!=5)
                        g.fillPolygon(segments[i]);
                    i++;
                }
            }
            case 7:{
                while (i<7){
                    if(i!=0 && i!=1 && i!=3 && i!=4)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 8:{
                while (i<7){
                    g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }
            case 9:{
                while (i<7){
                    if(i!=1 && i!=4)
                        g.fillPolygon(segments[i]);
                    i++;
                }
                break;
            }        
        }
    }
    
    private void init(){
        int h = this.getSize().height;
        int y = h/11;
        int w = this.getSize().width;
        int x = w/7;
        int xpoints[], ypoints[];
        segments = new Polygon[7];
        
        xpoints = new int[]{x,(int)(1.5*x),2*x, 2*x,(int)(1.5*x),x};
        ypoints = new int[]{2*y,(int)(1.5*y),2*y,5*y,(int)(5.5*y),5*y};
        segments[0] = new Polygon(xpoints,ypoints,xpoints.length);
        
        ypoints = new int[]{4*y,(int)(3.5*y),4*y,5*y,(int)(5.5*y),5*y};
        segments[1] = new Polygon(xpoints,ypoints,xpoints.length);
        
        xpoints = new int[]{2*x,5*x,(int)(5.5*x),5*x,2*x,(int)(1.5*x)};
        ypoints = new int[]{y,y,(int)(1.5*y),2*y,2*y,(int)(1.5*y)};  
        segments[2] = new Polygon(xpoints,ypoints,xpoints.length);
        
        ypoints = new int[]{5*y,5*y,(int)(5.5*y),6*y,6*y,(int)(5.5*y)};
        segments[3] = new Polygon(xpoints,ypoints,xpoints.length);
        
        ypoints = new int[]{9*y,9*y,(int)(9.5*y),10*y,10*y,(int)(9.5*y)};
        segments[4] = new Polygon(xpoints,ypoints,xpoints.length);
        
        xpoints = new int[]{5*x,(int)(5.5*x),6*x, 6*x,(int)(5.5*x),5*x};
        ypoints = new int[]{2*y,(int)(1.5*y),2*y,5*y,(int)(5.5*y),5*y};
        segments[5] = new Polygon(xpoints,ypoints,xpoints.length);
        
        ypoints = new int[]{6*y,(int)(5.5*y),6*y,9*y,(int)(9.5*y),9*y};
        segments[6] = new Polygon(xpoints,ypoints,xpoints.length);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaldigit;

import bgi.SimpleDigit;
import bgi.TouchDigit;
import bgi.TouchListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Vector;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author Paul
 */
public class ClockDigit extends SimpleDigit implements TouchDigit {
    

//    private Rectangle[] regions;
//    private int touched;
//    private int rows;
//    private int columns;
    private Polygon[] segments, colon;
    private Vector listeners; 
    private boolean textV, digitV;
    
    public ClockDigit(){
        super(7,1);
    }
    
    public ClockDigit(int x, int y){
        super(x,y);
        initPolygons();
    }
    
    @Override
    public void setText(String[] strings){
        super.setText(strings);
    }
    
    @Override
    public String[] getText(){
        return super.getText();
    }
    
    /**
     *
     * @param i Set the text alignment. Possible values are LEFT, CENTER, and RIGHT.
     */
    @Override
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
    }

    @Override
    public int getTextAlignment() {
       return super.getTextAlignment();
    }
    
    public Dimension getPreferredSize() {
        return new Dimension(200,300);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        
        g.setColor(Color.black);
        g.fillRect(0,0, this.getWidth(), this.getHeight());
        initPolygons();     
        g.setColor(Color.green);
        int i = 0;
        switch (this.getDigit()){
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
            default: {
                g.fillPolygon(colon[0]);
                g.fillPolygon(colon[1]);
            }
        }
        g.setColor(Color.RED);
        for(int y = 0;y<this.getText().length;y++){  
            int x = 0;
            switch(this.getTextAlignment()){
                case 1:{
                    x = 0;
                    break;
                }
                case 2:{
                    x = (this.getSize().width - g.getFontMetrics().stringWidth(this.getText()[y]))/2;
                    break;
                } 
                case 3:{
                    x = this.getSize().width - g.getFontMetrics().stringWidth(this.getText()[y]);
                    break;
                } 
            } 
            g.drawString(this.getText()[y], x, (y+1)*this.getSize().height/7);
        }
    }
    
    private void initPolygons(){
        int h = this.getSize().height;
        int y = h/11;
        int w = this.getSize().width;
        int x = w/7;
        int xpoints[], ypoints[], xcolon[], ycolon[];
        segments = new Polygon[7];
        colon = new Polygon[2];
        
        xcolon = new int[]{3*x,3*x,4*x,4*x};
        ycolon = new int[]{3*y,4*y,4*y,3*y};
        colon[0] = new Polygon(xcolon,ycolon,xcolon.length);
        
        ycolon = new int[]{7*y,8*y,8*y,7*y};
        colon[1] = new Polygon(xcolon,ycolon,xcolon.length);
        
        xpoints = new int[]{x,(int)(1.5*x),2*x, 2*x,(int)(1.5*x),x};
        ypoints = new int[]{2*y,(int)(1.5*y),2*y,5*y,(int)(5.5*y),5*y};
        segments[0] = new Polygon(xpoints,ypoints,xpoints.length);
        
        ypoints = new int[]{6*y,(int)(5.5*y),6*y,9*y,(int)(9.5*y),9*y};
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

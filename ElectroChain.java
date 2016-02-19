package com;

import java.awt.BasicStroke;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * Class: ElectrocChain4
 */
		
public class ElectroChain4 {  //1
	
  public static void main(String[] args) {  //2
    JFrame frame = new ElectroChainFrame4();
    frame.setVisible(true);
  }  //2
}  //1

/*
 * Class: ElectroChainFrame3
 */

class ElectroChainFrame4 extends JFrame {  //1
	
  public ElectroChainFrame4() {  //2
    setSize(1200, 700);
    setTitle("ElectroChain"
    		+ "");
 
    addWindowListener(new WindowAdapter() {  //3
      public void windowClosing(WindowEvent e) {  //4
        System.exit(0);
      }  //4
    });  //3
 
    Container contentPane = getContentPane();
    kanvas = new JPanel();
    contentPane.add(kanvas, "Center");
    JPanel p = new JPanel();
    addButton(p, "Start", new ActionListener() {  //3
      public void actionPerformed(ActionEvent evt) {  //4
        //Ball2 b = new Ball2(kanvas);
    	Sim4 sim = new Sim4(kanvas);
        sim.start();
      }  //4
    });  //3
 
    addButton(p, "Close", new ActionListener() {  //3
      public void actionPerformed(ActionEvent evt) {  //4
        kanvas.setVisible(false);
        System.exit(0);
      }  //4
    });  //3
    contentPane.add(p, "South");
  } //2
 
  public void addButton(Container c, String title, ActionListener a) {  //2
    JButton b = new JButton(title);
    c.add(b);
    b.addActionListener(a);
  }  //2
 
  private JPanel kanvas;
}  //1

/*
 * Class: Ball
 */

class Ball4 {  //1
	double x;
	double y;
	double phobic;
	Color color;
	
	public Ball4(double x, double y, double phobic, Color color) {  //2
		this.x = x;
		this.y = y;
		this.phobic = phobic;
		this.color = color;
	}  //2
}  //1

/*
 * Class: Sim3
 */

class Sim4 extends Thread {  //1
	
	Ball4 b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	Ball4 c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
	JPanel box; 
	static final int XSIZE = 5;
	static final int YSIZE = 5; 
	int it=0, hi=0;
	double sum,cx,cy,lastSum;

	
  public Sim4(JPanel b) {  //2
	  System.out.println("Starting");
    box = b;
  }  //2
  
  
  
 /*
  *  Sim4: Main action
  */
  
  public void run() {  //2
		 
	// build initial chain
	// later: (1) get phobics from args[]  (2) set b1 (3) set b2 etc at random angles 
	// (4) start button randomizes retaining arg phobics  
	  
	b1 = new Ball4(400.0,400.0,1.0,Color.red);
	b2 = new Ball4(580.0,450.0,1.0,Color.magenta);
	b3 = new Ball4(660.0,500.0,0.0,Color.yellow);
	b4 = new Ball4(750.0,550.0,0.0,Color.green);
	b5 = new Ball4(650.0,600.0,1.0,Color.blue);
	b6 = new Ball4(700.0,650.0,0.0,Color.orange);
	b7 = new Ball4(750.0,700.0,1.0,Color.pink);
	b8 = new Ball4(800.0,750.0,0.0,Color.gray);
	b9 = new Ball4(850.0,800.0,1.0,Color.cyan);
	b10 = new Ball4(900.0,850.0,0.0,Color.black);
	
	c1 = new Ball4(0.0,0.0,0.0,Color.black);
	c2 = new Ball4(0.0,0.0,0.0,Color.black);
	c3 = new Ball4(0.0,0.0,0.0,Color.black);
	c4 = new Ball4(0.0,0.0,0.0,Color.black);
	c5 = new Ball4(0.0,0.0,0.0,Color.black);
	c6 = new Ball4(0.0,0.0,0.0,Color.black);
	c7 = new Ball4(0.0,0.0,0.0,Color.black);
	c8 = new Ball4(0.0,0.0,0.0,Color.black);
	c9 = new Ball4(0.0,0.0,0.0,Color.black);
	c10 = new Ball4(0.0,0.0,0.0,Color.black);
	
	Graphics g = box.getGraphics();
	double s2cBefore=0, s2cAfter = 0;
	double d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;

	boolean randomize = true;
	if (randomize) {  //3
	/*
	 * Randomize the angles of the above structure, but retaining:
	 * 1. The location of b1
	 * 2. The distances between b1-b2, b2-b3, b4-b5, b5-b6
	 */
	d2 = Math.sqrt((b1.x-b2.x)*(b1.x-b2.x)+(b1.y-b2.y)*(b1.y-b2.y));
	d3 = Math.sqrt((b2.x-b3.x)*(b2.x-b3.x)+(b2.y-b3.y)*(b2.y-b3.y));
	d4 = Math.sqrt((b3.x-b4.x)*(b3.x-b4.x)+(b3.y-b4.y)*(b3.y-b4.y));
	d5 = Math.sqrt((b4.x-b5.x)*(b4.x-b5.x)+(b4.y-b5.y)*(b4.y-b5.y));
	d6 = Math.sqrt((b5.x-b6.x)*(b5.x-b6.x)+(b5.y-b6.y)*(b5.y-b6.y));
	d7 = Math.sqrt((b6.x-b7.x)*(b6.x-b7.x)+(b6.y-b7.y)*(b6.y-b7.y));
	d8 = Math.sqrt((b7.x-b8.x)*(b7.x-b8.x)+(b7.y-b8.y)*(b7.y-b8.y));
	d9 = Math.sqrt((b8.x-b9.x)*(b8.x-b9.x)+(b8.y-b9.y)*(b8.y-b9.y));
	d10 = Math.sqrt((b9.x-b10.x)*(b9.x-b10.x)+(b9.y-b10.y)*(b9.y-b10.y));
	
	// b2

	double ranRad = Math.random() * Math.PI - Math.PI/2;
	double ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b2.x = b1.x + ranSign * (d2*( Math.cos(ranRad))); 
	b2.y = b1.y + ranSign * (d2*( Math.sin(ranRad)));  
	
	// b3

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b3.x = b2.x + ranSign * (d3*( Math.cos(ranRad))); 
	b3.y = b2.y + ranSign * (d3*( Math.sin(ranRad))); 
	
	// b4

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b4.x = b3.x + ranSign * (d4*( Math.cos(ranRad))); 
	b4.y = b3.y + ranSign * (d4*( Math.sin(ranRad)));  
	
	// b5

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b5.x = b4.x + ranSign * (d5*( Math.cos(ranRad))); 
	b5.y = b4.y + ranSign * (d5*( Math.sin(ranRad)));  
	
	// b6

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b6.x = b5.x + ranSign * (d6*( Math.cos(ranRad))); 
	b6.y = b5.y + ranSign * (d6*( Math.sin(ranRad)));  
	
	// b7

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b7.x = b6.x + ranSign * (d7*( Math.cos(ranRad))); 
	b7.y = b6.y + ranSign * (d7*( Math.sin(ranRad)));  
	
	// b8

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b8.x = b7.x + ranSign * (d8*( Math.cos(ranRad))); 
	b8.y = b7.y + ranSign * (d8*( Math.sin(ranRad)));  
	
	// b9

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b9.x = b8.x + ranSign * (d9*( Math.cos(ranRad))); 
	b9.y = b8.y + ranSign * (d9*( Math.sin(ranRad))); 
	
	// b10

	ranRad = Math.random() * Math.PI - Math.PI/2;
	ranSign = 1;
	if (Math.random()<0.5) ranSign *= -1.0;	
	b10.x = b9.x + ranSign * (d10*( Math.cos(ranRad))); 
	b10.y = b9.y + ranSign * (d10*( Math.sin(ranRad))); 
	
	
	}  //3
    try {  //3	
	   
	    for (it = 1; it <= 1000; it++) {  //4
	    	System.out.println("i="+it);
	    	/* These are the examined rotations. The ball being rotated around
	    	 * surronded by parentheses. Note that positive e.g. +rad changes to
	    	 * ball(s) in opposite direction than expected because screen y-axis
	    	 * is reversed. So rad+ moves clockwise.
	    	 */
	    	// B1 around (B2)-B3-B4-B5-B6-B7-B8-B9-B10	 (+rad)    	
	    	// B1 around (B2)-B3-B4-B5-B6-B7-B8-B9-B10	 (-rad)  
	    	// B1-B2 around (B3)-B4-B5-B6-B7-B8-B9-B10	 (+rad)   
	    	// B1-B2 around (B3)-B4-B5-B6-B7-B8-B9-B10	 (-rad)   
	    	// B1-B2-B3 around (B4)-B5-B6-B7-B8-B9-B10	 (+rad) 
	    	// B1-B2-B3 around (B4)-B5-B6-B7-B8-B9-B10	 (-rad)
	    	// B1-B2-B3-B4 around (B5)-B6-B7-B8-B9-B10   (+rad)
	    	// B1-B2-B3-B4 around (B5)-B6-B7-B8-B9-B10   (-rad)
	    	// B1-B2-B3-B4-B5 around (B6)-B7-B8-B9-B10   (+rad)
	    	// B1-B2-B3-B4-B5 around (B6)-B7-B8-B9-B10   (-rad)
	    	// B10 around (B9)-B8-B7-B6-B5-B4-B3-B2-B1	 (+rad) 
	    	// B10 around (B9)-B8-B7-B6-B5-B4-B3-B2-B1	 (-rad) 
	    	// B10-B9 around (B8)-B7-B6-B5-B4-B3-B2-B1	 (+rad) 
	    	// B10-B9 around (B8)-B7-B6-B5-B4-B3-B2-B1	 (-rad)
	    	// B10-B9-B8 around (B7)-B6-B5-B4-B3-B2-B1	 (+rad)
	    	// B10-B9-B8 around (B7)-B6-B5-B4-B3-B2-B1	 (-rad)
	    	// B10-B9-B8-B7 around (B6)-B5-B4-B3-B2-B1	 (+rad)
	    	// B10-B9-B8-B7 around (B6)-B5-B4-B3-B2-B1	 (-rad)
	    	// B10-B9-B8-B7-B6 around (B5)-B4-B3-B2-B1	 (+rad)
	    	// B10-B9-B8-B7-B6 around (B5)-B4-B3-B2-B1	 (-rad)
	    		    	
	    	    	    	
	    	// B1 around (B2)-B3-B4-B5-B6-B7-B8-B9-B10	 (+rad) 	    	
	    	initCx();	    	
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b2.x-b1.x)*(b2.x-b1.x)+(b2.y-b1.y)*(b2.y-b1.y));
	    	System.out.println("dist b1-b2 = "+d1);
	    	
	    	// b1---b2
	    	
	    	if (b1.x > b2.x) {  //5
	    		c1.x = (b2.x + d1*( Math.cos(0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );
	    		c1.y = (b2.y + d1*( Math.sin(0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );	    	
	    	} else {  //5
	    		c1.x = (b2.x - d1*( Math.cos(0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );
	    		c1.y = (b2.y - d1*( Math.sin(0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	    	
	    	// B1 around (B2)-B3-B4-B5-B6-B7-B8-B9-B10	 (-rad) 
	    	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b2.x-b1.x)*(b2.x-b1.x)+(b2.y-b1.y)*(b2.y-b1.y));
	    	
	    	// b1---b2
	    	
	    	if (b1.x > b2.x) {  //5
	    		c1.x = (b2.x + d1*( Math.cos(-0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );
	    		c1.y = (b2.y + d1*( Math.sin(-0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );	    	
	    	} else {  //5
	    		c1.x = (b2.x - d1*( Math.cos(-0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );
	    		c1.y = (b2.y - d1*( Math.sin(-0.05 + Math.atan( (b2.y-b1.y)/(b2.x - b1.x) ) ) ) );	 
	    	}
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5

	    	
	    	// B1-B2 around (B3)-B4-B5-B6-B7-B8-B9-B10	 (+rad)
	   	 
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b3.x-b1.x)*(b3.x-b1.x)+(b3.y-b1.y)*(b3.y-b1.y));
	    	d2 = Math.sqrt((b3.x-b2.x)*(b3.x-b2.x)+(b3.y-b2.y)*(b3.y-b2.y));	    	
	    	System.out.println("dist b2-b3 = "+d2);
	    	
	    	// b1---b3
	    	
	    	if (b1.x > b3.x) {  //5
	    		c1.x = (b3.x + d1*( Math.cos(0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    		c1.y = (b3.y + d1*( Math.sin(0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b3.x - d1*( Math.cos(0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    		c1.y = (b3.y - d1*( Math.sin(0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    	} //5	    		
	    	
	    	// b2---b3
	    	
	    	if (b2.x > b3.x) {  //5
	    		c2.x = (b3.x + d2*( Math.cos(0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    		c2.y = (b3.y + d2*( Math.sin(0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b3.x - d2*( Math.cos(0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    		c2.y = (b3.y - d2*( Math.sin(0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	   	    	
	    	
	    	// B1-B2 around (B3)-B4-B5-B6-B7-B8-B9-B10	 (-rad)
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b3.x-b1.x)*(b3.x-b1.x)+(b3.y-b1.y)*(b3.y-b1.y));
	    	d2 = Math.sqrt((b3.x-b2.x)*(b3.x-b2.x)+(b3.y-b2.y)*(b3.y-b2.y));	    	
	    	
	    	// b1---b3
	    	
	    	if (b1.x > b3.x) {  //5
	    		c1.x = (b3.x + d1*( Math.cos(-0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    		c1.y = (b3.y + d1*( Math.sin(-0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b3.x - d1*( Math.cos(-0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    		c1.y = (b3.y - d1*( Math.sin(-0.05 + Math.atan( (b3.y-b1.y)/(b3.x - b1.x) ) ) ) );
	    	} //5	    		
	    	
	    	// b2---b3
	    	
	    	if (b2.x > b3.x) {  //5
	    		c2.x = (b3.x + d2*( Math.cos(-0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    		c2.y = (b3.y + d2*( Math.sin(-0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b3.x - d2*( Math.cos(-0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    		c2.y = (b3.y - d2*( Math.sin(-0.05 + Math.atan( (b3.y-b2.y)/(b3.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	       
	    	// B1-B2-B3 around (B4)-B5-B6-B7-B8-B9-B10	 (+rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b4.x-b1.x)*(b4.x-b1.x)+(b4.y-b1.y)*(b4.y-b1.y));
	    	d2 = Math.sqrt((b4.x-b2.x)*(b4.x-b2.x)+(b4.y-b2.y)*(b4.y-b2.y));
	    	d3 = Math.sqrt((b4.x-b3.x)*(b4.x-b3.x)+(b4.y-b3.y)*(b4.y-b3.y));
	    	System.out.println("dist b3-b4 = "+d3);

	    	// b1---b4
	    	
	    	if (b1.x > b4.x) {  //5
	    		c1.x = (b4.x + d1*( Math.cos(0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    		c1.y = (b4.y + d1*( Math.sin(0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b4.x - d1*( Math.cos(0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    		c1.y = (b4.y - d1*( Math.sin(0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );	
	    	} //5	 
	  	
	    		    	
	    	// b2---b4
	    	
	    	if (b2.x > b4.x) {  //5
	    		c2.x = (b4.x + d2*( Math.cos(0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    		c2.y = (b4.y + d2*( Math.sin(0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b4.x - d2*( Math.cos(0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    		c2.y = (b4.y - d2*( Math.sin(0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b3---b4
	    	
	    	if (b3.x > b4.x) {  //5
	    		c3.x = (b4.x + d3*( Math.cos(0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    		c3.y = (b4.y + d3*( Math.sin(0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b4.x - d3*( Math.cos(0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    		c3.y = (b4.y - d3*( Math.sin(0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    	} //5	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	    	
	    	// B1-B2-B3 around (B4)-B5-B6-B7-B8-B9-B10	 (-rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);;
	    	d1 = Math.sqrt((b4.x-b1.x)*(b4.x-b1.x)+(b4.y-b1.y)*(b4.y-b1.y));
	    	d2 = Math.sqrt((b4.x-b2.x)*(b4.x-b2.x)+(b4.y-b2.y)*(b4.y-b2.y));
	    	d3 = Math.sqrt((b4.x-b3.x)*(b4.x-b3.x)+(b4.y-b3.y)*(b4.y-b3.y));

	    	// b1---b4
	    	
	    	if (b1.x > b4.x) {  //5
	    		c1.x = (b4.x + d1*( Math.cos(-0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    		c1.y = (b4.y + d1*( Math.sin(-0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b4.x - d1*( Math.cos(-0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    		c1.y = (b4.y - d1*( Math.sin(-0.05 + Math.atan( (b4.y-b1.y)/(b4.x - b1.x) ) ) ) );
	    	} //5	 
	    	    		    	
	    	// b2---b4
	    	
	    	if (b2.x > b4.x) {  //5
	    		c2.x = (b4.x + d2*( Math.cos(-0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    		c2.y = (b4.y + d2*( Math.sin(-0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b4.x - d2*( Math.cos(-0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    		c2.y = (b4.y - d2*( Math.sin(-0.05 + Math.atan( (b4.y-b2.y)/(b4.x - b2.x) ) ) ) );
	    	} //5	
	       	
	    	// b3---b4
	    	
	    	if (b3.x > b4.x) {  //5
	    		c3.x = (b4.x + d3*( Math.cos(-0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    		c3.y = (b4.y + d3*( Math.sin(-0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b4.x - d3*( Math.cos(-0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    		c3.y = (b4.y - d3*( Math.sin(-0.05 + Math.atan( (b4.y-b3.y)/(b4.x - b3.x) ) ) ) );
	    	} //5	
	    	
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5

	    	// B1-B2-B3-B4 around (B5)-B6-B7-B8-B9-B10	 (+rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b5.x-b1.x)*(b5.x-b1.x)+(b5.y-b1.y)*(b5.y-b1.y));
	    	d2 = Math.sqrt((b5.x-b2.x)*(b5.x-b2.x)+(b5.y-b2.y)*(b5.y-b2.y));
	    	d3 = Math.sqrt((b5.x-b3.x)*(b5.x-b3.x)+(b5.y-b3.y)*(b5.y-b3.y));
	    	d4 = Math.sqrt((b5.x-b4.x)*(b5.x-b4.x)+(b5.y-b4.y)*(b5.y-b4.y));
	    	System.out.println("dist b5-b4 = "+d4);

	    	// b1---b5
	    	
	    	if (b1.x > b5.x) {  //5
	    		c1.x = (b5.x + d1*( Math.cos(0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    		c1.y = (b5.y + d1*( Math.sin(0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b5.x - d1*( Math.cos(0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    		c1.y = (b5.y - d1*( Math.sin(0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );	
	    	} //5	 
	  	
	    		    	
	    	// b2---b5
	    	
	    	if (b2.x > b5.x) {  //5
	    		c2.x = (b5.x + d2*( Math.cos(0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    		c2.y = (b5.y + d2*( Math.sin(0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b5.x - d2*( Math.cos(0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    		c2.y = (b5.y - d2*( Math.sin(0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b3---b5
	    	
	    	if (b3.x > b5.x) {  //5
	    		c3.x = (b5.x + d3*( Math.cos(0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    		c3.y = (b5.y + d3*( Math.sin(0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b5.x - d3*( Math.cos(0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    		c3.y = (b5.y - d3*( Math.sin(0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b4---b5
	    	
	    	if (b4.x > b5.x) {  //5
	    		c4.x = (b5.x + d4*( Math.cos(0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    		c4.y = (b5.y + d4*( Math.sin(0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    	} else {  //5	
	    		c4.x = (b5.x - d4*( Math.cos(0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    		c4.y = (b5.y - d4*( Math.sin(0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    	} //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	    	// B1-B2-B3-B4 around (B5)-B6-B7-B8-B9-B10	 (-rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b5.x-b1.x)*(b5.x-b1.x)+(b5.y-b1.y)*(b5.y-b1.y));
	    	d2 = Math.sqrt((b5.x-b2.x)*(b5.x-b2.x)+(b5.y-b2.y)*(b5.y-b2.y));
	    	d3 = Math.sqrt((b5.x-b3.x)*(b5.x-b3.x)+(b5.y-b3.y)*(b5.y-b3.y));
	    	d4 = Math.sqrt((b5.x-b4.x)*(b5.x-b4.x)+(b5.y-b4.y)*(b5.y-b4.y));
	    	System.out.println("dist b5-b4 = "+d4);

	    	// b1---b5
	    	
	    	if (b1.x > b5.x) {  //5
	    		c1.x = (b5.x + d1*( Math.cos(-0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    		c1.y = (b5.y + d1*( Math.sin(-0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b5.x - d1*( Math.cos(-0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );
	    		c1.y = (b5.y - d1*( Math.sin(-0.05 + Math.atan( (b5.y-b1.y)/(b5.x - b1.x) ) ) ) );	
	    	} //5	 
	  	
	    		    	
	    	// b2---b5
	    	
	    	if (b2.x > b5.x) {  //5
	    		c2.x = (b5.x + d2*( Math.cos(-0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    		c2.y = (b5.y + d2*( Math.sin(-0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b5.x - d2*( Math.cos(-0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    		c2.y = (b5.y - d2*( Math.sin(-0.05 + Math.atan( (b5.y-b2.y)/(b5.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b3---b5
	    	
	    	if (b3.x > b5.x) {  //5
	    		c3.x = (b5.x + d3*( Math.cos(-0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    		c3.y = (b5.y + d3*( Math.sin(-0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b5.x - d3*( Math.cos(-0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    		c3.y = (b5.y - d3*( Math.sin(-0.05 + Math.atan( (b5.y-b3.y)/(b5.x - b3.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b4---b5
	    	
	    	if (b4.x > b5.x) {  //5
	    		c4.x = (b5.x + d4*( Math.cos(-0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    		c4.y = (b5.y + d4*( Math.sin(-0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    	} else {  //5	
	    		c4.x = (b5.x - d4*( Math.cos(-0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    		c4.y = (b5.y - d4*( Math.sin(-0.05 + Math.atan( (b5.y-b4.y)/(b5.x - b4.x) ) ) ) );
	    	} //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    			
	    	// B1-B2-B3-B4-B5 around (B6)-B7-B8-B9-B10	 (+rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b6.x-b1.x)*(b6.x-b1.x)+(b6.y-b1.y)*(b6.y-b1.y));
	    	d2 = Math.sqrt((b6.x-b2.x)*(b6.x-b2.x)+(b6.y-b2.y)*(b6.y-b2.y));
	    	d3 = Math.sqrt((b6.x-b3.x)*(b6.x-b3.x)+(b6.y-b3.y)*(b6.y-b3.y));
	    	d4 = Math.sqrt((b6.x-b4.x)*(b6.x-b4.x)+(b6.y-b4.y)*(b6.y-b4.y));
	    	d5 = Math.sqrt((b6.x-b5.x)*(b6.x-b5.x)+(b6.y-b5.y)*(b6.y-b5.y));
	    	System.out.println("dist b5-b4 = "+d4);

	    	// b1---b6
	    	
	    	if (b1.x > b6.x) {  //5
	    		c1.x = (b6.x + d1*( Math.cos(0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    		c1.y = (b6.y + d1*( Math.sin(0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b6.x - d1*( Math.cos(0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    		c1.y = (b6.y - d1*( Math.sin(0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );	
	    	} //5	 
	  	
	    		    	
	    	// b2---b6
	    	
	    	if (b2.x > b6.x) {  //5
	    		c2.x = (b6.x + d2*( Math.cos(0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    		c2.y = (b6.y + d2*( Math.sin(0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b6.x - d2*( Math.cos(0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    		c2.y = (b6.y - d2*( Math.sin(0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b3---b6
	    	
	    	if (b3.x > b6.x) {  //5
	    		c3.x = (b6.x + d3*( Math.cos(0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    		c3.y = (b6.y + d3*( Math.sin(0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b6.x - d3*( Math.cos(0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    		c3.y = (b6.y - d3*( Math.sin(0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b4---b6
	    	
	    	if (b4.x > b6.x) {  //5
	    		c4.x = (b6.x + d4*( Math.cos(0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		c4.y = (b6.y + d4*( Math.sin(0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    	} else {  //5	
	    		c4.x = (b6.x - d4*( Math.cos(0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		c4.y = (b6.y - d4*( Math.sin(0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		
	    	} //5
	    	
	    	// b5---b6
	    	
	    	if (b5.x > b6.x) {  //5
	    		c5.x = (b6.x + d5*( Math.cos(0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		c5.y = (b6.y + d5*( Math.sin(0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    	} else {  //5	
	    		c5.x = (b6.x - d5*( Math.cos(0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		c5.y = (b6.y - d5*( Math.sin(0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		
	    	} //5   
	     	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
    		
	    	// B1-B2-B3-B4-B5 around (B6)-B7-B8-B9-B10	 (-rad) 
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d1 = Math.sqrt((b6.x-b1.x)*(b6.x-b1.x)+(b6.y-b1.y)*(b6.y-b1.y));
	    	d2 = Math.sqrt((b6.x-b2.x)*(b6.x-b2.x)+(b6.y-b2.y)*(b6.y-b2.y));
	    	d3 = Math.sqrt((b6.x-b3.x)*(b6.x-b3.x)+(b6.y-b3.y)*(b6.y-b3.y));
	    	d4 = Math.sqrt((b6.x-b4.x)*(b6.x-b4.x)+(b6.y-b4.y)*(b6.y-b4.y));
	    	d5 = Math.sqrt((b6.x-b5.x)*(b6.x-b5.x)+(b6.y-b5.y)*(b6.y-b5.y));
	    	System.out.println("dist b5-b4 = "+d4);

	    	// b1---b6
	    	
	    	if (b1.x > b6.x) {  //5
	    		c1.x = (b6.x + d1*( Math.cos(-0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    		c1.y = (b6.y + d1*( Math.sin(-0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    	} else {  //5	
	    		c1.x = (b6.x - d1*( Math.cos(-0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );
	    		c1.y = (b6.y - d1*( Math.sin(-0.05 + Math.atan( (b6.y-b1.y)/(b6.x - b1.x) ) ) ) );	
	    	} //5	 
	  	
	    		    	
	    	// b2---b6
	    	
	    	if (b2.x > b6.x) {  //5
	    		c2.x = (b6.x + d2*( Math.cos(-0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    		c2.y = (b6.y + d2*( Math.sin(-0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    	} else {  //5	
	    		c2.x = (b6.x - d2*( Math.cos(-0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    		c2.y = (b6.y - d2*( Math.sin(-0.05 + Math.atan( (b6.y-b2.y)/(b6.x - b2.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b3---b6
	    	
	    	if (b3.x > b6.x) {  //5
	    		c3.x = (b6.x + d3*( Math.cos(-0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    		c3.y = (b6.y + d3*( Math.sin(-0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    	} else {  //5	
	    		c3.x = (b6.x - d3*( Math.cos(-0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    		c3.y = (b6.y - d3*( Math.sin(-0.05 + Math.atan( (b6.y-b3.y)/(b6.x - b3.x) ) ) ) );
	    	} //5	
	    	
	    	
	    	// b4---b6
	    	
	    	if (b4.x > b6.x) {  //5
	    		c4.x = (b6.x + d4*( Math.cos(-0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		c4.y = (b6.y + d4*( Math.sin(-0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    	} else {  //5	
	    		c4.x = (b6.x - d4*( Math.cos(-0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		c4.y = (b6.y - d4*( Math.sin(-0.05 + Math.atan( (b6.y-b4.y)/(b6.x - b4.x) ) ) ) );
	    		
	    	} //5
	    	
	    	// b5---b6
	    	
	    	if (b5.x > b6.x) {  //5
	    		c5.x = (b6.x + d5*( Math.cos(-0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		c5.y = (b6.y + d5*( Math.sin(-0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    	} else {  //5	
	    		c5.x = (b6.x - d5*( Math.cos(-0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		c5.y = (b6.y - d5*( Math.sin(-0.05 + Math.atan( (b6.y-b5.y)/(b6.x - b5.x) ) ) ) );
	    		
	    	} //5   
	     	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5 		
	    	

	    	// B10 around (B9)-B8-B7-B6-B5-B4-B3-B2-B1	 (+rad)    
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b9.x)*(b10.x-b9.x)+(b10.y-b9.y)*(b10.y-b9.y));
	    	
	    	// b10---b9
	
	    	if (b10.x > b9.x) {  //5
	    		c10.x = (b9.x + d10*( Math.cos(0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );
	    		c10.y = (b9.y + d10*( Math.sin(0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b9.x - d10*( Math.cos(0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );
	    		c10.y = (b9.y - d10*( Math.sin(0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
    		
    		// B10 around (B9)-B8-B7-B6-B5-B4-B3-B2-B1	 (-rad)    
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b9.x)*(b10.x-b9.x)+(b10.y-b9.y)*(b10.y-b9.y));
	    	
	    	// b10---b9
	
	    	if (b10.x > b9.x) {  //5
	    		c10.x = (b9.x + d10*( Math.cos(-0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );
	    		c10.y = (b9.y + d10*( Math.sin(-0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b9.x - d10*( Math.cos(-0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );
	    		c10.y = (b9.y - d10*( Math.sin(-0.05 + Math.atan( (b9.y-b10.y)/(b9.x - b10.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    
	    	
	    	// B10-B9 around (B8)-B7-B6-B5-B4-B3-B2-B1	 (+rad)	    
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d5 = Math.sqrt((b4.x-b5.x)*(b4.x-b5.x)+(b4.y-b5.y)*(b4.y-b5.y));
	    	System.out.println("dist b4-b5 = "+d5);
	    	d10 = Math.sqrt((b10.x-b8.x)*(b10.x-b8.x)+(b10.y-b8.y)*(b10.y-b8.y));	
	    	d9 = Math.sqrt((b9.x-b8.x)*(b9.x-b8.x)+(b9.y-b8.y)*(b9.y-b8.y));	
	    	
	    	// b10---b8
	
	    	if (b10.x > b8.x) {  //5
	    		c10.x = (b8.x + d10*( Math.cos(0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );
	    		c10.y = (b8.y + d10*( Math.sin(0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b8.x - d10*( Math.cos(0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );
	    		c10.y = (b8.y - d10*( Math.sin(0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );	
	    	}  //5
	    		    	    	    	
	    	// b9---b8    	
	
	    	if (b9.x > b8.x) {  //5
	    		c9.x = (b8.x + d9*( Math.cos(0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );
	    		c9.y = (b8.y + d9*( Math.sin(0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b8.x - d9*( Math.cos(0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );
	    		c9.y = (b8.y - d9*( Math.sin(0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5

	    	// B10-B9 around (B8)-B7-B6-B5-B4-B3-B2-B1	 (-rad)	    
    		
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d5 = Math.sqrt((b4.x-b5.x)*(b4.x-b5.x)+(b4.y-b5.y)*(b4.y-b5.y));
	    	System.out.println("dist b4-b5 = "+d5);
	    	d10 = Math.sqrt((b10.x-b8.x)*(b10.x-b8.x)+(b10.y-b8.y)*(b10.y-b8.y));	
	    	d9 = Math.sqrt((b9.x-b8.x)*(b9.x-b8.x)+(b9.y-b8.y)*(b9.y-b8.y));	
	    	
	    	// b10---b8
	
	    	if (b10.x > b8.x) {  //5
	    		c10.x = (b8.x + d10*( Math.cos(-0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );
	    		c10.y = (b8.y + d10*( Math.sin(-0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b8.x - d10*( Math.cos(-0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );
	    		c10.y = (b8.y - d10*( Math.sin(-0.05 + Math.atan( (b8.y-b10.y)/(b8.x - b10.x) ) ) ) );	
	    	}  //5
	    		    	    	    	
	    	// b9---b8    	
	
	    	if (b9.x > b8.x) {  //5
	    		c9.x = (b8.x + d9*( Math.cos(-0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );
	    		c9.y = (b8.y + d9*( Math.sin(-0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b8.x - d9*( Math.cos(-0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );
	    		c9.y = (b8.y - d9*( Math.sin(-0.05 + Math.atan( (b8.y-b9.y)/(b8.x - b9.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	    	    	
	    	
	    	// B10-B9-B8 around (B7)-B6-B5-B4-B3-B2-B1    (+rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b7.x)*(b10.x-b7.x)+(b10.y-b7.y)*(b10.y-b7.y));
	    	d9 = Math.sqrt((b9.x-b7.x)*(b9.x-b7.x)+(b9.y-b7.y)*(b9.y-b7.y));
	    	d8 = Math.sqrt((b8.x-b7.x)*(b8.x-b7.x)+(b8.y-b7.y)*(b8.y-b7.y));
	    	
	    	// b10---b7
	 	
	    	if (b10.x > b7.x) {  //5
	    		c10.x = (b7.x + d10*( Math.cos(0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );
	    		c10.y = (b7.y + d10*( Math.sin(0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b7.x - d10*( Math.cos(0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );
	    		c10.y = (b7.y - d10*( Math.sin(0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b7
	
	    	if (b9.x > b7.x) {  //5
	    		c9.x = (b7.x + d9*( Math.cos(0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );
	    		c9.y = (b7.y + d9*( Math.sin(0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b7.x - d9*( Math.cos(0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );
	    		c9.y = (b7.y - d9*( Math.sin(0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b7
	
	    	if (b8.x > b7.x) {  //5
	    		c8.x = (b7.x + d8*( Math.cos(0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );
	    		c8.y = (b7.y + d8*( Math.sin(0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b7.x - d8*( Math.cos(0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );
	    		c8.y = (b7.y - d8*( Math.sin(0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	
    		
	    	// B10-B9-B8 around (B7)-B6-B5-B4-B3-B2-B1    (-rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b7.x)*(b10.x-b7.x)+(b10.y-b7.y)*(b10.y-b7.y));
	    	d9 = Math.sqrt((b9.x-b7.x)*(b9.x-b7.x)+(b9.y-b7.y)*(b9.y-b7.y));
	    	d8 = Math.sqrt((b8.x-b7.x)*(b8.x-b7.x)+(b8.y-b7.y)*(b8.y-b7.y));
	    	
	    	// b10---b7
	 	
	    	if (b10.x > b7.x) {  //5
	    		c10.x = (b7.x + d10*( Math.cos(-0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );
	    		c10.y = (b7.y + d10*( Math.sin(-0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b7.x - d10*( Math.cos(-0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );
	    		c10.y = (b7.y - d10*( Math.sin(-0.05 + Math.atan( (b7.y-b10.y)/(b7.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b7
	
	    	if (b9.x > b7.x) {  //5
	    		c9.x = (b7.x + d9*( Math.cos(-0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );
	    		c9.y = (b7.y + d9*( Math.sin(-0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b7.x - d9*( Math.cos(-0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );
	    		c9.y = (b7.y - d9*( Math.sin(-0.05 + Math.atan( (b7.y-b9.y)/(b7.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b7
	
	    	if (b8.x > b7.x) {  //5
	    		c8.x = (b7.x + d8*( Math.cos(-0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );
	    		c8.y = (b7.y + d8*( Math.sin(-0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b7.x - d8*( Math.cos(-0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );
	    		c8.y = (b7.y - d8*( Math.sin(-0.05 + Math.atan( (b7.y-b8.y)/(b7.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	    	
	    	// B10-B9-B8-B7 around (B6)-B5-B4-B3-B2-B1    (+rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b6.x)*(b10.x-b6.x)+(b10.y-b6.y)*(b10.y-b6.y));
	    	d9 = Math.sqrt((b9.x-b6.x)*(b9.x-b6.x)+(b9.y-b6.y)*(b9.y-b6.y));
	    	d8 = Math.sqrt((b8.x-b6.x)*(b8.x-b6.x)+(b8.y-b6.y)*(b8.y-b6.y));
	    	d7 = Math.sqrt((b7.x-b6.x)*(b7.x-b6.x)+(b7.y-b6.y)*(b7.y-b6.y));
	    	
	    	// b10---b6
	 	
	    	if (b10.x > b6.x) {  //5
	    		c10.x = (b6.x + d10*( Math.cos(0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );
	    		c10.y = (b6.y + d10*( Math.sin(0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b6.x - d10*( Math.cos(0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );
	    		c10.y = (b6.y - d10*( Math.sin(0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b6
	
	    	if (b9.x > b6.x) {  //5
	    		c9.x = (b6.x + d9*( Math.cos(0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );
	    		c9.y = (b6.y + d9*( Math.sin(0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b6.x - d9*( Math.cos(0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );
	    		c9.y = (b6.y - d9*( Math.sin(0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b6
	
	    	if (b8.x > b6.x) {  //5
	    		c8.x = (b6.x + d8*( Math.cos(0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );
	    		c8.y = (b6.y + d8*( Math.sin(0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b6.x - d8*( Math.cos(0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );
	    		c8.y = (b6.y - d8*( Math.sin(0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	// b7---b6
	    	
	    	if (b7.x > b6.x) {  //5
	    		c7.x = (b6.x + d7*( Math.cos(0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );
	    		c7.y = (b6.y + d7*( Math.sin(0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );	    	
	    	} else {  //5
	    		c7.x = (b6.x - d7*( Math.cos(0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );
	    		c7.y = (b6.y - d7*( Math.sin(0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );	
	    	}  //5
	    	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
    		
	
	    	// B10-B9-B8-B7 around (B6)-B5-B4-B3-B2-B1    (-rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b6.x)*(b10.x-b6.x)+(b10.y-b6.y)*(b10.y-b6.y));
	    	d9 = Math.sqrt((b9.x-b6.x)*(b9.x-b6.x)+(b9.y-b6.y)*(b9.y-b6.y));
	    	d8 = Math.sqrt((b8.x-b6.x)*(b8.x-b6.x)+(b8.y-b6.y)*(b8.y-b6.y));
	    	d7 = Math.sqrt((b7.x-b6.x)*(b7.x-b6.x)+(b7.y-b6.y)*(b7.y-b6.y));
	    	
	    	// b10---b6
	 	
	    	if (b10.x > b6.x) {  //5
	    		c10.x = (b6.x + d10*( Math.cos(-0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );
	    		c10.y = (b6.y + d10*( Math.sin(-0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b6.x - d10*( Math.cos(-0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );
	    		c10.y = (b6.y - d10*( Math.sin(-0.05 + Math.atan( (b6.y-b10.y)/(b6.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b6
	
	    	if (b9.x > b6.x) {  //5
	    		c9.x = (b6.x + d9*( Math.cos(-0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );
	    		c9.y = (b6.y + d9*( Math.sin(-0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b6.x - d9*( Math.cos(-0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );
	    		c9.y = (b6.y - d9*( Math.sin(-0.05 + Math.atan( (b6.y-b9.y)/(b6.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b6
	
	    	if (b8.x > b6.x) {  //5
	    		c8.x = (b6.x + d8*( Math.cos(-0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );
	    		c8.y = (b6.y + d8*( Math.sin(-0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b6.x - d8*( Math.cos(-0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );
	    		c8.y = (b6.y - d8*( Math.sin(-0.05 + Math.atan( (b6.y-b8.y)/(b6.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	// b7---b6
	    	
	    	if (b7.x > b6.x) {  //5
	    		c7.x = (b6.x + d7*( Math.cos(-0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );
	    		c7.y = (b6.y + d7*( Math.sin(-0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );	    	
	    	} else {  //5
	    		c7.x = (b6.x - d7*( Math.cos(-0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );
	    		c7.y = (b6.y - d7*( Math.sin(-0.05 + Math.atan( (b6.y-b7.y)/(b6.x - b7.x) ) ) ) );	
	    	}  //5
	    	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	  		

	    	// B10-B9-B8-B7-B6 around (B5)-B4-B3-B2-B1    (+rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b5.x)*(b10.x-b5.x)+(b10.y-b5.y)*(b10.y-b5.y));
	    	d9 = Math.sqrt((b9.x-b5.x)*(b9.x-b5.x)+(b9.y-b5.y)*(b9.y-b5.y));
	    	d8 = Math.sqrt((b8.x-b5.x)*(b8.x-b5.x)+(b8.y-b5.y)*(b8.y-b5.y));
	    	d7 = Math.sqrt((b7.x-b5.x)*(b7.x-b5.x)+(b7.y-b5.y)*(b7.y-b5.y));
	    	d6 = Math.sqrt((b6.x-b5.x)*(b6.x-b5.x)+(b6.y-b5.y)*(b6.y-b5.y));
	    	
	    	// b10---b5
	 	
	    	if (b10.x > b5.x) {  //5
	    		c10.x = (b5.x + d10*( Math.cos(0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );
	    		c10.y = (b5.y + d10*( Math.sin(0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b5.x - d10*( Math.cos(0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );
	    		c10.y = (b5.y - d10*( Math.sin(0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b5
	
	    	if (b9.x > b5.x) {  //5
	    		c9.x = (b5.x + d9*( Math.cos(0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );
	    		c9.y = (b5.y + d9*( Math.sin(0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b5.x - d9*( Math.cos(0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );
	    		c9.y = (b5.y - d9*( Math.sin(0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b5
	
	    	if (b8.x > b5.x) {  //5
	    		c8.x = (b5.x + d8*( Math.cos(0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );
	    		c8.y = (b5.y + d8*( Math.sin(0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b5.x - d8*( Math.cos(0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );
	    		c8.y = (b5.y - d8*( Math.sin(0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	// b7---b5
	    	
	    	if (b7.x > b5.x) {  //5
	    		c7.x = (b5.x + d7*( Math.cos(0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );
	    		c7.y = (b5.y + d7*( Math.sin(0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );	    	
	    	} else {  //5
	    		c7.x = (b5.x - d7*( Math.cos(0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );
	    		c7.y = (b5.y - d7*( Math.sin(0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );	
	    	}  //5
	    	
	    	// b6---b5
	    	
	    	if (b6.x > b5.x) {  //5
	    		c6.x = (b5.x + d6*( Math.cos(0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );
	    		c6.y = (b5.y + d6*( Math.sin(0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );	    	
	    	} else {  //5
	    		c6.x = (b5.x - d6*( Math.cos(0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );
	    		c6.y = (b5.y - d6*( Math.sin(0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );	
	    	}  //5
	    	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
	    	// B10-B9-B8-B7-B6 around (B5)-B4-B3-B2-B1    (-rad) 	
	    	initCx();
	    	s2cBefore = SumToCenter4(b1,b2,b3,b4,b5,b6,b7,b8,b9,b10);
	    	d10 = Math.sqrt((b10.x-b5.x)*(b10.x-b5.x)+(b10.y-b5.y)*(b10.y-b5.y));
	    	d9 = Math.sqrt((b9.x-b5.x)*(b9.x-b5.x)+(b9.y-b5.y)*(b9.y-b5.y));
	    	d8 = Math.sqrt((b8.x-b5.x)*(b8.x-b5.x)+(b8.y-b5.y)*(b8.y-b5.y));
	    	d7 = Math.sqrt((b7.x-b5.x)*(b7.x-b5.x)+(b7.y-b5.y)*(b7.y-b5.y));
	    	d6 = Math.sqrt((b6.x-b5.x)*(b6.x-b5.x)+(b6.y-b5.y)*(b6.y-b5.y));
	    	
	    	// b10---b5
	 	
	    	if (b10.x > b5.x) {  //5
	    		c10.x = (b5.x + d10*( Math.cos(-0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );
	    		c10.y = (b5.y + d10*( Math.sin(-0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );	    	
	    	} else {  //5
	    		c10.x = (b5.x - d10*( Math.cos(-0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );
	    		c10.y = (b5.y - d10*( Math.sin(-0.05 + Math.atan( (b5.y-b10.y)/(b5.x - b10.x) ) ) ) );	
	    	}  //5	    	
	    	
	    	// b9---b5
	
	    	if (b9.x > b5.x) {  //5
	    		c9.x = (b5.x + d9*( Math.cos(-0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );
	    		c9.y = (b5.y + d9*( Math.sin(-0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );	    	
	    	} else {  //5
	    		c9.x = (b5.x - d9*( Math.cos(-0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );
	    		c9.y = (b5.y - d9*( Math.sin(-0.05 + Math.atan( (b5.y-b9.y)/(b5.x - b9.x) ) ) ) );	
	    	}  //5
	  
	    	// b8---b5
	
	    	if (b8.x > b5.x) {  //5
	    		c8.x = (b5.x + d8*( Math.cos(-0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );
	    		c8.y = (b5.y + d8*( Math.sin(-0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );	    	
	    	} else {  //5
	    		c8.x = (b5.x - d8*( Math.cos(-0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );
	    		c8.y = (b5.y - d8*( Math.sin(-0.05 + Math.atan( (b5.y-b8.y)/(b5.x - b8.x) ) ) ) );	
	    	}  //5
	    	
	    	// b7---b5
	    	
	    	if (b7.x > b5.x) {  //5
	    		c7.x = (b5.x + d7*( Math.cos(-0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );
	    		c7.y = (b5.y + d7*( Math.sin(-0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );	    	
	    	} else {  //5
	    		c7.x = (b5.x - d7*( Math.cos(-0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );
	    		c7.y = (b5.y - d7*( Math.sin(-0.05 + Math.atan( (b5.y-b7.y)/(b5.x - b7.x) ) ) ) );	
	    	}  //5
	    	
	    	// b6---b5
	    	
	    	if (b6.x > b5.x) {  //5
	    		c6.x = (b5.x + d6*( Math.cos(-0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );
	    		c6.y = (b5.y + d6*( Math.sin(-0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );	    	
	    	} else {  //5
	    		c6.x = (b5.x - d6*( Math.cos(-0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );
	    		c6.y = (b5.y - d6*( Math.sin(-0.05 + Math.atan( (b5.y-b6.y)/(b5.x - b6.x) ) ) ) );	
	    	}  //5
	    	
	    	
	    	s2cAfter = SumToCenter4(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
    		if (s2cAfter < s2cBefore) {  //5
    			swapInCx();
    		}  //5
	    	
    		
	    	// Draw !
    		if (sum!=lastSum) hi = it;
	    	drawBalls(g);
	    	lastSum=sum;
        
	    }  //4
    } catch (Exception e) {  //3
    }  //3
  }  //2
  
  /*
   * Sim3: Support methods
   */
  
   public double SumToCenter4(Ball4 o1, Ball4 o2, Ball4 o3, Ball4 o4, Ball4 o5, Ball4 o6, Ball4 o7, Ball4 o8, Ball4 o9, Ball4 o10 ) {  //2
	  sum = 0;
	  cx = 0;
	  cy = 0;
	  double cumx = 0;
	  double cumy = 0;

	  int c = 0;
	  
	  if (b1.phobic != 0) {  //3
		  cumx += o1.x;
		  cumy += o1.y;
		  c++;
		  
	  }  //3
	  if (b2.phobic != 0) {
		  cumx += o2.x;
		  cumy += o2.y;
		  c++;
		  
	  }
	  if (b3.phobic != 0) {
		  cumx += o3.x;
		  cumy += o3.y;
		  c++;
		  
	  }
	  if (b4.phobic != 0) {
		  cumx += o4.x;
		  cumy += o4.y;
		  c++;
		  
	  }
	  if (b5.phobic != 0) {
		  cumx += o5.x;
		  cumy += o5.y;
		  c++;
		  
	  }
	  if (b6.phobic != 0) {
		  cumx += o6.x;
		  cumy += o6.y;
		  c++;
		  
	  }  	  
	  if (b7.phobic != 0) {  //3
		  cumx += o7.x;
		  cumy += o7.y;
		  c++;
		  
	  }  
	  if (b8.phobic != 0) {
		  cumx += o8.x;
		  cumy += o8.y;
		  c++;
		  
	  }
	  if (b9.phobic != 0) {
		  cumx += o9.x;
		  cumy += o9.y;
		  c++;
		  
	  }
	  if (b10.phobic != 0) {
		  cumx += o10.x;
		  cumy += o10.y;
		  c++;
		  
	  }
	  
	  cx = cumx/c;
	  cy = cumy/c;
	  
	  if (b1.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o1.x)*(cx-o1.x) + (cy-o1.y)*(cy-o1.y) ); 
	  }
	  if (b2.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o2.x)*(cx-o2.x) + (cy-o2.y)*(cy-o2.y) );
	  }
	  if (b3.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o3.x)*(cx-o3.x) + (cy-o3.y)*(cy-o3.y) );
	  }
	  if (b4.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o4.x)*(cx-o4.x) + (cy-o4.y)*(cy-o4.y) );
	  }
	  if (b5.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o5.x)*(cx-o5.x) + (cy-o5.y)*(cy-o5.y) );
	  }
	  if (b6.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o6.x)*(cx-o6.x) + (cy-o6.y)*(cy-o6.y) );
	  }
	  if (b7.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o7.x)*(cx-o7.x) + (cy-o7.y)*(cy-o7.y) ); 
	  }
	  if (b8.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o8.x)*(cx-o8.x) + (cy-o8.y)*(cy-o8.y) );
	  }
	  if (b9.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o9.x)*(cx-o9.x) + (cy-o9.y)*(cy-o9.y) );
	  }
	  if (b10.phobic != 0) {
	  sum = sum + Math.sqrt( (cx-o10.x)*(cx-o10.x) + (cy-o10.y)*(cy-o10.y) );
	  }
	  
	  return sum;
  }  //2
  
   
  public void drawBalls(Graphics g) {  //2
	  g.clearRect(0, 0, 1200, 700);
	  
	  Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(5));
	    //g2.drawLine(...);   //thick
	  
	    g.setColor(b1.color);	  		    
	    if (b1.phobic != 0) {g.fillOval((int)b1.x, (int)b1.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b1.x, (int)b1.y, XSIZE, YSIZE);
	    }
	    
	    g.setColor(b2.color);
	    if (b2.phobic != 0) {g.fillOval((int)b2.x, (int)b2.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b2.x, (int)b2.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b1.x,(int)b1.y,(int)b2.x,(int)b2.y);

	    g.setColor(b3.color);	
	    if (b3.phobic != 0) {g.fillOval((int)b3.x, (int)b3.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b3.x, (int)b3.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b2.x,(int)b2.y,(int)b3.x,(int)b3.y);
	    
	    g.setColor(b4.color);
	    if (b4.phobic != 0) {g.fillOval((int)b4.x, (int)b4.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b4.x, (int)b4.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b3.x,(int)b3.y,(int)b4.x,(int)b4.y);
	    
	    g.setColor(b5.color);	
	    if (b5.phobic != 0) {g.fillOval((int)b5.x, (int)b5.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b5.x, (int)b5.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b4.x,(int)b4.y,(int)b5.x,(int)b5.y);
	    
	    g.setColor(b6.color);
	    if (b6.phobic != 0) {g.fillOval((int)b6.x, (int)b6.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b6.x, (int)b6.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b5.x,(int)b5.y,(int)b6.x,(int)b6.y);
	    
	    g.setColor(b7.color);
	    if (b7.phobic != 0) {g.fillOval((int)b7.x, (int)b7.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b7.x, (int)b7.y, XSIZE, YSIZE);
	    }
	    g2.drawLine((int)b6.x,(int)b6.y,(int)b7.x,(int)b7.y);
	    
	    g.setColor(b8.color);
	    if (b8.phobic != 0) {g.fillOval((int)b8.x, (int)b8.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b8.x, (int)b8.y, XSIZE, YSIZE);
	    }	    
	    g2.drawLine((int)b7.x,(int)b7.y,(int)b8.x,(int)b8.y);  
	    
	    g.setColor(b9.color);
	    if (b9.phobic != 0) {g.fillOval((int)b9.x, (int)b9.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b9.x, (int)b9.y, XSIZE, YSIZE);
	    }	    
	    g2.drawLine((int)b8.x,(int)b8.y,(int)b9.x,(int)b9.y); 
	    
	    g.setColor(b10.color);
	    if (b10.phobic != 0) {g.fillOval((int)b10.x, (int)b10.y, XSIZE, YSIZE);
	    } else { g.drawOval((int)b10.x, (int)b10.y, XSIZE, YSIZE);
	    }	    
	    g2.drawLine((int)b9.x,(int)b9.y,(int)b10.x,(int)b10.y); 
	        	    
	    /////////////////////	    
	    g.setColor(Color.black);
	    g.fillOval((int)cx, (int)cy, 10, 10);
	    
	    g.drawString("i="+hi+"   PhobicEnergy = "+ sum,500,20);
	    //System.out.println("i="++"  phobic Energy="+sum);
	    
	    try {  //3
	    sleep(100);
	    } catch (Exception e) {  //3
	    }  //3
	    //g.setXORMode(box.getBackground());
	    try {  //3
	   	   sleep(100);
	    } catch (Exception e) {  //3
	    }  //3
  	  
  }  //2
  
  public void initCx() {  //2
	c1.x = b1.x;
	c1.y = b1.y;
	c2.x = b2.x;
	c2.y = b2.y;
	c3.x = b3.x;
	c3.y = b3.y;
	c4.x = b4.x;
	c4.y = b4.y;
	c5.x = b5.x;
	c5.y = b5.y;
	c6.x = b6.x;
	c6.y = b6.y;
	c7.x = b7.x;
	c7.y = b7.y;
	c8.x = b8.x;
	c8.y = b8.y;
	c9.x = b9.x;
	c9.y = b9.y;
	c10.x = b10.x;
	c10.y = b10.y;
	
    }  //2
  
  public void swapInCx() {  //2
	b1.x = c1.x;
	b1.y = c1.y;
	b2.x = c2.x;
	b2.y = c2.y;
	b3.x = c3.x;
	b3.y = c3.y;
	b4.x = c4.x;
	b4.y = c4.y;
	b5.x = c5.x;
	b5.y = c5.y;
	b6.x = c6.x;
	b6.y = c6.y;
	b7.x = c7.x;
	b7.y = c7.y;
	b8.x = c8.x;
	b8.y = c8.y;
	b9.x = c9.x;
	b9.y = c9.y;
	b10.x = c10.x;
	b10.y = c10.y;
  }  //2
  
}  //1


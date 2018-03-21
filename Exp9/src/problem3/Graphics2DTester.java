package problem3;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;


public class Graphics2DTester extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = 8612844987855483962L;

		public Graphics2DTester() {
			super("画图");
			setSize(400,300);
			setVisible(true);
		}
		
		public void paint(Graphics g) {
			Graphics2D g2d=(Graphics2D)g;
		super.paint(g2d);
		
		//写字
		g2d.setColor(Color.red);
		g2d.drawString("膜健神", 150, 100);
		
		//画线
		g2d.setColor(Color.blue);
		Stroke s1 = new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(s1);       
		Line2D line = new Line2D.Double(150,200, 100, 100);
		g2d.draw(line);
		
		//画矩形
		g2d.setColor(Color.green);
		Stroke s2 = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
		g2d.setStroke(s2);       
		Rectangle2D rect1=new Rectangle2D.Double(200, 200, 30, 40);
	    g2d.draw(rect1);
	    
	    g2d.setColor(Color.black);
	    g2d.fillRect(200, 200, 30, 40);
	    
	    g2d.setColor(Color.yellow);
	    Stroke s3 = new BasicStroke(2);
		g2d.setStroke(s3); 
		g2d.draw3DRect(300, 100, 30, 40,true);
		g2d.drawArc(300,200, 50, 30, 20, 180);
		}
		
		public static void main(String[] args) {
			Graphics2DTester test=new Graphics2DTester();
			test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}


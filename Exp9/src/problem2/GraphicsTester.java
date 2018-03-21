package problem2;

import java.awt.*;
import javax.swing.*;


public class GraphicsTester extends JFrame {
		/**
	 * 
	 */
	private static final long serialVersionUID = -2769611441516055636L;

		public GraphicsTester() {
			super("画图");
			setSize(400,300);
			setVisible(true);
		}
		
		public void paint(Graphics g) {
		super.paint(g);
		g.drawString("膜健神", 150, 100);
		g.drawLine(150,200, 50, 50);
		g.fillRect(200, 200, 30, 40);
		g.draw3DRect(300, 100, 30, 40,true);
		g.drawArc(300,200, 50, 30, 20, 180);
		}
		
		public static void main(String[] args) {
			GraphicsTester test=new GraphicsTester();
			test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}

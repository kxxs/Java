
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class scratch extends JFrame {

	public static void main(String[] args) {
		scratch frame = new scratch();
		frame.setVisible(true);
	}

	private static final long serialVersionUID = -1427095837898182149L;
	private JButton button;
	private Robot robot = null;

	public scratch() {
		try {
			robot = new Robot();
		} catch (AWTException exception) {
			exception.printStackTrace();
		}

		setAlwaysOnTop(true);
		setTitle("截图");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 137, 87);

		this.button = new JButton("截图");
		this.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				scratch.this.setVisible(false);//隐藏窗体
				
				scratch.this.robot.delay(100);//延时,保证窗体已经隐藏
				
				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();// 获取屏幕的尺寸
				BufferedImage image = scratch.this.robot
						.createScreenCapture(new Rectangle(0, 0,
								screenSize.width, screenSize.height));// 截取整个屏幕的图像
				
				scratch.this.setVisible(true);//显示窗口
				
				try {
					ImageIO.write(image, "png", new File("screenshot.png"));
					JOptionPane.showMessageDialog(scratch.this,
							"截图成功!\n保存到:screenshot.jpg");
				} catch (IOException exception) {
					exception.printStackTrace();
					JOptionPane.showMessageDialog(scratch.this, "截图失败!");
				}
			}
		});
		getContentPane().add(this.button, BorderLayout.CENTER);
	}

}

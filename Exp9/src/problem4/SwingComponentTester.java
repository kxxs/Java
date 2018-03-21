package problem4;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Font;

public class SwingComponentTester extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5228442829059486648L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingComponentTester frame = new SwingComponentTester();
					frame.setVisible(true);
					frame.setTitle("JFrame Exp");                     
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingComponentTester() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(15, 31, 81, 21);
		contentPane.add(lblInput);
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 25));
		textField.setBounds(72, 25, 122, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 25));
//		textArea.setBounds(219, 85, 286, 241);
//		contentPane.add(textArea);

		String[] listdata= {"膜健神","膜件神","膜鉴神","膜剑神","膜剑神","膜剑神","膜剑神","膜剑神"};

		JList list = new JList(listdata);
		list.setFont(new Font("宋体", Font.PLAIN, 27));
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text=textField.getText();
				String selection=(String)list.getSelectedValue();
				textArea.setText("Input is "+text+"\nSelection is "+selection);
			}
		});
		btnNewButton.setBounds(72, 337, 96, 27);
		contentPane.add(btnNewButton);
		
		JScrollPane jsp1 = new JScrollPane();
        contentPane.add(jsp1);
        jsp1.setBounds(38, 85, 143, 229);
        jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp1.setViewportView(list);
        jsp1.getViewport().setView(list); 
        
		JScrollPane jsp2 = new JScrollPane();
        contentPane.add(jsp2);
        jsp2.setBounds(219, 85, 286, 241);
        jsp2.setViewportView(textArea);
        jsp2.getViewport().setView(textArea); 
	}
}
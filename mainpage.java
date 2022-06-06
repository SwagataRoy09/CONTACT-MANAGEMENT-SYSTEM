package cmsmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class mainpage {
	 public static java.sql.Statement management() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactmanagement", "root", "root");
	        java.sql.Statement st = con.createStatement();
	        return st;
	    }

	public JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
    static mainpage window;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_1;
    private JTextPane USER;
    private JTextPane txtpnPassword;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new mainpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public mainpage() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\home.png"));
		frame.setBackground(new Color(51, 102, 255));
		frame.getContentPane().setBackground(new Color(204, 153, 204));
		frame.setBounds(100, 100, 1435, 725);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
			JButton btnNewButton = new JButton("SUBMIT");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = textField.getText();
					String password = passwordField.getText();
					try {
						 if(name.equals("root") && password.equals("root")) {
							 
								//page2 obj = new page2();
								management();	
								window.frame.setVisible(false);
								new editpage().main(null);
							}
							else {
								JOptionPane.showMessageDialog(null, "INVALID USER NAME OR PASSWORD");
								
							}
							
						} 
					catch (Exception e1) {
						
					}
				  }
					
			});
			
			btnNewButton_1 = new JButton("EXIT");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			txtpnPassword = new JTextPane();
			txtpnPassword.setBackground(new Color(84,84,84,255));
			txtpnPassword.setForeground(new Color(255, 255, 255));
			txtpnPassword.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
			txtpnPassword.setText("PASSWORD");
			txtpnPassword.setBounds(85, 261, 208, 33);
			frame.getContentPane().add(txtpnPassword);
			
			USER = new JTextPane();
			USER.setForeground(new Color(255, 255, 255));
			USER.setBackground(new Color(84,84,84,255));
			USER.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 20));
			USER.setText("USER-NAME");
			USER.setBounds(85, 101, 245, 33);
			frame.getContentPane().add(USER);
			btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			btnNewButton_1.setBackground(new Color(255, 255, 255));
			btnNewButton_1.setForeground(new Color(0, 0, 0));
			btnNewButton_1.setBounds(67, 470, 166, 63);
			frame.getContentPane().add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("LOGIN");
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
			lblNewLabel.setBounds(424, 19, 479, 63);
			frame.getContentPane().add(lblNewLabel);
			btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
			btnNewButton.setForeground(new Color(0, 0, 0));
			btnNewButton.setBackground(new Color(255, 255, 255));
			btnNewButton.setBounds(378, 470, 166, 63);
			frame.getContentPane().add(btnNewButton);
		
//		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
//		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewJgoodiesLabel.setIcon(new ImageIcon("D:\\eclipse\\img2.jpg"));
//		lblNewJgoodiesLabel.setBounds(0, 0, 461, 476);
//		frame.getContentPane().add(lblNewJgoodiesLabel);
//
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		passwordField.setBounds(85, 290, 418, 63);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		textField.setBounds(85, 133, 418, 63);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\insert.png"));
		lblNewLabel_1.setBounds(0, 0, 1528, 810);
		frame.getContentPane().add(lblNewLabel_1);
	}

	private static class DefaultComponentFactory {
	}
}

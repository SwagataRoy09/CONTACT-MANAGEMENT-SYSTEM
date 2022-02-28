package ContactManagement;

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

public class page1 {
	 public static java.sql.Statement management() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactmanagement", "root", "root");
	        java.sql.Statement st = con.createStatement();
	        return st;
	    }

	public JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
    static page1 window;
    private JButton btnNewButton_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new page1();
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
	public page1() throws Exception {
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
		frame.setBounds(100, 100, 953, 513);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
//		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("New JGoodies label");
//		lblNewJgoodiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewJgoodiesLabel.setIcon(new ImageIcon("D:\\eclipse\\img2.jpg"));
//		lblNewJgoodiesLabel.setBounds(0, 0, 461, 476);
//		frame.getContentPane().add(lblNewJgoodiesLabel);
//
		passwordField = new JPasswordField();
		passwordField.setBounds(485, 229, 418, 63);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(485, 120, 418, 63);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
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
							new MainPage().main(null);
						}
						else {
							JOptionPane.showMessageDialog(null, "INVALID USER NAME OR PASSWORD");
							
						}
						
					} 
				catch (Exception e1) {
					
				}
			  }
				
		});
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		btnNewButton.setForeground(new Color(51, 51, 255));
		btnNewButton.setBackground(new Color(255, 255, 153));
		btnNewButton.setBounds(737, 365, 166, 63);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		lblNewLabel.setBounds(485, 41, 418, 41);
		frame.getContentPane().add(lblNewLabel);
		
		btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(255, 255, 153));
		btnNewButton_1.setForeground(new Color(51, 51, 204));
		btnNewButton_1.setBounds(511, 365, 166, 63);
		frame.getContentPane().add(btnNewButton_1);
	}

	private static class DefaultComponentFactory {
	}
}

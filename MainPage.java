package ContactManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage {

	private JFrame frame;
    static MainPage window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new MainPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 0));
		frame.setBackground(new Color(102, 153, 0));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\PH.jpg"));
		frame.setBounds(100, 100, 1183, 486);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton LOGOUT = new JButton("LOGOUT");
		LOGOUT.setBackground(new Color(204, 255, 204));
		LOGOUT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				window.frame.setVisible(false);
				new page1().main(null);
				}
				catch(Exception exc) {
					
				}
			}
		});
		LOGOUT.setForeground(new Color(51, 51, 153));
		LOGOUT.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		LOGOUT.setBounds(486, 331, 214, 78);
		frame.getContentPane().add(LOGOUT);
		
		JButton SHOW = new JButton("SHOW ALL");
		SHOW.setBackground(new Color(204, 255, 204));
		SHOW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		SHOW.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SHOW.setForeground(new Color(51, 51, 204));
		SHOW.setBounds(486, 67, 214, 176);
		frame.getContentPane().add(SHOW);
		
		JButton EDIT = new JButton("EDIT");
		EDIT.setBackground(new Color(204, 255, 204));
		EDIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
				window.frame.setVisible(false);
				new EDIT().main(null);
				}
				catch(Exception exc)
				{
					
				}
			}
		});
		EDIT.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		EDIT.setForeground(new Color(51, 51, 255));
		EDIT.setBounds(875, 67, 214, 176);
		frame.getContentPane().add(EDIT);
		
		JButton insertion = new JButton("INSERT");
		insertion.setBackground(new Color(204, 255, 204));
		insertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				window.frame.setVisible(false);
				new INSERTION().main(null);
				}
				catch(Exception exc) {
					
				}
			}
		});
		insertion.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		insertion.setForeground(new Color(51, 51, 255));
		insertion.setBounds(86, 67, 214, 176);
		frame.getContentPane().add(insertion);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\\img4.jpg"));
		lblNewLabel.setBounds(10, 10, 1159, 439);
		frame.getContentPane().add(lblNewLabel);
	}
}

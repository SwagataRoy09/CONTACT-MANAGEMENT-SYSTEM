package ContactManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class EDIT {

	private JFrame frame;
    static EDIT window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new EDIT();
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
	public EDIT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\images.png"));
		frame.getContentPane().setBackground(new Color(255, 0, 204));
		frame.setBounds(100, 100, 963, 510);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton DELETE = new JButton("DELETE");
		DELETE.setBackground(new Color(255, 204, 255));
		DELETE.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		DELETE.setForeground(new Color(255, 0, 153));
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						window.frame.setVisible(false);
						try {
							new Delete().main(null);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
		});
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				new MainPage().main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(255, 204, 255));
		btnNewButton_1.setForeground(new Color(255, 0, 204));
		btnNewButton_1.setBounds(137, 384, 151, 56);
		frame.getContentPane().add(btnNewButton_1);
		DELETE.setBounds(56, 209, 285, 109);
		frame.getContentPane().add(DELETE);
		
		JButton SEARCH = new JButton("SEARCH");
		SEARCH.setBackground(new Color(255, 204, 255));
		SEARCH.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SEARCH.setForeground(new Color(255, 0, 153));
		SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					window.frame.setVisible(false);
					new SEARCH().main(null);
				} catch (Exception e1) {
				
				}
			}
		});
		SEARCH.setBounds(56, 43, 285, 109);
		frame.getContentPane().add(SEARCH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 0, 153));
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\\img8.jpg"));
		lblNewLabel.setBounds(10, 10, 929, 453);
		frame.getContentPane().add(lblNewLabel);
	}

}

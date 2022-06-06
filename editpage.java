package cmsmain;

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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class editpage {

	private JFrame frame;
    static editpage window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new editpage();
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
	public editpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(102, 102, 102));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\images.png"));
		frame.getContentPane().setBackground(new Color(102, 102, 102));
		frame.setBounds(100, 100, 1489, 797);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton DELETE = new JButton("DELETE");
		DELETE.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\DEL.gif"));
		DELETE.setBackground(new Color(102, 102, 102));
		DELETE.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		DELETE.setForeground(new Color(102, 102, 102));
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						window.frame.setVisible(false);
						try {
							new delete().main(null);
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
				try {
					new mainpage().main(null);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setToolTipText("ADD CONTACT");
		btnNewButton.setForeground(new Color(102, 102, 102));
		btnNewButton.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\adddd.gif"));
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					window.frame.setVisible(false);
					new INSERTION1().main(null);
					}
					catch(Exception exc) {
					}
			}
		});
		btnNewButton.setBounds(48, 57, 306, 258);
		frame.getContentPane().add(btnNewButton);
		btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(658, 530, 151, 56);
		frame.getContentPane().add(btnNewButton_1);
		DELETE.setBounds(515, 57, 312, 258);
		frame.getContentPane().add(DELETE);
		
		JButton SEARCH = new JButton("");
		SEARCH.setToolTipText("UPDATE");
		SEARCH.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\searchh.gif"));
		SEARCH.setBackground(new Color(102, 102, 102));
		SEARCH.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SEARCH.setForeground(new Color(0, 0, 0));
		SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					window.frame.setVisible(false);
					new searchit().main(null);
				} catch (Exception e1) {
				
				}
			}
		});
		SEARCH.setBounds(82, 396, 312, 258);
		frame.getContentPane().add(SEARCH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setToolTipText("DELETE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		lblNewLabel.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\insert.png"));
		lblNewLabel.setBounds(10, 10, 1517, 785);
		frame.getContentPane().add(lblNewLabel);
	}

}

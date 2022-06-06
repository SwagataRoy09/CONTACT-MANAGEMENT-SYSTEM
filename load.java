package cmsmain;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;

public class load {

	private JFrame frame;
	JLabel loading;
	JProgressBar pbar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		load l = new load();
	    l.frame.setVisible(true);
		try {
			for(int i=0;i<=100;i++) {
			Thread.sleep(50);
			l.pbar.setValue(i);
				if(i<=10) {
					l.loading.setText("Turning on Modules... "+i+"%");
				}
				else if(i<=20) {
					l.loading.setText("Loading Components... "+i+"%");
				}
				else if(i<=30) {
					l.loading.setText("Getting previous task... "+i+"%");
				}
				else if(i<=50) {
					l.loading.setText("Connecting to Database... "+i+"%");
					
				}
				else if(i<=70) {
					l.loading.setText("Successfully Connected... "+i+"%");
				}
				else if(i<=80) {
					l.loading.setText("Setting WorkSpace... "+i+"%");
				}
				else {
					l.loading.setText("Getting Started... "+i+"%");
				}
			}
			l.frame.setVisible(false);
			new mainpage().main(null);
		}
		catch (Exception e){
			
		}
	}

	/**
	 * Create the application.
	 */
	public load() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		
		frame.setBounds(100, 100, 500, 400);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pbar = new JProgressBar();
		pbar.setStringPainted(true);
		pbar.setFocusTraversalKeysEnabled(false);
		pbar.setForeground(new Color(255, 255, 255));
		pbar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		pbar.setBackground(new Color(0, 0, 0));
		pbar.setBounds(0, 772, 1633, 26);
		frame.getContentPane().add(pbar);
		
		loading = new JLabel("Loading... 0%");
		loading.setLabelFor(pbar);
		loading.setHorizontalAlignment(SwingConstants.CENTER);
		loading.setForeground(new Color(255, 255, 255));
		loading.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		loading.setBounds(0, 714, 359, 48);
		frame.getContentPane().add(loading);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\2.gif"));
		//		ImageIcon icon = new ImageIcon(this.getClass().getResource("1.gif"));
		//		lblNewLabel.setIcon(icon);
				lblNewLabel.setBounds(0, 0, 1578, 798);
				//lblNewLabel.getMaximumSize();
				//lblNewLabel.setBounds(-14, -11, 500, 400);
				frame.getContentPane().add(lblNewLabel);

	}
}

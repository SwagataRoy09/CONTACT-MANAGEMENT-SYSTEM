package cmsmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class delete extends mainpage {

	private JFrame frame;
	private JTextField namefield;
	private JTextPane txtpnNameYouWant;
	private JButton DELETE;
	private JButton HOME;
    static delete window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new delete();
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
	public delete() throws Exception {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\deletee.png"));
		frame.getContentPane().setBackground(new Color(102, 102, 102));
		frame.setBounds(100, 100, 1488, 794);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HOME = new JButton("BACK");
		HOME.addActionListener(new ActionListener() {
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
		HOME.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		HOME.setForeground(new Color(0, 0, 0));
		HOME.setBackground(new Color(255, 255, 255));
		HOME.setBounds(89, 616, 130, 58);
		frame.getContentPane().add(HOME);
		
		DELETE = new JButton("DELETE");
		DELETE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name=namefield.getText();
			        JOptionPane.showMessageDialog(null, "CONTACT DELETED");
				    String query = "delete from details where name='" + name + "'";
			        management().executeUpdate(query);
		
			    }
			    catch(Exception w) {
			  }
			}
		});
		DELETE.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		DELETE.setForeground(new Color(0, 0, 0));
		DELETE.setBackground(new Color(255, 255, 255));
		DELETE.setBounds(567, 598, 130, 58);
		frame.getContentPane().add(DELETE);
		
		txtpnNameYouWant = new JTextPane();
		txtpnNameYouWant.setBackground(new Color(255, 255, 255));
		txtpnNameYouWant.setForeground(new Color(255, 255, 255));
		txtpnNameYouWant.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		txtpnNameYouWant.setText("NAME YOU WANT TO DELETE :");
		txtpnNameYouWant.setOpaque(false);
		txtpnNameYouWant.setBounds(51, 270, 387, 47);
		frame.getContentPane().add(txtpnNameYouWant);
		
		namefield = new JTextField();
		namefield.setBackground(new Color(255, 255, 255));
		namefield.setBounds(159, 313, 461, 47);
		frame.getContentPane().add(namefield);
		namefield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\insert.png"));
		lblNewLabel.setBounds(10, 10, 1454, 789);
		frame.getContentPane().add(lblNewLabel);
	}
}

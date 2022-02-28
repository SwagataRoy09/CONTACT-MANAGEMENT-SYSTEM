package ContactManagement;

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

public class Delete extends page1 {

	private JFrame frame;
	private JTextField namefield;
	private JTextPane txtpnNameYouWant;
	private JButton DELETE;
	private JButton HOME;
    static Delete window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Delete();
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
	public Delete() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\deletee.png"));
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 1114, 534);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		HOME = new JButton("BACK");
		HOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				new MainPage().main(null);
			}
		});
		HOME.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		HOME.setForeground(new Color(255, 0, 102));
		HOME.setBackground(new Color(255, 204, 204));
		HOME.setBounds(81, 347, 130, 58);
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
		DELETE.setForeground(new Color(255, 51, 102));
		DELETE.setBackground(new Color(255, 204, 204));
		DELETE.setBounds(334, 347, 130, 58);
		frame.getContentPane().add(DELETE);
		
		txtpnNameYouWant = new JTextPane();
		txtpnNameYouWant.setForeground(new Color(255, 51, 153));
		txtpnNameYouWant.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		txtpnNameYouWant.setText("NAME YOU WANT TO DELETE");
		txtpnNameYouWant.setOpaque(false);
		txtpnNameYouWant.setBounds(29, 148, 387, 47);
		frame.getContentPane().add(txtpnNameYouWant);
		
		namefield = new JTextField();
		namefield.setBackground(new Color(255, 204, 204));
		namefield.setBounds(33, 192, 461, 47);
		frame.getContentPane().add(namefield);
		namefield.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\\img7.png"));
		lblNewLabel.setBounds(10, 10, 1080, 477);
		frame.getContentPane().add(lblNewLabel);
	}
}

package cmsmain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class INSERTION1 extends mainpage {

	public INSERTION1() throws Exception {
		super();
		initialize();
		// TODO Auto-generated constructor stub
	}

	private JFrame frmAddContact;
	private JTextField NAME;
	private JTextField Number;
    static INSERTION1 window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    window = new INSERTION1();
					window.frmAddContact.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 static void insert(String name, String no) throws Exception {
	        String query = "insert into details values('" + name + "','" + no + "')";
	        Statement statement= management();
	        statement.executeUpdate(query);
	    }

	/**
	 * Create the application.
	 */
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddContact = new JFrame();
		frmAddContact.setType(Type.POPUP);
		frmAddContact.setForeground(new Color(36,30,36));
		frmAddContact.setBackground(new Color(102, 102, 102));
		frmAddContact.setTitle("ADD CONTACT\r\n");
		frmAddContact.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\eclipse\\ContactManagementSystem\\icons\\add1.png"));
		frmAddContact.getContentPane().setBackground(new Color(102, 102, 102));
		frmAddContact.getContentPane().setForeground(new Color(255, 204, 204));
		frmAddContact.setBounds(100, 100, 1435, 725);
		frmAddContact.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddContact.getContentPane().setLayout(null);
		
		JButton HOME = new JButton("HOME");
		HOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					window.frmAddContact.setVisible(false);
					new editpage().main(null);
				} 
				catch (Exception e1) {
					
				}
				
			}
		});
		HOME.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		HOME.setForeground(new Color(0, 0, 0));
		HOME.setBounds(140, 543, 198, 44);
		frmAddContact.getContentPane().add(HOME);
		
		NAME = new JTextField();
		NAME.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		NAME.setForeground(new Color(255, 255, 255));
		NAME.setBounds(162, 180, 450, 44);
		frmAddContact.getContentPane().add(NAME);
		NAME.setOpaque(false);
		NAME.setColumns(10);
		
		Number = new JTextField();
		Number.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		Number.setForeground(new Color(255, 255, 255));
		Number.setBounds(162, 350, 450, 44);
		frmAddContact.getContentPane().add(Number);
		Number.setOpaque(false);
		Number.setColumns(10);
		
		JTextPane txtpnContactNumber = new JTextPane();
		txtpnContactNumber.setBackground(new Color(51, 0, 255));
		txtpnContactNumber.setForeground(new Color(0, 0, 0));
		txtpnContactNumber.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		txtpnContactNumber.setText("ENTER YOUR CONTACT NUMBER :");
		txtpnContactNumber.setBounds(165, 321, 400, 31);
		txtpnContactNumber.setOpaque(false);
		frmAddContact.getContentPane().add(txtpnContactNumber);
		
		JTextPane txtpnEnterYourName = new JTextPane();
		txtpnEnterYourName.setForeground(new Color(0, 0, 0));
		txtpnEnterYourName.setFont(new Font("Showcard Gothic", Font.PLAIN, 19));
		txtpnEnterYourName.setText("ENTER YOUR NAME :");
		txtpnEnterYourName.setOpaque(false);
		txtpnEnterYourName.setBounds(162, 139, 403, 31);
		frmAddContact.getContentPane().add(txtpnEnterYourName);
		
		JButton SUBMIT = new JButton("SUBMIT");
		SUBMIT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String name=NAME.getText();
				String no = Number.getText();
				JOptionPane.showMessageDialog(null, "SUCCESSFULLY ADDED");
				insert(name,no);
				}
				catch(Exception exd) {
					
				}
			}
		});
		SUBMIT.setForeground(new Color(0, 0, 0));
		SUBMIT.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SUBMIT.setBounds(494, 543, 198, 44);
		SUBMIT.setOpaque(false);
		frmAddContact.getContentPane().add(SUBMIT);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\insert.png"));
		lblNewLabel.setBounds(0, 0, 1528, 810);
		frmAddContact.getContentPane().add(lblNewLabel);
	}
}

package ContactManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class SEARCH {

	private JFrame frame;
	private JTextField textField;
    static SEARCH window;
    private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new SEARCH();
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
	public SEARCH() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 945, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		table.setFillsViewportHeight(true);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		String name = "SWAGATA";
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{1,name , null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setBackground(new Color(255, 153, 255));
		table.setCellSelectionEnabled(true);
		table.setBounds(874, 406, -394, -379);
		frame.getContentPane().add(table);
		
		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setText("SEARCH");
		txtpnSearch.setOpaque(false);
		txtpnSearch.setForeground(new Color(255, 0, 102));
		txtpnSearch.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		txtpnSearch.setBounds(145, 119, 134, 60);
		frame.getContentPane().add(txtpnSearch);
		
		JTextPane txtpnEnterTheName = new JTextPane();
		txtpnEnterTheName.setOpaque(false);
		txtpnEnterTheName.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		txtpnEnterTheName.setForeground(new Color(255, 0, 102));
		txtpnEnterTheName.setText("ENTER THE NAME TO BE SEARCHED");
		txtpnEnterTheName.setBounds(35, 187, 377, 31);
		frame.getContentPane().add(txtpnEnterTheName);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setForeground(new Color(255, 51, 102));
		textField.setFont(new Font("Showcard Gothic", Font.PLAIN, 21));
		textField.setBounds(35, 228, 377, 41);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton HOME = new JButton("HOME");
		HOME.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				window.frame.setVisible(false);
				new EDIT().main(null);
			}
		});
		HOME.setForeground(new Color(255, 0, 102));
		HOME.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		HOME.setBackground(new Color(255, 204, 204));
		HOME.setBounds(35, 352, 134, 60);
		frame.getContentPane().add(HOME);
		
		JButton SEARCH = new JButton("SEARCH");
		SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		SEARCH.setBackground(new Color(255, 204, 204));
		SEARCH.setForeground(new Color(255, 0, 102));
		SEARCH.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SEARCH.setBounds(283, 352, 134, 60);
		frame.getContentPane().add(SEARCH);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\\img7.png"));
		lblNewLabel.setBounds(10, 10, 911, 429);
		frame.getContentPane().add(lblNewLabel);
	}
}

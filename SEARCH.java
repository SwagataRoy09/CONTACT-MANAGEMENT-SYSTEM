package ContactManagement;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class SEARCH extends page1 {

	private JFrame frame;
	private JTextField nameToBeSearched;
	static SEARCH window;
	private  JTable table2;
	DefaultTableModel tbm;
	int p=0;
	String num="",nn="";

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
	public SEARCH() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\ContactmanagementSystem\\src\\ContactManagement\\search.jpg"));
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 945, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);



		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(506, 34, 335, 360);
		frame.getContentPane().add(scrollPane);

		table2 = new JTable();
		scrollPane.setViewportView(table2);
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table2.getSelectedRow();
				nameToBeSearched.setText(tbm.getValueAt(i, 0).toString());
			}
		});
		table2.setColumnSelectionAllowed(true);
		table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i=table2.getSelectedRow();
				p=i;
				nn=tbm.getValueAt(i, 1).toString();
				num=tbm.getValueAt(i, 2).toString();
				nameToBeSearched.setText(tbm.getValueAt(i, 1).toString());
				//textField_1.setText(def.getValueAt(i, 1).toString());

			}
		});
		table2.setRowSelectionAllowed(true);
		table2.setForeground(Color.BLUE);
		table2.setFillsViewportHeight(true);
		table2.setFont(new Font("High Tower Text", Font.BOLD, 12));
		table2.setBackground(Color.PINK);
		//table2.setColumnSelectionAllowed(true);
		table2.setCellSelectionEnabled(true);
		table2.setModel(new DefaultTableModel(
				new Object[][] {

				},
				new String[] {
						"NAME", "NUMBER"
				}
		));
		table2.getColumnModel().getColumn(0).setPreferredWidth(78);

		nameToBeSearched = new JTextField();
		nameToBeSearched.setBackground(new Color(255, 255, 255));
		nameToBeSearched.setForeground(new Color(255, 51, 102));
		nameToBeSearched.setFont(new Font("Showcard Gothic", Font.PLAIN, 21));
		nameToBeSearched.setBounds(35, 150, 377, 41);
		frame.getContentPane().add(nameToBeSearched);

		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					int i=table2.getSelectedRow();
					if(i>=0||!nameToBeSearched.getText().equalsIgnoreCase(""))
					{
						String namess=nameToBeSearched.getText();
						tbm.removeRow(i);
						String query01 = "delete from details where name='" + namess + "'";
						management().executeUpdate(query01);
						nameToBeSearched.setText("");
					}
					else{JOptionPane.showMessageDialog(null, "EMPTY!!!");}
				}
				catch(Exception exa)
				{

				}
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 102));
		btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setBounds(253, 235, 119, 60);
		frame.getContentPane().add(btnNewButton);

		JTextPane txtpnSearch = new JTextPane();
		txtpnSearch.setText("SEARCH");
		txtpnSearch.setOpaque(false);
		txtpnSearch.setForeground(new Color(255, 0, 102));
		txtpnSearch.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		txtpnSearch.setBounds(35, 39, 134, 60);
		frame.getContentPane().add(txtpnSearch);

		JTextPane txtpnEnterTheName = new JTextPane();
		txtpnEnterTheName.setOpaque(false);
		txtpnEnterTheName.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
		txtpnEnterTheName.setForeground(new Color(255, 0, 102));
		txtpnEnterTheName.setText("ENTER THE NAME TO BE SEARCHED");
		txtpnEnterTheName.setBounds(45, 111, 377, 31);
		frame.getContentPane().add(txtpnEnterTheName);


		//nameToBeSearched.setColumns(10);

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
		HOME.setBounds(162, 354, 134, 60);
		frame.getContentPane().add(HOME);

		JButton SEARCH = new JButton("SEARCH");
		SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbm = (DefaultTableModel) table2.getModel();
				tbm.setRowCount(0);
				try
				{
					String query="Select * from details Order by name";
					String sname =nameToBeSearched.getText().toUpperCase();
					int f=0;
					ResultSet rs= management().executeQuery(query);
					while(rs.next())
					{
						String name11 =rs.getString(1);
						String number =rs.getString(2);
						if(sname.trim().length()!=0 &&  name11.contains(sname)) {
							tbm.addRow(new Object[] {name11,number});
							f=1;
						}
					}
					if(f==0)
					{
						tbm.addRow(new Object[] {"NO RESULT FOUND","NO RESULT FOUND"});
					}
				}
				catch(Exception E)
				{
				}
			}
		});
		SEARCH.setBackground(new Color(255, 204, 204));
		SEARCH.setForeground(new Color(255, 0, 102));
		SEARCH.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
		SEARCH.setBounds(45, 235, 134, 60);
		frame.getContentPane().add(SEARCH);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Showcard Gothic", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\eclipse\\img7.png"));
		lblNewLabel.setBounds(10, 10, 911, 429);
		frame.getContentPane().add(lblNewLabel);
	}
}

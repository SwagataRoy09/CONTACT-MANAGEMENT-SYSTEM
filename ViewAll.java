package ContactManagement;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAll extends page1{

    private JFrame frame;
    private JLabel lblNewLabel;
    static DefaultTableModel tbm;
    private JButton btnNewButton;
    private JScrollBar scrollBar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAll window = new ViewAll();
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
    public ViewAll() throws Exception {
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 636, 449);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        scrollBar = new JScrollBar();
        scrollBar.setBackground(new Color(255, 204, 204));
        scrollBar.setBounds(432, 10, 17, 392);
        frame.getContentPane().add(scrollBar);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 422, 392);
        frame.getContentPane().add(scrollPane);
        JTable table2 = new JTable();
        scrollPane.setViewportView(table2);
        table2.setColumnSelectionAllowed(true);
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
        btnNewButton = new JButton("SHOW ALL\r\n");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tbm = (DefaultTableModel) table2.getModel();
                tbm.setRowCount(0);
                try {
                    String query = "select * from details order by name asc";
                    ResultSet rs = management().executeQuery(query);
                    boolean flag = true;
                    while (rs.next()) {
                        String Cname = rs.getString(1);
                        String Cnum = rs.getString(2);
                        tbm.addRow(new Object[] {Cname,Cnum});
                    }
                }
                catch(Exception ex) {
                }
            }
        });
        btnNewButton.setBackground(new Color(255, 204, 204));
        btnNewButton.setForeground(new Color(255, 0, 102));
        btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
        btnNewButton.setBounds(478, 0, 134, 31);
        frame.getContentPane().add(btnNewButton);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("D:\\ContactmanagementSystem\\src\\ContactManagement\\showall.jpg"));
        lblNewLabel.setBounds(0, 0, 622, 412);
        frame.getContentPane().add(lblNewLabel);
    }
}

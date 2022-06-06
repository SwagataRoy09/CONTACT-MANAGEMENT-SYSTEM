package cmsmain;
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
import javax.swing.SwingConstants;

public class viewall extends mainpage{

    private JFrame frame;
    private JLabel lblNewLabel;
    static DefaultTableModel def;
    private JButton btnNewButton;
    private JScrollBar scrollBar;
    private JButton btnNewButton_1;
    static viewall window;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new viewall();
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
    public viewall() throws Exception {
    	super();
        initialize();

    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1435, 725);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        btnNewButton_1 = new JButton("HOME");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    window.frame.setVisible(false);
                    new mainpage().main(null);
                }
                catch (Exception e1) {

                }

            }
        });
        btnNewButton_1.setForeground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(61, 47, 134, 31);
        frame.getContentPane().add(btnNewButton_1);

        scrollBar = new JScrollBar();
        scrollBar.setBackground(new Color(102, 102, 102));
        scrollBar.setBounds(780, 101, 17, 604);
        frame.getContentPane().add(scrollBar);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 101, 777, 604);
        frame.getContentPane().add(scrollPane);
        JTable table2 = new JTable();
        scrollPane.setViewportView(table2);
        table2.setColumnSelectionAllowed(true);
        table2.setRowSelectionAllowed(true);
        table2.setForeground(Color.BLUE);
        table2.setFillsViewportHeight(true);
        table2.setFont(new Font("High Tower Text", Font.BOLD, 12));
        table2.setBackground(new Color(102, 102, 102));
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
                def = (DefaultTableModel) table2.getModel();
                def.setRowCount(0);
                try {
                    String query4 = "select * from details order by name asc";
                    ResultSet rs = management().executeQuery(query4);
                    while (rs.next()) {
                        String Cname = rs.getString(1);
                        String Cnum = rs.getString(2);
                        def.addRow(new Object[] {Cname,Cnum});
                    }
                }
                catch(Exception ex) {

                }
            }
        });
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
        btnNewButton.setBounds(439, 48, 134, 31);
        frame.getContentPane().add(btnNewButton);

        lblNewLabel = new JLabel("New label");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setIcon(new ImageIcon("D:\\CMS-ADV\\IMAGE\\insert.png"));
    	lblNewLabel.setBounds(0, 0, 1528, 810);
        frame.getContentPane().add(lblNewLabel);
    }
}

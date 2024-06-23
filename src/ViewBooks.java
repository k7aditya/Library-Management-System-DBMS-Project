import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;

public class ViewBooks extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTextField searchField;
    private TableRowSorter<javax.swing.table.TableModel> sorter;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewBooks frame = new ViewBooks();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewBooks() {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        // Create a JLabel with the text "Search by name/author/genre"
        JLabel titleLabel = new JLabel("Search by name/author/genre", JLabel.CENTER);
        contentPane.add(titleLabel, BorderLayout.NORTH); // Add the label to the top of the contentPane

        // Create a panel for the search field and button with FlowLayout
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20); // Set initial text
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = searchField.getText();
                if (!query.equals("Search by name/author/genre")) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + query));
                }
            }
        });
        searchPanel.add(searchField); // Add search field
        searchPanel.add(searchButton); // Add search button

        contentPane.add(searchPanel, BorderLayout.CENTER); // Add the search panel to the center of the contentPane

        // Initialize table with all books and set up sorter
        String data[][] = null;
        String column[] = null;
        try {
            Connection con = DB.getConnection(); // Assuming DB.getConnection() is correctly implemented
            PreparedStatement ps = con.prepareStatement("SELECT * FROM books", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            column = new String[cols];
            for (int i = 1; i <= cols; i++) {
                column[i - 1] = rsmd.getColumnName(i);
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            data = new String[rows][cols];
            int count = 0;
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    data[count][i - 1] = rs.getString(i);
                }
                count++;
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        table = new JTable(data, column);
        table.setAutoCreateRowSorter(true); // Enable auto row sorter
        sorter = new TableRowSorter<>(table.getModel()); // Create a sorter
        table.setRowSorter(sorter); // Set the sorter for the table

        JScrollPane sp = new JScrollPane(table);
        contentPane.add(sp, BorderLayout.SOUTH); // Add the table to the bottom of the contentPane

        // Use pack() to size the frame according to its contents
        pack();
    }
}

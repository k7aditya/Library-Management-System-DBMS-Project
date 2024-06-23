    import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

// Historydao.java

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Historydao extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private int studentId;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Historydao frame = new Historydao(0); // Provide a default value for studentId
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Historydao(int studentId) {
        this.studentId = studentId;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        String data[][] = null;
        String column[] = null;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("select id, bookcallno, studentid, issueddate, returndate from permastudent where studentid=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, studentId);
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
        JScrollPane sp = new JScrollPane(table);

        contentPane.add(sp, BorderLayout.CENTER);
    }
}

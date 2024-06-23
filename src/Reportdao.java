/*import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;



import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class Reportdao extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private String callNumber;
    private String reportDate;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Reportdao frame = new Reportdao("A@4", "2016-08-05"); // Provide default values for callNumber and reportDate
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Reportdao(String callNumber, String reportDate) {
        this.callNumber = callNumber;
        this.reportDate = reportDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date RDate = dateFormat.parse(reportDate);

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
            PreparedStatement ps = con.prepareStatement("SELECT books.callno, books.name, books.quantity, books.issued, COUNT(issuebooksStudent.studentid) AS DueBooks FROM books, issuebooksStudent WHERE books.callno = ? AND issuebooksStudent.bookcallno = ? AND DATEDIFF(?, issuebooksStudent.issueddate) >= '15'", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, callNumber);
            ps.setString(2, callNumber);
            ps.setString(3, RDate);
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
}*/
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Reportdao extends JFrame {
    private String callNumber;
    private String reportDate;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Reportdao frame = new Reportdao("A@4", "2016-08-05"); // Provide default values for callNumber and reportDate
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Reportdao(String callNumber, String reportDate) {
        this.callNumber = callNumber;
        this.reportDate = reportDate;

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        String data[][] = null;
        String column[] = null;
        try {
            Connection con = DB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT books.callno, books.name, books.quantity, books.issued, COUNT(issuebooksStudent.studentid) AS DueBooks FROM books, issuebooksStudent WHERE books.callno = ? AND issuebooksStudent.bookcallno = ? AND DATEDIFF(?, issuebooksStudent.issueddate) >= '15'", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, callNumber);
            ps.setString(2, callNumber);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date RDate = dateFormat.parse(reportDate);
            ps.setDate(3, new java.sql.Date(RDate.getTime()));
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


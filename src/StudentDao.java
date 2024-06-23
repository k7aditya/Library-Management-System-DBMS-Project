import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDao {

    private static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());

    // Updated method signature to include email parameter
    public static int save(String name, String password, int id, String contact, String email) {
        int status = 0;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("insert into studenttable(studentname,password,studentID,studentcontact,studentemail) values(?,?,?,?,?)")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setInt(3, id);
            ps.setString(4, contact);
            ps.setString(5, email); // Set the email value
            status = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error saving student", e);
        }
        return status;
    }

    // Other methods remain unchanged
    public static int delete(int id) {
        int status = 0;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("delete from studenttable where studentID=?")) {
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting student", e);
        }
        return status;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from studenttable where studentname=? and password=?")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error validating student", e);
        }
        return status;
    }

    static boolean checkRollNoExistence(int id) {
        boolean exists = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from studenttable where studentID=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking roll number existence", e);
        }
        return exists;
    }

    static boolean checkEmailExistence(String email) {
            boolean exists = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from studenttable where studentemail=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking email existence", e);
        }
        return exists;
    }
}

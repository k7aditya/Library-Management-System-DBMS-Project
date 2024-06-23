import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeacherDao {

    private static final Logger LOGGER = Logger.getLogger(TeacherDao.class.getName());

    public static int save(String name, String password, int id, String contact, String email) {
        int status = 0;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("insert into teachertable(teachername,password,teacherid,teachercontact, teacheremail) values(?,?,?,?,?)")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setInt(3, id);
            ps.setString(4, contact);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error saving teacher", e);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("delete from teachertable where teacherid=?")) {
            ps.setInt(1, id);
            status = ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting teacher", e);
        }
        return status;
    }

    public static boolean validate(String name, String password) {
        boolean status = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from teachertable where teachername=? and password=?")) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error validating teacher", e);
        }
        return status;
    }

    static boolean checkTeacherIDExistence(int id) {
        boolean exists = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from teachertable where teacherid=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking teacher ID existence", e);
        }
        return exists;
    }
    static boolean checkTeacherEmailExistence(String email) {
            boolean exists = false;
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from teachertable where teacheremail=?")) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error checking email existence", e);
        }
        return exists;
    }
}

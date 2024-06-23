import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class ReturnBookDao {
	public static int delete(String bookcallno, int studentid, String newdate) {
    int status = 0;
    try {
        Connection con = DB.getConnection();

        // Check if the book with the given call number was issued to the specified student
        PreparedStatement psCheck = con.prepareStatement("SELECT * FROM issuebooksStudent WHERE bookcallno=? AND studentid=?");
        psCheck.setString(1, bookcallno);
        psCheck.setInt(2, studentid);
        ResultSet rsCheck = psCheck.executeQuery();
        if (!rsCheck.next()) {
            // If the book was not issued to the specified student, show a popup message
            JOptionPane.showMessageDialog(null, "The book was not issued to the specified student.");
            con.close();
            return 0;
        }

        // Update the book quantity and issued status
        status = updatebook(bookcallno);
        
        // Calculate and insert fine if applicable
        ffine(newdate, studentid);

        if (status > 0) {
            // If book update was successful, delete the entry from the issuebooksStudent table
            PreparedStatement psDelete = con.prepareStatement("DELETE FROM issuebooksStudent WHERE bookcallno=? AND studentid=?");
            psDelete.setString(1, bookcallno);
            psDelete.setInt(2, studentid);
            status = psDelete.executeUpdate();
        }

        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return status;
}

	public static int updatebook(String bookcallno){
		int status=0;
		int quantity=0,issued=0;
		try{
			Connection con=DB.getConnection();
			
			PreparedStatement ps=con.prepareStatement("select quantity,issued from books where callno=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
			}
			
			if(issued>0){
			PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,bookcallno);
			
			status=ps2.executeUpdate();
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        /*public static int ffine(String newdatee,int studentid){
		int status=0;
		Date quantity;
		try{
			Connection con=DB.getConnection();
			
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date newdate = dateFormat.parse(newdatee);
                        
                        
			PreparedStatement ps=con.prepareStatement("select issueddate from issuebooksStudent where studentid=?");
			ps.setInt(1,studentid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getDate("issueddate");
				//issued=rs.getInt("issued");
			}
                        long diffInMillies = Math.abs(newdate.getTime() - quantity.getTime());
                        long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
                        if((((int) diffInDays)-15) <= 0){
                                  diffInDays = 0;
                        }
                        else{
                             diffInDays = diffInDays - 15 ;
                        }
                        
			
			
			PreparedStatement ps2=con.prepareStatement("insert into charge(fine) values(?)");
			ps2.setInt(1,(int)diffInDays);
			
			
			status=ps2.executeUpdate();
			
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
        */
 public static int ffine(String newdatee, int studentid) {
    int status = 0;
    Date quantity = null; // Initialize the Date variable
    try {
        Connection con = DB.getConnection();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date newdate = dateFormat.parse(newdatee);

        // Retrieve the issueddate for the given studentid
        PreparedStatement ps = con.prepareStatement("SELECT issueddate FROM issuebooksStudent WHERE studentid=?");
        ps.setInt(1, studentid);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            quantity = rs.getDate("issueddate");
        }
        // Calculate the difference in days and apply the fine logic
        if (quantity != null) {
            long diffInMillies = Math.abs(newdate.getTime() - quantity.getTime());
            long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);

            if ((int) diffInDays > 15) {
                diffInDays =diffInDays - 15; // Subtract 15 days from the difference
            } else {
                diffInDays = 0; // No fine if less than or equal to 15 days
            }
            diffInDays *= 5;
            // Insert the fine into the charge table
            PreparedStatement ps2 = con.prepareStatement("INSERT INTO charge (fine) VALUES (?)");
            ps2.setInt(1, (int) diffInDays);
            status = ps2.executeUpdate();
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace(); // print the exception for debugging
    }
    return status;
}

}

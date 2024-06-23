import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class IssueBookDaoTeacher {
	
public static boolean checkBook(String bookcallno){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from books where callno=?");
		ps.setString(1,bookcallno);
	    ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

/*public static int save(String bookcallno,int teacherid,String teachername,String teachercontact,String IS,String Rn){
	int status=0;
	try{
		Connection con=DB.getConnection();
		
		status=updatebook(bookcallno);//updating quantity and issue
		
		if(status>0){
		PreparedStatement ps=con.prepareStatement("insert into issuebooksStudent(bookcallno,teacherid,teachername,teachercontact,issueddate,returndate,duedays) values(?,?,?,?,?,?,?)");
		ps.setString(1,bookcallno);
		ps.setInt(2,teacherid);
		ps.setString(3,teachername);
		ps.setString(4,teachercontact);
                ps.setString(5,IS);
                ps.setString(6,Rn);
                ps.setInt(7,0);
		status=ps.executeUpdate();
		}
		
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}*/


 public static int save(String bookcallno, int teacherid, String teachername, String teachercontact, String IS, String Rn) {
        int status = 0;
        try {
            Connection con = DB.getConnection();

            status = updatebook(bookcallno);// updating quantity and issue

            if (status > 0) {
                // Parse the date strings into Date objects
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date issuedDate = dateFormat.parse(IS);
                Date returnDate = dateFormat.parse(Rn);

                // Calculate the difference in days
                long diffInMillies = Math.abs(returnDate.getTime() - issuedDate.getTime());
                long diffInDays = diffInMillies / (24 * 60 * 60 * 1000);
                if((((int) diffInDays)-15) <= 0){
                     diffInDays = 0;
                }
                else{
                    diffInDays = diffInDays - 15 ;
                }

                PreparedStatement ps = con.prepareStatement("insert into issuebooksTeacher(bookcallno,teacherid,issueddate,returndate,duedays) values(?,?,?,?,?)");
                ps.setString(1, bookcallno);
                ps.setInt(2, teacherid);
                ps.setString(3, IS);
                ps.setString(4, Rn);
                ps.setInt(5, (int) diffInDays); // Set the difference in days as duedays
                
                
                PreparedStatement ps1 = con.prepareStatement("insert into permateacher(bookcallno,teacherid,issueddate,returndate,duedays) values(?,?,?,?,?)");
                ps1.setString(1, bookcallno);
                ps1.setInt(2, teacherid);
                ps1.setString(3, IS);
                ps1.setString(4, Rn);
                ps1.setInt(5, (int) diffInDays);
                
                status = ps.executeUpdate();
                status = ps1.executeUpdate();
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
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where callno=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,bookcallno);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
}

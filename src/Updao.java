import java.sql.Connection;
import java.sql.PreparedStatement;

public class Updao{

/*public static int update(String callnoo,String namee,String authorr,String categoryr,int quantityy){
	int status=0;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("UPDATE books SET name = namee , author = authorr , category = categoryr , quantity = quantityy WHERE callno = callnoo ");
		ps.setString(1,callnoo);
		ps.setString(2,namee);
		ps.setString(3,authorr);
		ps.setString(4,categoryr);
		ps.setInt(5,quantityy);
		status=ps.executeUpdate();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
*/
/*public static int update(String callnoo, int quantityy) {
    int status = 0;
    try {
        Connection con = DB.getConnection();
        PreparedStatement ps = con.prepareStatement("UPDATE books SET  quantity = quantityy WHERE callno = callnoo");
        //ps.setInt(1, quantityy);
        //ps.setString(2, callnoo);
        
        //status = ps.executeUpdate(); // Update status based on the execution result
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return status;
}
*/




public static int update(String bookcallno, int quantityyy){
		int status=0;
		//int quantity=0;
		try{
			Connection con=DB.getConnection();
			
			/*PreparedStatement ps=con.prepareStatement("select quantity from books where callno=?");
			ps.setString(1,bookcallno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				quantity=rs.getInt("quantity");
				//issued=rs.getInt("issued");
			}
                        */
			
			//if(quantity>0){
			PreparedStatement ps2=con.prepareStatement("update books set quantity=? where callno=?");
			ps2.setInt(1,quantityyy);
			//ps2.setInt(2,issued-1);
			ps2.setString(2,bookcallno);
			
			status=ps2.executeUpdate();
			//}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


public static int Delete(String bookcallno){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from books where callno=?");
			ps.setString(1,bookcallno);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


}



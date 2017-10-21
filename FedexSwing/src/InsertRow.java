import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertRow {
	public void InsertingRow(String T, String Ist, String s1, String s2, String tno, Double w) throws Exception {
	Connection con = connection.conn;
	Statement s = connection.stmt;
	s = con.createStatement();
	ResultSet resultSet = s.executeQuery("select * from FedTrack.package");
	PreparedStatement ps= connection.preparedstatement;
	String t=T ;
	String ist=Ist;
	String source = s1;
	String Dest = s2;
	String tracknum = tno ;
	Double W= w;
	ps = con.prepareStatement("insert into  FedTrack.package values (?,?,?,?,?)");
	ps.setString(1,Ist);
	ps.setString(2,t );
	ps.setString(3,source);
	ps.setString(4,Dest );
	ps.setString(5, tracknum);
	//ps.setDouble(6, W);
	ps.execute();
	con.close();
	// s.executeUpdate("INSERT INTO `FedTrack.package`(Time,Istation,Source,Destination,Trackingnumber) VALUE ('"+T+"','"+Ist+"','"+s1+"',"+s2+",'"+tracknum+"')");
	System.out.println("Inserting done!!!"); 

	}
}
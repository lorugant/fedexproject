
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class connection {
	public static Connection conn = null;
	public static Statement stmt=null;
	public static PreparedStatement preparedstatement = null;  

	public void connsetup() throws Exception
	{
	    conn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
	   
	    System.out.println("Connected to database");
	}
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FedexPackage {
	String S,D;
	String key;
  public FedexPackage FedexPackage() throws SQLException {
		System.out.println("In the Fedex Package program");
	  Connection  con = DriverManager.getConnection("jdbc:mysql://localhost/feedback?autoReconnect=true&useSSL=false","root","chinnu41093");
		   
	    System.out.println("Connected to database");
	//	Connection con = connection.conn;
		Statement s = connection.stmt;
		s = con.createStatement();
		//ResultSet resultSet = s.executeQuery("select * from feedback.comments");
		PreparedStatement ps= connection.preparedstatement;
		System.out.println("Enter the tracking number\n");
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine();
		System.out.println(key);
		String query="SELECT Source,Destination FROM FedTrack.package WHERE Trackingnumber='"+key+"'";
	//	s = con.prepareStatement("SELECT Source FROM FedTrack.package WHERE Trackingnumber="+key);
		ResultSet result_set=s.executeQuery(query);
		s = con.prepareStatement(query);
		try {
		while(result_set.next()){
			//Retrieve by column name

			String S = result_set.getString("Source");
			String D = result_set.getString("Destination");
			//setSval(S);
			//setDval(D);
			FedexPackage obj =  new FedexPackage();
			obj.setDval(D);
			obj.setSval(S);
			obj.key = key;
			Graph.mapper.put(key, obj);
			return obj;
			//System.out.println(S);
			//System.out.println(D);
		}
		}catch(Exception e) {System.out.println(e);}
		s.close();
		con.close();
		return null;
		}
	public void setSval(String s) {
		this.S = s;
		//System.out.println(S);
		
	}
	
	public void setDval(String d) {
		this.D=d;
		//System.out.println(D);
	}
	
	public String getSval() {
		System.out.println(S);
		return S;
		
	}
	public String getDval() {
		System.out.println(D);
		return D;
		
	}
		
	}
	

package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	private static String url = "jdbc:mysql://localhost:3306/SquadBanking";
	
	private static String username = "root";
	
	private static String password = "Abhi@d123";
	
	
	
	static Connection con = null;
	public static Connection getConnection() {
		
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	

}

package StudentManaagementApp;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
	
		static Connection con;
		
		public static Connection createC() {
		try {
			// load the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// create the connection
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String user = "root";
			String password = "ShubhamMySql2025";
			
			con = DriverManager.getConnection(url, user, password);
			
		}
		catch( Exception e) {
			e.printStackTrace();
		}
			
		return con;
		
	}
}

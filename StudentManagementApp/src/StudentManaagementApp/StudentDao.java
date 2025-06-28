package StudentManaagementApp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

// DAO stands for data object classes 

public class StudentDao {
	
	public static boolean insertStudentToDB(Student std) {
		
		boolean f = false;
		try {
			
			Connection con = CP.createC();
			
			String q = "insert into students_info( sName, sPhone, sCity) values( ?, ?, ?)";
			
			// for firing this query use prepared statement 
			PreparedStatement ptst = con.prepareStatement(q);
			ptst.setString(1, std.getStudentName());
			ptst.setString(2, std.getStudentPhone());
			ptst.setString(3, std.getStudentCity());
			
			//execute or fire the query in DB
			
			ptst.executeUpdate();
			f = true;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}

	public static boolean deleteStudentFromDB(int studentId) {
		
		boolean f = false;
		
		try {
			
			Connection con = CP.createC();
			
			String q = " delete from students_info where sId = ?";
			
			PreparedStatement ptst = con.prepareStatement(q);
			
			ptst.setInt(1, studentId);
			
			ptst.executeUpdate();
						
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}

	public static void showAll() {
	
		try {
			
			//create a connection  
			Connection con = CP.createC();
			
			String q = "select * from students_info; ";
			
			Statement stmt = con.createStatement();
			
			// this returns some data from the database that's why we used executeQuery , 
			// if it dosen't returns anything then we use executeUpdate(q); 
			
			ResultSet set = stmt.executeQuery(q); 
			
			while(set.next()) {
				
				int id = set.getInt(1);
				String Name = set.getString(2);
				String Phone = set.getString(3);
				String City = set.getString(4);
				
				System.out.println("ID of Student :- "+id);
				System.out.println("Name of Student:- "+Name);
				System.out.println("Phone number of Student :- "+Phone);
				System.out.println("City of Student :- "+City);
				System.out.println("+++++++++++++++++++++++++++++");
				System.out.println();
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

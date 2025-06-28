package StudentManaagementApp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException{
		System.out.println("Welcome to the Application");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Enter 1 for adding the student");
			System.out.println("Enter 2 for deleting the student");
			System.out.println("Enter 3 for display the student");
			System.out.println("Enter 4 for exit the app");
			int c = Integer.parseInt(br.readLine());
			
			if( c == 1) {
				// adding student
				System.out.println(" Enter Student Name :- ");
				String name = br.readLine();
				System.out.println(" Enter Student Phone Number :- ");
				String number = br.readLine();
				System.out.println(" Enter Student City :- ");
				String city = br.readLine();
				
				Student std = new Student(name, number, city);
				boolean ans = StudentDao.insertStudentToDB(std);
				System.out.println(std);
				
				if(ans) {
					System.out.println("Successfully added ");
				}else{
					System.out.println("Something went wrong");
				}
				
			} 
			else if (c == 2) {
				//Deleting the student1
				
				System.out.println(" Enter student id to delete student :- ");
				int sId = Integer.parseInt(br.readLine());
				boolean ans = StudentDao.deleteStudentFromDB(sId);
				
				if(ans) {
					System.out.println("Successfully deleted ");
				}else{
					System.out.println("Something went wrong");
				}
				
			} 
			else if ( c == 3) {
				// display the student 
				StudentDao.showAll();
			}
			else if ( c == 4) {
				//exit the app
				break;
			}
			else {
				
			}
			
		}
		
		System.out.println("Thank you for using the app");
		System.out.println("See you soon");

	}

}

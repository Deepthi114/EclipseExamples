import java.sql.*; 
import java.util.Scanner;
public class EmployeeDetails 
{
	static int choice;
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			Connection con=DriverManager.getConnection(url,username,password);
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			do
			{
				System.out.println("JDBC Programming ");
				System.out.println("1. Inserting Values");
				System.out.println("2.Updating Values");
				System.out.println("3.Display Values");
				System.out.println("4.Deleting Values");
				System.out.println("5.Selecting Perticular Column");
				System.out.println("Enter you Choice");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
							st.executeUpdate("insert into Employee values('Vijay Kumar',56,'Test Engr')");
							System.out.println("Record inserted");
							break;
							
				case 2:
					st.executeUpdate("update Employee set id=5575 where name='Anitha'");
					System.out.println("Record Updated");
					break;
					
				case 3:
					ResultSet rs=st.executeQuery("select * from Employee");
					while(rs.next())
					{
						System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3));
					}
					break;
				case 4:
					st.executeUpdate("delete Employee where id=56");
					System.out.println(" Record Deleted ");
					break;
				case 5:
					ResultSet rss=st.executeQuery("select name,position from Employee");
					while(rss.next())
					{
						System.out.println(rss.getString(1)+" "+rss.getString(2));
					}	
					break;
				}
			}while(choice!=8);
			
		
						
	}
}

/*
 
 >>>>> Inserting 
 
SQL> select * from Employee;

NAME                         ID POSITION
-------------------- ---------- --------------------
Anitha                     5574 Team Lead
Abbas                      4205 Android Developer
Jyoshna                    5484 DBA


SQL> select * from Employee;

NAME                         ID POSITION
-------------------- ---------- --------------------
Anitha                     5574 Team Lead
Krishna                    5849 HR
Vijay Kumar                5846 Test Engr
Vijay Kumar                  56 Test Engr
Abbas                      4205 Android Developer
Jyoshna                    5484 DBA


>>>>>updating 

SQL> select * from Employee;

NAME                         ID POSITION
-------------------- ---------- --------------------
Anitha                     5575 Team Lead
Krishna                    5849 HR
Vijay Kumar                5846 Test Engr
Vijay Kumar                  56 Test Engr
Abbas                      4205 Android Developer
Jyoshna                    5484 DBA


>>>>>>>Delete

SQL> select * from Employee;

NAME                         ID POSITION
-------------------- ---------- --------------------
Anitha                     5575 Team Lead
Krishna                    5849 HR
Vijay Kumar                5846 Test Engr
Abbas                      4205 Android Developer
Jyoshna                    5484 DBA


>>>>>>Selecting Perticular

JDBC Programming 
1. Inserting Values
2.Updating Values
3.Display Values
4.Deleting Values
5.Selecting Perticular Column
Enter you Choice
5
Anitha Team Lead
Krishna HR
Vijay Kumar Test Engr
Abbas Android Developer
Jyoshna DBA

*/

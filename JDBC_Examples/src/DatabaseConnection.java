
/*

Java Database Connection
1. import --->java.sql
2. load and register the driver --> oracle.jdbc.driver.OracleDriver
3. Create connection --> Connection
4. create a statement -->Statement
5. Execute the query -->
6. Process the results -->
7. Close

Example 1:
.........................................................................................................................................................................




import java.sql.*; 
public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			System.out.println("Connecting to selected database");
			Connection con=DriverManager.getConnection(url,username,password);
			if(con!=null)
			System.out.println("Connection Established");
			
			//4.Executing
			Statement st=con.createStatement();
			
			int x=st.executeUpdate("insert into Mydetails values('xyz','ABC',100)");
			if(x!=0)
				System.out.println("Record Updated");
			
			st.executeUpdate("delete from Mydetails");
			st.executeUpdate("insert into Mydetails values('Funny','Virginia',9451)");
			st.executeUpdate("insert into Mydetails values('Pinky','Vijayawada',154)");
			st.executeUpdate("insert into Mydetails values('Tinku','NewJersy',7726)");
			st.executeUpdate("update Mydetails set house=9411 where name='Funny'");
			
	}
}

OutPut:
	
	SQL> select * from Mydetails;

	NAME                 ADDRESS                             HOUSE
	-------------------- ------------------------------ ----------
	Tinku                NewJersy                             7726
	Funny                Virginia                             9411
	Pinky                Vijayawada                            154


Java:O/P

C:\Users\deept\Videos\Captures\Adv.Java\forName() getCar()>java DatabaseConnection
Connection Established
Record Updated




Example 2: Using Scanner
..................................................................................................................................................................................................


import java.sql.*; 
import java.util.Scanner;
public class DatabaseConnection
{
	public static void main(String[]args) throws NullPointerException
	{
		 //Creating the connection 
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String user = "system"; 
        String pass = "sql8699"; 
  
        //Entering the data 
        Scanner sc= new Scanner(System.in); 
        System.out.println("enter name"); 
        String name = sc.next(); 
        System.out.println("enter roll no"); 
        int roll = sc.nextInt(); 
        System.out.println("enter class"); 
        String cls =  sc.next(); 
  
        //Inserting data using SQL query 
        String sql = "insert into student1 values('"+name+"',"+roll+",'"+cls+"')"; 
        Connection con=null; 
        try
        { 
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver()); 
  
            //Reference to connection interface 
            con = DriverManager.getConnection(url,user,pass); 
  
            Statement st = con.createStatement(); 
            int m = st.executeUpdate(sql); 
            if (m == 1) 
                System.out.println("inserted successfully : "+sql); 
            else
                System.out.println("insertion failed"); 
            con.close(); 
        } 
        catch(Exception ex) 
        { 
            System.err.println(ex); 
        } 			
	}
}


Output:
	
	enter name
	Deepu
	enter roll no
	111
	enter class
	MS
	inserted successfully : insert into student1 values('Deepu',111,'MS')

	
	
	SQL:
		
		SQL> select * from student1;

		NAME                       ROLL CLS
		-------------------- ---------- --------------------
		Deepu                       111 MS



Example 3: using executeQuery 
..............................................................................................................................................

import java.sql.*; 
public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			System.out.println("Connecting to selected database");
			Connection con=DriverManager.getConnection(url,username,password);
			if(con!=null)
			System.out.println("Connection Established");
			
			//4.Executing
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select name,address from Mydetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			
			
	}
}



Example 4: using select Query 
..............................................................................................................................................


import java.sql.*; 
public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			System.out.println("Connecting to selected database");
			Connection con=DriverManager.getConnection(url,username,password);
			if(con!=null)
			System.out.println("Connection Established");
			
			//4.Executing
			Statement st=con.createStatement();
			st.executeUpdate("insert into Mydetails values('Mahee','Virginia',9574)");
			st.executeUpdate("insert into Mydetails values('Potti','WI',5141)");
			ResultSet rs=st.executeQuery("select * from Mydetails where name='Funny'");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			
			
	}
}




Example 5.1:  Commit from Cache memory to Main memory
..................................................................................................................................................


import java.sql.*; 
public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			Connection con=DriverManager.getConnection(url,username,password);
						
			//4.Executing
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select name,address from Mydetails");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
						
	}
}



OutPut:
	
	SQL> insert into Mydetails values('Mahee','Virginia',9335);

	1 row created.

	SQL> select * from Mydetails;

	NAME                 ADDRESS                             HOUSE
	-------------------- ------------------------------ ----------
	Tinku                NewJersy                             7726
	Funny                Virginia                             9411
	Pinky                Vijayawada                            154
	Mahee                Virginia                             9335

	SQL> commit;

	Commit complete.
	
	
	-->
	Tinku NewJersy
Funny Virginia
Pinky Vijayawada
Mahee Virginia


Ex: 5.2
.........................................................................................

import java.util.Scanner;

public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			Connection con=DriverManager.getConnection(url,username,password);
						
			//4.Executing
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the House number");
			int house=sc.nextInt();
			ResultSet rs=st.executeQuery("select address from Mydetails where house="+house);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
						
	}
}



OutPut;

Enter the House number
9411
Virginia


Ex: 5.3
.................................................................................................


import java.sql.*; 
import java.util.Scanner;

public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			Connection con=DriverManager.getConnection(url,username,password);
						
			//4.Executing
			Statement st=con.createStatement();
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Name");
			String name=sc.next();
			ResultSet rs=st.executeQuery("select address from Mydetails where name="+name);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
						
	}
}

O/P

Enter the Name
'Mahee'
Virginia




Example 6.1: Using PreparedStatement ( Insertion)
.....................................................................................................................................................


import java.sql.*; 
public class DatabaseConnection
{
	public static void main(String[]args) throws Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String username="system";
		String password="sql8699";

			//2. register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.Connection
			Connection con=DriverManager.getConnection(url,username,password);
						
			//4.Executing
			PreparedStatement ps=con.prepareStatement("insert into Mydetails values(?,?,?)");
			ps.setString(1,"Mouni");
			ps.setString(2, "Hydrabad");
			ps.setInt(3,129);
			ps.executeUpdate();
			
			ps.setString(1,"Chota");
			ps.setString(2, "Wisconsi");
			ps.setInt(3,2747);
			ps.executeUpdate();

			ps.setString(1,"Kittu");
			ps.setString(2, "Chennai");
			ps.setInt(3,1245);
			
			
			int res=ps.executeUpdate();
			if(res!=0)
				System.out.println(res+" Record Inserted ");
			
			
		
						
	}
}


O/P:
	
	1 Record Inserted 


SQL> select * from Mydetails;

NAME                 ADDRESS                             HOUSE
-------------------- ------------------------------ ----------
Tinku                NewJersy                             7726
Funny                Virginia                             9411
Pinky                Vijayawada                            154
Mouni                Hydrabad                              129
Chota                Wisconsi                             2747
Pandu                Vijayawada                            128
Kittu                Chennai                              1245
Mahee                Virginia                             9335

8 rows selected.

	
EX: 6.2	(Updating)
.............................................................................................................................................
			
			//4.Executing
			PreparedStatement ps=con.prepareStatement("update Mydetails set address=? where name=? ");
			ps.setString(1,"Guntur");
			ps.setString(2,"Pandu");
			
			
			int res=ps.executeUpdate();
			if(res!=0)
				System.out.println(res+" Record Inserted ");
			
O/P

SQL> select * from Mydetails;

NAME                 ADDRESS                             HOUSE
-------------------- ------------------------------ ----------
Tinku                NewJersy                             7726
Funny                Virginia                             9411
Pinky                Vijayawada                            154
Mouni                Hydrabad                              129
Chota                Wisconsi                             2747
Pandu                Guntur                                128
Kittu                Chennai                              1245
Mahee                Virginia                             9335

8 rows selected.

EX: 6.3 -- Using (Select command)
...............................................................................................................................................................

Connection con=DriverManager.getConnection(url,username,password);
						
			//4.Executing
			PreparedStatement ps=con.prepareStatement("select * from Mydetails");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));
			
			
		
						
	}
}


O/P

Tinku  NewJersy  7726
Funny  Virginia  9411
Pinky  Vijayawada  154
Mouni  Hydrabad  129
Chota  Wisconsi  2747
Pandu  Guntur  128
Kittu  Chennai  1245
Kittu  Chennai  1245
Kittu  Chennai  1245
Mahee  Virginia  9335


EX: 6.4   -- Using Particular value
................................................................................................................................................................

	//4.Executing
			PreparedStatement ps=con.prepareStatement("select name from Mydetails where address=?");
			ps.setString(1,"Virginia");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				System.out.println(rs.getString(1));
			
			
		
O/P:

Funny
Mahee

EX: 6.5 -- 
.....................................................................................
PreparedStatement ps=con.prepareStatement("select address from Mydetails where house=?");
			ps.setInt(1,9411);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
				System.out.println(rs.getString(1));
			
O/P
Virginia	

EX: 6.6 -- delete the particular record
...............................................................................................................................................................


			PreparedStatement ps=con.prepareStatement("delete Mydetails where address=?");
			ps.setString(1,"VA");
			
			int res=ps.executeUpdate();
			if(res!=0)
				System.out.println(res+" Record Deleted ");
			
			
O/P
Record Deleted


*/
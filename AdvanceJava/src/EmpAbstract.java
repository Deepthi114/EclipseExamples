
	/*abstract class Employee
	{
		String name;
		int members;
		String address;
		static String degree="Masters in Information Security System";
		abstract void details();
		
	}
	class Employee1 extends Employee
			{		
					void details()
					{
							this.name="Mahee";
							this.address="Fairfax";
							this.members=4;
							System.out.println("My Name:"+this.name);
							System.out.println("Address:"+this.address);
							System.out.println("Degree:"+degree);
							System.out.println("Members in my Family:"+this.members);
						}
			}
	class Employee2 extends Employee
			{
						void details()
						{
							this.name="Deepu";
							this.address="LeeHighway";
							this.members=4;							
							System.out.println("My Name:"+name);
							System.out.println("Address:"+address);
							System.out.println("Degree:"+degree);
							System.out.println("Members in my Family:"+members);			
							
						}						
			}
		class EmployeeObject 
		{
		static Employee getEmp(String empName)
			{
				if(empName.equals("Mahee"))
					return new Employee1();
				else
					if(empName.equals("Deepu"))
						return new Employee2();
					else
						return null;
			}
		}
	class EmployeeOverriding
	{	
	public static void main(String[]args)
		{
		
		//EmployeeObject eo=new EmployeeObject();
		Employee e= EmployeeObject.getEmp("Mahee");
		e.details();
		
		
		
		}

	}

*/
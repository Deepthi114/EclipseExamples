public class ThreadExample {

	public static void main(String[] args) throws Exception 
	{
	
		Thread ta=new Thread(() ->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Add i + '10' = "+(i+10));//Thread.currentThread().getPriority()
								try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}	
			
				});
		Thread tm=new Thread(()->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Mul i * '2' = "+(i*2));
									try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}				
				});
		
		ta.setPriority(Thread.MIN_PRIORITY);
		tm.setPriority(Thread.MAX_PRIORITY);
		
		
	/*	ta.setPriority(1);
		tm.setPriority(10);*/
		
		System.out.println(ta.getPriority()); // the actual priority is = 5
		System.out.println(tm.getPriority()); 
		
		/*The default "Range Of Priority"
		Least Priority = 1
		Normal Priority = 5
		Highest Priority  = 10*/
		
		
		ta.start();	
		tm.start();
	
	}
}


/* Example 1 -- Using " Thread class " and " Sleep method "
 _____________________________________________________________________________________

class Add extends Thread
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{		
			System.out.println("Add i + '10' = "+(i+10));
			try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
		}		
	}
}
class Mul extends Thread
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{		
			System.out.println("Mul i * '2' = "+(i*2));
			try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
		}		
	}	
}
public class ThreadExample {

	public static void main(String[] args) 
	{
		Add a=new Add();
		Mul m=new Mul();
		a.start();
		m.start();
	}
}

OutPut:

Add i + '10' = 10
Mul i * '2' = 0
Add i + '10' = 11
Mul i * '2' = 2
Mul i * '2' = 4
Add i + '10' = 12
Add i + '10' = 13
Mul i * '2' = 6
Mul i * '2' = 8
Add i + '10' = 14
Mul i * '2' = 10
Add i + '10' = 15

*/

/*Example 2 -- Using " Runnable interface "
 -----------------------------------------------------------------------------------------------------------------------------------------------
class Add implements Runnable
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{		
			System.out.println("Add i + '10' = "+(i+10));
			try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
		}		
	}
}
class Mul implements Runnable
{
	public void run()
	{
		for(int i=0;i<=5;i++)
		{		
			System.out.println("Mul i * '2' = "+(i*2));
			try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
		}		
	}	
}
public class ThreadExample {

	public static void main(String[] args) 
	{
		Add a=new Add();
		Mul m=new Mul();
		
		Thread ta=new Thread(a);
		Thread tm=new Thread(m);
		ta.start();
		tm.start();
	}
}

OutPut:
Mul i * '2' = 0
Add i + '10' = 10
Add i + '10' = 11
Mul i * '2' = 2
Add i + '10' = 12
Mul i * '2' = 4
Add i + '10' = 13
Mul i * '2' = 6
Add i + '10' = 14
Mul i * '2' = 8
Add i + '10' = 15
Mul i * '2' = 10
*/

/* Example 3 --> using " Anonymous Inner class " and " Lambda Expression "
 ____________________________________________________________________________________
public class ThreadExample {

	public static void main(String[] args) 
	{
		//Runnable --> it is a Functional Interface , We can Use Lambda Expression
				
		Thread ta=new Thread(() ->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Add i + '10' = "+(i+10));
									try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}	
			
				});
		Thread tm=new Thread(()->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Mul i * '2' = "+(i*2));
										try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}				
				});
		ta.start();
		tm.start();
	}
}

OutPut:

Mul i * '2' = 0
Add i + '10' = 10
Add i + '10' = 11
Mul i * '2' = 2
Add i + '10' = 12
Mul i * '2' = 4
Add i + '10' = 13
Mul i * '2' = 6
Add i + '10' = 14
Mul i * '2' = 8
Mul i * '2' = 10
Add i + '10' = 15
*/


/* Example 4 --> Using isAlive(),setName(),getName(),join() , name declaration during object creation 
 _______________________________________________________________________________________________
 
public class ThreadExample {

	public static void main(String[] args) throws Exception 
	{
		//Runnable --> it is a Functional Interface , We can Use Lambda Expression
				
		Thread ta=new Thread(() ->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Add i + '10' = "+(i+10));
								//	try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}	
			
				},"Addition Thread");
		Thread tm=new Thread(()->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Mul i * '2' = "+(i*2));
										// try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}				
				},"Multiplication Thread");
		
			ta.setName("Addition Thread");
			tm.setName("Multiplication Thread");
		
			System.out.println(ta.getName());
			System.out.println(tm.getName());
		
		O/P:
				Thread-0
				Thread-1
		
		
		
		ta.start();	
		tm.start();
		
		
		ta.join(); // "join()" method throws an Exception 
		tm.join();
		
		System.out.println("Addition Thread Active Status ="+ta.isAlive()); // Checks weather the Thread Add 'ta' is alive or not
		
		System.out.println("Mahee");
	}
}*/

/*Example 5 --> Using The "getPriority()" and "setPriority()"
 __________________________________________________________________________________________________

public class ThreadExample {

	public static void main(String[] args) throws Exception 
	{
	
		Thread ta=new Thread(() ->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Add i + '10' = "+(i+10));//Thread.currentThread().getPriority()
								try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}	
			
				});
		Thread tm=new Thread(()->
				{
					for(int i=0;i<=5;i++)
						{		
							System.out.println("Mul i * '2' = "+(i*2));
									try {				Thread.sleep(500);			} catch (InterruptedException e) {				e.printStackTrace();			}
						}				
				});
		
		ta.setPriority(Thread.MIN_PRIORITY);
		tm.setPriority(Thread.MAX_PRIORITY);
		
		ta.setPriority(1);
		tm.setPriority(10);
		
		System.out.println(ta.getPriority()); // the actual priority is = 5
		System.out.println(tm.getPriority()); 
		
		The default "Range Of Priority"
		Least Priority = 1
		Normal Priority = 5
		Highest Priority  = 10
		
		ta.start();	
		tm.start();	
	}
}

OutPut:

1
10
Mul i * '2' = 0
Add i + '10' = 10
Mul i * '2' = 2
Add i + '10' = 11
Mul i * '2' = 4
Add i + '10' = 12
Mul i * '2' = 6
Add i + '10' = 13
Mul i * '2' = 8
Add i + '10' = 14
Mul i * '2' = 10
Add i + '10' = 15
*/
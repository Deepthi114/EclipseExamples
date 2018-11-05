
class Abc
{
	int num;
	boolean valueSet = false;
	
	public synchronized void put(int num)  //when ever we use the " wait() " method we use "synchronized"
	{
		while(valueSet)
		{
			try{	wait();	} catch(Exception e) {}
		}
		System.out.println("Put :  "+num);
		this.num=num;
		valueSet=true;
		notify(); // Notify the Consumer Thread
		
	}
	public synchronized void get()
	{
		while(!valueSet)
		{
			try{	wait();	} catch(Exception e) {}
		}
		System.out.println("Get :  "+num);
		valueSet=false;
		notify(); //Notify the Produce Thread
	}
}

class Producer implements Runnable
{
	Abc a;

	public Producer(Abc a) {
		this.a = a;
		Thread  t=new Thread(this,"Producer");
		t.start();
	}
	public void run()
	{
		int i=0;
		while(true)
		{
			a.put(i++);
			try {				Thread.sleep(1000);			}			catch(Exception e) {	}
		}
	}
	
}

class Consumer implements Runnable
{
	Abc a;

	public Consumer(Abc a) {
		this.a = a;
		Thread  t=new Thread(this,"Consumer");
		t.start();
		
	}
	public void run()
	{
		while(true)
		{
			a.get();
			try {				Thread.sleep(1000);			}			catch(Exception e) {	}
		}
	}
	
}

public class InterThreadEx {

	public static void main(String[] args) 
		{
				Abc a=new Abc();
				new Producer(a);
				new Consumer(a);
		}

}


public class ForNameExample {
	
	static {
		System.out.println("ForName Static block");
	}

}

class Example2
{
	static {
		System.out.println("ForName Example 2 Static block");
	}
}

class Consultency
{
	public static void main(String[]args) throws Exception
	{
		System.out.println("Consultency main Block");
		Class.forName("ForNameExample");
		Class.forName("Example2");
	}
}

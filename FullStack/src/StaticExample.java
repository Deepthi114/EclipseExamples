
public class StaticExample {
	static {
		System.out.println("Static Block-1");//static block will be executed directly
		
	}
	static {
		System.out.println("Static Block-2");//static blocks are given the first place 
	}
	public static void show()
	{
		System.out.println("Static Method");//will be executed after the static block
	}
	static {
		System.out.println("Static Block-3");
	}

	public static void main(String[] args) {
		show();

	}

}

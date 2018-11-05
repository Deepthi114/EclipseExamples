abstract class Mobile {
	String mobile;
	String capacity;
	double version;
	abstract void version();
	abstract void details();

}
class IphoneX extends Mobile
{
	void version()
	{
		this.mobile="IphoneX";
		this.capacity="256GB";
		this.version=12.0;
	}
	void details()
	{		
		System.out.println("Mobile Name:"+this.mobile);
		System.out.println("Software Version:"+this.version);
		System.out.println("Storage Capacity:"+this.capacity);
	}

}
class Iphone6S extends Mobile
{
	
	void version()
	{
		this.mobile="Iphone6S";
		this.capacity="128GB";
		this.version=12.0;
	}
	void details()
	{
		System.out.println("Mobile Name:"+mobile);
		System.out.println("Software Version:"+version);
		System.out.println("Storage Capacity:"+capacity);
	}

}
class OnePlus extends Mobile
{
	void version()
	{
		this.mobile="OnePlus 6";
		this.capacity="128GB";
	}
	void details()
	{
		System.out.println("Mobile Name:"+mobile);
		System.out.println("Storage Capacity:"+capacity);
	}

	
}
class PhoneObject 
{
	Mobile getPhone(String phoneName)
	{
		if(phoneName.equals("IphoneX"))
			return new IphoneX();
		else
			if(phoneName.equals("Iphone6S"))
				return new Iphone6S();
			else
				return null;
	}
}
class MethodOverriding
{
	public static void main(String[]args)
	{
		PhoneObject po=new PhoneObject();
		Mobile m=po.getPhone( "IphoneX");
		m.version();
		m.details();
}
}


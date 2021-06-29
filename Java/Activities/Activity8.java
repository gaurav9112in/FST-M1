package activities;

public class Activity8 {
	
	public static void exceptionTest(String str) throws CustomException
	{
		if ( str.isEmpty())
			throw new CustomException("String is null"); 
		else
			System.out.println(str);
				
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Activity8.exceptionTest("Hello World");
			Activity8.exceptionTest("");
			
		}
		
		catch(CustomException cexp)
		{
			System.out.println("Inside catch block: " + cexp.getMessage());
        }
    
	}
				 
}



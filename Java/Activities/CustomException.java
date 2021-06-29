package activities;

public class CustomException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public CustomException(String msg)
	{
		this.message = msg;
	}
	
	@Override
	public String getMessage() {
	    return message;
	}

}

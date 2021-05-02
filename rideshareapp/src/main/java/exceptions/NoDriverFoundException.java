package exceptions;

public class NoDriverFoundException extends Exception{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No Driver is Currently free!";
	}
}

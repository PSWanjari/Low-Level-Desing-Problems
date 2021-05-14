package Exceptions;

public class InvalidUserException extends Exception {

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No user with the userid found";
	}
}

package Exceptions;

public class NoRoomCurrentlyAvailableException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Sorry Currently No room is avilable!!";
	}
}

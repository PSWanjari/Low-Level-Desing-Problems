package Exceptions;

public class InvalidRoomIdException extends Exception {
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No Room found with the given Id";
	}

}

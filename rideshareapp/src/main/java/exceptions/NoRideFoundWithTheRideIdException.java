package exceptions;

public class NoRideFoundWithTheRideIdException extends Exception {
 @Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "No ride with the particualr ride id found";
	}
   
}

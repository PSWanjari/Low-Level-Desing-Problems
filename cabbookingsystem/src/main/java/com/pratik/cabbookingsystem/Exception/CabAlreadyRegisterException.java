package com.pratik.cabbookingsystem.Exception;

public class CabAlreadyRegisterException extends RuntimeException {

	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "cab already register in the system !";
	}
	
	
}

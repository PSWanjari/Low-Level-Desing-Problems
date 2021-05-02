package DriverMatchingStraterigies;

import exceptions.NoDriverFoundException;
import model.Driver;
import model.User;

public interface DriverMatachingStratergies {
	public Driver MatchDriverToUSer(User user,int from,int to) throws NoDriverFoundException;
	
}

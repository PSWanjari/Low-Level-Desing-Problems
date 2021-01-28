package com.pratik.cabbookingsystem.DAO;

import java.util.HashMap;
import java.util.Map.Entry;

import com.pratik.cabbookingsystem.model.Rider;

public class RiderDAO {

	HashMap<String, Rider> riders_in_system = new HashMap<String, Rider>();
	
	//register a rider
	public void registerRider(String rider_id,String rider_name ) throws Exception
	{
		if(riders_in_system.containsKey(rider_id))
		{
			throw new Exception("Rider already registery in system");
		}else {
			Rider rider = new Rider(rider_id, rider_name);
			riders_in_system.put(rider_id, rider);				
		}
	}
	
	//get Rider from id 
	public Rider getrider(String id)
	{
		return riders_in_system.get(id);
	}
	//get all rider
	public void getallrider()
	{
		for (Entry<String, Rider> item : riders_in_system.entrySet()) {
			System.out.println(item.getValue().getId()+" "+item.getValue().getName());
		}
	}
}

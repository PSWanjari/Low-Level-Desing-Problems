package CostingStrategeries;

import DAO.PlatformDAO;
import model.Ride;

public class DistanceAndSeatsBasedCostingStratergy implements CostingStratergy {
   
	PlatformDAO platformDAO;
	public static final int CHARGES_PER_KM =20;
	
	public DistanceAndSeatsBasedCostingStratergy(PlatformDAO platformDAO) {
		// TODO Auto-generated constructor stub
		this.platformDAO = platformDAO;
	}
	public int calaculateCost(Ride ride) {
		// TODO Auto-generated method stub
		if(ride.getUser().isPreffereduser()){
			if(ride.getSeats()>=2)
			{
				return (int) ((ride.getTo()-ride.getFrom())*ride.getSeats()*CHARGES_PER_KM*0.75);
			}else {
				return (ride.getTo()-ride.getFrom())*CHARGES_PER_KM;
			}
		}
		if(ride.getSeats()>=2)
		{
			return (int) ((ride.getTo()-ride.getFrom())*ride.getSeats()*CHARGES_PER_KM*0.5);
		}
		return (int) ((ride.getTo()-ride.getFrom())*CHARGES_PER_KM*0.75);
		
	}
	

}

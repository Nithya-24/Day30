package day30;

import java.util.HashMap;

public class TotalFare {
	
	HashMap<Integer, TotalFare[]> rideRepo = new HashMap<Integer, TotalFare[]>();

	public HashMap<Integer, TotalFare[]> getRideRepo() {
		return rideRepo;
	}
	
	public double distance;
	public double time;
	

	public TotalFare(double distance, double time) {
		super();
		this.distance = distance;
		this.time = time;
	}
}
package day30;

import java.util.HashMap;

public class Ride {
	HashMap<Integer, TotalFare[]> rideRepo = new HashMap<Integer, TotalFare[]>();

	public HashMap<Integer, TotalFare[]> getRideRepo() {
		return rideRepo;
	}
}
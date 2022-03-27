package day30;

import java.util.HashMap;
import java.util.Map;

public class InvoiceGenerator {
	

	public double invoiceGenerator(TotalFare totalFare) {
		double fare = 10*totalFare.distance + totalFare.time;
		
		if(fare > 5) {
			return fare;
		}
		return 5;
	}
	
	/**
	 * Calculate fare for Multiple Rides
	 * @param rides
	 * @return
	 */
	
	public TotalFare invoiceGenerator(TotalFare[] totalFare) {
		double singleFare;
		double fare = 0;
		for (TotalFare ride : totalFare) {
			singleFare = 10*ride.distance + ride.time;
			fare += singleFare > 5 ? singleFare : 5;
		}
		return new TotalFare(totalFare.length, fare);

	}
	
	/**
	 * Methods to check the user rides 
	 * @param i
	 * @param rideRepo
	 * @return
	 */
	
	public TotalFare invoiceGenerator(int i, HashMap<Integer, TotalFare[]> rideRepo) {

		for (Map.Entry<Integer, TotalFare[]> rideEntry : rideRepo.entrySet()) {
			if (rideEntry.getKey() == i)
				return invoiceGenerator(rideEntry.getValue());
		}

		return null;
	}
	
}
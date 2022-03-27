package day30;

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
	
	public double invoiceGenerator(TotalFare[] totalFare) {
		double singleFare;
		double fare = 0;
		for (TotalFare ride : totalFare) {
			singleFare = 10*ride.distance + ride.time;
			fare += singleFare > 5 ? singleFare : 5;
		}
		return fare;
	}
}
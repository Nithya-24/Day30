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
	
	public double calculateTotalFare(TotalFare[] totalFare) {
		double fare = 0;
		for (TotalFare ride : totalFare) {
			
			fare += this.invoiceGenerator(ride);
		}
		return fare;
	}
	public int getNumberOfRides(TotalFare[] rides) {

		return rides.length;
	}

	/**
	 * Method to calculate average ride fare
	 * @param rides - array of rides
	 * @return - length of array
	 */
	public double getAvarageRideFare(TotalFare[] rides) {

		return calculateTotalFare(rides) / rides.length;
	}
	
}
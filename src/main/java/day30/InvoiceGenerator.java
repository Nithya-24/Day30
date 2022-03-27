package day30;

public class InvoiceGenerator {
	

	public double invoiceGenerator(TotalFare totalFare) {
		double fare = 10*totalFare.distance + totalFare.time;
		
		if(fare > 5) {
			return fare;
		}
		return 5;
	}
}
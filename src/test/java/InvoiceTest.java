import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import day30.InvoiceGenerator;
import day30.TotalFare;

public class InvoiceTest {

	InvoiceGenerator invoice;
	@Before 
	public void initialization() {
		invoice = new InvoiceGenerator();
	}
	
	/**
	 * Ttest case to check the total fare.
	 */
	
	@Test
	public void testGenerateInvoice() {
		
		Assert.assertEquals(103, invoice.invoiceGenerator(new TotalFare(10, 3)), 0.0);
	}
	/**
	 * Test case to check for minimum fare.
	 * If the fare is less that Rs.5 then we our min fare will be Rs.5.
	 */
	@Test
	public void testGenerateInvoice_getMin() {
		
		Assert.assertEquals(5, invoice.invoiceGenerator(new TotalFare(0.1, 1)), 0.0);
	}
	
	@Test
	public void whenGivenMultipleRidesShouldReturnTotalFare() {

		TotalFare[] totalFare = { new TotalFare(4, 5), new TotalFare(0.2, 1) };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double fare = invoiceGenerator.calculateTotalFare(totalFare);
		Assert.assertEquals(50, fare, 0.0);
	}

	@Test
	public void sizeAndAverageFare_of_Multiplerides() {
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

		TotalFare[] totalFare = { new TotalFare(4, 5), new TotalFare(0.2, 1), new TotalFare(12, 15) };

		double fare = invoiceGenerator.calculateTotalFare(totalFare);
		int numberOfRides = invoiceGenerator.getNumberOfRides(totalFare);
		double averageFare = invoiceGenerator.getAvarageRideFare(totalFare);

		Assert.assertEquals(185, fare, 0.0);
		Assert.assertEquals(3, numberOfRides);
		Assert.assertEquals(61.66, averageFare, 0.5);
	}
	
}
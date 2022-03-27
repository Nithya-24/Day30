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
	
	/**
	 * Test case to test multiple rides.
	 */
	@Test
	public void testGenerateInvoice_multipleRides() {
		
		TotalFare [] rides = {new TotalFare(0.1, 2), new TotalFare(10, 3)};
		Assert.assertEquals(108, invoice.invoiceGenerator(rides), 0.0);
	}
}
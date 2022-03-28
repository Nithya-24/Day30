import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import day30.Invoice;
import day30.InvoiceGenerator;
import day30.Ride;
import day30.TotalFare;

public class InvoiceTest {

	InvoiceGenerator invoice;
	Ride ride = new Ride();
	HashMap<Integer, TotalFare[]> rideRepo;
	
	@Before 
	public void initialization() {
		invoice = new InvoiceGenerator();
		rideRepo = ride.getRideRepo();
	}
	
	/**
	 * test case to check the total fare.
	 */
	
	@Test
	public void testGenerateInvoice() {

		assertEquals(103, invoice.invoiceGenerator(new TotalFare(10, 3, "normal")), 0.0);
	}
	/**
	 * Test case to check for minimum fare.
	 * If the fare is less that Rs.5 then we our min fare will be Rs.5.
	 */
	public void testGenerateInvoice_getMin() {

		assertEquals(5, invoice.invoiceGenerator(new TotalFare(0.1, 1, "normal")), 0.0);
	}
	
	@Test
	public void testGenerateInvoice_multipleRides() {

		TotalFare[] totalFare1 = { new TotalFare(0.1, 2, "premium"), new TotalFare(10, 3, "normal") };
		TotalFare[] totalFare2 = { new TotalFare(3, 2, "normal"), new TotalFare(1, 3, "premium"), new TotalFare(150, 300, "premium") };
		TotalFare[] totalFare3 = { new TotalFare(5, 7, "normal") };

		rideRepo.put(1, totalFare1);
		rideRepo.put(2, totalFare2);
		rideRepo.put(3, totalFare3);

		Invoice invoices = new Invoice(3, 2903, 967.6);

		assertEquals(invoices, invoice.invoiceGenerator(2, rideRepo));
	}

}
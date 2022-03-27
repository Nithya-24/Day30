import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import day30.Invoice;
import day30.InvoiceGenerator;
import day30.TotalFare;

public class InvoiceTest {

	InvoiceGenerator invoice;
	TotalFare rideRepository = new TotalFare(10, 3);
	HashMap<Integer, TotalFare[]> rideRepo;
	
	@Before 
	public void initialization() {
		invoice = new InvoiceGenerator();
		rideRepo = rideRepository.getRideRepo();
	}
	
	/**
	 * We have written this test case to check the total fare.
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
	public void testInvoice_multipleRides() {
		
		TotalFare [] rides = {new TotalFare(0.1, 2), new TotalFare(10, 3)};
		//Assert.assertEquals(108, invoice.generateInvoice(rides), 0.0);
	}
	
	/**
	 * Test case to check total ride, fare and average fare.
	 */
	@Test
	public void testGenerateInvoice_multipleRides() {
		
		TotalFare [] rides = {new TotalFare(0.1, 2), new TotalFare(10, 3)};
		Invoice invoices = new Invoice(2, 108, 54);
		
		Assert.assertEquals(invoices, invoice.invoiceGenerator(rides));
	}
	
	/**
	 * Test case to check fare with user id.
	 * We are storing each user rides and then adding it in the hash map with user it and fare. 
	 */
	@Test
	public void RidesRepo_multipleRides() {

		TotalFare[] rides1 = { new TotalFare(0.1, 2), new TotalFare(10, 3) };
		TotalFare[] rides2 = { new TotalFare(3, 2), new TotalFare(1, 3), new TotalFare(150, 300) };
		TotalFare[] rides3 = { new TotalFare(5, 7) };

		rideRepo.put(1, rides1);
		rideRepo.put(2, rides2);
		rideRepo.put(3, rides3);

		Invoice invoices = new Invoice(3, 1845, 615);

		assertEquals(invoices, invoice.invoiceGenerator(2, rideRepo));
	}

}
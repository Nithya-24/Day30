package day30;


public class TotalFare {
	
	public double distance;
	public double time;
	public String category;
	
	public double distancePrice;
	public double timePrice;
	
	public TotalFare(double distance, double time, String category) {
		super();
		this.distance = distance;
		this.time = time;
		
		switch (category) {
		case "premium":
			this.distancePrice = 15;
			this.timePrice = 2;
			break;
		case "normal":
			this.distancePrice = 10;
			this.timePrice = 1;
			break;
			
		}
	}
	
}
import java.util.Comparator;

public class Vehicle {
	private int MSRP;
	private boolean isAvailable;
	private String location;
	private String make;
	private String model;
	private int year;
	private String demand;
	
	
	public Vehicle(int MSRP, boolean isAvailable, String location, String make, String model, int year, String demand) {
		setMSRP(MSRP);
		setAvailable(isAvailable);
		setLocation(location);
		setModel(model);
		setMake(make);
		setYear(year);
		setDemand(demand);
	}
	
	
	
	
	public Integer getMSRP() {
		return MSRP;
	}
	public void setMSRP(int MSRP) {
		this.MSRP = MSRP;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDemand() {
		return demand;
	}
	public void setDemand(String demand) {
		this.demand = demand;
	}
	
	public double demandPremium() {
		double increaseRate = 1;		
		if (demand.equalsIgnoreCase("medium")) {
			increaseRate = 1.15;
		}
		if (demand.equalsIgnoreCase("high")) {
			increaseRate = 1.50;
		}
		return MSRP * increaseRate;
	}	
}

class PriceRanking implements Comparator<Vehicle> {
	public int compare(Vehicle v1, Vehicle v2) {
		return v1.getMSRP().compareTo(v2.getMSRP());
	}
}

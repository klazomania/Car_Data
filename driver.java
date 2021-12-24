
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class driver {
	
	public static int ID;
	public static TreeMap<Integer, Vehicle> cars = new TreeMap<Integer, Vehicle>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {		
		readFile("carData.txt");
		
		System.out.println("Here are the lowest priced cars for each location: ");
		System.out.println();
		String[] names = {"Boston", "Paris", "Tokyo", "London"};
		for (String item : names) {
			System.out.println(item + ":  " + vehicleSearch(item).getYear() + " " + vehicleSearch(item).getMake() + " " + vehicleSearch(item).getModel());
		}	
		
	}
	
	public static void readFile(String input) throws FileNotFoundException  {		
		File file = new File(input);
		Scanner sc = new Scanner(file);			
		ID = 101;
		while ((sc.hasNext() == true)) {
			String line = sc.nextLine();
			String[] temp = line.split("\\s+");		
			String tempMake = temp[0];
			String tempModel = temp[1];
			int tempYear = Integer.valueOf(temp[2]);
			int tempPrice = Integer.valueOf(temp[2].substring(1, temp[2].length())); 
			cars.put(ID, new Vehicle(tempPrice, true, randomCity(), tempMake, tempModel, tempYear, null));
			ID++;		
		}
	}
	
	public static String randomCity() {
		Random rand = new Random();
		int random = rand.nextInt(4);
		if (random == 0) {
			return "Boston";
		}
		else if (random == 1) {
			return "London";
		}
		else if (random == 2) {
			return "Paris";
		}
		else {
			return "Tokyo";
		}		
	}
	
	public static Vehicle vehicleSearch(String inputCity) {
		int lowestPrice = Integer.MAX_VALUE;
		int resultID = -1;
		Iterator<Map.Entry<Integer, Vehicle>> itr = cars.tailMap(101).entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, Vehicle> entry = itr.next();
			if ((entry.getValue().getLocation().equalsIgnoreCase(inputCity)) && (entry.getValue().getMSRP() < lowestPrice)) {
				lowestPrice = entry.getValue().getMSRP();
				resultID = entry.getKey();
			}
		}
		return cars.get(resultID);
	}
	
}

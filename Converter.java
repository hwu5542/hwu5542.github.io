package main;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;



public class Converter {

	static HashSet<String> volumeUnits = new HashSet<String>();
	static HashSet<String> areaUnits = new HashSet<String>();
	static HashSet<String> distanceUnits = new HashSet<String>();

	static HashMap<String, Double> convFactor = new HashMap<String, Double>();

	public static void main(String[] args) {
		int menuSelection = 0;
		String origUnit = "",
			   convUnit = "",
			   origAmtStr = "";
		double origAmt = 0.0;

		// initialize the set of volume units
		volumeUnits.add("gallon");
		volumeUnits.add("quart");
		volumeUnits.add("pint");
		volumeUnits.add("liter");
		volumeUnits.add("mililiter");		
		volumeUnits.add("cubic inch");		
		volumeUnits.add("cubit foot");
		volumeUnits.add("cubic meter");
		
		// initialize the map of volume conversion factor
		convFactor.put("gallon", 1.0);
		convFactor.put("quart", 4.0);
		convFactor.put("pint", 8.0);
		convFactor.put("liter", 3.78541);
		convFactor.put("mililiter", 3785.41);
		convFactor.put("cubic inch", 231.0);
		convFactor.put("cubic foot", 0.133681);
		convFactor.put("cubic meter", 0.00378541);

		
		// initialize the set of area units
		areaUnits.add("squre kilometer");
		areaUnits.add("squre meter");
		areaUnits.add("squre mile");
		areaUnits.add("squre yard");
		areaUnits.add("squre foot");
		areaUnits.add("squre inch");
		areaUnits.add("hectare");
		areaUnits.add("acre");
		
		// initialize the map of area conversion factor
		convFactor.put("squre kilometer", 0.01);
		convFactor.put("squre meter", 10000.0);
		convFactor.put("squre mile", 0.00386102);
		convFactor.put("squre yard", 11959.9);
		convFactor.put("squre foot", 107639.0);
		convFactor.put("squre inch", 15500000.0);
		convFactor.put("hectare", 1.0);
		convFactor.put("acre", 2.47105);

		// initialize the set of distance units
		distanceUnits.add("kilometer");
		distanceUnits.add("meter");
		distanceUnits.add("centimeter");
		distanceUnits.add("milimeter");
		distanceUnits.add("micrometer");
		distanceUnits.add("nanometer");
		distanceUnits.add("mile");
		distanceUnits.add("yard");
		distanceUnits.add("foot");
		distanceUnits.add("inch");		

		// initialize the map of distance conversion factor
		convFactor.put("kilometer", 0.00001);	
		convFactor.put("meter", 0.01);	
		convFactor.put("centimeter", 1.0);	
		convFactor.put("milimeter", 10.0);	
		convFactor.put("micrometer", 10000.0);	
		convFactor.put("nanometer", 10000000.0);	
		convFactor.put("mile", 0.0000062137);	
		convFactor.put("yard", 0.0109361);	
		convFactor.put("foot", 0.0328084);	
		convFactor.put("inch", 0.393701);	
		
		Scanner userInput = new Scanner(System.in);
		
		while (menuSelection != 4 /*last menu option*/) {
			userInput.reset();
			System.out.println("Please select convertion type:");
			System.out.println("1. Volume");
			System.out.println("2. Area");
			System.out.println("3. Distance");
			System.out.println("Enter anything else to exit");

			if (userInput.hasNext()) menuSelection = userInput.nextInt();
			userInput.nextLine();
			
			if ((menuSelection < 4) && (menuSelection > 0))	{
				System.out.println("Enter the amount:");
				if (userInput.hasNext()) origAmtStr = userInput.nextLine();
				origAmt = Double.parseDouble(origAmtStr);
				
				System.out.println("Enter the unit type:");				
				if (userInput.hasNext()) origUnit = userInput.nextLine();
								
				System.out.println("Enter the unit type converting to:");
				if (userInput.hasNext()) convUnit = userInput.nextLine();
			}
			

			switch (menuSelection) {
				case 1:
					if ((volumeUnits.contains(origUnit)) && (volumeUnits.contains(convUnit))) {
						ConvertUnits(origUnit, convUnit, origAmt);
					}
					else {
						System.out.println("Unit cannot be found");
					}
					break;
					
				case 2:
					if ((areaUnits.contains(origUnit)) && (areaUnits.contains(convUnit))) {
						ConvertUnits(origUnit, convUnit, origAmt);
					}
					else {
						System.out.println("Unit cannot be found");						
					}
					break;

				case 3:
					if ((distanceUnits.contains(origUnit)) && (distanceUnits.contains(convUnit))) {
						ConvertUnits(origUnit, convUnit, origAmt);
					}
					else {
						System.out.println("Unit cannot be found");	
					}
					break;

				default:
					menuSelection = 4;
			}
		}
		userInput.close();
	}

	public static void ConvertUnits(String origUnit, String convUnit, double origAmt)	{
		double factor, result;
		Double N1 = convFactor.get(origUnit),
			   N2 = convFactor.get(convUnit);
		factor = N2 / N1;
		result = origAmt * factor;
		System.out.println("The amount after convert: " + String.format("%.2f", result) + ' ' + convUnit + '\n');
	}
}
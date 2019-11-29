package OctopusConsortium.Core;

public class DistanceConversion {

	public static float ConvertKilometersToMiles(float kilometers) {
		if (kilometers > 0) {
    		return (float) (kilometers * 0.621371192);
    	} else {
    		return 0;
    	}
	}
	
	public static float ConvertKilometersToMiles(int kilometers) {
    	return ConvertKilometersToMiles((float) kilometers);
	}
	
	public static float ConvertMilesToKilometers(float miles) {
		if (miles > 0) {
    		return (float) (miles * 1.609344);
    	} else {
    		return 0;
    	}
	}
	
	public static float ConvertMilesToKilometers(int miles) {
    	return ConvertMilesToKilometers((float) miles);
	}
}

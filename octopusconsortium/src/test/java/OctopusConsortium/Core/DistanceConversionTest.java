package OctopusConsortium.Core;

import static org.junit.Assert.*;
import org.junit.Test;


public class DistanceConversionTest {

	@Test
	public void ConvertKilometersToMilesFloat() {
		//arrange
		float kms = 16;
		//act
		float miles = DistanceConversion.ConvertKilometersToMiles(kms);
		//assert
		assertEquals(10,miles,0.1);
	}
	
	@Test
	public void ConvertMilesToKilometersFloat() {
		//arrange
		float miles = 10;
		//act
		float kms = DistanceConversion.ConvertMilesToKilometers(miles);
		//assert
		assertEquals(16,kms,0.1);
	}
	
	@Test
	public void ConvertKilometersToMilesFloatLarge() {
		//arrange
		float kms = 2011;
		//act
		float miles = DistanceConversion.ConvertKilometersToMiles(kms);
		//assert
		assertEquals(1250,miles,1);
	}
	
	@Test
	public void ConvertMilesToKilometersFloatLarge() {
		//arrange
		float miles = 1250;
		//act
		float kms = DistanceConversion.ConvertMilesToKilometers(miles);
		//assert
		assertEquals(2011,kms,1);
	}
	
	@Test
	public void ConvertKilometersToMilesFloatZero() {
		//arrange
		float kms = 0;
		//act
		float miles = DistanceConversion.ConvertKilometersToMiles(kms);
		//assert
		assertEquals(0,miles,0.0001);
	}
	
	@Test
	public void ConvertMilesToKilometersFloatZero() {
		//arrange
		float miles = 0;
		//act
		float kms = DistanceConversion.ConvertMilesToKilometers(miles);
		//assert
		assertEquals(0,kms,0.0001);
	}
	
	@Test
	public void ConvertKilometersToMilesInteger() {
		//arrange
		int kms = 16;
		//act
		float miles = DistanceConversion.ConvertKilometersToMiles(kms);
		//assert
		assertEquals(10,miles,0.1);
	}
	
	@Test
	public void ConvertMilesToKilometersInteger() {
		//arrange
		int miles = 10;
		//act
		float kms = DistanceConversion.ConvertMilesToKilometers(miles);
		//assert
		assertEquals(16,kms,0.1);
	}
	
	@Test
	public void ConvertMilesToKilometersInteger30() {
		//arrange
		int miles = 30;
		//act
		float kms = DistanceConversion.ConvertMilesToKilometers(miles);
		//assert
		assertEquals(48.28,kms,0.01);
	}
}
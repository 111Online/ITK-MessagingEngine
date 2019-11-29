package OctopusConsortium.Core;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostcodeHelperTest {
	
	@Test
	public void AddSpaceToPostcodeTooLong() {
		//arrange
		String input = "SO302UNNN";
		String expected = "SO302U NNN";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}

	
	@Test
	public void AddSpaceToPostcodeSevenChars() {
		//arrange
		String input = "SO302UN";
		String expected = "SO30 2UN";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}

	@Test
	public void AddSpaceToPostcodeSixChars() {
		//arrange
		String input = "PO75SS";
		String expected = "PO7 5SS";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeSixCharsHasSpace() {
		//arrange
		String input = "PO7 5SS";
		String expected = "PO7 5SS";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeFiveChars() {
		//arrange
		String input = "S83NM";
		String expected = "S8 3NM";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeFourChars() {
		//arrange
		String input = "PO75";
		String expected = "P O75";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeFourCharsHasSpace() {
		//arrange
		String input = "PO7 5";
		String expected = "PO7 5";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeThreeChars() {
		//arrange
		String input = "PO7";
		String expected = "PO7";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeTwoChars() {
		//arrange
		String input = "SO";
		String expected = "SO";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeEmpty() {
		//arrange
		String input = "";
		String expected = "";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
	
	@Test
	public void AddSpaceToPostcodeHasSpace() {
		//arrange
		String input = "PO7 5SS";
		String expected = "PO7 5SS";
		
		//act
		String actual = PostcodeHelper.AddSpaceToPostcode(input);
		
		//assert
		assertEquals(expected,actual);
	}
		
	

}
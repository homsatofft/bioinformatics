package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

import week_1_2.Converter;

public class ConverterTest
{

	@Test
	public void testPatternToNumber()
	{
		assertEquals("Wrong pattern to number conversion", 912, Converter.patternToNumber("ATGCAA"));
		assertTrue("Wrong number to pattern conversion", Converter.numberToPattern((long) 912, 6).equals("ATGCAA"));
	}

}

package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Utils;

public class SkewTest
{

	Skew skew = new Skew();
	
	@Test
	public void test()
	{
		String input = "CATGGGCATCGGCCATACGCC";
		String expected = "0 -1 -1 -1 0 1 2 1 1 1 0 1 2 1 0 0 0 0 -1 0 -1 -2";		
		String res = Utils.collectionToString(skew.compute(input));
		assertTrue(expected.equals(res));
	}

	@Test
	public void testMins()
	{
		String expected = "11 24";
		String input = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
		String actual = Utils.collectionToString(skew.computeMins(input));
		assertTrue(expected.equals(actual));
	}
}

package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

import utils.Utils;

public class SkewTest
{

	@Test
	public void test()
	{
		String input = "CATGGGCATCGGCCATACGCC";
		String expected = "0 -1 -1 -1 0 1 2 1 1 1 0 1 2 1 0 0 0 0 -1 0 -1 -2";
		String skew = Utils.collectionToString(Skew.compute(input));
		assertTrue(expected.equals(skew));
	}

	@Test
	public void testMins()
	{
		String expected = "11 24";
		String input = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
		String actual = Utils.collectionToString(Skew.computeMins(input));
		assertTrue(expected.equals(actual));
	}
}

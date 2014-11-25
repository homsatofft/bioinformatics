package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class ClumpFindingTest
{
	ClumpFinding cf = new ClumpFinding();
	List<String> expected = new ArrayList<>(Arrays.asList("CGACA", "GAAGA"));
	String text = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
	
	@Test
	public void test()
	{
		Collection<String> actual = cf.compute(text, 5, 50, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

	@Test
	public void testBetter()
	{
		Collection<String> actual = cf.computeFast(text, 5, 50, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}
}

package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class PatternCountTest
{
	
	PatternCount pc = new PatternCount();

	@Test
	public void testCount()
	{
		String text = "GCGCG";
		String pattern = "GCG";
		assertEquals("Exact pattern count is wrong!", 2, pc.count(text, pattern));
	}

	@Test
	public void testCountN()
	{
		String text = "TTTAGAGCCTTCAGAGG";
		String pattern = "GAGG";
		int n = 2;
		assertEquals("Approximate pattern count is wrong!", 4, pc.countN(text, pattern, n));
	}
}

package week_3_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class GivenMassPeptideTest
{

	@Test
	public void testCalculate()
	{
		GivenMassPeptide gmp = new GivenMassPeptide();
		assertEquals(14712706211L, gmp.calculate(500));
	}
}

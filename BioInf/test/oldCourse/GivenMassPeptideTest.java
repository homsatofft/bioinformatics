package oldCourse;

import static org.junit.Assert.*;
import oldCourse.GivenMassPeptide;

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

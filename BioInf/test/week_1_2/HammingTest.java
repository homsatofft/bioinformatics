package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HammingTest
{

	@Test
	public void testDistance()
	{
		String one = "GGGCCGTTGGT";
		String two = "GGACCGTTGAC";
		assertEquals("Hamming calculated wrongly!", 3, Hamming.distance(one, two));
	}
}

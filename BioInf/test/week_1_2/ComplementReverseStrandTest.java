package week_1_2;

import static org.junit.Assert.*;

import org.junit.Test;

import week_1_2.ComplementReverseStrand;

public class ComplementReverseStrandTest
{

	@Test
	public void test()
	{
		assertTrue("ACCGGGTTTT".equals(ComplementReverseStrand.compute("AAAACCCGGT")));
	}

}

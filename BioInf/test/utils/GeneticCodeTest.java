package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class GeneticCodeTest
{

	@Test
	public void testGetRnaCodon()
	{
		GeneticCode gc = new GeneticCode();
		assertEquals("Should be equal!", 'G', gc.getAminoAcid("GGA"));
	}

}

package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ProfileTest
{

	@Test
	public void testFindPattern()
	{
		String dna = "ACCTGTTTATTGCCTAAGTTCCGAACAAACCCAATATAGCCCGAGGGCCT";
		double[][] profile =
		{
		{ 0.2, 0.2, 0.3, 0.2, 0.3, },
		{ 0.4, 0.3, 0.1, 0.5, 0.1 },
		{ 0.3, 0.3, 0.5, 0.2, 0.4 },
		{ 0.1, 0.2, 0.1, 0.1, 0.2 } };
		String expected = "CCGAG";
		Profile p = new Profile(profile);
		String result = p.findPattern(dna);
		assertTrue(String.format("Expected %s, computed %s", expected, result),
				result.equalsIgnoreCase(expected));
	}

	@Test
	public void testProfileGeneration()
	{
		List<String> dna = new ArrayList<>(Arrays.asList("TCGGGGGTTTTT",
				"CCGGTGACTTAC", "ACGGGGATTTTC", "TTGGGGACTTTT", "AAGGGGACTTCC",
				"TTGGGGACTTCC", "TCGGGGATTCAT", "TCGGGGATTCCT", "TAGGGGAACTAC",
				"TCGGGTATAACC"));
		Profile p = new Profile(dna, false);
		double expected = 0.5;
		assertTrue(String.format("Expected: %f, actual: %f", expected,
				p._profile[3][7]), expected == p._profile[3][7]);
	}

	@Test
	public void testProbability()
	{
		double[][] profile =
		{
		{ 0.4, 0.3, 0.0, 0.1, 0.0, 0.9, },
		{ 0.2, 0.3, 0.0, 0.4, 0.0, 0.1 },
		{ 0.1, 0.3, 1.0, 0.1, 0.5, 0.0 },
		{ 0.3, 0.1, 0.0, 0.4, 0.5, 0.0 } };
		Profile p = new Profile(profile);
		double prob = p.probability("CAGTGA");
		assertTrue(prob == 0.0108);
	}

}

package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class ApproximatePatternMatchTest
{

	String pattern = "ATTCTGGA";
	String inputText = "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT";
	int mismatches = 3;
	Collection<Integer> expected = new ArrayList<>(Arrays.asList(6, 7, 26, 27));
	
	@Test
	public void testCompute()
	{
		Collection<Integer> actual = ApproximatePatternMatch.compute(pattern, inputText, mismatches);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

}

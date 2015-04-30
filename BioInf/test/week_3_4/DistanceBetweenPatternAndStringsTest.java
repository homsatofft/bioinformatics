package week_3_4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class DistanceBetweenPatternAndStringsTest {

	@Test
	public void testCompute() {

		int expected = 5;
		String pattern = "AAA";
		Collection<String> dnaStrings = new ArrayList<>(Arrays.asList(
				"TTACCTTAAC", "GATATCTGTC", "ACGGCGTTCG", "CCCTAAAGAG",
				"CGTCAGAGGT"));
		DistanceBetweenPatternAndStrings dbps = new DistanceBetweenPatternAndStrings();
		int result = dbps.compute(pattern, dnaStrings);
		assertEquals(expected, result);
	}

}

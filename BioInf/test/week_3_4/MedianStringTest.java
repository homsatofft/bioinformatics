package week_3_4;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;


public class MedianStringTest {

	@Test
	public void testFindMedian() {

		int k = 3;
		Collection<String> dnaStrings = new ArrayList<>(Arrays.asList(
				"AAATTGACGCAT", 
				"GACGACCACGTT", 
				"CGTCAGCGCCTG",
				"GCTGAGCACCGG",
				"AGTTCGGGACAG"));
		String expected = "GAC";
		MedianString ms = new MedianString();
		String median = ms.findMedian(dnaStrings, k);
		assertTrue(expected.equalsIgnoreCase(median));
	}

}

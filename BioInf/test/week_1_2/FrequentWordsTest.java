package week_1_2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class FrequentWordsTest
{
	String inputText = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
	Collection<String> expected = new ArrayList<>(Arrays.asList("CATG", "GCAT"));

	@Test
	public void testSimple()
	{
		Collection<String> actual = FrequentWords.count(inputText, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

	@Test
	public void testSorting()
	{
		Collection<String> actual = FrequentWords.countSorting(inputText, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

	@Test
	public void testMismatchSorting()
	{
		String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
		int k = 4;
		int d = 1;
		Collection<String> expected = new ArrayList<>(Arrays.asList("GATG",
				"ATGC", "ATGT"));
		Collection<String> actual = FrequentWords.countMismatchSorting(text, k,
				d);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}
}

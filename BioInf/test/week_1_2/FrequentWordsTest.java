package week_1_2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import utils.Utils;

public class FrequentWordsTest
{
	String inputText = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
	Collection<String> expected = new ArrayList<>(Arrays.asList("CATG", "GCAT"));
	Collection<String> expectedMismatch = new ArrayList<>(Arrays.asList("GATG",
			"ATGC", "ATGT"));
	Collection<String> expectedMismatchReverse = new ArrayList<>(Arrays.asList(
			"ATGT", "ACAT"));
	int k = 4;
	int d = 1;
	FrequentWords fw = new FrequentWords();

	@Test
	public void testSimple()
	{
		Collection<String> actual = fw.count(inputText, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

	@Test
	public void testSorting()
	{
		Collection<String> actual = fw.countSorting(inputText, 4);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

	@Test
	public void testMismatch()
	{

		Collection<String> actual = fw.countMismatch(inputText, k, d);
		assertTrue(Utils.collectionsEqual(expectedMismatch, actual));
	}

	@Test
	public void testMismatchSorting()
	{
		Collection<String> actual = fw.countMismatchSorting(inputText, k, d);
		assertTrue(Utils.collectionsEqual(expectedMismatch, actual));
	}

	@Test
	public void testMismatchReverse()
	{
		Collection<String> actual = fw.countMismatchReverseSorting(inputText,
				k, d);
		System.out.println(Utils.collectionToString(actual));
		assertTrue(Utils.collectionsEqual(expectedMismatchReverse, actual));
	}
}

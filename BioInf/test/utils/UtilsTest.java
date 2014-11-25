package utils;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import utils.Utils;

public class UtilsTest
{

	@Test
	public void testCollectionsEqual()
	{
		Collection<Integer> collOne = new ArrayList<>(Arrays.asList(0, 1, 2));
		Collection<Integer> collTwo = new ArrayList<>(Arrays.asList(2, 1, 0));
		Collection<Integer> collThree = new ArrayList<>(Arrays.asList(0, 1, 2));
		Collection<Integer> collFour = new ArrayList<>(Arrays.asList(1, 1, 2));
		Collection<Integer> collFive = new ArrayList<>(Arrays.asList(1, 2));

		assertTrue(Utils.collectionsEqual(collOne, collTwo));
		assertTrue(Utils.collectionsEqual(collTwo, collThree));
		assertFalse(Utils.collectionsEqual(collThree, collFour));
		assertFalse(Utils.collectionsEqual(collTwo, collFour));
		assertFalse(Utils.collectionsEqual(collTwo, collFive));
	}

	@Test
	public void testCollectionToString()
	{
		Collection<Integer> collOne = new ArrayList<>(Arrays.asList(0, 1, 2));
		String expected = "0 1 2";
		assertTrue(expected.equals(Utils.collectionToString(collOne)));
	}

	@Test
	public void testStringToCollectionOfInt()
	{
		String string = "0 1 2";
		Collection<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
		Collection<Integer> actual = Utils.stringToCollectionOfInt(string);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

}
package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class MotifEnumerationTest
{

	MotifEnumeration me = new MotifEnumeration();
	@Test
	public void testEnumerate()
	{
		int k = 3;
		int d = 1;
		List<String> expected = new ArrayList<>(Arrays.asList("ATA", "ATT", "GTT","TTT"));
		Collection<String> source = new ArrayList<>(Arrays.asList("ATTTGGC", "TGCCTTA", "CGGTATC","GAAAATT"));
		Collection<String> actual = me.enumerate(source, k, d);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}

}

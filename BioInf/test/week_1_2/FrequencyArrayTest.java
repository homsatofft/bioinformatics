package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;
import week_1_2.FrequencyArray;

public class FrequencyArrayTest
{
	List<Integer> expected =  new ArrayList<Integer>(Arrays.asList(2, 1, 0, 0, 0, 0, 2, 2, 1, 2, 1, 0, 0, 1, 1, 0));
	FrequencyArray fa = new FrequencyArray();

	@Test
	public void testComputeFrequency()
	{
		Collection<Integer> actual =  fa.computeFrequency("ACGCGGCTCTGAAA", 2);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}
}

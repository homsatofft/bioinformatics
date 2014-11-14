package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import week_1_2.FrequencyArray;

public class FrequencyArrayTest
{
	@Test
	public void test()
	{
		List<Integer> expected =  new ArrayList<Integer>(Arrays.asList(2, 1, 0, 0, 0, 0, 2, 2, 1, 2, 1, 0, 0, 1, 1, 0));
		Collection<Integer> actual =  FrequencyArray.computeFrequency("ACGCGGCTCTGAAA", 2);
		assertTrue(Utils.collectionsEqual(expected, actual));
	}
}

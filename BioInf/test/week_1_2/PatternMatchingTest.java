package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PatternMatchingTest
{

	@Test
	public void test()
	{
		List<Integer> res =  new ArrayList<Integer>(Arrays.asList(1, 3, 9));
		List<Integer> list = PatternMatching.compute("ATAT", "GATATATGCATATACTT");
		assertTrue(Utils.collectionsEqual(res, list));
	}
}

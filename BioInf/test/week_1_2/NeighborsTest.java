package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class NeighborsTest
{
	String pattern = "ACG";
	Collection<String> expected = new ArrayList<>(Arrays.asList("CCG", "TCG",
			"GCG", "AAG", "ATG", "AGG", "ACA", "ACC", "ACT", "ACG"));

	@Test
	public void testGenerate()
	{
		assertTrue(Utils.collectionsEqual(expected,
				Neighbors.generate(pattern, 1)));
	}

	@Test
	public void testGenerateImmediate()
	{
		assertTrue(Utils.collectionsEqual(expected,
				Neighbors.generateImmediate(pattern)));
	}

	@Test
	public void testGenerateIterative()
	{
		assertTrue(Utils.collectionsEqual(expected,
				Neighbors.generateIterative(pattern, 1)));
	}
}

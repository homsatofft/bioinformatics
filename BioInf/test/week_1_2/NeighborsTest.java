package week_1_2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import utils.Utils;

public class NeighborsTest
{
	Neighbors n = new Neighbors();
	String pattern = "ACG";
	Collection<String> expected = new ArrayList<>(Arrays.asList("CCG", "TCG",
			"GCG", "AAG", "ATG", "AGG", "ACA", "ACC", "ACT", "ACG"));

	@Test
	public void testGenerate()
	{
		assertTrue(Utils.collectionsEqual(expected, n.generate(pattern, 1)));
	}

	@Test
	public void testGenerateImmediate()
	{
		assertTrue(Utils.collectionsEqual(expected,
				n.generateImmediate(pattern)));
	}

	@Test
	public void testGenerateIterative()
	{
		assertTrue(Utils.collectionsEqual(expected,
				n.generateIterative(pattern, 1)));
	}
}

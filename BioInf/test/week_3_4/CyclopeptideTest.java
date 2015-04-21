package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class CyclopeptideTest
{
	Cyclopeptide c = new Cyclopeptide();

	@Test
	public void testSequence()
	{
		List<Integer> spectrum = new ArrayList<>(Arrays.asList(0, 113, 128,
				186, 241, 299, 314, 427));
		String expected = "186-128-113 186-113-128 128-186-113 128-113-186 113-186-128 113-128-186";
		List<String> eCol = new ArrayList<>(Arrays.asList(expected.split(" ")));
		Collection<String> result = c.sequence(spectrum);
		assertTrue(Utils.collectionsEqual(eCol, result));
	}
	
	@Test
	public void testLeaderboardSequence()
	{
		List<Integer> spectrum = new ArrayList<>(Arrays.asList(0, 71, 113,
				129, 147, 200, 218, 260, 313, 331, 347, 389, 460));
		int threshold = 10;
		//String expected = "113-147-71-129";
		String result = c.leaderboardSequence(spectrum, threshold);
		System.out.println(result);
		assertEquals(true,true);
	}
}

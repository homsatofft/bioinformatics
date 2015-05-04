package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class GreedyMotifTest {
	
	@Test
	public void testSearch(){
		GreedyMotif gm = new GreedyMotif();
		int k = 3;
		int t = 5;
		List<String> dna = new ArrayList<>(Arrays.asList(
				"GGCGTTCAGGCA", 
				"AAGAATCAGTCA", 
				"CAAGGAGTTCGC",
				"CACGTCAATCAC",
				"CAATAATATTCG"));
		List<String> output = new ArrayList<>(Arrays.asList("CAG", "CAG",
				"CAA", "CAA", "CAA"));
		Collection<String> result = gm.search(dna, k, t);
		System.out.println(Utils.collectionToString(result));
		assertTrue(Utils.collectionsEqual(output, result));
	}

	@Test
	public void testScore() {
		List<String> dna = new ArrayList<>(Arrays.asList(
				"TCGGGGGTTTTT", 
				"CCGGTGACTTAC", 
				"ACGGGGATTTTC",
				"TTGGGGACTTTT",
				"AAGGGGACTTCC",
				"TTGGGGACTTCC",
				"TCGGGGATTCAT",
				"TCGGGGATTCCT",
				"TAGGGGAACTAC",
				"TCGGGTATAACC"));
		int expected = 30;
		GreedyMotif gm = new GreedyMotif();
		int actual = gm.score(dna);
		assertTrue(String.format("Expected: %d, actual: %d", expected, actual),
				expected == actual);
	}

}

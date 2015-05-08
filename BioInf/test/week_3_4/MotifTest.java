package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class MotifTest {
	
	Motif m = new Motif();
	@Test
	public void testSearch(){
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
		Collection<String> result = m.search(dna, k, t, false);
		assertTrue(Utils.collectionsEqual(output, result));
	}
	
	@Test
	public void testSearchWithPseudocounts(){
		int k = 3;
		int t = 5;
		List<String> dna = new ArrayList<>(Arrays.asList(
				"GGCGTTCAGGCA", 
				"AAGAATCAGTCA", 
				"CAAGGAGTTCGC",
				"CACGTCAATCAC",
				"CAATAATATTCG"));
		List<String> output = new ArrayList<>(Arrays.asList("TTC", "ATC",
				"TTC", "ATC", "TTC"));
		Collection<String> result = m.search(dna, k, t, true);
		assertTrue(Utils.collectionsEqual(output, result));
	}
	
	@Test
	public void testRandomSearch(){
		int k = 8;
		int t = 5;
		int n = 2000;
		List<String> dna = new ArrayList<>(Arrays.asList(
				"CGCCCCTCTCGGGGGTGTTCAGTAAACGGCCA", 
				"GGGCGAGGTATGTGTAAGTGCCAAGGTGCCAG", 
				"TAGTACCGAGACCGAAAGAAGTATACAGGCGT",
				"TAGATCAAGTTTCAGGTGCACGTCGGTGAACC",
				"AATCCACCAGCTCCACGTGCAATGTTGGCCTA"));
		List<String> output = new ArrayList<>(Arrays.asList("TCTCGGGG", "CCAAGGTG",
				"TACAGGCG", "TTCAGGTG", "TCCACGTG"));
		Collection<String> result = m.searchRandom(dna, k, t, n);
		System.out.println(Utils.collectionToLines(result));
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
		int actual = m.score(dna);
		assertTrue(String.format("Expected: %d, actual: %d", expected, actual),
				expected == actual);
	}

}

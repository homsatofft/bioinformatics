package week_3_4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import utils.Utils;

public class PeptideEncodingTest
{

	@Test
	public void test()
	{
		String text = "ATGGCCATGGCCCCCAGAACTGAGATCAATAGTACCCGTATTAACGGGTGA";
		String peptide = "MA";
		PeptideEncoding pe = new PeptideEncoding();
		List<String> expected = new ArrayList<>(Arrays.asList("ATGGCC", "GGCCAT", "ATGGCC"));
		Collection<String> res = pe.getEncodingPatterns(text, peptide);
		System.out.println(Utils.collectionToString(res));
		assertTrue(Utils.collectionsEqual(expected, res));
	}

}

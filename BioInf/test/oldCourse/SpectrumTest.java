package oldCourse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oldCourse.Spectrum;

import org.junit.Test;

import utils.Utils;

public class SpectrumTest
{
	Spectrum s = new Spectrum();

	@Test
	public void testGenerateLinear()
	{
		String peptide = "NQEL";
		String expected = "0 113 114 128 129 242 242 257 370 371 484";
		String actual =  Utils.collectionToString(s.generateLinear(peptide));
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testGenerateCyclic()
	{
		String peptide = "LEQN";
		String expected = "0 113 114 128 129 227 242 242 257 355 356 370 371 484";
		String actual =  Utils.collectionToString(s.generateCyclic(peptide));
		assertTrue(expected.equals(actual));
	}
	
	@Test
	public void testConsistency()
	{
		List<Integer> spectrum = new ArrayList<>(Arrays.asList(0, 113, 114, 128, 129, 242, 242, 257, 370, 371, 484));
		List<Integer> consistentSpectrum = new ArrayList<>(Arrays.asList(128, 129, 242, 242, 257));
		List<Integer> inconsistentSpectrum = new ArrayList<>(Arrays.asList(0, 113, 113, 128, 129));
		
		assertTrue(s.isConsistent(consistentSpectrum, spectrum));
		assertFalse(s.isConsistent(inconsistentSpectrum, spectrum));
	}
	
	@Test
	public void testScore()
	{
		String peptide = "NQEL";
		List<Integer> spectrum = new ArrayList<>(Arrays.asList(0, 99, 113, 114, 128, 227, 257, 299, 355, 356, 370, 371, 484));
		assertEquals(11, s.cyclicScore(peptide, spectrum));
		assertEquals(8, s.linearScore(peptide, spectrum));
	}
}

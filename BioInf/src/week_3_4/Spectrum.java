package week_3_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import utils.GeneticCode;

public class Spectrum
{

	GeneticCode geneticCode = new GeneticCode();

	public List<Integer> generateLinear(String peptide)
	{
		List<Integer> spectrum = new ArrayList<>();
		List<Integer> prefixMass = new ArrayList<>();
		spectrum.add(0);
		prefixMass.add(0);
		for (int i = 0; i < peptide.length(); i++)
		{
			char aminoAcid = peptide.charAt(i);
			int mass = prefixMass.get(i)
					+ geneticCode.getAminoAcidMass(aminoAcid);
			prefixMass.add(mass);
		}
		for (int i = 0; i < peptide.length(); i++)
		{
			for (int j = i + 1; j < peptide.length() + 1; j++)
			{
				spectrum.add(prefixMass.get(j) - prefixMass.get(i));
			}
		}
		Collections.sort(spectrum);
		return spectrum;
	}

	public List<Integer> generateCyclic(String peptide)
	{
		List<Integer> spectrum = new ArrayList<>();
		List<Integer> prefixMass = new ArrayList<>();
		if (peptide.length() == 0)
		{
			return spectrum;
		}
		int peptideMass;
		spectrum.add(0);
		prefixMass.add(0);
		for (int i = 0; i < peptide.length(); i++)
		{
			char aminoAcid = peptide.charAt(i);
			int mass = prefixMass.get(i)
					+ geneticCode.getAminoAcidMass(aminoAcid);
			prefixMass.add(mass);
		}
		peptideMass = prefixMass.get(peptide.length());
		for (int i = 0; i < peptide.length(); i++)
		{
			for (int j = i + 1; j < peptide.length() + 1; j++)
			{
				spectrum.add(prefixMass.get(j) - prefixMass.get(i));
				if (i > 0 && j < peptide.length())
				{
					spectrum.add(peptideMass
							- (prefixMass.get(j) - prefixMass.get(i)));
				}
			}
		}
		Collections.sort(spectrum);
		return spectrum;
	}

	public int parentMass(List<Integer> spectrum)
	{
		return spectrum.get(spectrum.size() - 1);
	}

	public String peptideToMassString(String peptide)
	{
		StringBuilder sb = new StringBuilder();
		String delim = "";
		for (Character c : peptide.toCharArray())
		{
			sb.append(delim);
			sb.append(geneticCode.getAminoAcidMass(c));
			delim = "-";
		}
		return sb.toString();
	}

	public boolean isConsistent(List<Integer> testedSpectrum,
			List<Integer> spectrum)
	{
		if (testedSpectrum.size() == 0)
		{
			return false;
		}
		int n = 1;
		for (int i = 0; i < testedSpectrum.size(); i++)
		{
			int element = testedSpectrum.get(i);
			while (i + n < testedSpectrum.size()
					&& element == testedSpectrum.get(i + n))
			{
				n++;
			}
			if (!containsAtLeastN(spectrum, element, n))
			{
				return false;
			}
			n = 1;
		}
		return true;
	}

	private boolean containsAtLeastN(List<Integer> collection, Integer element,
			int n)
	{
		int k = 0;
		for (Integer t : collection)
		{
			if (t.equals(element))
			{
				k++;
			}
			if (t > element)
			{
				break;
			}
		}
		return k >= n;
	}
}

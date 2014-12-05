package week_3_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import utils.GeneticCode;
import utils.Utils;

public class Cyclopeptide
{
	Spectrum s = new Spectrum();
	GeneticCode code = new GeneticCode();
	List<String> peptides = new ArrayList<>();

	public Collection<String> sequence(List<Integer> spectrum)
	{
		int count = 0;
		List<String> result = new ArrayList<String>();
		int parentMass = spectrum.get(spectrum.size() - 1);
		peptides.add(new String());
		while (!peptides.isEmpty())
		{
			peptides = expand(peptides);
			List<String> tmpPeptides = new ArrayList<>(peptides);
			for (String peptide : tmpPeptides)
			{
				int peptideMass = code.getPeptideMass(peptide);
				if (peptideMass > parentMass)
				{
					peptides.remove(peptide);
					continue;
				}
				else if (peptideMass == parentMass)
				{
					System.out.println("Mass hit: " + ++count);
					if (Utils.collectionsEqualTotally(s.generateCyclic(peptide), spectrum))
					{
						System.out.println("valid: " + peptide);
						String ss = s.peptideToMassString(peptide);
						result.add(ss);
					}
					else
					{
						System.out.println("invalid: " + peptide);
					}
					peptides.remove(peptide);
				}
				else if (!s.isConsistent(s.generateLinear(peptide), spectrum))
				{
					peptides.remove(peptide);
				}
			}
		}
		return result;
	}

	private List<String> expand(List<String> set)
	{
		List<String> expanded = new ArrayList<>();
		for (String string : set)
		{
			for (char c : code.aminoAcids)
			{
				expanded.add(string.concat(Character.toString(c)));
			}
		}
		Collections.sort(expanded);
		return expanded;
	}
}

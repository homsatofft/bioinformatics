package week_3_4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import utils.GeneticCode;
import utils.Utils;

public class Cyclopeptide
{
	Spectrum s = new Spectrum();
	GeneticCode code = new GeneticCode();
	List<String> peptides = new ArrayList<>();

	public Collection<String> sequence(List<Integer> spectrum)
	{
		Set<String> result = new HashSet<String>();
		int parentMass = spectrum.get(spectrum.size() - 1);
		peptides.add(new String());
		while (!peptides.isEmpty())
		{
			peptides = expandList(peptides);
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
					if (Utils.collectionsEqual(s.generateCyclic(peptide),
							spectrum))
					{
						String ss = s.peptideToMassString(peptide);
						result.add(ss);
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

	public String leaderboardSequence(List<Integer> spectrum,
			int threshold)
	{
		Set<String> leaderboard = new HashSet<String>();
		Set<String> leadingPeptides = new HashSet<>();
		leaderboard.add(new String());
		String leaderPeptide = new String();
		int parentMass = spectrum.get(spectrum.size() - 1);
		while (!leaderboard.isEmpty())
		{
			leaderboard = expandSet(leaderboard);
			Set<String> tmpPeptides = new HashSet<>(leaderboard);
			for (String peptide : tmpPeptides)
			{
				int peptideMass = code.getPeptideMass(peptide);
				if (peptideMass > parentMass)
				{
					leaderboard.remove(peptide);
					continue;
				}
				else if (peptideMass == parentMass)
				{
					int score = s.cyclicScore(peptide, spectrum);
					if(score==83){
						System.out.println(peptide);
						leadingPeptides.add(peptide);
					}
					if (score > s.cyclicScore(
							leaderPeptide, spectrum))
					{
						leaderPeptide = peptide;
					}
				}
			}
			leaderboard = trim(leaderboard, spectrum, threshold);
		}
		System.out.println(leadingPeptides.size());
		/*try
		{
			Utils.writeToFile(Utils.collectionToString(leadingPeptides));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return leaderPeptide;
	}

	private Set<String> trim(Set<String> leaderboard, List<Integer> spectrum,
			int threshold)
	{
		class ScoredPeptide
		{

			int _score;
			String _peptide;

			public ScoredPeptide(String peptide, int score)
			{
				_score = score;
				_peptide = peptide;
			}
		}

		class ScoredPeptideComparator implements Comparator<ScoredPeptide>
		{
			@Override
			public int compare(ScoredPeptide sp1, ScoredPeptide sp2)
			{
				return sp2._score - sp1._score;
			}
		}

		PriorityQueue<ScoredPeptide> q = new PriorityQueue<ScoredPeptide>(
				new ScoredPeptideComparator());
		for (String peptide : leaderboard)
		{
			q.add(new ScoredPeptide(peptide, s.linearScore(peptide, spectrum)));
		}
		Set<String> result = new HashSet<>();
		while (result.size() < threshold)
		{
			ScoredPeptide sp = q.poll();
			if (sp == null)
			{
				break;
			}
			result.add(sp._peptide);
		}
		return result;
	}

	private List<String> expandList(List<String> coll)
	{
		List<String> expanded = new ArrayList<>();
		for (String string : coll)
		{
			for (char c : code.aminoAcids)
			{
				expanded.add(string.concat(Character.toString(c)));
			}
		}
		Collections.sort(expanded);
		return expanded;
	}
	
	private Set<String> expandSet(Set<String> set)
	{
		Set<String> expanded = new HashSet<>();
		for (String string : set)
		{
			for (char c : code.aminoAcids)
			{
				expanded.add(string.concat(Character.toString(c)));
			}
		}
		return expanded;
	}
}

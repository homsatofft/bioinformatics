package week_3_4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.ParameterParser;
import utils.Utils;

public class Motif
{

	public Collection<String> searchRandom(List<String> dnaStrings, int k,
			int t, int n)
	{
		boolean usePseudocounts = true;
		List<String> result = new ArrayList<>();
		List<String> bestMotifs = new ArrayList<>();
		List<String> motifs = new ArrayList<>();
		Random r = new Random();
		for (String dna : dnaStrings)
		{
			result.add(dna.substring(0, k));

		}
		for (int i = 0; i < n; i++)
		{
			for (String dna : dnaStrings)
			{
				int ranomNum = r.nextInt(dna.length() - k + 1);
				motifs.add(dna.substring(ranomNum, ranomNum + k));
			}
			bestMotifs.addAll(motifs);
			while (true)
			{
				Profile p = new Profile(motifs, usePseudocounts);
				motifs = p.motifs(dnaStrings);
				if (score(motifs) < score(bestMotifs))
				{
					bestMotifs.clear();
					bestMotifs.addAll(motifs);
				}
				else
				{
					if (score(bestMotifs) < score(result))
					{
						result.clear();
						result.addAll(bestMotifs);
					}
					break;
				}
			}
		}
		return result;
	}

	public Collection<String> search(List<String> dna, int k, int t,
			boolean usePseudocounts)
	{
		List<String> bestMotifs = new ArrayList<>();
		for (String dnaString : dna)
		{
			String motif = dnaString.substring(0, k);
			bestMotifs.add(motif);
		}
		String line = dna.get(0);
		for (int i = 0; i <= line.length() - k; i++)
		{
			List<String> _profileMotifs = new ArrayList<>();
			String _motif = line.substring(i, i + k);
			_profileMotifs.add(_motif);
			for (int j = 1; j < t; j++)
			{
				Profile p = new Profile(_profileMotifs, usePseudocounts);
				String __motif = p.findPattern(dna.get(j));
				_profileMotifs.add(__motif);
			}
			if (score(_profileMotifs) < score(bestMotifs))
			{
				bestMotifs = _profileMotifs;
			}
		}
		return bestMotifs;
	}

	int score(List<String> motif)
	{
		int score = 0;
		for (int j = 0; j < motif.get(0).length(); j++)
		{
			List<Character> chars = new ArrayList<>();
			for (int i = 0; i < motif.size(); i++)
			{
				chars.add(motif.get(i).charAt(j));
			}
			Collections.sort(chars);
			char _c = 'A';
			int max = 0;
			int _score = 0;
			for (char c : chars)
			{
				if (c != _c)
				{
					_score = Math.max(max, _score);
					max = 1;
					_c = c;
				}
				else
				{
					max++;
				}
			}
			_score = Math.max(max, _score);
			score += motif.size() - _score;
		}
		return score;
	}

	public static void main(String[] args)
	{
		ParameterParser pp = new ParameterParser();
		try
		{
			pp.parseDataFile(args);
		}
		catch (IOException e)
		{
			System.out.println(e);
			return;
		}
		int k = pp.namedInteger("k");
		int t = pp.namedInteger("t");
		List<String> dnaStrings = new ArrayList<>(pp.inputStrings());
		//Collection<String> output = pp.outputStrings();
		Motif m = new Motif();
		Collection<String> result = m.searchRandom(dnaStrings, k, t, 2000);
		//System.out.println(Utils.collectionsEqual(output, result));
		System.out.println(Utils.collectionToLines(result));
	}
}

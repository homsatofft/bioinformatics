package week_1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class Neighbors
{
	private static Collection<String> nucleotides()
	{
		return Arrays.asList("A", "C", "G", "T");
	}

	public static Collection<String> generate(String pattern, int d)
	{
		Collection<String> neighborhood = new HashSet<>();
		if (d == 0)
		{
			neighborhood.add(pattern);
			return neighborhood;
		}
		if (pattern.length() == 1)
		{
			neighborhood.addAll(nucleotides());
			return neighborhood;
		}
		String firstSymbol = pattern.substring(0, 1);
		String suffixPattern = pattern.substring(1);
		Collection<String> suffixNeighbors = Neighbors.generate(suffixPattern,
				d);
		for (String text : suffixNeighbors)
		{
			if (Hamming.distance(suffixPattern, text) < d)
			{
				for (String nucleotide : nucleotides())
				{
					neighborhood.add(nucleotide + text);
				}
			}
			else
			{
				neighborhood.add(firstSymbol + text);
			}
		}
		return neighborhood;
	}

	public static Collection<String> generateIterative(String pattern, int d)
	{
		Collection<String> neighborhood = new HashSet<>();
		neighborhood.add(pattern);
		for (int i = 0; i < d; i++)
		{
			Collection<String> tmpNeighborhood = new ArrayList<String>(neighborhood);
			for (String string : tmpNeighborhood)
			{
				neighborhood.addAll(generateImmediate(string));
			}
		}
		return neighborhood;
	}

	public static Collection<String> generateImmediate(String pattern)
	{
		Collection<String> neighborhood = new HashSet<>();
		neighborhood.add(pattern);
		for (int i = 0; i < pattern.length(); i++)
		{
			String c = pattern.substring(i, i + 1);
			for (String nucleotide : nucleotides())
			{
				if (!c.equalsIgnoreCase(nucleotide))
				{
					StringBuilder sb = new StringBuilder(pattern);
					neighborhood.add(sb.replace(i, i + 1, nucleotide)
							.toString());
				}
			}
		}
		return neighborhood;
	}
}

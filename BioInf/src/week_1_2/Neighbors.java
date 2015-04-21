package week_1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import utils.Utils;

public class Neighbors
{
	private Collection<String> nucleotides()
	{
		return Arrays.asList("A", "C", "G", "T");
	}

	public Collection<String> generate(String pattern, int d)
	{
		Hamming h = new Hamming();
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
		Collection<String> suffixNeighbors = generate(suffixPattern,
				d);
		for (String text : suffixNeighbors)
		{
			if (h.distance(suffixPattern, text) < d)
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

	public Collection<String> generateIterative(String pattern, int d)
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

	public Collection<String> generateImmediate(String pattern)
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
	
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			return;
		}
		String pattern = args[0];
		int d = 0;
		try
		{
			d = Integer.parseInt(args[1]);
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
			return;
		}
		Neighbors n = new Neighbors();
		Collection<String> nucleotides = n.generate(pattern, d);
		System.out.println(nucleotides.size());
		System.out.println(Utils.collectionToString(nucleotides));
	}
}

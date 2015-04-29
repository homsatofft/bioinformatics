package week_3_4;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import utils.ParameterParser;
import utils.Utils;
import week_1_2.Neighbors;
import week_1_2.PatternCount;

public class MotifEnumeration
{
	Neighbors n = new Neighbors();
	PatternCount pc = new PatternCount();

	public Collection<String> enumerate(Collection<String> dna, int k, int d)
	{
		Set<String> res = new HashSet<String>();
		for (String dnaString : dna)
		{
			int tLen = dnaString.length();
			for (int i = 0; i <= tLen - k; i++)
			{
				String current = dnaString.substring(i, i + k);
				Collection<String> neighbors = n.generate(current, d);
				for (String pattern : neighbors)
				{
					boolean isPresent = true;
					for (String anotherDnaString : dna)
					{
						if (pc.countN(anotherDnaString, pattern, d) == 0)
						{
							isPresent = false;
							break;
						}
					}
					if (isPresent)
					{
						res.add(pattern);
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args)
	{
		ParameterParser pp = new ParameterParser();
		String[] paramsArray = {"-input", "-integers", "-inline", "k", "d", "-strings", "dnaStrings", "-end"};
		String source = "data/dataset_156_7.txt";
		try
		{
			pp.parseDataFile(source, paramsArray);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		int k = pp.namedInteger("k");
		int d = pp.namedInteger("d");
		Collection<String> dna = pp.inputStrings();
		MotifEnumeration me = new MotifEnumeration();
		System.out.println(Utils.collectionToString(me.enumerate(dna, k, d)));
	}
}

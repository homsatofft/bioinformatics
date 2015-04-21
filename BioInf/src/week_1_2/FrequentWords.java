package week_1_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequentWords
{
	PatternCount pc = new PatternCount();
	Converter c = new Converter();
	Neighbors n = new Neighbors();
	ComplementReverseStrand crs = new ComplementReverseStrand();

	private int max(int[] arr)
	{
		int maxCount = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (maxCount < arr[i])
			{
				maxCount = arr[i];
			}
		}
		return maxCount;
	}

	public Collection<String> count(String text, int k)
	{
		Set<String> result = new HashSet<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		int maxCount;
		for (int i = 0; i < text.length() - k; i++)
		{
			String pattern = text.substring(i, i + k);
			count.add(pc.count(text, pattern));
		}
		maxCount = Collections.max(count);
		for (int i = 0; i < text.length() - k; i++)
		{
			if (count.get(i) == maxCount)
			{
				result.add(text.substring(i, i + k));
			}
		}
		return result;
	}

	public Collection<String> countSorting(String text, int k)
	{
		Collection<String> frequentPatterns = new HashSet<>();
		int l = text.length() - k;
		long[] index = new long[l];
		int[] count = new int[l];
		int maxCount = 0;

		for (int i = 0; i < l; i++)
		{
			String pattern = text.substring(i, i + k);
			index[i] = (c.patternToNumber(pattern));
			count[i] = 1;
		}
		Arrays.sort(index);
		for (int i = 1; i < l; i++)
		{
			if (index[i] == index[i - 1])
			{
				count[i] = count[i - 1] + 1;
			}
			if (maxCount < count[i])
			{
				maxCount = count[i];
			}
		}

		for (int i = 1; i < l; i++)
		{
			if (count[i] == maxCount)
			{
				frequentPatterns.add(c.numberToPattern(index[i], k));
			}
		}
		return frequentPatterns;
	}

	public Collection<String> countMismatch(String text, int k, int d)
	{
		Collection<String> frequentPatterns = new HashSet<>();
		int size = (int) Math.pow(4, k);
		boolean[] close = new boolean[size];
		int[] freqArray = new int[size];
		for (int i = 0; i < text.length() - k; i++)
		{
			Collection<String> neighborhood = n.generate(
					text.substring(i, i + k), d);
			for (String string : neighborhood)
			{
				close[(int) c.patternToNumber(string)] = true;
			}
		}
		for (int i = 0; i < size; i++)
		{
			if (close[i])
			{
				String pattern = c.numberToPattern((long) i, k);
				freqArray[i] = pc.countN(text, pattern, d);
			}
		}
		int maxCount = max(freqArray);

		for (int i = 0; i < size; i++)
		{
			if (freqArray[i] == maxCount)
			{
				String pattern = c.numberToPattern((long) i, k);
				frequentPatterns.add(pattern);
			}
		}
		return frequentPatterns;
	}

	public Collection<String> countMismatchSorting(String text, int k, int d)
	{

		Set<String> frequentPatterns = new HashSet<>();
		List<String> neighborhoods = new ArrayList<>();

		for (int i = 0; i < text.length() - k; i++)
		{
			neighborhoods.addAll(n.generate(text.substring(i, i + k), d));
		}

		Object[] neighborhoodArray;
		int l = neighborhoods.size();
		long[] index = new long[l];
		int[] count = new int[l];
		int maxCount = 0;

		neighborhoodArray = neighborhoods.toArray();

		for (int i = 0; i < l; i++)
		{
			String pattern = (String) neighborhoodArray[i];
			index[i] = c.patternToNumber(pattern);
			count[i] = 1;
		}

		Arrays.sort(index);

		for (int i = 1; i < l; i++)
		{
			if (index[i] == index[i - 1])
			{
				count[i] = count[i - 1] + 1;
			}
			if (maxCount < count[i])
			{
				maxCount = count[i];
			}
		}

		for (int i = 0; i < l; i++)
		{
			if (count[i] == maxCount)
			{
				frequentPatterns.add(c.numberToPattern(index[i], k));
			}
		}
		return frequentPatterns;
	}

	public Collection<String> countMismatchReverseSorting(String text, int k,
			int d)
	{
		System.out.println("Started serch for most frequent " + k
				+ "-mers with " + d + " mismatch and reverse complements");
		Set<String> frequentPatterns = new HashSet<>();
		List<String> neighborhoods = new ArrayList<>();

		for (int i = 0; i < text.length() - k; i++)
		{
			neighborhoods.addAll(n.generate(text.substring(i, i + k), d));
			neighborhoods.addAll(n.generate(
					crs.compute(text.substring(i, i + k)), d));
		}

		Object[] neighborhoodArray;
		int l = neighborhoods.size();
		long[] index = new long[l];
		int[] count = new int[l];
		int maxCount = 0;

		neighborhoodArray = neighborhoods.toArray();

		for (int i = 0; i < l; i++)
		{
			String pattern = (String) neighborhoodArray[i];
			index[i] = c.patternToNumber(pattern);
			count[i] = 1;
		}

		Arrays.sort(index);

		for (int i = 1; i < l; i++)
		{
			if (index[i] == index[i - 1])
			{
				count[i] = count[i - 1] + 1;
			}
			if (count[i] > maxCount)
			{
				maxCount = count[i];
			}
		}

		for (int i = 0; i < l; i++)
		{
			if (count[i] == maxCount)
			{
				frequentPatterns.add(c.numberToPattern(index[i], k));
			}
		}
		System.out.println("Search finished!");
		return frequentPatterns;
	}
	
	public static void main(String[] args)
	{
		if (args.length != 3)
		{
			return;
		}
		String text = args[0];
		int k = 0;
		int d = 0;
		try
		{
			k = Integer.parseInt(args[1]);
			d = Integer.parseInt(args[2]);
		}
		catch (NumberFormatException e)
		{
			System.out.println(e);
			return;
		}
		FrequentWords fw = new FrequentWords();
		System.out.println(fw.countMismatch(text, k, d));
	}

}

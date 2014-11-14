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

	private static int max(int[] arr)
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

	public static Collection<String> count(String text, int k)
	{
		Set<String> result = new HashSet<String>();
		ArrayList<Integer> count = new ArrayList<Integer>();
		int maxCount;
		for (int i = 0; i < text.length() - k; i++)
		{
			String pattern = text.substring(i, i + k);
			count.add(PatternCount.count(text, pattern));
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

	public static Collection<String> countSorting(String text, int k)
	{
		Collection<String> frequentPatterns = new HashSet<>();
		int l = text.length() - k;
		long[] index = new long[l];
		int[] count = new int[l];

		for (int i = 0; i < l; i++)
		{
			String pattern = text.substring(i, i + k);
			index[i] = (Converter.patternToNumber(pattern));
			count[i] = 1;
		}
		Arrays.sort(index);
		for (int i = 1; i < l; i++)
		{
			if (index[i] == index[i - 1])
			{
				count[i] = count[i - 1] + 1;
			}
		}

		int maxCount = max(count);

		for (int i = 1; i < l; i++)
		{
			if (count[i] == maxCount)
			{
				frequentPatterns.add(Converter.numberToPattern(index[i], k));
			}
		}
		return frequentPatterns;
	}

	public static Collection<String> countMismatch(String text, int k, int d)
	{
		Collection<String> frequentPatterns = new HashSet<>();
		int size = (int) Math.pow(4, k);
		boolean[] close = new boolean[size];
		int[] freqArray = new int[size];
		for (int i = 0; i < text.length() - k; i++)
		{
			Collection<String> neighborhood = Neighbors.generate(
					text.substring(i, i + k), d);
			for (String string : neighborhood)
			{
				close[(int) Converter.patternToNumber(string)] = true;
			}
		}
		for (int i = 0; i < size; i++)
		{
			if (close[i])
			{
				String pattern = Converter.numberToPattern((long) i, k);
				freqArray[i] = PatternCount.countN(text, pattern, d);
			}
		}
		int maxCount = max(freqArray);
		for (int i = 0; i < size; i++)
		{
			if (freqArray[i] == maxCount)
			{
				String pattern = Converter.numberToPattern((long) i, d);
				frequentPatterns.add(pattern);
			}
		}
		return frequentPatterns;
	}

	public static Collection<String> countMismatchSorting(String text, int k,
			int d)
	{

		Set<String> frequentPatterns = new HashSet<>();
		List<String> neighborhoods = new ArrayList<>();
		Object[] neighborhoodArray;

		for (int i = 0; i < text.length() - k; i++)
		{
			neighborhoods
					.addAll(Neighbors.generateIterative(text.substring(i, i + k), d));
		}

		int l = neighborhoods.size();
		long[] index = new long[l];
		int[] count = new int[l];

		neighborhoodArray = neighborhoods.toArray();

		for (int i = 0; i < l - 1; i++)
		{
			String pattern = (String) neighborhoodArray[i];
			index[i] = Converter.patternToNumber(pattern);
			count[i] = 1;
		}

		Arrays.sort(index);

		for (int i = 0; i < l - 1; i++)
		{
			if (index[i] == index[i + 1])
			{
				count[i + 1] = count[i] + 1;
			}
		}

		int maxCount = max(count);

		for (int i = 1; i < l - 1; i++)
		{
			if (count[i] == maxCount)
			{
				frequentPatterns.add(Converter.numberToPattern(index[i], k));
			}
		}
		return frequentPatterns;
	}
}

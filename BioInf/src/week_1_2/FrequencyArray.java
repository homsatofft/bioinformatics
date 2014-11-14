package week_1_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrequencyArray
{
	public static List<Integer> computeFrequency(String text, int k)
	{
		List<Integer> l = new ArrayList<>();
		int[] arr = computeFrequencyToArray(text, k);
		for (int i = 0; i < arr.length; i++)
		{
			l.add(arr[i]);
		}
		return l;
	}

	public static int[] computeFrequencyToArray(String text, int k)
	{
		int[] arr = new int[(int) Math.pow(4, k)];
		for (int i = 0; i <= text.length() - k; i++)
		{
			long index = Converter.patternToNumber(text.substring(i, i + k));
			arr[(int) index]++;
		}
		return arr;
	}

	public static Set<Long> computeFrequencyFaster(String text, int k,
			int threshold)
	{
		Set<Long> set = new HashSet<>();
		long[] arr = new long[(int) Math.pow(4, k)];
		for (int i = 0; i <= text.length() - k; i++)
		{
			long index = Converter.patternToNumber(text.substring(i, i + k));
			arr[(int) index]++;
			if (arr[(int) index] == threshold)
			{
				set.add(index);
			}
		}
		return set;
	}
}

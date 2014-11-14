package week_1_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClumpFinding
{
	public static Collection<String> compute(String text, int k, int L, int t)
	{
		Set<Long> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		int length = text.length() >= 1000 ? text.length() / 100 * 100 : text.length();
		int divider = length / 10;
		long t1 = System.currentTimeMillis();
		long time = 0;
		for (int i = 0; i < text.length() - L; i++)
		{
			String subString = text.substring(i, i + L);
			set = FrequencyArray.computeFrequencyFaster(subString, k, t);
			for (Long j : set)
			{
				result.add(Converter.numberToPattern(j, k));
			}
			if (i % divider == 0)
			{
				long t2 = System.currentTimeMillis();
				time +=  (t2 - t1) / 1000;
				System.out.println("Passed: " + time);
				t1 = t2;
				System.out.println(i / divider * 10);
			}
		}
		return result;
	}
	
	public static Collection<String> computeFast(String genome, int k, int L, int t)
	{
		Set<String> frequentPatterns = new HashSet<>();
		String firstPattern, lastPattern;
		long j;
		boolean[] clump = new boolean[(int) Math.pow(4, k)];
		String text = genome.substring(0, L);
		int[] frequencyArray = FrequencyArray.computeFrequencyToArray(text, k);
		for (int i = 0; i < (int) Math.pow(4, k); i++)
		{
			if (frequencyArray[i] >= t)
			{
				clump[i] = true;
			}
		}
		for (int i = 1; i < genome.length() - L; i++)
		{
			firstPattern = genome.substring(i - 1, i - 1 + k);
			j = Converter.patternToNumber(firstPattern);
			frequencyArray[(int) j] -= 1;
			lastPattern = genome.substring(i + L - k, i + L);
			j = Converter.patternToNumber(lastPattern);
			frequencyArray[(int) j] += 1;
			if (frequencyArray[(int) j] >= t)
			{
				clump[(int) j] = true;
			}
		}
		for (long i = 0; i < (int) Math.pow(4, k); i++)
		{
			if (clump[(int) i])
			{
				frequentPatterns.add(Converter.numberToPattern(i, k));
			}
		}
		return frequentPatterns;
	}
}

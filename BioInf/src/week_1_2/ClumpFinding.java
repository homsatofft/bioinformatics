package week_1_2;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClumpFinding
{
	FrequencyArray fa = new FrequencyArray();

	public Collection<String> compute(String text, int k, int L, int t)
	{
		Converter c = new Converter();
		Set<Integer> set = new HashSet<>();
		Set<String> result = new HashSet<>();
		for (int i = 0; i < text.length() - L; i++)
		{
			String subString = text.substring(i, i + L);
			set = fa.computeFrequencyFaster(subString, k, t);
			for (Integer j : set)
			{
				result.add(c.numberToPattern((long) j, k));
			}
		}
		return result;
	}

	public Collection<String> computeFast(String genome, int k, int L, int t)
	{
		Converter c = new Converter();
		Set<String> frequentPatterns = new HashSet<>();
		String firstPattern, lastPattern;
		long j;
		boolean[] clump = new boolean[(int) Math.pow(4, k)];
		String text = genome.substring(0, L);
		int[] frequencyArray = fa.computeFrequencyToArray(text, k);
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
			j = c.patternToNumber(firstPattern);
			frequencyArray[(int) j] -= 1;
			lastPattern = genome.substring(i + L - k, i + L);
			j = c.patternToNumber(lastPattern);
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
				frequentPatterns.add(c.numberToPattern(i, k));
			}
		}
		return frequentPatterns;
	}
}

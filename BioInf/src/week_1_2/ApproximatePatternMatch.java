package week_1_2;

import java.util.ArrayList;
import java.util.Collection;

public class ApproximatePatternMatch
{
	public static Collection<Integer> compute(String pattern, String inputText,
			int mismatches)
	{
		Collection<Integer> list = new ArrayList<>();
		for (int i = 0; i <= inputText.length() - pattern.length(); i++)
		{
			String candidatePattern = inputText.substring(i,
					i + pattern.length());
			if (Hamming.distance(pattern, candidatePattern) <= mismatches)
			{
				list.add(i);
			}
		}
		return list;
	}
}

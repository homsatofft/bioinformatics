package week_1_2;

import java.util.ArrayList;
import java.util.List;

public class PatternMatching
{
	public static List<Integer> compute(String pattern, String text)
	{
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < text.length() - pattern.length(); i++)
		{
			if (pattern.equals(text.substring(i, i + pattern.length())))
			{
				res.add(i);
				// uncomment below to skip pattern-in-pattern
				// i += pattern.length();
			}
		}
		return res;
	}
}

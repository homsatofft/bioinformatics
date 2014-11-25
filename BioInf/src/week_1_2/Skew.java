package week_1_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Skew
{
	public static Collection<Integer> compute(String inputText)
	{
		System.out.println("Building skew...");
		List<Integer> result = new ArrayList<>();
		int counter = 0;
		result.add(counter);
		for (char c : inputText.toCharArray())
		{
			if (Character.toLowerCase(c) == 'c')
			{
				counter--;
			}
			if (Character.toLowerCase(c) == 'g')
			{
				counter++;
			}
			result.add(counter);
		}
		System.out.println("Building skew finished!");
		return result;
	}

	public static Collection<Integer> computeMins(String inputText)
	{
		System.out.println("Finding skew minimums...");
		List<Integer> result = new ArrayList<>();
		List<Integer> list = (List<Integer>) compute(inputText);
		int min = Collections.min(list);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == min)
			{
				result.add(i);
			}
		}
		System.out.println("Finding skew minimums finished!");
		return result;
	}
}

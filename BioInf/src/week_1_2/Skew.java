package week_1_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Skew
{
	public static Collection<Integer> compute(String inputText)
	{
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
		return result;
	}

	public static Collection<Integer> computeMins(String inputText)
	{
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
		return result;
	}
}

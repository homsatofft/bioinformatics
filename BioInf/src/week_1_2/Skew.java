package week_1_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Skew
{
	public Collection<Integer> compute(String inputText)
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

	public Collection<Integer> computeMins(String inputText)
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

	public Collection<Integer> computeMaxs(String inputText)
	{
		List<Integer> result = new ArrayList<>();
		List<Integer> list = (List<Integer>) compute(inputText);
		int max = Collections.max(list);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i) == max)
			{
				result.add(i);
			}
		}
		return result;
	}

	public int findMaximumPosition(String inputText)
	{
		int res = -1;
		List<Integer> list = (List<Integer>) computeMaxs(inputText);
		if (!list.isEmpty())
		{
			res = list.get(0);
		}
		return res;
	}

	public int findMinimumPosition(String inputText)
	{
		int res = -1;
		List<Integer> list = (List<Integer>) computeMins(inputText);
		if (!list.isEmpty())
		{
			res = list.get(0);
		}
		return res;
	}

	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			return;
		}
		String inputText = args[0];
		String action = args[1];
		int res = -1;
		Skew s = new Skew();
		switch (action)
		{
		case "min":
			res = s.findMinimumPosition(inputText);
			break;
		case "max":
			res = s.findMaximumPosition(inputText);
			break;
		default:
			break;
		}
		System.out.println(res);
	}
}

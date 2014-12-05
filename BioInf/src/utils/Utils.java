package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils
{
	public static <T> boolean collectionsEqual(Collection<T> collOne,
			Collection<T> collTwo)
	{
		if (collOne.size() != collTwo.size())
		{
			return false;
		}
		return collTwo.containsAll(collOne);
	}

	public static <T> boolean collectionsEqualTotally(Collection<T> collOne,
			Collection<T> collTwo)
	{
		List<T> listOne = new ArrayList<>(collOne);
		List<T> listTwo = new ArrayList<>(collTwo);
		String sizeDiffers = "Size differs: %d and %d";
		String elementDiffer = "Different elements at %d: %s and %s";
		if (listOne.size() != listTwo.size())
		{
			return false;
			// String.format(sizeDiffers, listOne.size(), listTwo.size());
		}
		for (int i = 0; i < listOne.size(); i++)
		{
			if (!listOne.get(i).equals(listTwo.get(i)))
			{
				return false;// String.format(elementDiffer, i, listOne.get(i),
				// listTwo.get(i));
			}
		}
		return true;// "Collections totally equal!";
	}

	public static <T> String collectionToString(Collection<T> arr)
	{
		StringBuilder sb = new StringBuilder();
		for (T item : arr)
		{
			sb.append(item);
			sb.append(' ');
		}
		return sb.toString().trim();
	}

	public static <T> String collectionToLines(Collection<T> arr)
	{
		StringBuilder sb = new StringBuilder();
		for (T item : arr)
		{
			sb.append(item);
			sb.append('\n');
		}
		return sb.toString().trim();
	}

	public static Collection<Integer> stringToCollectionOfInt(String string)
	{
		Collection<Integer> res = new ArrayList<Integer>();
		String[] numbers = string.split(" ");
		for (String number : numbers)
		{
			res.add(Integer.parseInt(number));
		}
		return res;
	}

	public static void writeToFile(String string) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("data/result.txt"));
		bw.write(string);
		bw.close();
	}
}

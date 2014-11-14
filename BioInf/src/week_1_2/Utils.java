package week_1_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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

	public static <T> void writeToFile(Collection<T> collection)
			throws IOException
	{
		BufferedWriter bw = new BufferedWriter(
				new FileWriter("data/result.txt"));
		bw.write(Utils.collectionToString(collection));
		bw.close();
	}
}

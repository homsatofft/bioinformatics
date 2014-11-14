package week_1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RunTest
{
	public static void main(String[] args) throws IOException
	{
		String test = "data/frequent_words_mismatch_data_1.txt";
		BufferedReader br = new BufferedReader(new FileReader(test));
		//String pattern;
		String text;
		String output;
		String[] params;
		//String line;
		int k;
		int d;
		br.readLine();
		text = br.readLine();
		params = br.readLine().trim().split(" ");
		k = Integer.parseInt(params[0]);
		d = Integer.parseInt(params[1]);
		br.readLine();
		/*Collection<String> output = new ArrayList<String>();
		while ((line = br.readLine()) != null)
		{
			output.add(line);
		}*/
		output = br.readLine();
		br.close();

		// int result = PatternCount.countN(inputText, pattern, mismatches);

		Collection<String> res = FrequentWords.countMismatchSorting(text, k, d);
		System.out.println(output.equals(res));
		// inputText, mismatches);
		Utils.writeToFile(res);
	}
}

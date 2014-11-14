package week_1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class RunTask
{
	public static void main(String[] args) throws IOException
	{
		String task = "data/dataset_3014_3.txt";
		BufferedReader br = new BufferedReader(new FileReader(task));
		String pattern;
		// String inputText;
		// int output;
		int mismatches;
		//br.readLine();
		// inputText = br.readLine();
		pattern = br.readLine();
		mismatches = Integer.parseInt(br.readLine().trim());
		/*br.readLine();
		Collection<String> output = new ArrayList<String>();
		String line;
		while ((line = br.readLine()) != null)
		{
			output.add(line);
		}*/
		// output = Integer.parseInt(br.readLine());
		br.close();

		// int result = PatternCount.countN(inputText, pattern, mismatches);

		Collection<String> res = Neighbors.generate(pattern, mismatches);
		//System.out.println(Utils.collectionsEqual(output, res));
		// inputText, mismatches);
		Utils.writeToFile(res);
	}
}

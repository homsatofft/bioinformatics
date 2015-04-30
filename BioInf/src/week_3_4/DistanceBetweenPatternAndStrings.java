package week_3_4;

import java.io.IOException;
import java.util.Collection;

import utils.ParameterParser;
import week_1_2.Hamming;

public class DistanceBetweenPatternAndStrings {

	public int compute(String pattern, Collection<String> dnaStrings) {

		Hamming h = new Hamming();
		int distance = 0;
		int k = pattern.length();
		for (String line : dnaStrings) {
			int hammingDistance = Integer.MAX_VALUE;
			for (int i = 0; i <= line.length() - k; i++) {
				String _pattern = line.substring(i, i + k);
				hammingDistance = Math.min(hammingDistance,
						h.distance(pattern, _pattern));
			}
			distance += hammingDistance;
		}
		return distance;
	}
	
	public static void main(String[] args) {
		
		ParameterParser pp = new ParameterParser();
		try {
			pp.parseDataFile(args);
		} catch (IOException e) {
			System.out.println(e);
			return;
		}
		String pattern = pp.namedString("pattern");
		Collection<String> dnaStrings = pp.inputStrings();
		DistanceBetweenPatternAndStrings dbps = new DistanceBetweenPatternAndStrings();
		System.out.println(dbps.compute(pattern, dnaStrings));
	}
}

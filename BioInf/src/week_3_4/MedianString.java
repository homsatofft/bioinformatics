package week_3_4;

import java.io.IOException;
import java.util.Collection;

import utils.ParameterParser;
import week_1_2.Converter;

public class MedianString {

	public String findMedian(Collection<String> dnaStrings, int k) {

		String median = new String();
		Converter c = new Converter();
		DistanceBetweenPatternAndStrings dbps = new DistanceBetweenPatternAndStrings();
		int distance = Integer.MAX_VALUE;
		int maxValue = (int) (Math.pow(4, k) - 1);
		for (int i = 0; i < maxValue; i++) {
			String pattern = c.numberToPattern((long) i, k);
			int _distance = dbps.compute(pattern, dnaStrings);
			if (distance > _distance) {
				distance = _distance;
				median = pattern;
			}
		}
		return median;
	}

	public static void main(String[] args) {

		ParameterParser pp = new ParameterParser();
		try {
			pp.parseDataFile(args);
		} catch (IOException e) {
			System.out.println(e);
			return;
		}
		int k = pp.namedInteger("k");
		Collection<String> dnaStrings = pp.inputStrings();
		MedianString ms = new MedianString();
		System.out.println(ms.findMedian(dnaStrings, k));
	}
}

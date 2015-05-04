package week_3_4;

import java.io.IOException;
import java.util.List;

import utils.ParameterParser;

public class Profile {
	double[][] _profile;
	private int _k;

	public Profile(int k) {
		_k = k;
		_profile = new double[4][_k];

	}

	public Profile(double[][] profile) {
		_profile = profile;
		_k = _profile[0].length;
	}

	public Profile(List<String> dna) {
		profileFromStrings(dna);
	}

	public void setRow(double[] row, int index) {
		if (row.length != _k || index > 3) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < row.length; i++) {
			_profile[index][i] = row[i];
		}
	}

	private double probability(String pattern) {
		double _prob = 1.0;
		for (int j = 0; j < pattern.length(); j++) {
			char c = pattern.charAt(j);
			switch (c) {
			case 'A':
				_prob *= _profile[0][j];
				break;
			case 'C':
				_prob *= _profile[1][j];
				break;
			case 'G':
				_prob *= _profile[2][j];
				break;
			case 'T':
				_prob *= _profile[3][j];
				break;
			default:
				_prob = 0.0;
				break;
			}
		}
		return _prob;
	}

	private void profileFromStrings(List<String> dna) {
		int k = dna.size();
		int l = dna.get(0).length();
		_k = l;
		_profile = new double[4][l];
		for (int i = 0; i < l; i++) {
			double counterA = 0, counterC = 0, counterG = 0, counterT = 0;
			for (int j = 0; j < k; j++) {
				char c = dna.get(j).charAt(i);
				switch (c) {
				case 'A':
				case 'a':
					counterA++;
					break;
				case 'C':
				case 'c':
					counterC++;
					break;
				case 'G':
				case 'g':
					counterG++;
					break;
				case 'T':
				case 't':
					counterT++;
					break;
				}
			}
			_profile[0][i] = counterA / k;
			_profile[1][i] = counterC / k;
			_profile[2][i] = counterG / k;
			_profile[3][i] = counterT / k;
		}
	}

	public String findPattern(String dna) {
		String res = new String();
		double prob = 0.0;
		for (int i = 0; i <= dna.length() - _k; i++) {
			String pattern = dna.substring(i, i + _k).toUpperCase();
			double _prob = probability(pattern);
			if (_prob > prob) {
				prob = _prob;
				res = pattern;
			}
		}
		return res;
	}

	public void print() {
		for (int i = 0; i < _profile.length; i++) {
			for (int j = 0; j < _profile[i].length; j++) {
				System.out.print(_profile[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ParameterParser pp = new ParameterParser();
		try {
			pp.parseDataFile(args);
		} catch (IOException e) {
			System.out.println(e);
			return;
		}
		Profile p = new Profile(pp.profile());
		String dna = pp.namedString("dna");
		System.out.println(p.findPattern(dna));
	}
}
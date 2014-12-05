package utils;

import week_1_2.Converter;

public class GeneticCode
{
	private String errorMessage = "Cannot translate this codon: %s";

	public char[] geneticCode =
	{ 'K', 'N', 'K', 'N', 'T', 'T', 'T', 'T', 'R', 'S', 'R', 'S', 'I', 'I',
			'M', 'I', 'Q', 'H', 'Q', 'H', 'P', 'P', 'P', 'P', 'R', 'R', 'R',
			'R', 'L', 'L', 'L', 'L', 'E', 'D', 'E', 'D', 'A', 'A', 'A', 'A',
			'G', 'G', 'G', 'G', 'V', 'V', 'V', 'V', '*', 'Y', '*', 'Y', 'S',
			'S', 'S', 'S', '*', 'C', 'W', 'C', 'L', 'F', 'L', 'F' };

	public char[] aminoAcids =
	{ 'G', 'A', 'S', 'P', 'V', 'T', 'C', 'I', 'L', 'N', 'D', 'K', 'Q', 'E',
			'M', 'H', 'F', 'R', 'Y', 'W' };

	public int[] aminoAcidsMass =
	{ 57, 71, 87, 97, 99, 101, 103, 113, 113, 114, 115, 128, 128, 129, 131,
			137, 147, 156, 163, 186 };

	private Converter converter = new Converter();

	public char getAminoAcid(String rnaString)
	{
		if (rnaString.length() != 3)
		{
			throw new IllegalArgumentException(String.format(errorMessage,
					rnaString));
		}
		return geneticCode[(int) converter.patternToNumber(rnaString)];
	}

	public int getAminoAcidMass(char c)
	{
		switch (Character.toLowerCase(c))
		{
		case 'g':
			return 57;
		case 'a':
			return 71;
		case 's':
			return 87;
		case 'p':
			return 97;
		case 'v':
			return 99;
		case 't':
			return 101;
		case 'c':
			return 103;
		case 'i':
		case 'l':
			return 113;
		case 'n':
			return 114;
		case 'd':
			return 115;
		case 'k':
		case 'q':
			return 128;
		case 'e':
			return 129;
		case 'm':
			return 131;
		case 'h':
			return 137;
		case 'f':
			return 147;
		case 'r':
			return 156;
		case 'y':
			return 163;
		case 'w':
			return 186;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int getPeptideMass(String peptide)
	{
		int res = 0;
		for (char c : peptide.toCharArray())
		{
			res += getAminoAcidMass(c);
		}
		return res;
	}
}

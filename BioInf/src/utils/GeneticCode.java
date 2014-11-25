package utils;

import week_1_2.Converter;

public class GeneticCode
{
	private String errorMessage = "Cannot translate to Codon this string: %s";
	
	public char[] geneticCode = {
		'K', 'N', 'K', 'N', 'T', 'T', 'T', 'T',
		'R', 'S', 'R', 'S', 'I', 'I', 'M', 'I',
		'Q', 'H', 'Q', 'H', 'P', 'P', 'P', 'P',
		'R', 'R', 'R', 'R', 'L', 'L', 'L', 'L',
		'E', 'D', 'E', 'D', 'A', 'A', 'A', 'A',
		'G', 'G', 'G', 'G', 'V', 'V', 'V', 'V',
		'*', 'Y', '*', 'Y', 'S', 'S', 'S', 'S',
		'*', 'C', 'W', 'C', 'L', 'F', 'L', 'F'};
	
	private Converter converter = new Converter();
	
	public char getAminoAcid(String rnaString)
	{
		if(rnaString.length()!=3){
			throw new IllegalArgumentException(String.format(errorMessage, rnaString));
		}
		return geneticCode[(int) converter.patternToNumber(rnaString)];
	}
}

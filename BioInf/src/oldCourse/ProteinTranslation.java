package oldCourse;

import utils.GeneticCode;

public class ProteinTranslation
{

	private GeneticCode geneticCode = new GeneticCode();
	private final char STOP_CODE = '*';

	public String translate(String rnaString)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rnaString.length(); i += 3)
		{
			char c = geneticCode.getAminoAcid(rnaString.substring(i, i + 3));
			if (c == STOP_CODE)
			{
				break;
			}
			sb.append(c);
		}
		return sb.toString();
	}
}

package week_3_4;

import java.util.ArrayList;
import java.util.List;

import week_1_2.ComplementReverseStrand;

public class PeptideEncoding
{
	private ProteinTranslation pt = new ProteinTranslation();
	private ComplementReverseStrand crs = new ComplementReverseStrand();
	private final int CODON_LENGTH = 3;

	public List<String> getEncodingPatterns(String text, String peptide)
	{
		List<String> res = new ArrayList<String>();
		int step = peptide.length() * CODON_LENGTH;
		for (int i = 0; i < text.length() - step; i ++)
		{
			String pattern = text.substring(i, i + step);
			String reversePattern = crs.compute(pattern);
			if (peptide.equals(pt.translate(pattern))
					|| peptide.equals(pt.translate(reversePattern)))
			{
				res.add(pattern);
			}
		}
		return res;
	}
}

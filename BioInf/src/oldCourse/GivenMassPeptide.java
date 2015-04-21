package oldCourse;

import utils.GeneticCode;

public class GivenMassPeptide
{
	private GeneticCode gc = new GeneticCode();

	public long calculate(int mass)
	{
		long res = 0L;
		int n = 0;
		int[] peptide;
		int l = gc.aminoAcidsMass.length;
		int i = 0;
		int tmp;
		boolean shouldIncrement = false;
		while (true)
		{
			peptide = new int[++n];
			System.out.println("n = "+n);
			shouldIncrement = false;
			if (peptideMass(peptide) > mass)
			{
				return res;
			}
			while (true)
			{
				if (shouldIncrement)
				{
					i = 0;
					break;
				}
				if (peptideMass(peptide) == mass)
				{
					res++;
				}
				tmp = peptide[0] + 1;
				while (tmp == l)
				{
					if (i == n - 1)
					{
						shouldIncrement = true;
						break;
					}
					peptide[i] = 0;
					tmp = peptide[++i] + 1;
					if (tmp != l)
					{
						peptide[i] = tmp;
						tmp = 0;
						i = 0;
					}
				}
				peptide[0] = tmp;
			}
		}
	}

	private int peptideMass(int[] peptide)
	{
		int res = 0;
		for (Integer index : peptide)
		{
			res += gc.aminoAcidsMass[index];
		}
		return res;
	}
}

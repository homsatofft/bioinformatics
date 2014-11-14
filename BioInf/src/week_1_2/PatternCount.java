package week_1_2;

public class PatternCount
{
	public static int count(String text, String pattern)
	{
		int count = 0;
		int tLen = text.length();
		int pLen = pattern.length();
		for (int i = 0; i <= tLen - pLen; i++)
		{
			String current = text.substring(i, i + pLen);
			if (pattern.equalsIgnoreCase(current))
			{
				count++;
			}
		}
		return count;
	}

	public static int countN(String text, String pattern, int hammingDistance)
	{
		int count = 0;
		int tLen = text.length();
		int pLen = pattern.length();
		for (int i = 0; i <= tLen - pLen; i++)
		{
			String current = text.substring(i, i + pLen);
			if (Hamming.distance(pattern, current) <= hammingDistance)
			{
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		int k = countN("AACAAGCTGATAAACATTTAAAGAG", "AAAAA", 2);
		System.out.println(k);
	}
}

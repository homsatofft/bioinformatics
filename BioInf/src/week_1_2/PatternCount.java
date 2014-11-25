package week_1_2;

public class PatternCount
{
	public int count(String text, String pattern)
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

	public int countN(String text, String pattern, int hammingDistance)
	{
		Hamming h = new Hamming();
		int count = 0;
		int tLen = text.length();
		int pLen = pattern.length();
		for (int i = 0; i <= tLen - pLen; i++)
		{
			String current = text.substring(i, i + pLen);
			if (h.distance(pattern, current) <= hammingDistance)
			{
				count++;
			}
		}
		return count;
	}
}

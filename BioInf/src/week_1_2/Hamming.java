package week_1_2;

public class Hamming
{
	public int distance(String stringOne, String stringTwo)
	{
		int hamming = 0;
		if (stringOne.length() != stringTwo.length())
		{
			throw new IllegalArgumentException(
					"Cannot calculate Hamming distance for different length strings!");
		}
		String _one = stringOne.toLowerCase();
		String _two = stringTwo.toLowerCase();
		for (int i = 0; i < stringOne.length(); i++)
		{
			Character cOne = _one.charAt(i);
			Character cTwo = _two.charAt(i);
			if (!cOne.equals(cTwo))
			{
				hamming++;
			}
		}
		return hamming;
	}
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			return;
		}
		String text1 = args[0];
		String text2 = args[1];
		Hamming h = new Hamming();
		System.out.println(h.distance(text1, text2));
	}
}

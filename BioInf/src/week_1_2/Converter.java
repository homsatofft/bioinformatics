package week_1_2;

public class Converter
{
	private static int charToCode(char c)
	{
		switch (Character.toLowerCase(c))
		{
		case 'a':
			return 0;
		case 'c':
			return 1;
		case 'g':
			return 2;
		case 't':
			return 3;
		default:
			throw new IllegalArgumentException("Illegal code: " + c);
		}
	}

	private static char codeToChar(int i)
	{
		switch (i)
		{
		case 0:
			return 'A';
		case 1:
			return 'C';
		case 2:
			return 'G';
		case 3:
			return 'T';
		default:
			throw new IllegalArgumentException("Illegal code: " + i);
		}
	}

	public static long patternToNumber(String pattern)
	{
		return patternToNumberRecursive(pattern, 0);
	}

	public static String numberToPattern(Long number, int length)
	{
		return numberToPatternRecursive(number, length, new String());
	}

	private static String numberToPatternRecursive(long number, int length,
			String acc)
	{
		if (length == 0)
		{
			return acc;
		}
		long prefixNumber = number / 4;
		int r = (int) (number % 4);
		String nexAcc = new StringBuilder(acc).insert(0, codeToChar(r))
				.toString();
		return numberToPatternRecursive(prefixNumber, length - 1, nexAcc);
	}

	private static long patternToNumberRecursive(String pattern, long acc)
	{
		if (pattern.isEmpty())
		{
			return acc;
		}
		char firstSymbol = pattern.charAt(0);
		String nextPattern = pattern.substring(1);
		long nextAcc = (long) (acc + Math.pow(4, pattern.length() - 1)
				* charToCode(firstSymbol));
		return patternToNumberRecursive(nextPattern, nextAcc);
	}

	public static void main(String[] args)
	{
		System.out.println(numberToPattern((long) 912, 6));
	}
}

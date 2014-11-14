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

	private static char codeToChar(char i)
	{
		switch (i)
		{
		case '0':
			return 'A';
		case '1':
			return 'C';
		case '2':
			return 'G';
		case '3':
			return 'T';
		default:
			throw new IllegalArgumentException("Illegal code: " + i);
		}
	}

	public static long patternToNumber(String pattern)
	{
		long result = 0;
		for (int i = 0; i < pattern.length(); i++)
		{
			result += charToCode(pattern.charAt(i))
					* Math.pow(4, (pattern.length() - i - 1 ));
		}
		return result;
	}

	public static String numberToPattern(Long j, int length)
	{
		String num = Long.toString(j, 4);
		StringBuilder sb = new StringBuilder();
		for (char c : num.toCharArray())
		{
			sb.append(codeToChar(c));
		}
		for (int i = sb.length(); i < length; i++)
		{
			sb.insert(0, 'A');
		}
		// System.out.println(sb.toString());
		return sb.toString();
	}

	public static void main(String[] args)
	{
		System.out.println(numberToPattern((long) 6580, 8));
	}
}

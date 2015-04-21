package week_1_2;

public class ComplementReverseStrand
{
	private char codeReverse(char c)
	{
		switch (Character.toLowerCase(c))
		{
		case 'a':
			return 'T';
		case 'c':
			return 'G';
		case 'g':
			return 'C';
		case 't':
			return 'A';
		default:
			throw new IllegalArgumentException();
		}
	}

	public String compute(String input)
	{
		StringBuilder sb = new StringBuilder();
		char[] arr = input.toCharArray();
		for (int i = arr.length - 1; i >= 0; i--)
		{
			sb.append(codeReverse(arr[i]));
		}
		return sb.toString();
	}
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			return;
		}
		String text = args[0];
		ComplementReverseStrand crs = new ComplementReverseStrand();
		System.out.println(crs.compute(text));
	}
}

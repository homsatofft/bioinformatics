package utils;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class ParameterParserTest
{

	ParameterParser pp = new ParameterParser();
	@Test
	public void test()
	{
		String[] paramsArray = {"-input", "-integers", "-inline", "k", "d", "-strings", "dnaStrings", "-output", "-strings", "-inline", "result", "-end"};
		String source = "data/motif_enumeration_data.txt";
		try
		{
			pp.parseDataFile(source, paramsArray);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		assertTrue(pp.namedInputIntegers.get("k").value() == 5);
		assertTrue(pp.inputStrings.size() == 6);
	}

}

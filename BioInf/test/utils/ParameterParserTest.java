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
		String[] paramsArray = {"data/motif_enumeration_data.txt",
				"-input", "-integers", "-inline", "k", "d", "-strings", "dnaStrings", 
				"-output", "-strings", "-inline", "result", "-end"};
		try
		{
			pp.parseDataFile(paramsArray);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		assertTrue(pp.namedInputIntegers.get("k").value() == 5);
		assertTrue(pp.inputStrings.size() == 6);
	}

}

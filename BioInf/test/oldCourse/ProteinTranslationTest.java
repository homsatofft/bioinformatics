package oldCourse;

import static org.junit.Assert.*;
import oldCourse.ProteinTranslation;

import org.junit.Test;

public class ProteinTranslationTest
{	
	@Test
	public void testTranslate()
	{
		ProteinTranslation pt = new ProteinTranslation();
		String rnaString = "AUGGCCAUGGCGCCCAGAACUGAGAUCAAUAGUACCCGUAUUAACGGGUGA";
		String output = "MAMAPRTEINSTRING";
		assertTrue(output.equals(pt.translate(rnaString)));
	}
}

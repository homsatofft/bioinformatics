package week_1_2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ ClumpFindingTest.class,
		ComplementReverseStrandTest.class, ConverterTest.class,
		FrequencyArrayTest.class, FrequentWordsTest.class, HammingTest.class,
		NeighborsTest.class, PatternCountTest.class,
		SkewTest.class})
public class AllTests
{

}

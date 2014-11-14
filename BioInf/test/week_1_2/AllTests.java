package week_1_2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(
{ ApproximatePatternMatchTest.class, ClumpFindingTest.class,
		ComplementReverseStrandTest.class, ConverterTest.class,
		FrequencyArrayTest.class, FrequentWordsTest.class, HammingTest.class,
		NeighborsTest.class, PatternCountTest.class, PatternMatchingTest.class,
		SkewTest.class, UtilsTest.class })
public class AllTests
{

}

package utils;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomTest {
	double[] distribution = new double[2];
	@Before
	public void setUp(){
		distribution[0] = 1.0;
		distribution[1] = 0.0;
	}
	
	@Test
	public void testSetDistribution(){
		Random r = new Random(distribution);
		assertEquals(distribution[0], r._distribution[0], 0);
		distribution[0] = 0.0;
		distribution[1] = 1.0;
		r.setDistribution(distribution);
		assertEquals(distribution[1], r._distribution[1], 0);
	}
	
	@Test
	public void testNextInt() {
		Random r = new Random(distribution);
		int result = r.nextInt();
		assertEquals(1, result);
		distribution[0] = 0.0;
		distribution[1] = 1.0;
		r.setDistribution(distribution);
		result = r.nextInt();
		assertEquals(2, result);
	}

}

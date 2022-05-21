package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Euclidean;

public class EuclideanTest {

	@Test
	public void TestDistancep1p2() {
		List<Double> p1 = Arrays.asList(2.0, 3.0, 5.0);
		List<Double> p2 = Arrays.asList(2.0, 5.0, 6.0);
		double expected = Math.sqrt(5.0);
		double actual = new Euclidean().distance(p1, p2);
		assertEquals(expected, actual);
	}
}
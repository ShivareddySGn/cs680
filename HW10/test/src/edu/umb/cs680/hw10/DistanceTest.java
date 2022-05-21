package edu.umb.cs680.hw10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw10.Chebyshev;
import edu.umb.cs680.hw10.Distance;
import edu.umb.cs680.hw10.Euclidean;
import edu.umb.cs680.hw10.Manhattan;

public class DistanceTest {
	private static List<Double> p1, p2, p3, p4, p5;
	private static List<List<Double>> pointsList = new LinkedList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		p1 = Arrays.asList(2.0, 3.0, 5.0);
		p2 = Arrays.asList(2.0, 5.0, 6.0);
		p3 = Arrays.asList(3.0, 4.0, 8.0);
		p4 = Arrays.asList(4.0, 2.0, 1.0);
		p5 = Arrays.asList(5.0, 5.0, 6.0);
		pointsList.add(p1);
		pointsList.add(p2);
		pointsList.add(p3);
		pointsList.add(p4);
		pointsList.add(p5);
	}

	@Test
	public void TestGetP1P2() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(p1, p2);
		assertEquals(expected, actual);
	}

	@Test
	public void VerifygetP1P2AndEuclidean() {
		double expected = Math.sqrt(5.0);
		double actual = Distance.get(p1, p2, new Euclidean());
		assertEquals(expected, actual);
	}

	@Test
	public void VerifygetP1P2AndManhattan() {
		double expected = 3.0;
		double actual = Distance.get(p1, p2, new Manhattan());
		assertEquals(expected, actual);
	}

	@Test
	public void VerifygetP1P2AndChebyshev() {
		double expected = 2.0;
		double actual = Distance.get(p1, p2, new Chebyshev());
		assertEquals(expected, actual);
	}

	@Test
	public void TestPointListMatrix() {
		Double[][] expected = { { 0.0, Math.sqrt(5.0), Math.sqrt(11.0), Math.sqrt(21.0), Math.sqrt(14.0) },
				{ Math.sqrt(5.0), 0.0, Math.sqrt(6.0), Math.sqrt(38.0), 3.0 },
				{ Math.sqrt(11.0), Math.sqrt(6.0), 0.0, Math.sqrt(54.0), 3.0 },
				{ Math.sqrt(21.0), Math.sqrt(38.0), Math.sqrt(54.0), 0.0, Math.sqrt(35.0) },
				{ Math.sqrt(14.0), 3.0, 3.0, Math.sqrt(35.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList);
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

	@Test
	public void TestPointListMatrixAndEuclidean() {
		Double[][] expected = { { 0.0, Math.sqrt(5.0), Math.sqrt(11.0), Math.sqrt(21.0), Math.sqrt(14.0) },
				{ Math.sqrt(5.0), 0.0, Math.sqrt(6.0), Math.sqrt(38.0), 3.0 },
				{ Math.sqrt(11.0), Math.sqrt(6.0), 0.0, Math.sqrt(54.0), 3.0 },
				{ Math.sqrt(21.0), Math.sqrt(38.0), Math.sqrt(54.0), 0.0, Math.sqrt(35.0) },
				{ Math.sqrt(14.0), 3.0, 3.0, Math.sqrt(35.0), 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Euclidean());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}
	

	
	@Test
	public void TestPointListMatrixAndChebyshev() {
		Double[][] expected = { { 0.0, 2.0, 3.0, 4.0, 3.0 },
								{ 2.0, 0.0, 2.0, 5.0, 3.0 },
								{ 3.0, 2.0, 0.0, 7.0, 2.0 },
								{ 4.0, 5.0, 7.0, 0.0, 5.0 },
								{ 3.0, 3.0, 2.0, 5.0, 0.0 } };
		List<List<Double>> actual = Distance.matrix(pointsList, new Chebyshev());
		for (int i = 0; i < expected.length; i++) {
			Double[] temp = new Double[5];
			assertArrayEquals(expected[i], actual.get(i).toArray(temp));
		}
	}

}
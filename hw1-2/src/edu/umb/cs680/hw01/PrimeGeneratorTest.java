package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	@Test
	public void onetosix()
	{
		PrimeGenerator gen = new PrimeGenerator(1,6);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	@Test
	public void negativetopositive()
	{
	
		try {
			PrimeGenerator gen = new PrimeGenerator(-5,5);
			
			}catch(Exception e) {
				assertEquals("Wrong input values: from=-5 to=5" ,e.getMessage());

				
			}
		}

	@Test
	public void onetotwenty()
	{
		PrimeGenerator gen = new PrimeGenerator(1,20);
		gen.generatePrimes();
		Long[] expectedPrimes = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L}; 
		assertArrayEquals( expectedPrimes, gen.getPrimes().toArray() ); 
	}
	
}

package edu.umb.cs680.hw2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw2.Singleton;



public class SingletonTest {

	@Test
	public void VerifygetInstanceforNonNull() {
		assertNotNull(Singleton.getInstance());
	}
	
	@Test
	public void VerifygetInstanceforIdentical() {
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		assertSame(a,b);
	}

}
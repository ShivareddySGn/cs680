package edu.umb.cs680.hw5;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw5.Escalator;

class EscalatorTest {

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(Escalator.getInstance());
	}

	@Test
	public void getInstanceReturnIdenticalInstance() {
		Escalator e1 = Escalator.getInstance();
		Escalator e2 = Escalator.getInstance();
		assertSame(e1, e2);
	}

}
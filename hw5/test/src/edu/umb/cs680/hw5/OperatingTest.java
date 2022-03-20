package edu.umb.cs680.hw5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw5.Escalator;
import edu.umb.cs680.hw5.Operating;
import edu.umb.cs680.hw5.StandBy;
import edu.umb.cs680.hw5.Stopped;

class OperatingTest {
	private static Escalator e;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		e = Escalator.getInstance();
	}

	@BeforeEach
	public void setUpBeforeEveryTest() throws Exception {
		e.changeState(Operating.getInstance());
	}

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(Operating.getInstance());
	}

	@Test
	public void getInstanceReturnIdenticalInstance() {
		Operating o1 = Operating.getInstance();
		Operating o2 = Operating.getInstance();
		assertSame(o1, o2);
	}

	@Test
	public void startButtonPushedTesting() {
		e.startButtonPushed();
		assertSame(e.getState(), Operating.getInstance());
	}

	@Test
	public void stopButtonPushedTesting() {
		e.stopButtonPushed();
		assertSame(e.getState(), Stopped.getInstance());
	}

	@Test
	public void motionDetectedTesting() {
		e.motionDetected();
		assertSame(e.getState(), Operating.getInstance());
	}
}
	

package edu.umb.cs680.hw5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw5.Escalator;
import edu.umb.cs680.hw5.Operating;
import edu.umb.cs680.hw5.StandBy;
import edu.umb.cs680.hw5.Stopped;

class StandByTest {
	private static Escalator e;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		e = Escalator.getInstance();
	}

	@BeforeEach
	public void setUpBeforeEveryTest() throws Exception {
		e.changeState(StandBy.getInstance());
	}

	@Test
	public void getInstanceReturnNonNullValue() {
		assertNotNull(StandBy.getInstance());
	}

	@Test
	public void getInstanceReturnIdenticalInstance() {
		StandBy s1 = StandBy.getInstance();
		StandBy s2 = StandBy.getInstance();
		assertSame(s1, s2);
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

	@Test
	public void motionNotDetectedTesting() {
		e.motionNotDetected();
		assertSame(e.getState(), StandBy.getInstance());
	}
}
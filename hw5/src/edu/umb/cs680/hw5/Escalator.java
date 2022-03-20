package edu.umb.cs680.hw5;

public class Escalator {
	private static Escalator instance = null;
	private State state = Stopped.getInstance();

	private Escalator() {}

	public static Escalator getInstance() {
		if (instance == null) {
			instance = new Escalator();
			Stopped.setEscalator(instance);
		}
		return instance;
	}

	public State getState() {
		return state;
	}

	public void changeState(State newState) {
		state = newState;
	}

	public void startButtonPushed() {
		state.startButtonPushed();
	}

	public void stopButtonPushed() {
		state.stopButtonPushed();
	}

	public void motionDetected() {
		state.motionDetected();
	}

	public void motionNotDetected() {
		state.motionNotDetected();
	}

	public void moveSteps() {
		System.out.println("The steps are going to move!");
	}

	public void stopSteps() {
		System.out.println("The steps are going to be stopped!");
	}

	public void enableSensor() {
		System.out.println("The sensor is going to be enabled!");
	}

	public void disableSensor() {
		System.out.println("The sensor is going to be disabled!");
	}

}
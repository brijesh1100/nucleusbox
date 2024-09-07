package com.nb.engin.orchestrator.context;

public class JobContext implements Context {
	private Object input;
	private Object output;

	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	}

	public Object getOutput() {
		return output;
	}

	public void setOutput(Object output) {
		this.output = output;
	}

}

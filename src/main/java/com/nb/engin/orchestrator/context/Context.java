package com.nb.engin.orchestrator.context;

/**
 * Put your @see Job and @see JobStep in this context. This will define the
 * input and output of the @see Job or @see JobStep.
 */
public interface Context {
	Object getInput();

	void setInput(Object input);

	Object getOutput();

	void setOutput(Object output);

}

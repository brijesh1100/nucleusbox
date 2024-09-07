package com.nb.engin.orchestrator;

import com.nb.engin.orchestrator.exception.OrchestratorException;
import com.nb.engin.orchestrator.exception.OrchestratorExceptionHandler;

public class DefaultExceptionHandler implements OrchestratorExceptionHandler {

	/**
	 * default exception handler which stop the channel or orchestrator that it attached to.
	 */
	public void handle(OrchestratorException e) {
		throw e;
	}

}

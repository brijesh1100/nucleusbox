package com.nb.engin.orchestrator.exception;

/**
 * a OrchestratorExceptionHandler can be attached on a orchestrator
 * the handler can stop the orchestrator by rethrown an exception
 */
public interface OrchestratorExceptionHandler {

	void handle(OrchestratorException e);
}

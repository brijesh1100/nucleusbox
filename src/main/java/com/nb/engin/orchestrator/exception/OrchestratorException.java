package com.nb.engin.orchestrator.exception;

/**
 * The <code>OrchestratorException</code> is used to log exception Task.
 */
public class OrchestratorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode = 0;

	public OrchestratorException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public OrchestratorException(String msg, int errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

	public OrchestratorException(String msg, int errorCode, Throwable cause) {
		super(msg, cause);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}
}
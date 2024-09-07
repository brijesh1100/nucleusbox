package com.nb.engin.orchestrator.context;

/**
 * Error Loging context allow to log error
 */
public interface ErrorContext<E> extends Context {
	void logError(E error);
}

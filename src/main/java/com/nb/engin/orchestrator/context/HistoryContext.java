package com.nb.engin.orchestrator.context;

public interface HistoryContext<H> extends Context{

	/**
	 * a context that allow logging history
	 */
	void logHistory(H history);
}

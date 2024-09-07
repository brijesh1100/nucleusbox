package com.nb.engin.orchestrator;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorExceptionHandler;

/**
 * a <code>Channel</code> class is a sequence list of tasks act as a single task
 * <p>
 * it groups a list of tasks to form a broader reusable functional task
 * <p>
 * another usage is to provide a way for selector to choose a list of tasks
 * <p>
 * it should to be used directly without subclass
 */

public class Channel<P extends Context> extends AbstractListTask<P> implements Task<P> {

	public Channel(Task<? super P>... tasks) {
		super(tasks);
	}

	public Channel(OrchestratorExceptionHandler exceptionHandler, Task<? super P> ts) {
		super(exceptionHandler, ts);
	}

}
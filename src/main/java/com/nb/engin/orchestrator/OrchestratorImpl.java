package com.nb.engin.orchestrator;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorExceptionHandler;

/**
 * This <code>OrchestratorImpl</code> class is the default <code>Orchestrator</code>
 * implementation.
 * <p>
 * for details, see {@link Orchestrator}
 *
 * @param <P> the context that compatible with all it's tasks.
 * @see Orchestrator
 */
public class OrchestratorImpl<P extends Context> extends AbstractListTask<P> implements IOrchestrator<P> {
    /**
     * @param ts the list of tasks to be executed sequentially
     */
    public OrchestratorImpl(Task<? super P>... ts) {
        super(ts);
    }

    /**
     * @param ts the list of tasks to be executed sequentially
     * @param exceptionHandler the orchestrator exception handler, can rethrow exception or just log error
     */
    public OrchestratorImpl(OrchestratorExceptionHandler exceptionHandler, Task<? super P>... ts) {
        super(exceptionHandler, ts);
    }

}
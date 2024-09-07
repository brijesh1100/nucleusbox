package com.nb.engin.orchestrator;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorException;


/**
 * This interface represents one of many Steps in a
 * <code>Orchestrator</code> execution.
 *
 * @param <P> the context type which pass through all tasks in a Orchestrator
 * @see Orchestrator
 * @see Context
 */
public interface Task<P extends Context> {
    /**
     * @param context <code>context</code> interface that this Task is working on
     * @throws OrchestratorException if there is an issue
     */
    void execute(P context) throws OrchestratorException;
}
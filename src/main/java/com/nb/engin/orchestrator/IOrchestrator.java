package com.nb.engin.orchestrator;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorException;

public interface IOrchestrator<P extends Context> {

	/**
     * Execute the <code>Task</code>s, by the order of their position in
     * task list,
     * (Note: the tasks are executed in the same thread as the caller)
     *
     * @param context the <code>context</code> object
     * @throws OrchestratorException if there is an issue
     */
    void execute(P context) throws OrchestratorException;
}

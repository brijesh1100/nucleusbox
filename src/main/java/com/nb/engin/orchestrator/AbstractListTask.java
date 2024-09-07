package com.nb.engin.orchestrator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorException;
import com.nb.engin.orchestrator.exception.OrchestratorExceptionHandler;

public abstract class AbstractListTask<P extends Context> {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractListTask.class);

    private List<Task<? super P>> tasks;
    private OrchestratorExceptionHandler exceptionHandler = new DefaultExceptionHandler();

    /**
     * @param ts the list of tasks to be executed sequentially
     */
    public AbstractListTask(Task<? super P>... ts) {
        List<Task<? super P>> list = new ArrayList<>();
        Collections.addAll(list, ts);
        tasks = list;
    }

    /**
     * @param ts the list of tasks to be executed sequentially
     * @param exceptionHandler the orchestrator exception handler, can rethrow exception or just log error
     */
    public AbstractListTask(OrchestratorExceptionHandler exceptionHandler, Task<? super P>... ts) {
        this(ts);
        this.exceptionHandler = exceptionHandler;
    }

    public void execute(final P context) throws OrchestratorException {
        if (logger.isDebugEnabled()) {
            logger.debug("orchestrator " + this.getClass().getName() + " started");
        }

        for (Task<? super P> task : tasks) {
            try {
                task.execute(context);
            } catch (OrchestratorException e) {
                logger.error(e.getMessage());
                exceptionHandler.handle(e);
            }
        }
    }

}
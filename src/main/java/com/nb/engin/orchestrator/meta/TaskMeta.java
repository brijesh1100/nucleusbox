package com.nb.engin.orchestrator.meta;

import java.util.List;

/**
 * Meta data for Task
 */
public class TaskMeta extends Metadata {

    public TaskMeta(String beanName, String className, String context, List<String> parents) {
        super(Type.TASK, beanName, className, context, parents);
    }
}
package com.nb.engin.orchestrator.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Meta data for Orchestrator
 */
public class OrchestratorMeta extends Metadata {
    private List<Metadata> taskList = new ArrayList<>();

    public OrchestratorMeta(String beanName, String className, String context, List<String> parents) {
        super(Type.ORCHESTRATOR, beanName, className, context, parents);
    }

    public List<Metadata> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Metadata> taskList) {
        this.taskList = taskList;
    }
}
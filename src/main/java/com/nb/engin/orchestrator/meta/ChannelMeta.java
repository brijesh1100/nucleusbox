package com.nb.engin.orchestrator.meta;

import java.util.ArrayList;
import java.util.List;

/**
 * Meta data for Channel
 */
public class ChannelMeta extends Metadata {
	private List<Metadata> taskList = new ArrayList<>();

	public ChannelMeta(String beanName, String className, String context, List<String> parents) {
		super(Type.CHANNEL, beanName, className, context, parents);
	}

	public List<Metadata> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Metadata> taskList) {
		this.taskList = taskList;
	}
}
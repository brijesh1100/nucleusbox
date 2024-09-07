package com.nb.engin.orchestrator.meta;

import java.util.List;
import java.util.Map;

/**
 * Meta data for Selector
 */
public class SelectorMeta extends Metadata {
	private Map<String, Metadata> map;

	public SelectorMeta(String beanName, String className, String context, List<String> parents) {
		super(Type.SELECTOR, beanName, className, context, parents);
	}

	public Map<String, Metadata> getMap() {
		return map;
	}

	public void setMap(Map<String, Metadata> map) {
		this.map = map;
	}

}
package com.nb.engin.orchestrator;

import java.util.EnumMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nb.engin.orchestrator.context.Context;
import com.nb.engin.orchestrator.exception.OrchestratorException;

/**
 * This <code>Selector</code> class is used to execute only one selected task(or channel)
 * <p>
 * it provides parallel flow of a process
 * <p>
 * concrete class usually implement getChannel base on data in context
 * <p>
 *
 * @param <P> context that compatible with all tasks that it may select
 */
public abstract class Selector<K extends Enum<K>, P extends Context> implements Task<P> {
	protected static final Logger logger = LoggerFactory.getLogger(Selector.class);
	private EnumMap<K, Task<P>> taskMap;

	public Selector(EnumMap<K, Task<P>> taskMap) {
		super();
		this.taskMap = taskMap;
	}

	@Override
	public void execute(P context) throws OrchestratorException {
		K channelKey = this.getChannel(context);
		Task<P> channel = taskMap.get(channelKey);
		if (null != channel)
			channel.execute(context);
		else
			logger.warn("Selector: the selected " + channelKey + " is not configured.");
	}

	public abstract K getChannel(P context);
}
package com.nb.engin.orchestrator.example;

import com.nb.engin.orchestrator.context.AnalyticsContext;
import com.nb.engin.orchestrator.context.DataCollectorContext;
import com.nb.engin.orchestrator.context.ReadAndWriteContext;

public class ESJobContext implements DataCollectorContext, ReadAndWriteContext, AnalyticsContext {

	public void init() {
	}

	@Override
	public void logHistory(String history) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getInput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInput(Object input) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOutput(Object output) {
		// TODO Auto-generated method stub
		
	}
}

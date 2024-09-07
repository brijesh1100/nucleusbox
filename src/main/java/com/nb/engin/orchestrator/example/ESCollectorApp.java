package com.nb.engin.orchestrator.example;

import com.nb.engin.orchestrator.IOrchestrator;
import com.nb.engin.orchestrator.OrchestratorImpl;
import com.nb.engin.orchestrator.example.task.AnalyticsTask;
import com.nb.engin.orchestrator.example.task.DataCollectorTask;
import com.nb.engin.orchestrator.example.task.ESTask;
import com.nb.engin.orchestrator.example.task.ReadAndWriteTask;

public class ESCollectorApp {

	private static DataCollectorTask dataCollectortask = new DataCollectorTask();
	private static ReadAndWriteTask readWritetask = new ReadAndWriteTask();
	private static AnalyticsTask analyticstask = new AnalyticsTask();
	private static ESTask esTask = new ESTask();

	public static void main(String[] args) {
		IOrchestrator<ESJobContext> esJob = new OrchestratorImpl<>(dataCollectortask, readWritetask, analyticstask,
				esTask);
	}
}

package com.nb.engin.orchestrator.model;

import com.nb.engin.orchestrator.context.Context;

public class JobStep implements IJob, Runnable {

	private Long jobStepId;
	private String jobStepName;
	private Context context;

	public JobStep(String jobStepName, Context context) {
		this.jobStepName = jobStepName;
		this.context = context;
	}

	public void run() {
		// Simulate some processing
		System.out.println("Executing job step: " + jobStepName);
		try {
			Thread.sleep(1000); // Simulating a task
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		// On completion, update context or trigger callback
		System.out.println("Completed job step: " + jobStepName);
	}

	public void start() {
		run();
	}

	public void stop() {
		System.out.println("Stopping job step: " + jobStepName);
	}

	public void shutdown() {
		System.out.println("Forcing shutdown of job step: " + jobStepName);
	}

	public Long getJobStepId() {
		return jobStepId;
	}

	public void setJobStepId(Long jobStepId) {
		this.jobStepId = jobStepId;
	}

	public String getJobStepName() {
		return jobStepName;
	}

	public void setJobStepName(String jobStepName) {
		this.jobStepName = jobStepName;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}
	
	

}

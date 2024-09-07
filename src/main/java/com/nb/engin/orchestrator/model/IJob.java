package com.nb.engin.orchestrator.model;

public interface IJob {
	
	/**
	 * This will start the job execution.
	 * */
	public void start();
	
	/**
	 * This method will not immediately stop the job first it will check if Job is Running or not.
	 * If Running then it will wait to finish and then Stop the Job.
	 * 
	 * */
	public void stop();
	
	
	/**
	 * This will force job to stop
	 * */
	public void shutdown();

}

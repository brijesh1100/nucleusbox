package com.nb.engine.orchestrator.example;

import com.nb.engin.orchestrator.context.JobContext;
import com.nb.engin.orchestrator.model.Job;

/**
 * This class an example to perform task
 * ProfileJob has few Job and JobStep
 * First it will create MappingJob which construct the DAG of the process
 * Second it will run the profiling mapping and listen the callback 
 * if Second is done 
 * 
 * */
public class ProfileJob extends Job{
	
	public ProfileJob(String jobName, JobContext context) {
		super(jobName, context);
	}

	public void start() {
		System.out.println("Profile job starting.");
        super.run();
	}

}

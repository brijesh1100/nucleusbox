package com.nb.engin.orchestrator.ragistory;

import java.util.ArrayList;
import java.util.List;

import com.nb.engin.orchestrator.model.Job;

public class JobRagistration implements Ragistration{

	private final List<Job> registeredJobs = new ArrayList<Job>();

    public void registerJob(Job job) {
        registeredJobs.add(job);
        System.out.println("Job Registered: " + job.getJobName());
    }
	
}

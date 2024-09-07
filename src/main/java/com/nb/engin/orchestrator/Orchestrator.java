package com.nb.engin.orchestrator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.nb.engin.orchestrator.constant.JobState;
import com.nb.engin.orchestrator.context.JobContext;
import com.nb.engin.orchestrator.model.Job;
import com.nb.engin.orchestrator.model.JobStep;
import com.nb.engine.orchestrator.example.ProfileJob;

/**
 * This class has big responsibility. 
 * @see Orchestrator is responsible for automating Job orchastration process, coordinating the multiple task in workflow.
 * It will schedule, coordinate, and monitor the execution of jobs, ensuring they run in the correct order and at the designated times.
 * */
public class Orchestrator {

    private final Map<Long, Job> jobs = new ConcurrentHashMap<Long, Job>();
	private final ExecutorService executorService = Executors.newFixedThreadPool(1);

    public void submitJob(ProfileJob job) {
        System.out.println("Submitting job to orchestrator: " + job);
        executorService.submit(job);
    }

    public void shutdown() {
        executorService.shutdown();
    }
    
    public void scheduleJob(Job job) {
        jobs.put(job.getJobId(), job);
        job.setState(JobState.RUNNING);
        System.out.println("Job Scheduled: " + job.getJobName());
//        executorService.submit(job); // Run job asynchronously
        new Thread(job).start();
    }

    public void stopJob(Long jobId) {
        Job job = jobs.get(jobId);
        if (job != null) {
            job.stop();
            job.setState(JobState.FAILED); // Assuming stop means failure in this case
        }
    }

    public static void main(String[] args) {
        Orchestrator orchestrator = new Orchestrator();

        // Create a sample job
        JobContext context = new JobContext();
        ProfileJob job = new ProfileJob("Profile-Job", context);
        JobStep step1 = new JobStep("Step1", context);
        JobStep step2 = new JobStep("Step2", context);
        job.addJobStep(step1);
        job.addJobStep(step2);

        // Submit job to orchestrator
        orchestrator.submitJob(job);

        // Shutdown orchestrator after all jobs finish
        orchestrator.shutdown();
    }
	
}

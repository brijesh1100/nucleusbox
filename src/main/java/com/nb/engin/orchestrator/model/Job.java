package com.nb.engin.orchestrator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.nb.engin.orchestrator.constant.JobState;
import com.nb.engin.orchestrator.context.JobContext;
import com.nb.engin.orchestrator.ragistory.JobRagistration;

public abstract class Job implements IJob, Runnable {

	protected Long jobId;
	protected String jobName;
	private JobState state;
	protected List<JobStep> jobSteps = new ArrayList<JobStep>();
	protected JobContext context;
	private int retryCount = 3; // Retry logic
	protected ExecutorService executor;

	public Job(String jobName, JobContext context) {
		this.jobName = jobName;
		this.context = context;
		this.jobId = UUID.randomUUID().getMostSignificantBits();
		this.state = JobState.IN_PROGRESS;
	}

//	private void createJobStep(String jobName) {
//		JobStep jobstep = new JobStep(jobName + "-" + "jobStep0", this.context);
//		this.jobSteps.add(jobstep);
//	}

	public Job(JobRagistration ragistration) {

	}

	public void run() {
		try {
			CompletableFuture<?>[] futures = jobSteps.stream()
					.map(step -> CompletableFuture.supplyAsync(() -> executeJobStepWithRetry(step)))
					.toArray(CompletableFuture[]::new);

			CompletableFuture.allOf(futures).join(); // Wait for all steps to complete
			setState(JobState.COMPLETED);
			System.out.println("Job Completed: " + jobName);
		} catch (Exception e) {
			setState(JobState.FAILED);
			e.printStackTrace();
		}
	}

	private boolean executeJobStepWithRetry(JobStep jobStep) {
		int attempts = 0;
		while (attempts < retryCount) {
			try {
				jobStep.start();
				return true; // Success
			} catch (Exception e) {
				attempts++;
				if (attempts == retryCount) {
					setState(JobState.FAILED);
					System.out.println("Job Failed after retries: " + jobStep.getJobStepName());
					return false;
				}
			}
		}
		return false;
	}

	public void start() {
		System.out.println("Starting job: " + jobName);
		executor.submit(this);
	}

	public void stop() {
		System.out.println("Gracefully stopping job: " + jobName);
		jobSteps.forEach(JobStep::stop);
        System.out.println("Job Stopped: " + jobName);
	}

	public void shutdown() {
		System.out.println("Forcing shutdown of job: " + jobName);
		executor.shutdownNow(); // Forcefully shutdown job execution
	}

	protected void onComplete() {
		System.out.println("Job " + jobName + " completed successfully.");
		executor.shutdown();
	}

	// Add job steps dynamically
	public void addJobStep(JobStep jobStep) {
		this.jobSteps.add(jobStep);
	}

	public JobState getState() {
		return state;
	}

	public void setState(JobState state) {
		this.state = state;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public JobContext getContext() {
		return context;
	}

	public void setContext(JobContext context) {
		this.context = context;
	}

	public int getRetryCount() {
		return retryCount;
	}

	public void setRetryCount(int retryCount) {
		this.retryCount = retryCount;
	}

	public ExecutorService getExecutor() {
		return executor;
	}

	public void setExecutor(ExecutorService executor) {
		this.executor = executor;
	}

}

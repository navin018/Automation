package dataobjects;

import java.util.Map;



public class WorkItemDO {
	
	public static WorkItemDO INSTANCE;
	public String Summary;
	public String Description;
	
	
	public String Severity;
	public String Priority;
	

	public String StoryPoints;
	public String EpicName;
	
	public String ReleaseName;
	public String ReleaseStartDate;
	public String ReleaseEndDate;
	public String ReleaseDescription;
	
	public String SprintStartDate;
	public String SprintEndDate;
	public String TeamName;
	
	
	


	public String WorkItemExternalId_Impediment;
	public String WorkItemExternalId_Risk;
	public String WorkItemExternalId_Task;
	public String WorkItemExternalId_Issue;
	public String WorkItemExternalId_Story;
	public String WorkItemExternalId_Feature;
	public String WorkItemExternalId_Deliverable;
	public String WorkItemExternalId_Bug;
	public String WorkItemExternalId_SubTask;
	public String WorkItemExternalId_Epic;
	
	public String Probability;
	public String Impact;
	public String TargetResolutionDate;
	public String NextReviewDate;
	
	public String IterationName;
	public String StartDate;
	public String EndDate;
	
	public String BusinessValue;
	public String RiskReduction;
	public String Rank;
	public String StackRank;
	public String Effort;
	public String RemainingWork;
	public String ActualEffort;
	public String Completed;
	public String CompletedWork;
	public String OriginalEstimate;
	public String TimeCriticality;
	public String Criticality;
	public String Complexity;
	public String CostEstimate;
	public String CostApproved;
	public String Risk;
	
	
	public String WSJF;
	
	public String getBusinessValue() {
		return BusinessValue;
	}

	public void setBusinessValue(String businessValue) {
		BusinessValue = businessValue;
	}

	public String getRiskReduction() {
		return RiskReduction;
	}

	public void setRiskReduction(String riskReduction) {
		RiskReduction = riskReduction;
	}

	
	public String getSprintStartDate() {
		return SprintStartDate;
	}

	public void setSprintStartDate(String sprintStartDate) {
		SprintStartDate = sprintStartDate;
	}

	public String getSprintEndDate() {
		return SprintEndDate;
	}

	public void setSprintEndDate(String sprintEndDate) {
		SprintEndDate = sprintEndDate;
	}


	public String getTeamName() {
		return TeamName;
	}

	public void setTeamName(String teamName) {
		TeamName = teamName;
	}



	
	
	public String getIterationName() {
		return IterationName;
	}

	public void setIterationName(String iterationName) {
		IterationName = iterationName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}




	
	public String getProbability() {
		return Probability;
	}

	public void setProbability(String probability) {
		Probability = probability;
	}

	public String getImpact() {
		return Impact;
	}

	public void setImpact(String impact) {
		Impact = impact;
	}

	public String getTargetResolutionDate() {
		return TargetResolutionDate;
	}

	public void setTargetResolutionDate(String targetResolutionDate) {
		TargetResolutionDate = targetResolutionDate;
	}

	public String getNextReviewDate() {
		return NextReviewDate;
	}

	public void setNextReviewDate(String nextReviewDate) {
		NextReviewDate = nextReviewDate;
	}




	public String getWorkItemExternalId_Impediment() {
		return WorkItemExternalId_Impediment;
	}

	public void setWorkItemExternalId_Impediment(String workItemExternalId_Impediment) {
		WorkItemExternalId_Impediment = workItemExternalId_Impediment;
	}

	public String getWorkItemExternalId_Risk() {
		return WorkItemExternalId_Risk;
	}

	public void setWorkItemExternalId_Risk(String workItemExternalId_Risk) {
		WorkItemExternalId_Risk = workItemExternalId_Risk;
	}

	public String getWorkItemExternalId_Task() {
		return WorkItemExternalId_Task;
	}

	public void setWorkItemExternalId_Task(String workItemExternalId_Task) {
		WorkItemExternalId_Task = workItemExternalId_Task;
	}

	public String getWorkItemExternalId_Issue() {
		return WorkItemExternalId_Issue;
	}

	public void setWorkItemExternalId_Issue(String workItemExternalId_Issue) {
		WorkItemExternalId_Issue = workItemExternalId_Issue;
	}

	public String getWorkItemExternalId_Story() {
		return WorkItemExternalId_Story;
	}

	public void setWorkItemExternalId_Story(String workItemExternalId_Story) {
		WorkItemExternalId_Story = workItemExternalId_Story;
	}

	public String getWorkItemExternalId_Feature() {
		return WorkItemExternalId_Feature;
	}

	public void setWorkItemExternalId_Feature(String workItemExternalId_Feature) {
		WorkItemExternalId_Feature = workItemExternalId_Feature;
	}

	public String getWorkItemExternalId_Deliverable() {
		return WorkItemExternalId_Deliverable;
	}

	public void setWorkItemExternalId_Deliverable(String workItemExternalId_Deliverable) {
		WorkItemExternalId_Deliverable = workItemExternalId_Deliverable;
	}

	public String getWorkItemExternalId_Bug() {
		return WorkItemExternalId_Bug;
	}

	public void setWorkItemExternalId_Bug(String workItemExternalId_Bug) {
		WorkItemExternalId_Bug = workItemExternalId_Bug;
	}

	public String getWorkItemExternalId_SubTask() {
		return WorkItemExternalId_SubTask;
	}

	public void setWorkItemExternalId_SubTask(String workItemExternalId_SubTask) {
		WorkItemExternalId_SubTask = workItemExternalId_SubTask;
	}

	public String getWorkItemExternalId_Epic() {
		return WorkItemExternalId_Epic;
	}

	public void setWorkItemExternalId_Epic(String workItemExternalId_Epic) {
		WorkItemExternalId_Epic = workItemExternalId_Epic;
	}

	
	
	public Map<String, WorkItemDO> item;
	
	public static void setInstance(WorkItemDO instance){
		INSTANCE = instance;
	}
	
	public static WorkItemDO getINSTANCE() {
		return INSTANCE;
	}

	public String getReleaseName() {
		return ReleaseName;
	}

	public void setReleaseName(String releaseName) {
		ReleaseName = releaseName;
	}

	public String getReleaseStartDate() {
		return ReleaseStartDate;
	}

	public void setReleaseStartDate(String releaseStartDate) {
		ReleaseStartDate = releaseStartDate;
	}

	public String getReleaseEndDate() {
		return ReleaseEndDate;
	}

	public void setReleaseEndDate(String releaseEndDate) {
		ReleaseEndDate = releaseEndDate;
	}

	public String getReleaseDescription() {
		return ReleaseDescription;
	}

	public void setReleaseDescription(String releaseDescription) {
		ReleaseDescription = releaseDescription;
	}
	
	public String getSummary() {
		return Summary;
	}

	public void setSummary(String summary) {
		Summary = summary;
	}
	
	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getSeverity() {
		return Severity;
	}


	public void setSeverity(String severity) {
		Severity = severity;
	}


	public String getPriority() {
		return Priority;
	}

	public void setPriority(String priority) {
		Priority = priority;
	}


	public String getStoryPoints() {
		return StoryPoints;
	}


	public void setStoryPoints(String storyPoints) {
		StoryPoints = storyPoints;
	}
	public String getEpicName() {
		return EpicName;
	}

	public void setEpicName(String epicName) {
		EpicName = epicName;
		
		
	}
	
	
}
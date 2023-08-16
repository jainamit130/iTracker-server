package com.accolitedigital.iTracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Turbohire {

	@Id
	@JsonProperty
	@Column(name = "id")
	private String RecordId;
	@JsonProperty
	private String ApplicantName;
	@JsonProperty("Interviewers")
	private String interviewers;
	@JsonProperty
	private String Category;
	@JsonProperty
	private String JobStage;
	@JsonProperty("EvaluationDateTime")
	private String evaluationDateTime;
	@JsonProperty("DateTimeInMilli")
	private Long dateTimeInMilli;

	public String getRecordId() {
		return RecordId;
	}
	public void setRecordId(String RecordId) {
		this.RecordId = RecordId;
	}
	public String getApplicantName() {
		return ApplicantName;
	}

	public void setApplicantName(String applicantName) {
		ApplicantName = applicantName;
	}

	public String getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(String interviewers) {
		this.interviewers = interviewers;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getJobStage() {
		return JobStage;
	}

	public void setJobStage(String jobStage) {
		JobStage = jobStage;
	}

	public String getEvaluationDateTime() {
		return evaluationDateTime;
	}

	public void setEvaluationDateTime(String evaluationDateTime) {
		this.evaluationDateTime = evaluationDateTime;
	}

	public Long getDateTimeInMilli() {
		return dateTimeInMilli;
	}

	public void setDateTimeInMilli(Long dateTimeInMilli) {
		this.dateTimeInMilli = dateTimeInMilli;
	}
}

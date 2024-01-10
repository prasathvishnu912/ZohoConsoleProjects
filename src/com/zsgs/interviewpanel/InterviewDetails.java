package com.zsgs.interviewpanel;

import java.time.LocalDate;

public class InterviewDetails implements Comparable<InterviewDetails> {

	public InterviewDetails(String interviewerName, String candName, LocalDate date) {
		super();
		this.interviewerName = interviewerName;
		this.candName = candName;
		this.date = date;
	}

	private String interviewerName;
	private String candName;
	private LocalDate date;

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getCandName() {
		return candName;
	}

	public void setCandName(String candName) {
		this.candName = candName;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int compareTo(InterviewDetails o) {
		if (this.getDate() == null)
			return 0;
		return this.getDate().compareTo(o.getDate());
	}
}

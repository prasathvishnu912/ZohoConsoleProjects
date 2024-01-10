package com.zsgs.interviewpanel.candidate.addcandidate;

import com.zsgs.interviewpanel.Candidate;

public class AddCandidateVM {

	public void addingCandidate(Candidate cand) {
		AddCandidateModel addCandModel = new AddCandidateModel();
		addCandModel.addCandQueue(cand);
	}


	public boolean validateName(String name) {
		if (!name.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean validateAge(int age) {
		if (age < 40) {
			return true;
		}
		return false;
	}

	public boolean validateEmail(String emailId) {
		if (emailId.contains("@"))
			return true;
		return false;
	}

	public boolean validateMobNum(String mobNum) {
		if (!(mobNum.length() < 10))
			return true;
		return false;
	}

}

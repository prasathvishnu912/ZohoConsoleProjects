package com.zsgs.interviewpanel;

public class Candidate implements Comparable<Object>{
	
	private String name;
	private int age;
	private String mobNum;
	private String emailId;
	
	public Candidate(String name, int age, String emailId, String mobNum){
		this.name=name;
		this.age=age;
		this.emailId = emailId;
		this.mobNum = mobNum;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
		
}

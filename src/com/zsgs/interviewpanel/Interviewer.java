package com.zsgs.interviewpanel;

public class Interviewer implements Comparable<Interviewer>{
	
	private int id;
	private String name;
	private String pwd;
	
	public Interviewer(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public int compareTo(Interviewer o) {
		// TODO Auto-generated method stub
		return this.id-o.id;
	}

	
	
	
}

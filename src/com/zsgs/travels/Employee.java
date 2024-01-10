package com.zsgs.travels;

public class Employee {
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Employee(String userName, String pwd, String vechileType) {
		this.userName = userName;
		this.pwd = pwd;
		this.vechileType = vechileType;
	}
	
	public Employee(String userName, String pwd, String vechileType, int empId, String name, String mobNum) {
		this.userName = userName;
		this.pwd = pwd;
		this.vechileType = vechileType;
		this.empId = empId;
		this.name = name;
		this.mobNum = mobNum;
	}

	public Employee(String vechileType, int empId, String name, String mobNum) {
		this.vechileType = vechileType;
		this.empId = empId;
		this.name = name;
		this.mobNum = mobNum;
	}

	public String getVechileType() {
		return vechileType;
	}

	public void setVechileType(String vechileType) {
		this.vechileType = vechileType;
	}
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobNum() {
		return mobNum;
	}

	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}

	private String userName;
	private String pwd;
	private String vechileType;
	private int empId;
	private String name;
	private String mobNum;

}

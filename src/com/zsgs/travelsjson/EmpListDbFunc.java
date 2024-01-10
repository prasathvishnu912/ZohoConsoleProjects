package com.zsgs.travelsjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zsgs.travels.Employee;

public class EmpListDbFunc {
    
	private Gson gson = new Gson();
	private String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/travelsjson/employees.json";
	
	public List<Employee> getEmployeeList(){
    	List<Employee> empList = new LinkedList<>();
    	try {
			JsonObject empJsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray empArrJson = empJsonObj.get("employeeDet").getAsJsonArray();
			
			Iterator<JsonElement> empArrIterator = empArrJson.iterator();
			while(empArrIterator.hasNext()) {
				JsonObject emp = empArrIterator.next().getAsJsonObject();
				String name = emp.get("name").getAsString();
				int empId = emp.get("empId").getAsInt();
				String mobNum = emp.get("mobNum").getAsString();
				String userName = emp.get("userName").getAsString();
				String pwd = emp.get("pwd").getAsString();
				String vechileType = emp.get("vechileType").getAsString();
				
				empList.add(new Employee(userName, pwd, vechileType, empId, name, mobNum));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return empList;   	
    }
	
	public void addEmpList(List<Employee> empList) {
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			
			jsonObj.remove("employeeDet");
			JsonArray empArr = new JsonArray();
			
			for(Employee emp: empList) {
				
				JsonObject empJson = new JsonObject();
				empJson.addProperty("empId", emp.getEmpId());
				empJson.addProperty("name", emp.getName());
				empJson.addProperty("mobNum", emp.getMobNum());
				empJson.addProperty("vechileType", emp.getVechileType());
				empJson.addProperty("userName", emp.getUserName());
				empJson.addProperty("pwd", emp.getPwd());
				empArr.add(empJson);
			}
			
			try {
				FileWriter writer = new FileWriter(filePath);
				jsonObj.add("employeeDet", empArr);

				gson.toJson(jsonObj, writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public List<Employee> getAttendEmpList(){
    	List<Employee> empList = new LinkedList<>();
    	try {
			JsonObject empJsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray empArrJson = empJsonObj.get("attendanceList").getAsJsonArray();
			
			Iterator<JsonElement> empArrIterator = empArrJson.iterator();
			while(empArrIterator.hasNext()) {
				JsonObject emp = empArrIterator.next().getAsJsonObject();
				String name = emp.get("name").getAsString();
				int empId = emp.get("empId").getAsInt();
				String mobNum = emp.get("mobNum").getAsString();
				String vechileType = emp.get("vechileType").getAsString();
				
				empList.add(new Employee(vechileType, empId, name, mobNum));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	return empList;   	
    }

	public void addAttendEmpList(List<Employee> empList) {
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			
			jsonObj.remove("attendanceList");
			JsonArray empArr = new JsonArray();
			
			for(Employee emp: empList) {
				
				JsonObject empJson = new JsonObject();
				empJson.addProperty("empId", emp.getEmpId());
				empJson.addProperty("name", emp.getName());
				empJson.addProperty("mobNum", emp.getMobNum());
				empJson.addProperty("vechileType", emp.getVechileType());
				empArr.add(empJson);
			}
			
			try {
				FileWriter writer = new FileWriter(filePath);
				jsonObj.add("attendanceList", empArr);

				gson.toJson(jsonObj, writer);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}

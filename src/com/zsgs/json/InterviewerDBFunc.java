package com.zsgs.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zsgs.interviewpanel.Interviewer;


public class InterviewerDBFunc {

	private Gson gson = new Gson();
	private String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/json/interviewersList.json";
	
	public Queue<Interviewer> getInterviewersList() {
		Queue<Interviewer> interviewersList = new PriorityQueue<>();
		
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray carArray = jsonObj.getAsJsonArray("interviewers");
			for (int i = 0; i < carArray.size(); i++) {
			    JsonObject interObj = carArray.get(i).getAsJsonObject();
			    
			    int id = interObj.get("empId").getAsInt();
			    String name = interObj.get("name").getAsString();
			    String pwd = interObj.get("pwd").getAsString();
			    Interviewer inter = new Interviewer(id, name, pwd);
			    interviewersList.offer(inter);  
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return interviewersList;
	}
	
	
	public void addIntToDB(Queue<Interviewer> interviewerList) {

		JsonArray interArray = new JsonArray();
		
		try {
			if(interviewerList.size()!=0) {
				for(Interviewer inter : interviewerList) {
					
					JsonObject newInterviewer = new JsonObject();
					newInterviewer.addProperty("empId", inter.getId()); 
					newInterviewer.addProperty("name", inter.getName());
					newInterviewer.addProperty("pwd", inter.getPwd());
					interArray.add(newInterviewer);
				}	
			}
			
				FileWriter writer = new FileWriter(filePath);
				JsonObject mainObject = new JsonObject();
	            mainObject.add("interviewers", interArray);
	            gson.toJson(mainObject, writer);

	            writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}


	}
}

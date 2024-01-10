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
import com.zsgs.interviewpanel.Candidate;

public class CandDBFunc {

	private Gson gson = new Gson();
	private String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/json/candList.json";
	
	public void addCandidate(Queue<Candidate> candsList) {

		JsonArray candsArray = new JsonArray();
		
		try {
			
			for(Candidate cand : candsList) {
				
				JsonObject newCandidate = new JsonObject();
				newCandidate.addProperty("name", cand.getName()); 
				newCandidate.addProperty("age", cand.getAge());
				newCandidate.addProperty("email", cand.getEmailId());
				newCandidate.addProperty("mobNum", cand.getMobNum());

				candsArray.add(newCandidate);
			}
				FileWriter writer = new FileWriter(filePath);
				JsonObject mainObject = new JsonObject();
	            mainObject.add("candidates", candsArray);
	            gson.toJson(mainObject, writer);

	            writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}


	}
	
	public Queue<Candidate> getCandidatesList() {
		
		Queue<Candidate> candList = new PriorityQueue<>();
		
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray candsArray = jsonObj.getAsJsonArray("candidates");
			if(candsArray.size()!=0) {
				for (int i = 0; i < candsArray.size(); i++) {
				    JsonObject candidate = candsArray.get(i).getAsJsonObject();
				    
				    String name = candidate.get("name").getAsString();
				    int age = candidate.get("age").getAsInt();
				    String emailId = candidate.get("email").getAsString();
				    String mobNum = candidate.get("mobNum").getAsString();
				    Candidate cand = new Candidate(name, age, emailId, mobNum);
				    candList.offer(cand);
				   
				}
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return candList;
		
	}
}

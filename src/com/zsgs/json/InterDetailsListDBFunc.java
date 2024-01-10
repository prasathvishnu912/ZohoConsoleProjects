package com.zsgs.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Queue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zsgs.interviewpanel.InterviewDetails;

public class InterDetailsListDBFunc {

	String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/json/interDetailsList.json";
	Gson gson = new Gson();
	
	public void addIntToDB(Queue<InterviewDetails> interDetList) {

		JsonArray candsArray = new JsonArray();
		
		try {
			if(interDetList.size()!=0) {
				for(InterviewDetails iDL : interDetList) {
					
					JsonObject newCandidate = new JsonObject();
					newCandidate.addProperty("interviewerName", iDL.getInterviewerName()); 
					newCandidate.addProperty("candidate", iDL.getCandName());
					newCandidate.addProperty("date", iDL.getDate().toString());
					candsArray.add(newCandidate);
				}	
			}
			
				FileWriter writer = new FileWriter(filePath);
				JsonObject mainObject = new JsonObject();
	            mainObject.add("interviewList", candsArray);
	            gson.toJson(mainObject, writer);

	            writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}


	}
	
public Queue<InterviewDetails> getInterviewsList() {
		
		Queue<InterviewDetails> interViewList = new PriorityQueue<>();
		
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray interviewsDetailsArr = jsonObj.getAsJsonArray("interviewList");
			if(interviewsDetailsArr.size()!=0) {
				for (int i = 0; i < interviewsDetailsArr.size(); i++) {
				    JsonObject interDetails = interviewsDetailsArr.get(i).getAsJsonObject();
				    
				    String interviewerName = interDetails.get("interviewerName").getAsString();
				    String candidate = interDetails.get("candidate").getAsString();
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				    LocalDate date = LocalDate.parse(interDetails.get("date").getAsString(), formatter);
				    InterviewDetails interviewDetails = new InterviewDetails(interviewerName, candidate, date);
				    interViewList.offer(interviewDetails);
				   
				}
			}
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return interViewList;
		
	}
}

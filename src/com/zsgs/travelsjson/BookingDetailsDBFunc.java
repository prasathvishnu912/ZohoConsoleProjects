package com.zsgs.travelsjson;

import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;
import com.zsgs.travels.TravelDetails;

public class BookingDetailsDBFunc {
       
	private Gson gson = new Gson();
	private String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/travelsjson/bookingsDetails.json"; 
	
	
	public void addDetailsToDB(List<Customer> travelList, String key) {
		JsonObject cusDetObj;
		try {
			cusDetObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			cusDetObj.remove(key);
			
			JsonArray detailsList = new JsonArray();
			
			for(Customer traDet : travelList) {
				JsonObject cusJsonObj = new JsonObject();
				cusJsonObj.addProperty("cusName", traDet.getCusName());
				cusJsonObj.addProperty("mobNum", traDet.getMobNum());
				
				JsonObject traDetObj = new JsonObject();
				traDetObj.addProperty("from", traDet.getTravelDetails().getFrom());
				traDetObj.addProperty("to", traDet.getTravelDetails().getTo());
				traDetObj.addProperty("arrivalTime", traDet.getTravelDetails().getArrivalTime().toString());
				traDetObj.addProperty("depatureTime", traDet.getTravelDetails().getDepatureTime().toString());
				
				JsonObject vechileDetObj = new JsonObject();
				vechileDetObj.addProperty("vechileNo", traDet.getTravelDetails().getBookedCar().getVechileNum());
				vechileDetObj.addProperty("driverName", traDet.getTravelDetails().getBookedCar().getDriverName());
				traDetObj.add("vechileDetails", vechileDetObj);
				
				cusJsonObj.add("travelDetails", traDetObj);
				detailsList.add(cusJsonObj);
			}
			
			cusDetObj.add(key, detailsList);
			
			try {
				FileWriter writter = new FileWriter(filePath);
				gson.toJson(cusDetObj, writter);
				writter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public List<Customer> getCusList(String key){
		List<Customer> cusList = new LinkedList<>();
		
		try {
			JsonObject cusDetObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray detArr = cusDetObj.get(key).getAsJsonArray();
			
			if(detArr!=null&&detArr.size()!=0) {
				for (int i = 0; i < detArr.size(); i++) {
				    JsonObject customerJson = detArr.get(i).getAsJsonObject();
				    
				    String cusName = customerJson.get("cusName").getAsString();
				    String mobNum = customerJson.get("mobNum").getAsString();
				   
				    JsonObject traDet = customerJson.get("travelDetails").getAsJsonObject();
				    
				    String from = traDet.get("from").getAsString();
				    String to = traDet.get("to").getAsString();
				    String arrivalTime = traDet.get("arrivalTime").getAsString();
				    String depatureTime = traDet.get("depatureTime").getAsString();
				    
				    JsonObject vechileDetJson = traDet.get("vechileDetails").getAsJsonObject();
				    String carNum = vechileDetJson.get("vechileNo").getAsString();
				    String driverName = vechileDetJson.get("driverName").getAsString();
				    
				    TravelsVechile carDetObj = new TravelsVechile(carNum, driverName);
				    
				    LocalDateTime arrivalTimeObj = LocalDateTime.parse(arrivalTime);
				    LocalDateTime depatureTimeObj = LocalDateTime.parse(depatureTime);
				    
				    TravelDetails traDetObj = new TravelDetails(from, to, arrivalTimeObj, depatureTimeObj, carDetObj);
				    Customer customerObj = new Customer(cusName, mobNum, traDetObj);
				    cusList.add(customerObj);
				}
			}
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return cusList;	
	}
}

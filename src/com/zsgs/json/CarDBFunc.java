package com.zsgs.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.zsgs.tollqueue.Car;

public class CarDBFunc {
	private Gson gson = new Gson();
	
	public void addCarQueueToDB(Queue<Car> carQueue) {
		
		try {
			JsonArray  carList = new JsonArray();
	        FileWriter fileWriter = new FileWriter("/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/json/carlist.json");
	        for (Car car : carQueue) {
                JsonObject carJson = new JsonObject();
                carJson.addProperty("carNum", car.getCarNum());
                carJson.addProperty("time", car.getTime());
                carList.add(carJson);
            }
	        JsonObject mainObject = new JsonObject();
            mainObject.add("carsList", carList);

          
            gson.toJson(mainObject, fileWriter);

            fileWriter.close();

		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
        	}
	
	
	public Queue<Car> getCarList() {
		Queue<Car> carList = new ConcurrentLinkedQueue<>();
		
		String filePath = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/json/carlist.json";
		JsonObject jsonObj;
		try {
			jsonObj = gson.fromJson(new FileReader(filePath), JsonObject.class);
			JsonArray carArray = jsonObj.getAsJsonArray("carsList");
			if(carArray.size()!=0) {
				for (int i = 0; i < carArray.size(); i++) {
				    JsonObject car = carArray.get(i).getAsJsonObject();
				    
				    String carNum = car.get("carNum").getAsString();
				    String age = car.get("time").getAsString();
				    Car newCar = new Car(carNum, age); 
				    carList.offer(newCar);  
				}
			}
			
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return carList;
	}
}

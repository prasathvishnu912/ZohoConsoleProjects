package com.zsgs.travelsjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zsgs.travels.TravelsVechile;

public class TravelVechileListDBFunc {

	private Gson gson = new Gson();
	private String path = "/home/suren-16923-test/Documents/ZSGSProject/ZSGSProject/src/com/zsgs/travelsjson/travelVechileList.json";

	public List<TravelsVechile> getVechileList(String vechileType, String key) {
		List<TravelsVechile> vechileList = new LinkedList<>();

		try {
			JsonObject jsonObj = gson.fromJson(new FileReader(path), JsonObject.class);
			JsonObject vechileJsonObj = jsonObj.get(vechileType).getAsJsonObject();
			JsonArray vechileArr = vechileJsonObj.getAsJsonArray(key);

			if (vechileArr != null && vechileArr.size() != 0) {
				Iterator<JsonElement> vechileIterator = vechileArr.iterator();
				while (vechileIterator.hasNext()) {
					JsonObject vechile = vechileIterator.next().getAsJsonObject();
					String vechileNum = vechile.get(vechileType + "No").getAsString();
					String driverName = vechile.get("driverName").getAsString();

					vechileList.add(new TravelsVechile(vechileNum, driverName));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vechileList;
	}

	public void addVechileListToDB(List<TravelsVechile> travelsVechileList, String vechileType, String key) {

		try {
			JsonObject jsonObj = gson.fromJson(new FileReader(path), JsonObject.class);
			JsonObject vechileJsonObj = jsonObj.get(vechileType).getAsJsonObject();
			vechileJsonObj.remove(key);

			JsonArray vechileList = new JsonArray();
			FileWriter fileWriter = new FileWriter(path);

			for (TravelsVechile vechile : travelsVechileList) {
				JsonObject vechileJson = new JsonObject();
				vechileJson.addProperty(vechileType + "No", vechile.getVechileNum());
				vechileJson.addProperty("driverName", vechile.getDriverName());
				vechileList.add(vechileJson);
			}

			vechileJsonObj.add(key, vechileList);
			jsonObj.add(vechileType, vechileJsonObj);

			gson.toJson(jsonObj, fileWriter);

			fileWriter.close();

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}

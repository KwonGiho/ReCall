package com.example.kwongyo.recall.model;


import com.example.kwongyo.recall.model.DTO.MarkerDTO;


import org.json.JSONArray;

import org.json.JSONObject;

import java.util.List;

public class MarkerJson {
	
	public static final MarkerJson instance;
	static {
		instance = new MarkerJson();
	}
	
	private MarkerJson() {
		// TODO Auto-generated constructor stub
	}
	
	public static MarkerJson getInstance() {
		return instance;
	}
	
	public JSONObject createJson(List<MarkerDTO> markerList) {
		JSONObject json = new JSONObject();
		if(markerList != null) {
			JSONObject markerJson = null;
			JSONArray markerArr = new JSONArray();
			try {
				for(MarkerDTO marker : markerList) {
					markerJson = new JSONObject();
					markerJson.put("lat", marker.getLat());
					markerJson.put("lng", marker.getLng());
					markerJson.put("m_time", marker.getM_time());
					markerJson.put("event",marker.getEvent());
					markerArr.put(markerJson);
				}
				json.put("markers", markerArr);
				return json;
			}catch (Exception e) {
				e.printStackTrace();
				return json;
			}
		}
		return json;
	}

}

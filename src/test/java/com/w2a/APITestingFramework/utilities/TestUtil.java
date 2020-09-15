package com.w2a.APITestingFramework.utilities;

import org.json.JSONObject;

import com.w2a.APITestingFramework.listeners.ExtentListeners;

public class TestUtil {


	public static boolean hasKey(String json,String key) {
		
		JSONObject jsonobject= new JSONObject(json);
		
		ExtentListeners.testReport.get().info("Validating the presence of Key:"+key);
		
		return jsonobject.has(key);
	}


	public static String getJsonkeyValue(String json,String Key) 
	{
		JSONObject jsonobject= new JSONObject(json);
		
		ExtentListeners.testReport.get().info("Validating the presence of value:"+Key);
		
		return jsonobject.get(Key).toString();
		
		 
		
		
	}
}

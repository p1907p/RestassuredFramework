package com.w2a.APITestingFramework.testcases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;
import com.w2a.APITestingFramework.APIs.CreatecustomerAPI;
import com.w2a.APITestingFramework.APIs.DeletecustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.Datautils;
import com.w2a.APITestingFramework.utilities.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Hashtable;

public class Deletecustestcases extends BaseTest {

	
	
	@Test(dataProviderClass = Datautils.class,dataProvider = "data")
	public void deletCustomer(Hashtable<String,String>adata) {

		
		System.out.println("delete test id!!");
		
		Response response = DeletecustomerAPI.sendDeleteReqToDeleteCustWithValidId(adata);

		//String acutalid=response.jsonPath().get("id").toString();
		
		response.prettyPrint();
		ExtentListeners.testReport.get().info(adata.toString());
		
		System.out.println(response.getStatusCode());

		/*
		 * System.out.println("Getting id from JSON Path:"+acutalid);
		 * 
		 * Assert.assertEquals(acutalid, adata.get("id"),"ID is not matching");
		 */
		/*
		 * JSONObject jsonobject= new JSONObject(response.asString());
		 * 
		 * System.out.println(jsonobject.has("id"));
		 * 
		 * assertTrue(jsonobject.has("id"),"ID is not present");
		 */
	
		
		System.out.println("Presence check for object key :"+TestUtil.getJsonkeyValue(response.asString(), "object"));
		
		System.out.println("Presence check for D key"+TestUtil.getJsonkeyValue(response.asString(), "deleted"));
	
		
		Assert.assertTrue(TestUtil.hasKey(response.asString(), "id"),"ID is not present");
		
		String id=TestUtil.getJsonkeyValue(response.asString(), "id");
		
		System.out.println(id);
		
		assertEquals(id, adata.get("id"), "ID is not matching");
		
		
		System.out.println("Object key value is :"+TestUtil.getJsonkeyValue(response.asString(), "object"));
	
		System.out.println("Deleted key value is :"+TestUtil.getJsonkeyValue(response.asString(), "deleted"));
		
		
		
	}

    
	
	 }
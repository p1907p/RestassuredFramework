package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class CreatecustomerAPI extends BaseTest{

	
	/*
	 * we will create valid service key we will create invalid service key
	 */
//this is second sample comment
	public static Response sendPostReqToCreateCustWithValidKey(Hashtable<String, String>adata) 
	{

		Response response = given().auth().basic(prop.getProperty("validSecretKey"), "")
				
				.formParam("name", adata.get("name"))
				.formParam("email", adata.get("email"))
				.formParam("description", adata.get("description"))
				.post(prop.getProperty("customerAPIendpoints"));

		return response;
	}
	
	public static Response sendPostReqToCreateCustWithInvalidKey(Hashtable<String, String>adata)
	{
		
		Response response=given().auth().basic(prop.getProperty("invalidsecretkey"), "")
		.formParam("name", adata.get("name"))
		.formParam("email", adata.get("email"))
		.formParam("description", adata.get("description"))
		.post(prop.getProperty("customerAPIendpoints"));
		
		return response;
	}
	


}

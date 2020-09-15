package com.w2a.APITestingFramework.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import com.w2a.APITestingFramework.setUp.BaseTest;

import io.restassured.response.Response;

public class DeletecustomerAPI extends BaseTest {

	public static Response sendDeleteReqToDeleteCustWithValidId(Hashtable<String, String>adata) 
	{
	String str=	prop.getProperty("customerAPIendpoints");
	
	System.out.println(str);
		Response response = given().auth().basic(prop.getProperty("validSecretKey"),"")
			.delete(prop.getProperty("customerAPIendpoints")+"/"+adata.get("id"));

		return response;
	}

	
}

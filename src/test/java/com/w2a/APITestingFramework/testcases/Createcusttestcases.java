package com.w2a.APITestingFramework.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.APIs.CreatecustomerAPI;
import com.w2a.APITestingFramework.listeners.ExtentListeners;
import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.Datautils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

public class Createcusttestcases extends BaseTest {

	
	
	@Test(dataProviderClass = Datautils.class,dataProvider = "data")
	public void validCreatcustomer(Hashtable<String,String>adata) {

		
		System.out.println("first test method!!");
		
		Response response = CreatecustomerAPI.sendPostReqToCreateCustWithValidKey(adata);

		//ExtentListeners.testReport.get().info(adata.toString());
		
		response.prettyPrint();

		System.out.println(response.getStatusCode());

		Assert.assertEquals(response.statusCode(), 200);

	}

    
	@Test(dataProviderClass = Datautils.class,dataProvider = "data")

	 public void invalidCreatcustomer(Hashtable<String,String>adata) {

			System.out.println("In this second invalid data");
			
			Response response = CreatecustomerAPI.sendPostReqToCreateCustWithInvalidKey(adata);
		
			//ExtentListeners.testReport.get().info(adata.toString());
			response.prettyPrint();

			System.out.println(response.getStatusCode());

			Assert.assertEquals(response.statusCode(), 401);
}
	
	
	
	
	 }
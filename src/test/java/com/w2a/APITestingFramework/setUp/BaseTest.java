package com.w2a.APITestingFramework.setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.w2a.APITestingFramework.utilities.ExcelReader;

import io.restassured.RestAssured;

public class BaseTest {

	public static   Properties prop= new Properties();
	public FileInputStream fis;
	public static ExcelReader eread=new ExcelReader("src\\test\\resources\\excel\\datadriventest.xlsx");
//	public String sheetname="testdata";
	
	
	@BeforeSuite
	public void setUp()  {
		
		System.out.println("program started");
		
		try {
			fis=new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssured.baseURI=prop.getProperty("baseURI");
		RestAssured.basePath=prop.getProperty("basePath");
		
	}
	
	
	
	@AfterSuite
	public void tearDown() {
		
		
	}
	
}

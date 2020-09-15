package com.w2a.APITestingFramework.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.w2a.APITestingFramework.setUp.BaseTest;
import com.w2a.APITestingFramework.utilities.ExcelReader;

public class Testprop extends BaseTest {

	public static void main(String[] args) throws IOException {
		
		Properties prop= new Properties();
		
		int c=eread.getRowCount("testdata");
		System.out.println(c);
		int r=eread.getColumnCount("testdata");
		System.out.println(r);
		//Object s=prop.get("testDatasheet");
		
		/*
		 *  System.out.println(s);
		 */
			FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\properties\\config.properties");
		
			// TODO Auto-generated catch block
		
	   String str=prop.getProperty("invalidsecretkey");
	   System.out.println(str);
		prop.load(fis);
		String s=prop.getProperty("testDatasheet");
		
		
		System.out.println(s);
		System.out.println(prop.getProperty("baseURI"));
		
	}

}

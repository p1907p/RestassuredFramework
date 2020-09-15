package com.w2a.APITestingFramework.utilities;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.APITestingFramework.setUp.BaseTest;

	public class Datautils extends BaseTest {
		
	/*
	 * @Test(dataProvider = "date") public void testData(Hashtable<String, String>
	 * data) { //String Runmode,String Firstname,String Lastname,String postcode
	 * 
	 * System.out.println("i got the data from data provider method!!");
	 * 
	 * System.out.println(data.get("Runmode")+"---"+data.get("Firstname")+"---"+data
	 * .get("Lastname")+"---"+data.get("postcode")+"----"); }
	 */		
		
	@DataProvider(name = "data",parallel = true)
	public Object [][] getData(Method m){
		
		
		System.out.println("data method is going to start!!");
		
		String testname=m.getName();
		//int rowcount=eread.getRowCount(prop.getProperty("testDatasheet"));
		
		String testsheetname="validTestdata";
		
		//System.out.println("this is the name:"+testsheetname);
		
		int rowcount=eread.getRowCount(testsheetname);

		
		System.out.println("i got the sheet and total rows are:"+rowcount);
		
		System.out.println("method name is :"+testname);
		
		//testcase start number
		
		int testrownum=1;
		
		System.out.println("we will get the testcase start no here!!");
		for(testrownum=1;testrownum<=rowcount;testrownum++) {
			
			//String testcasename=eread.getCellData(prop.getProperty("testDatasheet"), 0, testrownum);
			
			String testcasename=eread.getCellData(testsheetname, 0, testrownum);

			
			if(testcasename.equalsIgnoreCase(testname)) {
				System.out.println("found the testcase name:"+testname);
				break;
				
			}
			
		}
		
		System.out.println("testcase header starts at rowno:"+testrownum);
		
		// row count
		System.out.println("will be getting row count here!!");
		
		int testdatano=testrownum+2;
		
		int datarow=0;
		
		while(!eread.getCellData(testsheetname, 0, testdatano+datarow).equals("")) {
		
		//while(!eread.getCellData(prop.getProperty("testDatasheet"), 0, testdatano+datarow).equals("")) {

			datarow++;
			
		}
		System.out.println("while loop ends!!");
		
		System.out.println("total rows of testdata are:"+datarow);
		
		//column count
		System.out.println("will be printing test header column count!!");
		int colstartno=testrownum+1;
		
		int testcols=0;
		
		while(!eread.getCellData(testsheetname, testcols, colstartno).equals("") ){
		
		//while(!eread.getCellData(prop.getProperty("testDatasheet"), testcols, colstartno).equals("") ){

			testcols++;
		}
		
		System.out.println("total columns are : "+testcols);

		//printing data
		System.out.println("will be printing data object:");
		
		Object [][] data= new Object [datarow][1];
		
		int i=0;
		System.out.println("loops starts!!");
		for(int rnums=testdatano;rnums<(testdatano+datarow);rnums++) {
		
			Hashtable<String, String> table= new Hashtable<String, String>();
					
			//cols
			for(int cnum=0;cnum<testcols;cnum++) {
				
		//	System.out.println(read.getCellData(Constants.Data_sheet, cnum, rnums));
		
								
			String testdata=eread.getCellData(testsheetname, cnum, rnums);
			//	String testdata=eread.getCellData(prop.getProperty("testDatasheet"), cnum, rnums);

				
			String colno=eread.getCellData(testsheetname, cnum, colstartno);
			
				//String colno=eread.getCellData(prop.getProperty("testDatasheet"), cnum, colstartno);

			table.put(colno, testdata);
			
			}
		
			data[i][0]=table;
			i++;

			System.out.println("loop ends");
		}
		return data;
}
}
	
	
	
	
	/*@DataProvider(name="data")
	public Object[][] getData(Method m) {

		String sheetName=m.getName();
		int rows = eread.getRowCount(sheetName);
		int col = eread.getColumnCount(sheetName);

		System.out.println("rows size" + rows);
		System.out.println("rows size" + col);

		Object[][] data = new Object[rows-1][col];

//		 data[0][0]=eread.getCellData("testdata", 0, 2);
//		 data[0][1]=eread.getCellData("testdata", 1, 2);
//		 data[0][2]=eread.getCellData("testdata", 2, 2);
//		
//		 data[1][0]=eread.getCellData("testdata", 0, 3);
//		 data[1][1]=eread.getCellData("testdata", 1, 3);
//		 data[1][2]=eread.getCellData("testdata", 2, 3);
		

		 for (int rownum=2;rownum<=rows;rownum++) {
			
			 for(int colnum=0;colnum<col;colnum++) {
 
			  data [rownum-2][colnum]=eread.getCellData(sheetName, colnum, rownum);		 
		                   
		          //System.out.println(data.toString());
		

	}
			


} return data;
	
	}
	}
*/
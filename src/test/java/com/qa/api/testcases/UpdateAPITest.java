package com.qa.api.testcases;

import org.testng.annotations.Test;

import com.qa.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class UpdateAPITest extends TestBase{
 
  @BeforeClass
  public void beforeClass() throws IOException {
	RestAssured.baseURI=readPropertyValue("baseUrl"); 
  }

  
  @Test
  public void updateUserTest() {
	  System.out.println("Started executing the updateUserTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	  //Create object for Objectmapper class
	  JSONObject obj=new JSONObject();
	  obj.put("name", "Bhavani");
	  obj.put("job", "AutomationTestEngineer");
	//add the object to request ref
	  req.body(obj.toString());
	    
	  //execute the Get API
	  Response resp=req.request(Method.PUT, "/2");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 200);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  
	  String nameVal=resp.jsonPath().get("name");
	  System.out.println("Response body name value is:"+nameVal);
	  Assert.assertEquals(nameVal, "Bhavani");
	  
	  String jobVal=resp.jsonPath().get("job");
	  System.out.println("Response body job value is:"+jobVal);
	  Assert.assertEquals(jobVal, "AutomationTestEngineer");
	  
	  System.out.println("*************************************************************");
  }
  
  @Test
  public void updateUserWithPatchTest() {
	  System.out.println("Started executing the updateUserWithPatchTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	  //Create object for Objectmapper class
	  JSONObject obj=new JSONObject();
	  obj.put("name", "Farook");
	 // obj.put("job", "AutomationTestEngineer");
	//add the object to request ref
	  req.body(obj.toString());
	    
	  //execute the Get API
	  Response resp=req.request(Method.PATCH, "/2");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 200);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  
	  String nameVal=resp.jsonPath().get("name");
	  System.out.println("Response body name value is:"+nameVal);
	  Assert.assertEquals(nameVal, "Farook");
	  
	  String jobVal=resp.jsonPath().get("job");
	  System.out.println("Response body job value is:"+jobVal);
	  
	  
	  System.out.println("*************************************************************");
  }
  
  
  
  
}

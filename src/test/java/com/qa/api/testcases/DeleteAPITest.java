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

public class DeleteAPITest extends TestBase{
 
  @BeforeClass
  public void beforeClass() throws IOException {
	RestAssured.baseURI=readPropertyValue("baseUrl"); 
  }

  
  @Test
  public void deleteUserTest() {
	  System.out.println("Started executing the deleteUserTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	
	    
	  //execute the Get API
	  Response resp=req.request(Method.DELETE, "/2");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 204);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  	    
	  System.out.println("*************************************************************");
  }
  
  
  
}

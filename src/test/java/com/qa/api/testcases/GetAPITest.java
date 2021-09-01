package com.qa.api.testcases;

import org.testng.annotations.Test;

import com.qa.api.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetAPITest extends TestBase{
 
  @BeforeClass
  public void beforeClass() throws IOException {
	RestAssured.baseURI=readPropertyValue("baseUrl"); 
  }

  
  @Test
  public void fetchListOfUsersTest() {
	  System.out.println("Started executing the fetchListOfUsersTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	  //execute the Get API
	  Response resp=req.request(Method.GET, "?page=2");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 200);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  
	  	//Validating the Response body
	  Integer totalVal=resp.jsonPath().get("total");

	 System.out.println("total value is:"+totalVal);
	//  Assert.assertEquals(totalVal, 12);
		//Validating the Response body
	  Integer perPageVal=resp.jsonPath().get("per_page");
	  System.out.println("per page value is:"+perPageVal);
	  
	  //fetch the array elements
	  String eamilVal=resp.jsonPath().get("data[0].email");
	  System.out.println("firts array objetc email value:"+eamilVal);
	  Assert.assertEquals(eamilVal, "michael.lawson@reqres.in");
	  System.out.println("*************************************************************");
  }
  
  @Test
  public void fetchSingleUserTest() {
	  System.out.println("Started executing the fetchListOfUsersTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	  //execute the Get API
	  Response resp=req.request(Method.GET, "/2");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 200);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  System.out.println("Ended executing the fetchSingleUserTest()..."); 
	  System.out.println("**************Ended executing the fetchListOfUsersTest()...**********");
  }
  
  @Test
  public void fetchSingleUserNotFoundTest() {
	  System.out.println("Started executing the fetchSingleUserNotFoundTest()...");
	//create RequestSpecification request object
	  RequestSpecification req=RestAssured.given();
	  //add the headers t orequest
	  req.headers("Accept", "application/json");
	  req.headers("Content-Type", "application/json");
	  //execute the Get API
	  Response resp=req.request(Method.GET, "/23");
	  //convert the resp object into string  format
	  System.out.println("response in string format:"+resp.asString());
	  //fetch the statusCode
	  int respStatusCode=resp.getStatusCode();
	  System.out.println("response statuscode is:"+respStatusCode);
	  Assert.assertEquals(respStatusCode, 404);
	  //fetch the statusLine
	  String statusLine=resp.getStatusLine();
	  System.out.println("Statusline is:"+statusLine);
	  System.out.println("******Ended executing the fetchSingleUserNotFoundTest()..****.");
  }
  
  
  
}

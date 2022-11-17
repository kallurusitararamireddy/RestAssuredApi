package com.power.api.test;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmpCloud_EmployeeDetails_Post_Api_Test {
	
	@Test
	void PostEmpcloudEmployeeDetails() throws InterruptedException
	{
		
		//Base URI 

		RestAssured.baseURI="https://api.dev.empcloud.com";
		
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Request payload along with Post Request
		
		JSONObject requestParams=new JSONObject();
		requestParams.put("orgName", "Microsoft");
		requestParams.put("line1", "Dafne");
		requestParams.put("line2", "Dafne");
		requestParams.put("state", "Belfast");
		requestParams.put("zipCode", "518001");
		requestParams.put("countryCode", "UK");
		
		
		httprequest.header("Content-Type","application/json");
		httprequest.body(requestParams.toString());
		
		//Response object
		Response response =httprequest.request(Method.POST,"v1/data/add-employee");
		
		
		
		//Print Response
		
		String responcebody=response.getBody().asString();
		System.out.println("Response Body is:"+responcebody);
		
		//status code Validation
		int statusCode=response.getStatusCode();
		System.out.println("Status code is"+statusCode);
		Reporter.log("<B><font color = 'orange'> Register Organization API Responce  -</font>is :"+ statusCode);
		Assert.assertEquals(statusCode, 200);
		

		
		
		

		
		
	}
	

}

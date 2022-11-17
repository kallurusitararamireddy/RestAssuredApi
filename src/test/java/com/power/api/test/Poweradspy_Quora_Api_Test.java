package com.power.api.test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Poweradspy_Quora_Api_Test {
	
	@Test
	void getQuoraResponce() throws InterruptedException
	{
		
		//Base URI
		RestAssured.baseURI="https://api.poweradspy.com";
		//Thread.sleep(10000);
		
		//Request Object
		RequestSpecification httprequest=RestAssured.given();
		
		//Responce object
		
		Response responce=httprequest.request(Method.GET,"/language-translate");
		
		//Print Responce
		
		String responcebody=responce.getBody().asString();
		System.out.println("Response Body is:"+responcebody);
		
		//status Validation
		int statusCode=responce.getStatusCode();
		System.out.println("Status code is"+statusCode);
		Reporter.log("<B><font color = 'orange'> Quora API Responce  -</font>is :"+ statusCode);
		Assert.assertEquals(statusCode, 200);
		

		
		
	}
	

}

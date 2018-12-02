package com.commonapi;

import static com.jayway.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

//import static com.jayway.restassured.RestAssured.*;

/**
 * This uses restassured dependency[BDD based] to automate API testing uses
 * normal statements
 *
 *
 */

public class APITestGetRequest {

	// API Key : 0f30829f98c5a41c11ec4c0eded6318f
	// user name: figmdtest1@sharklasers.com
	// With valid API key
	// @Test
	public void Test_01() {
		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=0f30829f98c5a41c11ec4c0eded6318f");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
	}

	// When API key is invalid
	// @Test
	public void Test_02() {
		Response resp = when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=0f30829f98c5a4");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 401);
	}

	// How to give parameters
	// @Test
	public void Test_03() {
		Response resp = given()
				.param("q", "London")
				.param("appid", "0f30829f98c5a41c11ec4c0eded6318f")
				.when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=0f30829f98c5a41c11ec4c0eded6318f");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		// OR
		if (resp.getStatusCode() == 200) {
			System.out.println("API is working fine");
		} else {
			Assert.fail("API is not working");
		}
	}

	// How to give parameters and validate using then with rest assured
	// @Test
	public void Test_04() {
		given().param("q", "London")
				.param("appid", "0f30829f98c5a41c11ec4c0eded6318f").when()
				.get("http://api.openweathermap.org/data/2.5/weather").then()
				.assertThat().statusCode(200);
	}

	// How to print response
	// @Test
	public void Test_06() {
		Response resp = given()
				.param("q", "London,us")
				.param("appid", "0f30829f98c5a41c11ec4c0eded6318f")
				.when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=0f30829f98c5a41c11ec4c0eded6318f");
		System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		// OR
		if (resp.getStatusCode() == 200) {
			System.out.println("API is working fine.\nResponse is=>"
					+ resp.toString());
		} else {
			Assert.fail("API is not working");
		}
	}

	// Get the value of any component using json path
	// Complex json paths
	// $.weather[0].description
	@Test
	public void Test_07() {
		// ///////Case 1: Normal test

		String actualReport = given()
				.parameter("q", "London")
				.parameter("appid", "0f30829f98c5a41c11ec4c0eded6318f")
				.when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=0f30829f98c5a41c11ec4c0eded6318f")
				.then().contentType(ContentType.JSON).extract()
				.path("weather[0].description");
		// No need to pass the $. rest assured

		System.out.println("Description is=> " + actualReport);

		// ///////Case 2: Actual/Real time testing scenario
		String expectedWeatherReport = "Any string that we can get from database/any other file";
		Response resp = given()
				.parameter("q", "London")
				.parameter("appid", "0f30829f98c5a41c11ec4c0eded6318f")
				.when()
				.get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=665ec421e79ffe444b99cfe877a4b0de");

		String actualWeatherReport = resp.then().contentType(ContentType.JSON)
				.extract().path("weather[0].description");
		if (actualWeatherReport.equalsIgnoreCase(expectedWeatherReport)) {
			System.out.println("Test Case PASS");
		} else {
			System.out.println("Test Case FAIL");
			Assert.fail("Test Case FAIL");
		}

	}

	// Note: We can use two api calls like get weather description using ID and
	// by
	// using Lat,Long and compare both results getting same for same city

}

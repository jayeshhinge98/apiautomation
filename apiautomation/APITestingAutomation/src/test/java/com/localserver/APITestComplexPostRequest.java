package com.localserver;

import static com.jayway.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.posts.Info;
import com.api.posts.PostData;
import com.api.posts.PostDataComplex;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.lessThan;
//import static org.hamcrest.Matchers.lessThan;;
import static com.jayway.restassured.RestAssured.*;

//import static com.jayway.restassured.RestAssured.*;
public class APITestComplexPostRequest {

	// Get Request : http://localhost:3000/posts
	// @Test()
	public void test_01() {
		Response resp = when().get("http://localhost:3000/posts");
		String title = resp.then().contentType(ContentType.JSON).extract()
				.path("title[0]");
		System.out.println("Title is=>" + title);
		// System.out.println("Get response is =>" + resp.asString());
	}

	// POST Request : http://localhost:3000/posts/1
	// @Test()
	public void test_02() {
		PostDataComplex pdc = new PostDataComplex();
		Info info = new Info();
		info.setAddress("add 2");
		info.setEmail("abc@gmail.com");
		info.setPhone("985040");
		Info info2 = new Info();
		info2.setAddress("add 3");
		info2.setEmail("abcdef@gmail.com");
		info2.setPhone("7585985040");
		pdc.setId("2");
		pdc.setTitle("This is title");
		pdc.setAuthor("Set Author");
		pdc.setInfo(new Info[] { info, info2 });

		Response resp = given().body(pdc).when().contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");

		System.out.println("POST response is =>" + resp.asString());
		System.out.println("Status is =>" + resp.getStatusCode());
	}

	// Get Request : http://localhost:3000/posts
	@Test()
	public void test_03() {
		Response resp = when().get("http://localhost:3000/posts");
		Long time = resp.then().extract().time();
		System.out.println("Response time is=>" + time);
		// System.out.println("Get response is =>" + resp.asString());
		when().get("http://localhost:3000/posts").then().time(lessThan(10L));

	}
}
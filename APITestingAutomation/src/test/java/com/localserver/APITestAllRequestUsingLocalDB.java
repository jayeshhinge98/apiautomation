package com.localserver;

import static com.jayway.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.posts.PostData;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class APITestAllRequestUsingLocalDB {
	// SET_UP
	// set up dummy server for POST, GET etc.
	// https://github.com/typicode/json-server
	// install node js first
	// set path in envr variable C:\Program Files\nodejs
	// After installing open cmd & type =npm install -g json-server
	// create db.json using below json file

	// {
	// "posts": [
	// { "id": 1, "title": "json-server", "author": "typicode" }
	// ],
	// "comments": [
	// { "id": 1, "body": "some comment", "postId": 1 }
	// ],
	// "profile": { "name": "typicode" }
	// }

	// To Start JSON type cmd = json-server --watch db.json

	// Get Request : http://localhost:3000/posts
	 @Test(priority=1)
	public void test_01() {
		Response resp = when().get("http://localhost:3000/posts");
		System.out.println("Get response is =>" + resp.asString());

	}

	// POST Request(create new entry/add new entries to resources)
	// @Test(priority=2)
	public void test_02() {
		Response resp = given()
				.body("{\"id\": \"2\", \"title\": \"title 2\",\"author\": \"sample_author\"}")
				.when().contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println("POST response is =>" + resp.asString());

	}

	// POST request by using Object
	// @Test(priority=3)
	public void test_03() {
		PostData posts = new PostData();
		posts.setId(3);
		posts.setTitle("Title2 using object");
		posts.setAuthor("Set Author2 using objct");
		Response resp = given().body(posts).when()
				.contentType(ContentType.JSON)
				.post("http://localhost:3000/posts");
		System.out.println("POST response is =>" + resp.asString());

	}

	// Get to get some value
	// @Test
	public void test_04() {
		Response resp = when().get("http://localhost:3000/posts/3");
		System.out.println("Get response for 3rd number data is =>"
				+ resp.asString());
	}

	// PUT Request(Update the data)
	// @Test
	public void test_05() {
		PostData pd = new PostData();
		pd.setId(3);
		pd.setTitle("Put Request");
		pd.setAuthor("Put author");
		Response resp = given().body(pd).when().contentType(ContentType.JSON)
				.put("http://localhost:3000/posts/3");
		System.out.println("PUT response is =>" + resp.asString());
	}

	// PATCH Request(Update only specific data, no need to pass all the parameters)
	// @Test
	public void test_06() {
		// PostData pd = new PostData();
		// pd.setId(5);
		// pd.setTitle("Patch update Request");
		Response resp = given().body("{\"title\":\"Patch update Request2\"}")
				.when().contentType(ContentType.JSON)
				.patch("http://localhost:3000/posts/3");
		System.out.println("PATCH response is =>" + resp.asString());
	}

	// Delete Request(Delete specific resources)
	//@Test
	public void test_07() {
		// PostData pd = new PostData();
		// pd.setId(5);
		// pd.setTitle("Patch update Request");
		Response resp = when().delete("http://localhost:3000/posts/5");
		System.out.println("Delete response is =>" + resp.asString());
		System.out.println("StatusCode is=>" + resp.getStatusCode());
	}
}
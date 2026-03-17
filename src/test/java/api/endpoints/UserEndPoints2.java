package api.endpoints;

// UsreEndPoints.java
//Created for perform Create, Read, Update, Delete request the user apis
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints2 {
	
	//create method to load properties file and get urls
	public static ResourceBundle getURL()
	{
		ResourceBundle routs= ResourceBundle.getBundle("routes"); // load the properties file
		return routs;
	}

	public static Response createUser(User payload)	// pass User.java class parameter
	{
		String post_url=getURL().getString("post_url");
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_url);
		return response;
		
	}
	
	public static Response getUser(String userName)	// pass User.java class parameter
	{
		String get_url=getURL().getString("get_url");
		Response response=given()
			.pathParam("username", userName)
		.when()
			.get(get_url);
	
		return response;
	}
	
	public static Response updateUser(User payload, String userName)	// pass User.java class parameter
	{
		String update_url=getURL().getString("update_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
				.put(update_url);
			return response;
	}
	
	public static Response deleteUser(String userName)	// pass User.java class parameter
	{
		String delete_url=getURL().getString("delete_url");
		
		Response response=given()
			.pathParam("username", userName)
		.when()
			.delete(delete_url);
	
		return response;
	}
}

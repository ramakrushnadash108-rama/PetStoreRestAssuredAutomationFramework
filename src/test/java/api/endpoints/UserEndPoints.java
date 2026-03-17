package api.endpoints;

// UsreEndPoints.java
//Created for perform Create, Read, Update, Delete request the user apis
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	public static Response createUser(User payload)	// pass User.java class parameter
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		return response;
		
	}
	
	public static Response getUser(String userName)	// pass User.java class parameter
	{
		Response response=given()
			.pathParam("username", userName)
		.when()
			.get(Routes.get_url);
	
		return response;
	}
	
	public static Response updateUser(User payload, String userName)	// pass User.java class parameter
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
			.when()
				.put(Routes.update_url);
			return response;
	}
	
	public static Response deleteUser(String userName)	// pass User.java class parameter
	{
		Response response=given()
			.pathParam("username", userName)
		.when()
			.delete(Routes.delete_url);
	
		return response;
	}
}

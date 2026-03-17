package api.endpoints;

/*

Swagger URI : https://petstore.swagger.io
 
 // User Module
Base URL: https://petstore.swagger.io/v2
Create user(POST): https://petstore.swagger.io/v2/user
Get user(GET): https://petstore.swagger.io/v2/user/{{firstName}}
Update user(PUT): https://petstore.swagger.io/v2/user/{{firstName}}
Delete User(DELETE): https://petstore.swagger.io/v2/user/{{firstName}}
  
// Pet Module

// Store Module
*/



public class Routes {
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	// User module
	
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	
	// Store module
		// Here create store modules urls.
	
	// Pet Module
	// Here create pet modules urls.
	
	
	
	
	

}
